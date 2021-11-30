package com.gitee.ayezs.util;

import com.gitee.ayezs.annotation.WrapperAnnotation;
import com.gitee.ayezs.marshaller.FindAnnotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnotationUtil {
    public static <A extends Annotation> FindAnnotations  findWrapperAnnotation(Field field) {
        if (field == null) {
            return null;
        }

        for (Annotation annotation : field.getAnnotations()) {
            //跳过java自带的注解
            if(isJavaAnnotations(annotation)){
                continue;
            }
            if(annotation instanceof WrapperAnnotation){
                FindAnnotations findAnnotations = new FindAnnotations();
                findAnnotations.setEnd((WrapperAnnotation) annotation);
                return findAnnotations;
            }else {
                FindAnnotations  findAnnotations = findWrapperAnnotation(annotation.annotationType());
                if(findAnnotations != null){
                    findAnnotations.setStart(annotation);
                    return findAnnotations;
                }
            }
        }
        return null;
    }

    public static <A extends Annotation> FindAnnotations findWrapperAnnotation(Class<A> clazz) {
        if (clazz == null) {
            return null;
        }
        for (Annotation annotation : clazz.getAnnotations()) {
            if(isJavaAnnotations(annotation)){
                continue;
            }
            if(annotation instanceof WrapperAnnotation){
                FindAnnotations findAnnotations = new FindAnnotations();
                findAnnotations.setEnd((WrapperAnnotation) annotation);
                return findAnnotations;
            }else {
                FindAnnotations  findAnnotations = findWrapperAnnotation(annotation.annotationType());
                if(findAnnotations != null){
                    findAnnotations.setStart(annotation);
                    return findAnnotations;
                }
            }
        }
        return null;
    }

    /**
     * 只有java自带的注解
     */
    private static boolean isJavaAnnotations(Annotation type) {
        return type.annotationType().getName().startsWith("java.");
    }

}

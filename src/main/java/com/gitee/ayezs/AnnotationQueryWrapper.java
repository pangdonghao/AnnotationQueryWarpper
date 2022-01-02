package com.gitee.ayezs;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gitee.ayezs.annotation.wrapper.WrapperAnnotation;
import com.gitee.ayezs.marshaller.FindAnnotations;
import com.gitee.ayezs.marshaller.WrapperBuilder;
import com.gitee.ayezs.util.AnnotationUtil;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于注解的QueryWrapper
 */
public class AnnotationQueryWrapper<T> extends QueryWrapper<T> {
//    public static List<Annotation> annotations = new ArrayList<>();

    public static Map<WrapperAnnotation, WrapperBuilder> marshallerMap = new HashMap<>();
    public AnnotationQueryWrapper(T entity) {
        super();
        Field[] declaredFields = entity.getClass().getDeclaredFields();
        for (Field field :
                declaredFields) {
            FindAnnotations findAnnotations = AnnotationUtil.findWrapperAnnotation(field);
            if(findAnnotations != null){
                WrapperAnnotation wrapperAnnotation = findAnnotations.getEnd();
                if(wrapperAnnotation != null){
                    WrapperBuilder wrapperBuilder1 = marshallerMap.get(wrapperAnnotation);
                    if(wrapperBuilder1 != null){
                        wrapperBuilder1.build(this, field, entity, findAnnotations.getStart(), wrapperAnnotation.methodName());
                    }else {
                        WrapperBuilder wrapperBuilder = null;
                        try {
                            wrapperBuilder = wrapperAnnotation.marshaller().newInstance();
                            marshallerMap.put(wrapperAnnotation, wrapperBuilder);
                            wrapperBuilder.build(this, field, entity, findAnnotations.getStart(), wrapperAnnotation.methodName());
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}

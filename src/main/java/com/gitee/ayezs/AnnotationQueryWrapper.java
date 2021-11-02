package com.gitee.ayezs;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.gitee.ayezs.annotation.Eq;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 基于注解的QueryWrapper
 * @param <T>
 */
public class AnnotationQueryWrapper<T> extends QueryWrapper<T> {
    public static List<Annotation> annotations = new ArrayList<>();
    public AnnotationQueryWrapper(T entity) {
        super(entity);
        Field[] declaredFields = entity.getClass().getDeclaredFields();
        for (Field f :
                declaredFields) {
            try {
                Eq eq = f.getAnnotation(Eq.class);
                if(eq != null){
                    Object o = f.get(entity);
                    if(o != null ){
                        f.setAccessible(true);
                        if(StringUtils.isNotBlank(eq.column())){
                            eq(eq.column(), o);
                        }else {
                            eq(f.getName(), o);
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addAnnotation(Annotation a){
        annotations.add(a);
    }
}

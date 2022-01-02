package com.gitee.ayezs.marshaller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 装配器
 * @author 庞冬皓
 */
public interface WrapperBuilder {
    /**
     *
     * @param queryWrapper queryWrapper
     * @param field 字段
     * @param o 传人的对象
     * @param annotation 字段上的注解
     * @return QueryWrapper
     */
    QueryWrapper build(QueryWrapper queryWrapper, Field field, Object o, Annotation annotation, String methodName);
}

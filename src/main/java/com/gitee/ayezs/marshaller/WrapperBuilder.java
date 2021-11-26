package com.gitee.ayezs.marshaller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.gitee.ayezs.annotation.Eq;
import com.gitee.ayezs.annotation.WrapperAnnotation;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 装配器
 * @author 庞冬皓
 * @date 2021/10/2 15:39
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

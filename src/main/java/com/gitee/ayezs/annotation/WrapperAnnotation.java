package com.gitee.ayezs.annotation;

import com.gitee.ayezs.marshaller.WrapperBuilder;

import java.lang.annotation.*;

/**
 * @author: 庞冬皓
 * @description
 * : 2021/10/2 15:29
 */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface WrapperAnnotation{
    Class<? extends WrapperBuilder> marshaller();
    String methodName();
}

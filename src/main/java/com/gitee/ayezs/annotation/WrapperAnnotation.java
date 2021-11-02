package com.gitee.ayezs.annotation;

import com.gitee.ayezs.marshaller.Marshaller;

import java.lang.annotation.*;

/**
 * @author: 庞冬皓
 * @description
 * @date: 2021/10/2 15:29
 */
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface WrapperAnnotation {

}

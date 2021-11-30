package com.gitee.ayezs.annotation;

import com.gitee.ayezs.marshaller.CommonWrapperBuild;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 大于等于
 * @author: 庞冬皓
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@WrapperAnnotation(methodName = "ge", marshaller = CommonWrapperBuild.class)
public @interface Ge {
    /**
     * 字段名
     */
    String column() default "";
}

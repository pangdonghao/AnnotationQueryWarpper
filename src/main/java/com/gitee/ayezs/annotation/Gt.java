package com.gitee.ayezs.annotation;

import com.gitee.ayezs.marshaller.CommonWrapperBuild;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 大于
 * @author: 庞冬皓
 * @date: 2021/10/2 15:03
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@WrapperAnnotation(methodName = "gt", marshaller = CommonWrapperBuild.class)
public @interface Gt {
    /**
     * 字段名
     * @return
     */
    String column() default "";
}

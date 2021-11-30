package com.gitee.ayezs.annotation;

import com.gitee.ayezs.marshaller.CommonWrapperBuild;
import com.gitee.ayezs.util.AnnotationUtil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 *
 * @author: 庞冬皓
 * : 2021/10/2 15:03
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@WrapperAnnotation(methodName = "like",marshaller = CommonWrapperBuild.class)
public @interface Like {
    /**
     * 字段名
     * @return
     */
    String column();
}

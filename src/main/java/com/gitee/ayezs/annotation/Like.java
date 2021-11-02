package com.gitee.ayezs.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 *
 * @author: 庞冬皓
 * @date: 2021/10/2 15:03
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@WrapperAnnotation(column = "", marshaller = null)
public @interface Like  {
    /**
     * 字段名
     * @return
     */
    String column();
}

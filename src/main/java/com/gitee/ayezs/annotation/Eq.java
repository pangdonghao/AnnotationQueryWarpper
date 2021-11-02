package com.gitee.ayezs.annotation;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.function.Function;


/**
 *
 * @author: 庞冬皓
 * @date: 2021/10/2 15:03
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Eq {
    /**
     * 字段名
     * @return
     */
    String column();

    Like f();
}

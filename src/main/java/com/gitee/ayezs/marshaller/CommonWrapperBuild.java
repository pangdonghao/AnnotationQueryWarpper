package com.gitee.ayezs.marshaller;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.gitee.ayezs.annotation.RemainUnchanged;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CommonWrapperBuild implements WrapperBuilder {
    @Override
    public QueryWrapper build(QueryWrapper queryWrapper, Field field, Object o, Annotation annotation, String methodName) {
        field.setAccessible(true);
        try {
            Object value = field.get(o);
            if(value != null ){
                TableField tableField = field.getAnnotation(TableField.class);
                String fieldName;
                if(tableField!=null){
                    fieldName = tableField.value();
                }else {
                    RemainUnchanged remainUnchanged = field.getAnnotation(RemainUnchanged.class);
                    if(remainUnchanged !=null){
                        fieldName= field.getName();
                    }else {
                        fieldName = StringUtils.camelToUnderline(field.getName());
                    }
                }
                Method method = queryWrapper.getClass().getMethod(methodName, Object.class, Object.class);
                method.invoke(queryWrapper, fieldName, value);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        field.setAccessible(false);
        return queryWrapper;
    }
}

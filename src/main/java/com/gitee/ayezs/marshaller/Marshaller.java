package com.gitee.ayezs.marshaller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.lang.reflect.Field;

/**
 * 装配器
 * @author: 庞冬皓
 * @date: 2021/10/2 15:39
 */
public interface Marshaller {
    default QueryWrapper marshaller(QueryWrapper queryWrapper, Field field, Object o) {

        if(eq != null){
            Object o = f.get(entity);
            if(o != null ){
                f.setAccessible(true);
                if(StringUtils.isNotBlank(eq.column())){
                    eq(eq.column(), o);
                }else {
                    eq(f.getName(), o);
                }
            }
        }
    }
}

package com.gitee.ayezs.annotation;

import com.gitee.ayezs.marshaller.WrapperBuilder;

/**
 * @author: 庞冬皓
 * @date: 2021/10/2 15:40
 */
public @interface MarshallerAnnotation {
    String column();
    Class<WrapperBuilder> marshaller();
}

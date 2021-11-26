package com.gitee.ayezs;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.gitee.ayezs.annotation.Eq;

public class AAA extends Model<AAA> {
    @Eq(column = "aa")
    public String al;
}

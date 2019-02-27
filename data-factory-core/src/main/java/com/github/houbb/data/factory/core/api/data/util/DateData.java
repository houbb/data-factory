package com.github.houbb.data.factory.core.api.data.util;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.google.auto.service.AutoService;

import java.util.Date;

/**
 * 日期类数据初始化
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
@AutoService(IData.class)
public class DateData implements IData<Date> {
    @Override
    public Date build(IContext context, Class<Date> dateClass) {
        return new Date();
    }
}

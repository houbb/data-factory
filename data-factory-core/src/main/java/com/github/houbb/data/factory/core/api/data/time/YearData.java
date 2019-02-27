package com.github.houbb.data.factory.core.api.data.time;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.google.auto.service.AutoService;

import java.time.LocalDate;
import java.time.Year;

/**
 * @author binbin.hou
 * date 2019/2/27
 * @since 0.0.1
 * @see java.time.Year jdk8 年份类
 */
@AutoService(IData.class)
public class YearData implements IData<Year> {
    @Override
    public Year build(IContext context, Class<Year> localDateClass) {
        return Year.now();
    }
}

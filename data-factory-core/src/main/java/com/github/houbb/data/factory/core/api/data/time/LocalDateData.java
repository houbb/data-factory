package com.github.houbb.data.factory.core.api.data.time;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.google.auto.service.AutoService;

import java.time.LocalDate;

/**
 * @author binbin.hou
 * date 2019/2/27
 * @since 0.0.1
 * @see LocalDate jdk8 日期类
 */
@AutoService(IData.class)
public class LocalDateData implements IData<LocalDate> {
    @Override
    public LocalDate build(IContext context, Class<LocalDate> localDateClass) {
        return LocalDate.now();
    }
}

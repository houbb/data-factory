package com.github.houbb.data.factory.core.api.data.time;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.google.auto.service.AutoService;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author binbin.hou
 * date 2019/2/27
 * @since 0.0.1
 * @see java.time.LocalTime jdk8 时间类类
 */
@AutoService(IData.class)
public class LocalTimeData implements IData<LocalTime> {
    @Override
    public LocalTime build(IContext context, Class<LocalTime> localDateClass) {
        return LocalTime.now();
    }
}

package com.github.houbb.data.factory.core.api.data.time;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.google.auto.service.AutoService;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author binbin.hou
 * date 2019/2/27
 * @since 0.0.1
 * @see java.time.LocalDateTime jdk8 日期时间类
 */
@AutoService(IData.class)
public class LocalDateTimeData implements IData<LocalDateTime> {
    @Override
    public LocalDateTime build(IContext context, Class<LocalDateTime> localDateClass) {
        return LocalDateTime.now();
    }
}

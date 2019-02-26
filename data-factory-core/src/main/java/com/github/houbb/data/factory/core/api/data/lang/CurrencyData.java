package com.github.houbb.data.factory.core.api.data.lang;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.google.auto.service.AutoService;

import java.util.Currency;
import java.util.Date;
import java.util.Locale;

/**
 * 金额类数据初始化
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
@AutoService(IData.class)
public class CurrencyData implements IData<Currency> {
    @Override
    public Currency build(IContext context, Class<Currency> dateClass) {
        return Currency.getInstance(Locale.CHINA);
    }
}

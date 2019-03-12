package com.github.houbb.data.factory.core.api.regex;

import com.github.houbb.data.factory.api.core.IRegexGen;
import com.mifmif.common.regex.Generex;

/**
 * 默认的 regex 生成方式
 * @author binbin.hou
 * @date 2019/3/12
 * @since 0.0.3
 */
public class DefaultRegexGen implements IRegexGen {

    @Override
    public String generate(String regex) {
        Generex generex = new Generex(regex);
        return generex.random();
    }

}

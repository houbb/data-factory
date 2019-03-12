package com.github.houbb.data.factory.core.util.regex;

import com.github.houbb.data.factory.api.core.IRegexGen;
import com.github.houbb.data.factory.core.api.regex.DefaultRegexGen;
import com.github.houbb.data.factory.core.model.regex.RegexBean;
import com.github.houbb.data.factory.core.util.DataUtil;
import org.junit.jupiter.api.Test;

/**
 * Regex 正则测试
 * @author binbin.hou
 * @date 2019/3/12
 * @since 0.0.3
 */
public class DataUtilRegexTest {

    /**
     * 正则表达式测试
     */
    @Test
    public void regexTest() {
        RegexBean regexBean = DataUtil.build(RegexBean.class);
        System.out.println(regexBean);
    }

    @Test
    public void regexRandomTest() {
        IRegexGen regexGen = new DefaultRegexGen();
        System.out.println(regexGen.generate("[0-3]([a-c]|[e-g]{1,2})"));
    }

}

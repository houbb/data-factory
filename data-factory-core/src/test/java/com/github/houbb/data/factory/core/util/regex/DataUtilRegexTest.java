package com.github.houbb.data.factory.core.util.regex;

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

    @Test
    public void stringTest() {
        RegexBean regexBean = DataUtil.build(RegexBean.class);
        System.out.println(regexBean.getName());
        System.out.println(regexBean.getAge());
    }

}

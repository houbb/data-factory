package com.github.houbb.data.factory.core.util.base;

import com.github.houbb.data.factory.core.util.DataUtil;

import org.junit.Assert;
import org.junit.Test;

/**
* <p> DataUtil Tester. </p>
* <p> 2019-02-26 16:20:40.536 </p>
*
* @author binbin.hou
* @version 0.0.1-SNAPSHOT
*/
public class DataUtilPatternTest {

    /**
    *
    * Method: build(clazz)
    */
    @Test
    public void buildNullTest() throws Exception {
        Object result = DataUtil.build(null);
        Assert.assertNull(result);
    }

}

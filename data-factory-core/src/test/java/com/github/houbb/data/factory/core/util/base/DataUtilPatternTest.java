package com.github.houbb.data.factory.core.util.base;

import com.github.houbb.data.factory.core.util.DataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Assertions.assertNull(result);
    }

}

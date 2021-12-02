package com.github.houbb.data.factory.core.util.base;

import com.github.houbb.data.factory.core.util.DataUtil;

import org.junit.Test;
import org.junit.Assert;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Currency;
import java.util.Date;

/**
* <p> DataUtil Tester. </p>
* <p> 2019-02-26 16:20:40.536 </p>
*
* @author binbin.hou
* @version 0.0.1-SNAPSHOT
*/
public class DataUtilMathTest {

    /**
    *
    * Method: build(clazz)
    */
    @Test
    public void buildBigDecimalTest() throws Exception {
        BigDecimal result = DataUtil.build(BigDecimal.class);
        Assert.assertNotNull(result);
        System.out.println(result);
    }

    /**
     *
     * Method: build(clazz)
     */
    @Test
    public void buildBigIntegerTest() throws Exception {
        BigInteger result = DataUtil.build(BigInteger.class);
        Assert.assertNotNull(result);
        System.out.println(result);
    }

}

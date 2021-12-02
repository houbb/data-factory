package com.github.houbb.data.factory.core.util;

import com.github.houbb.data.factory.core.model.annotation.UserAnnotationNumber;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * <p> DataUtil Tester. </p>
 * <p> 2019-02-26 16:20:40.536 </p>
 *
 * @author binbin.hou
 * @version 0.0.1-SNAPSHOT
 */
public class DataUtilAnnotationNumberTest {

    /**
     * Method: build(clazz)
     */
    @Test
    public void stringAnnotationTest() throws Exception {
        UserAnnotationNumber number = DataUtil.build(UserAnnotationNumber.class);
        System.out.println(number);

        Assert.assertTrue(number.getaByte() >= 10);
        Assert.assertTrue(number.getaByte() <= 20);

        Assert.assertTrue(number.getaShort() >= 10);
        Assert.assertTrue(number.getaShort() <= 20);

        Assert.assertTrue(number.getInteger() >= 10);
        Assert.assertTrue(number.getInteger() <= 20);

        Assert.assertTrue(number.getaLong() >= 10);
        Assert.assertTrue(number.getaLong() <= 20);

        Assert.assertTrue(number.getaFloat() >= 10);
        Assert.assertTrue(number.getaFloat() <= 21);

        Assert.assertTrue(number.getaDouble() >= 10);
        Assert.assertTrue(number.getaDouble() <= 21);

        Assert.assertTrue(number.getBigInteger().compareTo(new BigInteger("10")) >= 0);
        Assert.assertTrue(number.getBigInteger().compareTo(new BigInteger("20")) <= 0);

        Assert.assertTrue(number.getBigDecimal().compareTo(new BigDecimal("10")) >= 0);
        Assert.assertTrue(number.getBigDecimal().compareTo(new BigDecimal("21")) <= 0);

        System.out.println(number.getaFloat());
        System.out.println(number.getaDouble());
        System.out.println(number.getBigDecimal());
    }

}

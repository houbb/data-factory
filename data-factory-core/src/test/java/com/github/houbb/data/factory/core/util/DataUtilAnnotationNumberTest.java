package com.github.houbb.data.factory.core.util;

import com.github.houbb.data.factory.core.model.annotation.UserAnnotationNumber;
import com.github.houbb.data.factory.core.model.annotation.UserAnnotationString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

        Assertions.assertTrue(number.getaByte() >= 10);
        Assertions.assertTrue(number.getaByte() <= 20);

        Assertions.assertTrue(number.getaShort() >= 10);
        Assertions.assertTrue(number.getaShort() <= 20);

        Assertions.assertTrue(number.getInteger() >= 10);
        Assertions.assertTrue(number.getInteger() <= 20);

        Assertions.assertTrue(number.getaLong() >= 10);
        Assertions.assertTrue(number.getaLong() <= 20);

        Assertions.assertTrue(number.getaFloat() >= 10);
        Assertions.assertTrue(number.getaFloat() <= 21);

        Assertions.assertTrue(number.getaDouble() >= 10);
        Assertions.assertTrue(number.getaDouble() <= 21);

        Assertions.assertTrue(number.getBigInteger().compareTo(new BigInteger("10")) >= 0);
        Assertions.assertTrue(number.getBigInteger().compareTo(new BigInteger("20")) <= 0);

        Assertions.assertTrue(number.getBigDecimal().compareTo(new BigDecimal("10")) >= 0);
        Assertions.assertTrue(number.getBigDecimal().compareTo(new BigDecimal("21")) <= 0);

        System.out.println(number.getaFloat());
        System.out.println(number.getaDouble());
        System.out.println(number.getBigDecimal());
    }

}

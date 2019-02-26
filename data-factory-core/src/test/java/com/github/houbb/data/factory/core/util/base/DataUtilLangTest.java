package com.github.houbb.data.factory.core.util.base;

import com.github.houbb.data.factory.core.util.DataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Currency;
import java.util.Date;

/**
* <p> DataUtil Tester. </p>
* <p> 2019-02-26 16:20:40.536 </p>
*
* @author binbin.hou
* @version 0.0.1-SNAPSHOT
*/
public class DataUtilLangTest {

    /**
    *
    * Method: build(clazz)
    */
    @Test
    public void buildStringTest() throws Exception {
        String result = DataUtil.build(String.class);
        System.out.println(result);
    }

    /**
     *
     * Method: build(clazz)
     */
    @Test
    public void buildDateTest() throws Exception {
        Date result = DataUtil.build(Date.class);
        System.out.println(result);
    }

    /**
     *
     * Method: build(clazz)
     */
    @Test
    public void buildCurrencyTest() throws Exception {
        Currency result = DataUtil.build(Currency.class);
        System.out.println(result);
    }

}

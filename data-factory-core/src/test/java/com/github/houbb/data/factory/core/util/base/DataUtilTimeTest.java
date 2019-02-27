/*
 * Copyright (c)  2019. houbinbin Inc.
 * data-factory All rights reserved.
 */

package com.github.houbb.data.factory.core.util.base;

import com.github.houbb.data.factory.core.util.DataUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;

/**
* <p> DataUtil Tester. </p>
* <p> 2019-02-26 16:20:40.536 </p>
*
* @author binbin.hou
* @version 0.0.1-SNAPSHOT
*/
public class DataUtilTimeTest {

    /**
    *
    * Method: build(clazz)
    */
    @Test
    public void buildLocalDateTest() throws Exception {
        LocalDate result = DataUtil.build(LocalDate.class);
        System.out.println(result);
    }

    /**
     *
     * Method: build(clazz)
     */
    @Test
    public void buildLocalTimeTest() throws Exception {
        LocalTime result = DataUtil.build(LocalTime.class);
        System.out.println(result);
    }

    /**
     *
     * Method: build(clazz)
     */
    @Test
    public void buildLocalDateTimeTest() throws Exception {
        LocalDateTime result = DataUtil.build(LocalDateTime.class);
        System.out.println(result);
    }

    /**
     *
     * Method: build(clazz)
     */
    @Test
    public void buildYearTest() throws Exception {
        Year result = DataUtil.build(Year.class);
        System.out.println(result);
    }

}

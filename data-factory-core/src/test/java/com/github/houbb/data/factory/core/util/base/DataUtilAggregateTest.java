package com.github.houbb.data.factory.core.util.base;

import com.github.houbb.data.factory.core.util.DataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
* <p> DataUtil Tester. </p>
* <p> 2019-02-26 16:20:40.536 </p>
*
* @author binbin.hou
* @version 0.0.1-SNAPSHOT
*/
public class DataUtilAggregateTest {

    /**
    *
    * Method: build(clazz)
    */
    @Test
    public void buildArrayBaseTest() throws Exception {
        String[] strings = new String[1];
        String[] result = DataUtil.build(strings.getClass());
        System.out.println(Arrays.toString(result));
    }

    /**
     *
     * Method: build(clazz)
     */
    @Test
    public void buildIterableBaseTest() throws Exception {
        Collection<String> strings = new ArrayList<>();
        Collection<String> result = DataUtil.build(strings.getClass());
        System.out.println(result);
    }

}

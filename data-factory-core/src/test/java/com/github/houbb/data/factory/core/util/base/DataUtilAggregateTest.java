package com.github.houbb.data.factory.core.util.base;

import com.github.houbb.data.factory.core.model.StatusEnum;
import com.github.houbb.data.factory.core.model.User;
import com.github.houbb.data.factory.core.util.DataUtil;
import org.junit.Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Collection<String> strings = new ArrayList<String>();
        Collection<String> result = DataUtil.build(strings.getClass());
        System.out.println(result);
    }

    /**
     *
     * Method: build(clazz)
     */
    @Test
    public void buildMapBaseTest() throws Exception {
        Map<String, String> map = new HashMap<>();
        Map<String, String> result = DataUtil.build(map.getClass());
        System.out.println(result);
    }

    /**
     *
     * Method: build(clazz)
     */
    @Test
    public void buildBeanBaseTest() throws Exception {
        User user = DataUtil.build(User.class);
        System.out.println(user);
    }

    /**
     *
     * Method: build(clazz)
     */
    @Test
    public void buildEnumBaseTest() throws Exception {
        User user = DataUtil.build(User.class);
        System.out.println(user);
    }


    @Test
    public void enumTest() {
        System.out.println(StatusEnum.class);
    }
}

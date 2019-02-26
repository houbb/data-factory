package com.github.houbb.data.factory.core.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * date 2019/2/26
 */
public class DataClassUtilTest {

    @Test
    public void allTest() {
        List<String> types = new ArrayList<>();
        System.out.println(DataClassUtil.getAllGenericInterfaces(types.getClass()));
//        System.out.println(DataClassUtil.getGenericType(types.getClass(), Iterable.class, 0));
    }
}

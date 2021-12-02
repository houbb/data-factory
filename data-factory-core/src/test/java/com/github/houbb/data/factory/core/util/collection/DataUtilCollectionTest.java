package com.github.houbb.data.factory.core.util.collection;

import com.github.houbb.data.factory.core.util.DataUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class DataUtilCollectionTest {

    @Test
    public void primitiveArrayTest() {
        System.out.println(Arrays.toString(DataUtil.build(int[].class)));
        System.out.println(Arrays.toString(DataUtil.build(short[].class)));
        System.out.println(Arrays.toString(DataUtil.build(byte[].class)));
        System.out.println(Arrays.toString(DataUtil.build(boolean[].class)));
        System.out.println(Arrays.toString(DataUtil.build(char[].class)));
        System.out.println(Arrays.toString(DataUtil.build(double[].class)));
        System.out.println(Arrays.toString(DataUtil.build(float[].class)));
        System.out.println(Arrays.toString(DataUtil.build(long[].class)));
    }

    @Test
    public void setTest() {
        Set<String> set = new HashSet<>();
        System.out.println(DataUtil.build(set.getClass()));
    }

}

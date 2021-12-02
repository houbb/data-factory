package com.github.houbb.data.factory.core.util.base;

import com.github.houbb.data.factory.core.util.DataUtil;

import org.junit.Assert;
import org.junit.Test;

/**
* <p> DataUtil Tester. </p>
* <p> 2019-02-26 16:20:40.536 </p>
*
* @author binbin.hou
* @version 0.0.1-SNAPSHOT
*/
public class DataUtilBaseTest {

    /**
     *
     * Method: build(clazz)
     */
    @Test
    public void buildStringTest() throws Exception {
        String s1 = DataUtil.build(String.class);
        System.out.println(s1);
    }

    /**
    *
    * Method: build(clazz)
    */
    @Test
    public void buildBooleanTest() throws Exception {
        boolean b1 = DataUtil.build(Boolean.class);
        boolean b2 = DataUtil.build(boolean.class);
        System.out.println(b1);
        System.out.println(b2);
    }

    /**
     *
     * Method: build(clazz)
     */
    @Test
    public void buildCharTest() throws Exception {
        Character character1 = DataUtil.build(Character.class);
        Character character2 = DataUtil.build(char.class);
        System.out.println(character1);
        System.out.println(character2);
    }

    /**
     *
     * Method: build(clazz)
     */
    @Test
    public void buildByteTest() throws Exception {
        Byte resultOne = DataUtil.build(Byte.class);
        Byte resultTwo = DataUtil.build(byte.class);
        System.out.println(resultOne);
        System.out.println(resultTwo);
    }

    /**
     *
     * Method: build(clazz)
     */
    @Test
    public void buildIntTest() throws Exception {
        Integer resultOne = DataUtil.build(Integer.class);
        Integer resultTwo = DataUtil.build(int.class);
        System.out.println(resultOne);
        System.out.println(resultTwo);
    }

    /**
     *
     * Method: build(clazz)
     */
    @Test
    public void buildShortTest() throws Exception {
        Short resultOne = DataUtil.build(Short.class);
        Short resultTwo = DataUtil.build(short.class);
        System.out.println(resultOne);
        System.out.println(resultTwo);
    }

    /**
     *
     * Method: build(clazz)
     */
    @Test
    public void buildLongTest() throws Exception {
        Long resultOne = DataUtil.build(Long.class);
        Long resultTwo = DataUtil.build(long.class);
        System.out.println(resultOne);
        System.out.println(resultTwo);
    }

    /**
     *
     * Method: build(clazz)
     */
    @Test
    public void buildFloatTest() throws Exception {
        Float resultOne = DataUtil.build(Float.class);
        Float resultTwo = DataUtil.build(float.class);
        System.out.println(resultOne);
        System.out.println(resultTwo);
    }

    /**
     *
     * Method: build(clazz)
     */
    @Test
    public void buildDoubleTest() throws Exception {
        Double resultOne = DataUtil.build(Double.class);
        Double resultTwo = DataUtil.build(double.class);
        System.out.println(resultOne);
        System.out.println(resultTwo);
    }

    /**
     *
     * Method: build(clazz)
     */
    @Test
    public void buildVoidTest() throws Exception {
        Void resultOne = DataUtil.build(Void.class);
        Void resultTwo = DataUtil.build(void.class);
        Assert.assertNull(resultOne);
        Assert.assertNull(resultTwo);
    }
}

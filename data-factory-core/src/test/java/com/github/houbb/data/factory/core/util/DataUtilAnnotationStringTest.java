package com.github.houbb.data.factory.core.util;

import com.github.houbb.data.factory.core.model.annotation.UserAnnotationString;

import org.junit.Test;
import org.junit.Assert;

/**
* <p> DataUtil Tester. </p>
* <p> 2019-02-26 16:20:40.536 </p>
*
* @author binbin.hou
* @version 0.0.1-SNAPSHOT
*/
public class DataUtilAnnotationStringTest {

    /**
    *
    * Method: build(clazz)
    */
    @Test
    public void stringAnnotationTest() throws Exception {
        for(int i = 0; i < 100; i++) {
            UserAnnotationString userAnnotationString = DataUtil.build(UserAnnotationString.class);

            Assert.assertNull(userAnnotationString.getHobby());
            Assert.assertTrue(userAnnotationString.getName().length() >= 2);
            Assert.assertTrue(userAnnotationString.getName().length() <= 10);
        }
    }

}

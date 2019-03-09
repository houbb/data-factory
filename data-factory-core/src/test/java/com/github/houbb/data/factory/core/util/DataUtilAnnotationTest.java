package com.github.houbb.data.factory.core.util;

import com.github.houbb.data.factory.core.model.annotation.UserAnnotation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
* <p> DataUtil Tester. </p>
* <p> 2019-02-26 16:20:40.536 </p>
*
* @author binbin.hou
* @version 0.0.1-SNAPSHOT
*/
public class DataUtilAnnotationTest {

    /**
    *
    * Method: build(clazz)
    */
    @Test
    public void stringAnnotationTest() throws Exception {
        for(int i = 0; i < 100; i++) {
            UserAnnotation userAnnotation = DataUtil.build(UserAnnotation.class);

            Assertions.assertNull(userAnnotation.getHobby());
            Assertions.assertTrue(userAnnotation.getName().length() >= 2);
            Assertions.assertTrue(userAnnotation.getName().length() <= 10);
        }
    }

}

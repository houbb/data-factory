package com.github.houbb.data.factory.core.util;

import com.github.houbb.data.factory.core.model.annotation.UserAnnotationString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

            Assertions.assertNull(userAnnotationString.getHobby());
            Assertions.assertTrue(userAnnotationString.getName().length() >= 2);
            Assertions.assertTrue(userAnnotationString.getName().length() <= 10);
        }
    }

}

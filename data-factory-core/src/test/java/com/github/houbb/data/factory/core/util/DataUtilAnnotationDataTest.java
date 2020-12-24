package com.github.houbb.data.factory.core.util;

import com.github.houbb.data.factory.core.model.annotation.UserAnnotationData;
import org.junit.jupiter.api.Test;

/**
* <p> DataUtil Tester. </p>
* <p> 2019-02-26 16:20:40.536 </p>
*
* @author binbin.hou
* @version 0.0.6
*/
public class DataUtilAnnotationDataTest {

    @Test
    public void test() {
        UserAnnotationData data = DataUtil.build(UserAnnotationData.class);
        assert  data.getName().equals("123");
    }

}

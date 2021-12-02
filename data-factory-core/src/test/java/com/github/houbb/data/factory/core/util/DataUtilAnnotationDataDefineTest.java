package com.github.houbb.data.factory.core.util;

import com.github.houbb.data.factory.core.model.annotation.UserAnnotationData;
import com.github.houbb.data.factory.core.model.annotation.UserDefineAnnotationData;
import org.junit.Test;

/**
* <p> 自定义注解 </p>
* <p> 2019-02-26 16:20:40.536 </p>
*
* @author binbin.hou
* @version 1.0.0
*/
public class DataUtilAnnotationDataDefineTest {

    @Test
    public void test() {
        UserDefineAnnotationData data = DataUtil.build(UserDefineAnnotationData.class);
        assert  data.getName().equals("echo");
        assert  data.getHobby().equals("game");
    }

}

package com.github.houbb.data.factory.core.api.data.aggregate;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.heaven.util.util.ArrayUtil;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 枚举信息的处理
 * @author binbin.hou
 * date 2019/2/27
 * @since 0.0.1
 */
public class EnumData implements IData<Enum> {

    @Override
    public Enum build(IContext context, Class<Enum> enumClass) {
        Enum[] enums = enumClass.getEnumConstants();
        if(ArrayUtil.isNotEmpty(enums)) {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            return enums[random.nextInt(enums.length)];
        }
        return null;
    }

}

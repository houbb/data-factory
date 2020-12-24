package com.github.houbb.data.factory.core.model.annotation;

import com.github.houbb.data.factory.api.annotation.DataFactory;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 数字类注解测试
 * @author binbin.hou
 * @date 2019/3/9
 * @since 0.0.2
 */
public class UserAnnotationNumber {

    @DataFactory(min = 10, max = 20)
    private Byte aByte;

    @DataFactory(min = 10, max = 20)
    private Short aShort;

    @DataFactory(min = 10, max = 20)
    private Integer integer;

    @DataFactory(min = 10, max = 20)
    private Long aLong;

    @DataFactory(min = 10, max = 20, precision = 3)
    private Double aDouble;

    @DataFactory(min = 10, max = 20, precision = 3)
    private Float aFloat;

    @DataFactory(min = 10, max = 20, precision = 3)
    private BigDecimal bigDecimal;

    @DataFactory(min = 10, max = 20)
    private BigInteger bigInteger;

    public Byte getaByte() {
        return aByte;
    }

    public void setaByte(Byte aByte) {
        this.aByte = aByte;
    }

    public Short getaShort() {
        return aShort;
    }

    public void setaShort(Short aShort) {
        this.aShort = aShort;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public Long getaLong() {
        return aLong;
    }

    public void setaLong(Long aLong) {
        this.aLong = aLong;
    }

    public Double getaDouble() {
        return aDouble;
    }

    public void setaDouble(Double aDouble) {
        this.aDouble = aDouble;
    }

    public Float getaFloat() {
        return aFloat;
    }

    public void setaFloat(Float aFloat) {
        this.aFloat = aFloat;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    public BigInteger getBigInteger() {
        return bigInteger;
    }

    public void setBigInteger(BigInteger bigInteger) {
        this.bigInteger = bigInteger;
    }

    @Override
    public String toString() {
        return "UserAnnotationNumber{" +
                "aByte=" + aByte +
                ", aShort=" + aShort +
                ", integer=" + integer +
                ", aLong=" + aLong +
                ", aDouble=" + aDouble +
                ", aFloat=" + aFloat +
                ", bigDecimal=" + bigDecimal +
                ", bigInteger=" + bigInteger +
                '}';
    }
}

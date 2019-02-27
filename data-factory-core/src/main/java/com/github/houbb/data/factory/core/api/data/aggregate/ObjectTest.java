package com.github.houbb.data.factory.core.api.data.aggregate;

/**
 * @author binbin.hou
 * date 2019/2/27
 */
public class ObjectTest<T> {

    private Iterable<T> iterable;

    public Iterable<T> getIterable() {
        return iterable;
    }

    public void setIterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }
}

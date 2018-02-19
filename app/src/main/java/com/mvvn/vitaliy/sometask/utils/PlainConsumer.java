package com.mvvn.vitaliy.sometask.utils;

import io.reactivex.functions.Consumer;

/*********
 * Created by vitaliy on 12/20/17.
 ********/

public interface PlainConsumer<T> extends Consumer<T> {
    /**
     * Consume the given value.
     * @param t the value
     */
    @Override
    void accept(T t);
}

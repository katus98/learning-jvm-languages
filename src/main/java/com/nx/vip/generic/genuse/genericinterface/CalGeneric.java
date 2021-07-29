package com.nx.vip.generic.genuse.genericinterface;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
public interface CalGeneric<T> {

    T add(T a, T b);

    T mul(T a, T b);

    T sub(T a, T b);

    T div(T a, T b);
}

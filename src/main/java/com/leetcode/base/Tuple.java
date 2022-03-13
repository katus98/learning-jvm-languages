package com.leetcode.base;

/**
 * @author SUN Katus
 * @version 1.0, 2022-03-13
 */
public class Tuple<U, V> {
    private U _1;
    private V _2;

    public Tuple() {
    }

    public Tuple(U _1, V _2) {
        this._1 = _1;
        this._2 = _2;
    }

    public U _1() {
        return _1;
    }

    public void _1(U _1) {
        this._1 = _1;
    }

    public V _2() {
        return _2;
    }

    public void _2(V _2) {
        this._2 = _2;
    }
}

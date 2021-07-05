package com.katus.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-17
 */
public class Order<T> {
    protected String orderName;
    protected int orderId;
    protected T orderT;

    public Order() {}

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    // 以下的方法都不是泛型方法
    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    // 静态方法中不能使用类的泛型
    public static void test() {
        // 异常类不能使用泛型 甚至不能继承为泛型类
//        try {
//
//        } catch (T t) {
//
//        }
    }

    public void test1() {
        // T[] ts = new T[10] 是错误的
        T[] ts = (T[]) new Object[10];
    }
}

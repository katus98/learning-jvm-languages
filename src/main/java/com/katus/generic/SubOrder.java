package com.katus.generic;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-17
 */
public class SubOrder<T> extends Order<T> {
    private String desc;

    public SubOrder() {}

    public SubOrder(String orderName, int orderId, T orderT, String desc) {
        super(orderName, orderId, orderT);
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "SubOrder{" +
                "desc='" + desc + '\'' +
                ", orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }
}

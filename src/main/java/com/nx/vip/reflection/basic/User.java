package com.nx.vip.reflection.basic;

import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
@NoArgsConstructor
@ToString
public class User extends Person {
    public static String nationality;
    public String idCard;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void play() {
        System.out.println("user play method...");
    }

    private User(String idCard, String address) {
        this.idCard = idCard;
        this.address = address;
    }

    /**
     * @param a 加数一
     * @param b 加数二
     * @return 返回两个加数的和
     */
    public int add(int a, int b) {
        return a + b;
    }
}

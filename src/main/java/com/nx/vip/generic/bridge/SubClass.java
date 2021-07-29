package com.nx.vip.generic.bridge;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
public class SubClass implements SuperClass<String> {
    @Override
    public String m01(String param) {
        return param + "---";
    }
}

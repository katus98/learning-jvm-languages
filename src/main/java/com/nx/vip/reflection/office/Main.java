package com.nx.vip.reflection.office;

import org.junit.jupiter.api.Test;

/**
 * 正常构造对象和反射构造对象之间的时间差异,
 * 反射构造对象要显著缓慢, 落后多个数量级
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
public class Main {

    private WPS getInstanceByKeyRef(String key) {
        String fullClassName = "com.nx.vip.reflection.office." + key;
        Class<?> clazz;
        WPS wps = null;
        try {
            clazz = Class.forName(fullClassName);
            wps = (WPS) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return wps;
    }

    private WPS getInstanceByKey(String key) {
        WPS wps;
        switch (key) {
            case "Word":
                wps = new Word();
                break;
            case "Excel":
                wps = new Excel();
                break;
            case "Pdf":
                wps = new Pdf();
                break;
            default:
                wps = null;
        }
        return wps;
    }

    @Test
    void test() {
        String key = "Pdf";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            WPS wps1 = getInstanceByKey(key);
            wps1.processDocument();
            WPS wps2 = getInstanceByKeyRef(key);
            wps2.processDocument();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start));
    }
}

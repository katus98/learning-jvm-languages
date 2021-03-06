package com.nx.vip.anno.fruit;

import com.nx.vip.anno.ColorEnum;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
public class Apple {
    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor = ColorEnum.RED)
    private String appleColor;

    @FruitProvider(id = 1, name = "山东富士")
    private String appleProvider;

    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
}

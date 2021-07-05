package com.katus.compare;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-12
 */
public class Good implements Comparable<Good> {
    private String name;
    private double price;

    public Good() {
        this("", 0.0);
    }

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Good o) {
        if (this.price > o.getPrice()) {
            return (int)(this.price - o.getPrice()) + 1;
        } else if (this.price == o.getPrice()) {
            return 0;
        } else {
            return (int)(this.price - o.getPrice()) - 1;
        }
    }
}

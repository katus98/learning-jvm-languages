package com.katus.enumAnnotation;

import org.junit.jupiter.api.Test;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-12
 */
public class enumTest {
    @Test
    public void test1() {
        Season1 season1 = Season1.SUMMER;
        System.out.println(season1);
    }

    @Test
    public void test2() {
        // toString() 常量名
        Season1 season1 = Season1.WINTER;
        System.out.println(season1.toString());

        // values() 获取枚举类的全部常量
        Season1[] season1s = Season1.values();
        for (Season1 value : season1s) {
            System.out.println(value.toString());
        }

        // valueOf("...") 根据名称获取枚举类常量 找不到会抛异常
        Season1 season11 = Season1.valueOf("AUTUMN");
        System.out.println(season11.toString());
    }

    @Test
    public void test3() {
        Season2 season2 = Season2.WINTER;
        season2.show();
    }
}

// Java5 之前的枚举类写法
class Season {
    private final String seasonName;
    private final String seasonDesc;

    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冰天雪地");

    // 可选方法
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}

// Java5 新特性 枚举类 默认继承自Enum类
enum Season1 {
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "冰天雪地");

    private final String seasonName;
    private final String seasonDesc;

    Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 可选方法
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}

interface Info {
    void show();
}

// Java5 新特性 枚举类 每个对象实现接口功能不同
enum Season2 implements Info {
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("你好吗");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("挺热的");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("你爽吗");
        }
    },
    WINTER("冬天", "冰天雪地"){
        @Override
        public void show() {
            System.out.println("很冷的");
        }
    };

    private final String seasonName;
    private final String seasonDesc;

    Season2(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 可选方法
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}

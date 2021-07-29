package com.nx.vip.generic.border;

import java.util.ArrayList;

/**
 * 泛型通配符：边界的问题
 * 三种边界
 * 无界： <?>
 * 上界： <? extends E>
 * 下界： <? super E>
 * 编译检查 保证类型的安全
 * 避免强制转换的硬编码
 * 增加调用代码的重用性
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
public class BorderDemo {

    /**
     * 无界通配符的使用
     */
    public void border01(ArrayList<?> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(0));
        }
    }

    /**
     * 上界通配符的使用
     * <? extends Object> 等同于 无界通配符
     */
    public void border02(ArrayList<? extends Number> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(0));
        }
    }

    /**
     * 下界通配符的使用
     */
    public void border03(ArrayList<? super Number> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(0));
        }
    }

    public static void main(String[] args) {
        BorderDemo borderDemo = new BorderDemo();
        ArrayList<String> strList = new ArrayList<>();
        ArrayList<Object> objList = new ArrayList<>();
        ArrayList<Number> numberArrayList = new ArrayList<>();
        ArrayList<Double> doubleArrayList = new ArrayList<>();
        ArrayList<Integer> intArrayList = new ArrayList<>();

        //无界
        borderDemo.border01(strList);
        borderDemo.border01(objList);
        borderDemo.border01(intArrayList);

        //上界
        borderDemo.border02(intArrayList);
        borderDemo.border02(doubleArrayList);

        //下界
        borderDemo.border03(numberArrayList);
        borderDemo.border03(objList);
    }
}

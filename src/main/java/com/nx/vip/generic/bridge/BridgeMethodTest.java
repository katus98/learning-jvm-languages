package com.nx.vip.generic.bridge;

/**
 * 在java1.5以前, 比如声明一个集合类型：
 * List list = new ArrayList();
 * 那么往list中可以添加任何类型的对象, 但是在从集合中获取对象时, 无法确定获取到的对象是什么具体的类型
 * 所以在1.5的时候引入了泛型, 在声明集合的时候就指定集合中存放的是什么类型的对象：
 * List<String> list = new ArrayList<String>();
 * 那么在获取时就不必担心类型的问题, 因为泛型在编译时编译器会检查往集合中添加的对象的类型是否匹配泛型类型
 * 如果不正确会在编译时就会发现错误, 而不必等到运行时才发现错误。
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
public class BridgeMethodTest {

    public static void main(String[] args) throws Exception {
        SuperClass cl = new SubClass();
        System.out.println(cl.m01("123"));
        // 字节码文件中使用的是m1(object)方法, 所以编译不会报错; 但是实际上调用的时候invoke还是泛型方法, 所以运行时报错
        System.out.println(cl.m01(new Object()));

        System.out.println(cl.getClass().getDeclaredMethod("m01", Object.class).isBridge());
    }
}

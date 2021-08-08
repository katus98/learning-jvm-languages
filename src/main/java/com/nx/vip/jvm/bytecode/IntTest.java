package com.nx.vip.jvm.bytecode;

/**
 * istort_2 操作码 + 操作数
 * 1、加载和存贮指令[类型]
 *   [i,f,l,d.a]load store
 *   bipush sipush ldc ldc_w ldc2_w... acontst_XXX
 * 2、对象的创建和访问
 *   new newarry, XXXarry
 *   get put...
 * 3、栈
 *   pop pop2
 * 4、ifeq iflt ifle ifne...
 *   goto...
 * 5、invokevitrul
 *   interface
 *   static
 *   special
 *
 * @author SUN Katus
 * @version 1.0, 2021-08-04
 */
public class IntTest {
    /**
     * 观察class文件的结构
     */
    public static void main(String[] args) {
        /*
        0: iconst_1
        1: istore_1
         */
        int a = 1;
        /*
        2: sipush        200
        5: istore_2
         */
        int b = 200;
        /*
        6: iload_1
        7: iload_2
        压入堆栈
         */
        /*
        8: iadd
        9: istore_3
         */
        int c = a + b;
        /*
        10: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        13: iload_3
        压入堆栈
        14: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
        17: return
         */
        System.out.println(c);
    }
}

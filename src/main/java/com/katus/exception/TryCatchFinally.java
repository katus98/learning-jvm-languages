package com.katus.exception;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-23
 */
public class TryCatchFinally {

    public static class Demo {
        public int process(int a) {
            try {
                a += 1;
                throw new MyException();
            } catch (MyException e) {
                return a;
            } finally {
                a += 1;
                System.out.println(a);   // 3
            }
        }

        public String processRef(String str) {
            try {
                str += "1";
                throw new MyException();
            } catch (MyException e) {
                return str;
            } finally {
                str += "1";
                System.out.println(str);   // 111
            }
        }
    }

    public static class MyException extends Exception {
        public MyException() {
        }

        public MyException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo.process(1));   // 2
        System.out.println(demo.processRef("1"));   // 11
    }
}

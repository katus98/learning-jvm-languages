package com.katus.io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 缓冲流测试 Buffered 优势在于效率高 速度快
 * @author SUN Katus
 * @version 1.0, 2020-08-21
 */
public class BufferedTest {
    @Test
    public void copyByBufferedStream() {
        File srcFile = new File("src/main/resources/pic.jpg");
        File destFile = new File("src/main/resources/pic2.jpg");
        FileInputStream inputStream;
        FileOutputStream outputStream;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            // 创建节点流
            inputStream = new FileInputStream(srcFile);
            outputStream = new FileOutputStream(destFile);
            // 在节点流的基础上 创建缓冲流
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            byte[] data = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(data)) != -1) {
                bufferedOutputStream.write(data, 0, len);
                // bufferedOutputStream.flush();   刷新缓冲区 立刻写入 不调用时只有缓冲区满了才会写入
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 先关闭外层流 再关闭内层流
            // 关闭外层流的同时 内层流会自动关闭 所以没有必要再写
            try {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testBufferedText() {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(new File("src/main/resources/test1.txt")));
            writer = new BufferedWriter(new FileWriter(new File("src/main/resources/test2.txt")));
            // 方式1
//            char[] chs = new char[10];
//            int len;
//            while ((len = reader.read(chs)) != -1) {
//                writer.write(chs, 0, len);
//            }
            // 方式2
            String str;
            while ((str = reader.readLine()) != null) {   // str中不包含换行符
                writer.write(str);
                writer.newLine();   // 换行
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

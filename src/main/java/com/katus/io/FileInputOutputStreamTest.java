package com.katus.io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 字节 IO 流测试 适合处理非文本文件 FileInputStream FileOutputStream
 * @author SUN Katus
 * @version 1.0, 2020-08-21
 */
public class FileInputOutputStreamTest {
    @Test
    public void copyFile() {
        File srcFile = new File("src/main/resources/pic.jpg");
        File destFile = new File("src/main/resources/pic2.jpg");
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(srcFile);
            outputStream = new FileOutputStream(destFile);
            byte[] data = new byte[1024];
            int len;
            while ((len = inputStream.read(data)) != -1) {
                outputStream.write(data, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

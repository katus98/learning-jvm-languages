package com.katus.io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符 IO 流测试 FileReader FileWriter 只能处理文本文件
 * @author SUN Katus
 * @version 1.0, 2020-08-21
 */
public class FileReaderWriterTest {
    @Test
    public void testFileReader() {
        File file = new File("src/main/resources/test.txt");
        FileReader fileReader = null;
        try {
            // 字符流
            fileReader = new FileReader(file);
            // 读取一个字符
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileReader2() {
        File file = new File("src/main/resources/test.txt");
        FileReader fileReader = null;
        try {
            // 字符流
            fileReader = new FileReader(file);
            // 读取一个字符
            char[] chs = new char[5];
            int len;
            while ((len = fileReader.read(chs)) != -1) {   // 返回每次读取数量 <= char数组长度
//                for (int i = 0; i < len; i++) {
//                    System.out.print(chs[i]);
//                }
                String s = new String(chs, 0, len);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileWriter() {
        File file = new File("src/main/resources/test1.txt");
        FileWriter fileWriter = null;
        try {
            //fileWriter = new FileWriter(file);   // 覆盖写入
            fileWriter = new FileWriter(file, true);   // 追加写入
            fileWriter.write("I have a dream!\n");
            fileWriter.write("You need to have a dream!\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void copyFile() {
        File srcFile = new File("src/main/resources/test1.txt");
        File destFile = new File("src/main/resources/test2.txt");
        FileReader reader = null;
        FileWriter writer = null;
        try {
            reader = new FileReader(srcFile);
            writer = new FileWriter(destFile);
            char[] chs = new char[10];
            int len;
            while ((len = reader.read(chs)) != -1) {
                writer.write(chs, 0, len);
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

package com.katus.io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * File 类
 * File类对象代表一个文件或者文件目录
 * @author SUN Katus
 * @version 1.0, 2020-08-17
 */
public class FileTest {
    @Test
    public void test1() {
        File file = new File("src\\main\\resources\\color.properties");
        System.out.println(file);

        File file1 = new File("src\\main", "resources");
        System.out.println(file1);

        File file2 = new File(file1, "color.properties");
        System.out.println(file2);
    }

    @Test
    public void test2() {
        File file1 = new File("src\\main\\resources\\color.properties");
        File file2 = new File("D:\\Data\\TestData");
        System.out.println(file1.getAbsolutePath());   // 获取文件绝对路径
        System.out.println(file1.getPath());   // 获取文件路径 构造的时候的参数
        System.out.println(file1.getName());   // 获取文件名字
        System.out.println(file1.getParent());   // 获取父目录
        System.out.println(file1.length());   // 文件大小 (字节)
        System.out.println(new Date(file1.lastModified()));   // 最后一次修改时间

        System.out.println();
        System.out.println(file2.getAbsolutePath());   // 获取文件绝对路径
        System.out.println(file2.getPath());   // 获取文件路径
        System.out.println(file2.getName());   // 获取文件名字
        System.out.println(file2.getParent());   // 获取父目录
        System.out.println(file2.length());   // 文件大小 (字节)
        System.out.println(new Date(file2.lastModified()));   // 最后一次修改时间

        String[] list = file2.list();
        System.out.println(Arrays.toString(list));
        File[] files = file2.listFiles();
        System.out.println(Arrays.toString(files));
    }

    @Test
    public void test3() {
        File file1 = new File("D:\\Data\\TestData\\words.txt");
        File file2 = new File("D:\\Data\\TestData\\word.txt");
        // 把file1名称改为file2名称 并返回成功与否
        // 要求file2实际不存在 否则会失败
        System.out.println(file1.renameTo(file2));
    }

    @Test
    public void test4() {
        File file = new File("D:\\Data\\TestData\\words.txt");
        // file = new File("D:\\Data\\TestData");
        // 以下方法的默认值都是false 如果不存在文件 则都是false
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());
        System.out.println(file.isHidden());
    }

    @Test
    public void test5() throws IOException {
        // 文件的创建与删除
        File file = new File("D:\\Data\\TestData\\test.txt");
        boolean result;
        if (file.exists()) {
            result = file.delete();
            System.out.println("delete: " + result);
        } else {
            result = file.createNewFile();
            System.out.println("create: " + result);
        }
    }

    @Test
    public void test6() {
        // 文件目录的创建与删除
        File dir1 = new File("D:\\Data\\TestData\\test");
        File dir2 = new File("D:\\Data\\TestData\\test\\test1");
        if (dir1.exists()) {
            System.out.println("delete: " + dir1.delete());
        }
        if (dir2.exists()) {
            System.out.println("delete: " + dir2.delete());
        } else {
            // 创建目录时如果存在则不再创建
            System.out.println("mkdir: " + dir2.mkdir());   // 只能创建单层目录(最后一层)
            System.out.println("mkdirs: " + dir2.mkdirs());   // 允许创建多层目录
        }
    }
}

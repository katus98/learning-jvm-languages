package com.nx.vip.io.nio;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.security.SecureRandom;

/**
 * NIO Java 缓冲区类的使用
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-22
 */
public class BufferTest {
    /**
     * 测试Buffer基本方法
     */
    @Test
    public void testBasicMethod() {
        // 分配缓冲区大小 capacity=6, position = 0, limit = capacity
        IntBuffer buffer = IntBuffer.allocate(6);
        for (int i = 0; i < buffer.capacity(); i++) {
            int nextInt = new SecureRandom().nextInt(20);
            // 将数据放入缓冲区 position + 1
            buffer.put(nextInt);
        }
        // 反转, limit = position, position = 0
        buffer.flip();
        while (buffer.hasRemaining()) {
            // 取出position位置的数据 position + 1
            System.out.println(buffer.get());
        }
    }

    /**
     * 测试从文件中读取内容
     */
    @Test
    public void testReadFile() throws IOException {
        FileInputStream fis = new FileInputStream("src/main/resources/test.txt");
        // 从输入流中获取隧道
        FileChannel channel = fis.getChannel();
        // 分配缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 将数据从隧道中读取, 写出到缓冲区中, 这个过程也存在pos的移动
        channel.read(buffer);
        // 读取缓冲区之前必须执行反转
        buffer.flip();
        // 读取
        while (buffer.hasRemaining()) {
            System.out.println((char) buffer.get());
        }
        fis.close();
    }

    /**
     * 测试将数据写出到文件
     */
    @Test
    public void testWriteFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("src/main/resources/testX.txt");
        // 从输入流中获取隧道
        FileChannel channel = fos.getChannel();
        // 编辑写出内容
        byte[] bytes = "Hello, I am god!".getBytes();
        // 分配缓冲区空间
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 将数据写入缓冲区
        buffer.put(bytes);
        // 反转
        buffer.flip();
        // 将数据从缓冲区中读出并写入到隧道中
        channel.write(buffer);
        fos.close();
    }

    /**
     * 测试从文件中读取内容然后写出到另一个文件
     */
    @Test
    public void testReadAndWriteFile() throws IOException {
        FileInputStream fis = new FileInputStream("src/main/resources/test1.txt");
        FileOutputStream fos = new FileOutputStream("src/main/resources/testX.txt");
        FileChannel readChannel = fis.getChannel();
        FileChannel writeChannel = fos.getChannel();
        // 堆内内存分配的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(50);
        // 堆外内存分配的缓冲区, 堆外效率更高, 因为IO通信最终都要借助OS API内存终究会拷贝到堆外
        // ByteBuffer buffer1 = ByteBuffer.allocateDirect(50);
        while (true) {
            // 将缓冲区中的指针状况全部恢复原装, 如果不执行的话就无法恢复write对pos的移动
            buffer.clear();
            // read方法会影响pos指针位置
            int readSize = readChannel.read(buffer);
            System.out.println(readSize);
            if (readSize == -1) break;
            // 将limit限制在pos写到的位置, 然后将pos指针移动到首部
            buffer.flip();
            // write方法也会影响pos指针位置
            writeChannel.write(buffer);
        }
        fis.close();
        fos.close();
    }

    /**
     * 测试各种类型的缓冲类型
     */
    @Test
    public void testBufferType() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.putChar('a');
        buffer.putInt(1);
        buffer.putLong(100L);
        buffer.putShort((short) 2);
        buffer.putFloat(4.5F);
        buffer.putDouble(5.5);
        System.out.println(buffer.position());
        buffer.flip();
        System.out.println(buffer.getChar());
        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getShort());
        System.out.println(buffer.getFloat());
        System.out.println(buffer.getDouble());
    }

    /**
     * 测试缓冲区切片
     */
    @Test
    public void testSlice() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); ++i) {
            buffer.put((byte) i);
        }
        buffer.position(2);
        buffer.limit(8);
        // slice方法是根据当前缓冲区的position和limit指针生成一个新的缓冲区
        // capacity = limit - position
        ByteBuffer resetBuffer = buffer.slice();
        for (int i = 0; i < resetBuffer.capacity(); i++) {
            byte anInt = resetBuffer.get();
            resetBuffer.put(i, (byte) (anInt * 2));
        }
        buffer.position(0);
        buffer.limit(buffer.capacity());
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }

    /**
     * 测试只读缓冲区
     */
    @Test
    public void testReadOnly() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }
        // 为原有缓冲区生成一个只读的引用, 拥有独立拷贝的三指针, 但是数据与原缓冲区绑定
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        System.out.println("------Class------");
        // 注意两者类不同
        System.out.println(buffer.getClass());
        System.out.println(readOnlyBuffer.getClass());
        System.out.println("------Old Position------");
        System.out.println(buffer.position());
        System.out.println(readOnlyBuffer.position());
        // 反转只读指针
        readOnlyBuffer.flip();
        System.out.println("------New Position------");
        System.out.println(buffer.position());
        System.out.println(readOnlyBuffer.position());
        // 读取只读缓冲区内容
        System.out.println("------Old Data------");
        for (int i = 0; i < readOnlyBuffer.capacity(); i++) {
            System.out.println(readOnlyBuffer.get());
        }
        // readOnlyBuffer.flip();
        // 只读缓冲区只能读, 不能写
        // readOnlyBuffer.put((byte) 1);
        // 对原始缓冲区的数据进行更改
        buffer.clear();
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) (i + 10));
        }
        // 只读缓冲区中的可以读到的数据也变化了
        System.out.println("------New Data------");
        readOnlyBuffer.flip();
        for (int i = 0; i < readOnlyBuffer.capacity(); i++) {
            System.out.println(readOnlyBuffer.get());
        }
    }

    /**
     * 测试缓冲区数组包装
     */
    @Test
    public void testWrap() {
        byte[] bytes = new byte[]{'a', 'b', 'c'};
        // wrap方法将字节数组包装到缓冲区中, 直接记录引用地址
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        // 对原始数组的修改会直接体现在缓冲区的数据上
        bytes[0] = 'b';
        // 对缓冲区的修改自不必说
        // 一个比较特别的如果指定索引号修改数据不会修改position指针的位置
        buffer.put(2, (byte) 'b');
        // 所以这个地方不需要flip
        for (int i = 0; i < buffer.capacity(); i++) {
            System.out.println((char) buffer.get());
        }
        // 可以证明两者是同一个数组
        System.out.println(buffer.array() == bytes);
    }
}

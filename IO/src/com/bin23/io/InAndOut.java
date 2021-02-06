package com.bin23.io;

import java.io.*;

/**
 * 文件的读写，输入于输出，读取文件中的数据到内存，还可以从内存写数据输出到文件
 */
public class InAndOut {

    public static void AboutIn(){
        InputStream in = null;
        OutputStream out = null;
        try {
            //现在输入数据，也就是从硬盘到内存
            in = new FileInputStream(new File("F:\\About_Test\\I am the One.txt"));
            System.out.println("获取可读取的文件的长度(字节)："+in.available());
            byte[] buf = new byte[in.available()];//这样就可以在内存中开辟一个合适的字节数组空间来存储输入流中传输过来的数据
            in.read(buf);//将数据读到buf中
//            byte - > String
//            System.out.println("看看buf内容："+buf);//这样打印的话是看不出来的
            System.out.println("看看buf内容："+new String(buf));
            System.out.println("所以完成写入了");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(in!=null)in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void AboutOut(){
        OutputStream out = null;
        try {
            //接下来输出，从内存输出到硬盘
            out = new FileOutputStream(new File("F:\\About_Test\\I am the Tow.txt"));
            out.write("你看，我就是从内存中出来的，来到了硬盘很开心".getBytes());
            System.out.println("完成输出");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(out!=null)out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        AboutIn();
        AboutOut();
    }
}

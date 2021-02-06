package com.bin23.io;

import java.io.*;

public class AboutFileCopy {

    /**
     * 通过字节流来复制文件，基本任何文件都可以通过字节流来复制
     */
    public static void copyByBytes(){
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream("F:\\About_Test\\I am the One.txt");
            out = new FileOutputStream("F:\\About_Test\\I am the Copy.txt");
            //开辟50字节的内存
            byte[] buf = new byte[50];

            int len = -1;
            while((len = in.read(buf))!=-1){
                out.write(buf,0,len);
            }
            System.out.println("通过字节流来复制文件，文件完成复制");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(out!=null)out.close();
                if(in!=null)in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 通过字符流来复制文件，这样对于，比如纯文本的复制，效率就高得多，不适合用于图片，视频等文件复制
     */
    public static void copyByCharacter(){
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new FileReader("F:\\About_Test\\待复制的源文件.txt");
            writer = new FileWriter("F:\\About_Test\\复制后且修改了的文件.txt");

            //通过字符流来读写，那么久开辟一个字符数组
            //我们可以分成很多分来读，不要一次性读，当然一次性读也行，要是文件是电影那种，2，3G这么大的那就内存爆炸了
            //一次读10个字符，开辟大小为10的字符数组空间
            char[] buf = new char[10];
            StringBuffer sb = new StringBuffer();//为拼接字符做准备
            int len = -1;
            while((len = reader.read(buf))!=-1){
                sb.append(buf,0,len);//每读一次拼接一次
            }
            System.out.println("看看已经读取到的数据："+sb);

            String content = sb.toString().replace("{地点}", "广州");

            writer.write(content);
            System.out.println("成功通过字符流复制文件");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer!=null)writer.close();
                if(reader!=null)reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 自带缓冲区的字符流，无需我们手动去写缓冲区了
     */
    public static void copyCharacterBuffered(){
        Reader reader = null;
        Writer writer = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            reader = new FileReader("F:\\About_Test\\待复制的源文件.txt");
            writer = new FileWriter("F:\\About_Test\\（自带缓冲区的字符流实现）复制后且修改了的文件.txt");

            br = new BufferedReader(reader);
            bw = new BufferedWriter(writer);

            StringBuffer sb = new StringBuffer();
            String line = null;

            while((line = br.readLine())!=null){//readLine();一整行的读，返回的是读到的内容
                sb.append(line);
            }
            System.out.println("看下通过readLine()方法读取到的内容："+sb);

            String content = sb.toString().replace("{地点}","深圳");

            bw.write(content);
            System.out.println("通过自带缓冲区的字符流实现复制了");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bw!=null)bw.close();
                if(br!=null)br.close();
                if(writer!=null)writer.close();
                if(reader!=null)reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        copyByBytes();
        copyByCharacter();
        copyCharacterBuffered();
    }
}

package com.bin23.io;

import java.io.*;

public class AboutFileCopyData {
    public static void main(String[] args) {
        InputStream in = null;
        DataInputStream din = null;

        OutputStream out = null;
        DataOutputStream dout = null;
        try {
            in = new FileInputStream("D:\\Wallpaper\\Assassin\\亚诺.jpg");
            din = new DataInputStream(in);

            out = new FileOutputStream("F:\\About_Test\\亚诺(二进制流).jpg");
            dout = new DataOutputStream(out);

            //开辟10字节的内存空间
            byte[] buf = new byte[10];
            int len = -1;
            while((len = din.read(buf))!=-1){
                dout.write(buf,0,len);
            }
            System.out.println("使用二进制流复制文件成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(dout!=null)dout.close();
                if(din!=null)din.close();
                if(out!=null)out.close();
                if(in!=null)in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

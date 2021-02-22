package com.bin23.test;

import com.bin23.deco.LowerCaseInputStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestIO {

    public static void testIO(){
        int c;
        try {
            InputStream in =
                    new LowerCaseInputStream(
                        new BufferedInputStream(
                            new FileInputStream("D:\\SoftWare\\JetBrains\\Learning\\About_PattenDesign\\StarBuzz\\JavaIO_DecoratorTest\\src\\readme.txt")));
            while((c = in.read()) >= 0) {
                System.out.print((char)c);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        testIO();
    }
}

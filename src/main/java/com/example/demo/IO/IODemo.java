package com.example.demo.IO;


import java.io.*;

/**
 * @author lei.X
 * @date 2018/9/27
 */
public class IODemo {
    /**
     * FileWriter字符流写入
     * @throws IOException
     */
    private static void fileWriterDemo() throws IOException {
        FileWriter fileWriter = null;
            fileWriter = new FileWriter("demo.txt");
            fileWriter.write("test");
            fileWriter.flush();
            fileWriter.close();

    }

    /***
     * fileReader 单字节读取
     * @throws IOException
     */
    private static void fileReadDemo() throws IOException {
        FileReader fileReader = new FileReader("demo.txt");

        int ch =0;
        while ((ch = fileReader.read())!=-1){
            System.out.println("ch="+(char)ch);
        }


    }

    /**
     * fileReader 按照块读取
     * @throws IOException
     */
    private static void fileReadDemo2() throws IOException {
        FileReader fileReader = new FileReader("demo.txt");

        char[] buf = new char[1024];
        int num=0;
        while ((num = fileReader.read(buf))!=-1){
            System.out.println(buf);
        }


    }

    /**
     * fileBufferReader
     * 为了提高效率。加入缓冲技术。将字符读取流对象作为参数传递给缓冲对象的构造函数。
     * @throws IOException
     */
    private static void fileBufferReadDemo() throws IOException {
        FileReader fileReader = new FileReader("demo.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

        bufferedReader.close();


    }

    /**
     * 添加缓冲的写入函数
     * 如果该文件以及存在，会直接覆盖原文件
     * @throws IOException
     */
    private static void fileBufferWriterDemo() throws IOException {
        FileWriter fileWriter = new FileWriter("demo.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (int i=0;i<5;i++){
            bufferedWriter.write("abcd: "+i);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

        bufferedWriter.close();



    }

    /**
     * fileInputStream
     *
     * inputStream对象的available()方法获取流中可读取的数据大小，通常我们调用这个函数是在下载文件或者对文件进行其他处理时获取文件的总大小。
     * available()在本地拷贝文件的时候可以使用，但是在获取网络流的时候，因为网络不稳定，read（）方法可能是阻塞的，说明这时候我们使用这个函数是获取不到文件的总大小的
     * 所以还是推荐在网络访问上使用固定的字符长度
     * @throws IOException
     */
    private static void fileInputStreamDemo() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("test.txt");

        byte[] buf = new byte[fileInputStream.available()];
        fileInputStream.read(buf);

        fileInputStream.close();


    }

    /**
     * fileInputStream
     * 采用固定大小的buffer
     * @throws IOException
     */
    private static void fileInputStreamDemo2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("demo.txt");
        byte[] buf = new byte[1024];
        int len =0;
        while ((len=fileInputStream.read(buf)) != -1){
            System.out.println(new String(buf,0,len));
        }


    }


    public static void main(String[] args) {
        try {
            fileInputStreamDemo2();
        } catch (IOException e) {
            System.out.println("error");
        }
    }
}

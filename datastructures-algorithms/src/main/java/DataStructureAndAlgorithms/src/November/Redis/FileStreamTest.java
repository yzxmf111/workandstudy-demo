package November.Redis;

import java.io.*;

public class FileStreamTest {
    private static final String fileName = "fileStream.txt";

    public static void main(String[] args) {
        testFileOutputStream();

       testFileInputStream();
    }
    /**

     * */
    private static void testFileOutputStream() {
       // FileOutputStream os = new FileOutputStream(fileName);
        File file = new File(fileName);
        try {
            //覆盖模式的FileOutputStream对象
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(new byte[]{0x61, 0x62, 0x63, 0x64});
            fos.write(new byte[]{0x65, 0x66, 0x67, 0x68});
            FileOutputStream fos2 = new FileOutputStream(file);
           fos.write(new byte[]{0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78});//qrstuvwx
           FileOutputStream fos3 = new FileOutputStream(file,true);
           fos3.write(new byte[] { 0x51, 0x52, 0x53, 0x54 });// QRST
            fos.flush();
            fos.close();
            fos2.close();
            fos3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void testFileInputStream() {

        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            FileDescriptor fd = fis.getFD();
            FileInputStream fis2 = new FileInputStream(fd);
            System.out.println("使用read()读取一个字节：" + (char) fis.read());
            System.out.println("使用available()获取当前可用字节数:" + fis.available());
            // 测试read(byte[] b,int off,int len)
            byte[] b = new byte[5];
            fis.read(b);
            System.out.println("使用readread(byte[] b,int off,int len)读取5个字节到b中:" + new String(b));
            System.out.println("使用available()获取当前可用字节数:" + fis.available());
            System.out.printf("使用skip(long n)跳过%s个字节\n", fis.skip(1));
            System.out.println("使用available()获取当前可用字节数:" + fis.available());
            fis.close();
            fis2.close();
            // 测试skip(long byteCount)
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

package November.Redis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestChannelAndBuffer {
    public static void main(String[] args) {
        // 为了比较效率，记录程序执行时间
        long startTime = System.currentTimeMillis();  // 开始时间

        // 1 声明输入输出流
        FileInputStream fis = null;
        FileOutputStream fos = null;
        // 2 声明通道
        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            // 3 创建输入输出流
            fis = new FileInputStream("田一帆-华东理工大学-机械.pdf");
            fos = new FileOutputStream("D:/田一帆-华东理工大学-机械.pdf");

            // 4 获取通道
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            // 5 分配指定大小的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // 6 将通道中的数据存入缓存区中
            while(inChannel.read(buffer) != -1){
                buffer.flip();  // 切换到读取数据的模式
                // 7 将缓存区中的数据写入通道中
                outChannel.write(buffer);
                buffer.clear();  // 清空缓存区
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(outChannel != null){
                try{
                    outChannel.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(inChannel != null){
                try{
                    inChannel.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try{
                    fos.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try{
                    fis.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }

        // 记录结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("用通道完成文件的复制（非直接缓冲区）耗时为" + (endTime - startTime) + "MS");


    }
}

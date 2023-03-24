package November.Redis;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestChannel {
    public static void main(String[] args) throws IOException {
        // 1. 通过本地IO的方式来获取通道
        FileInputStream fileInputStream = new FileInputStream("F:\\3yBlog\\JavaEE常用框架\\Elasticsearch就是这么简单.md");

        // 得到文件的输入通道
        FileChannel inchannel = fileInputStream.getChannel();

        // 2. jdk1.7后通过静态方法.open()获取通道
        FileChannel.open(Paths.get("F:\\3yBlog\\JavaEE常用框架\\Elasticsearch就是这么简单2.md"), StandardOpenOption.WRITE);
    }
}

/**
 * FileName: Test
 * Author:   yangqinkuan
 * Date:     2019-12-10 12:06
 * Description:
 */

package NIO;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        int i = 4;
        int b = ( i << 0 );
        System.out.println(b);

        /*File destFile = new File("asdas");
        // 1. 获取管道
        Pipe pipe = Pipe.open();

        // 2. 将缓冲区数据写入到管道
        // 2.1 获取一个通道
        Pipe.SinkChannel sinkChannel = pipe.sink();
        // 2.2 定义缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.put("发送数据".getBytes());
        buffer.flip(); // 切换数据模式
        // 2.3 将数据写入到管道
        sinkChannel.write(buffer);

        // 3. 从管道读取数据
        Pipe.SourceChannel sourceChannel = pipe.source();
        buffer.flip();
        int len = sourceChannel.read(buffer);
        System.out.println(new String(buffer.array(),0,len));

        // 4. 关闭管道
        sinkChannel.close();
        sourceChannel.close();*/
    }
}

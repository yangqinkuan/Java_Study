/**
 * FileName: Test3
 * Author:   yangqinkuan
 * Date:     2019-12-11 15:16
 * Description:
 */

package BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Test3 {
    public static void main(String[] args) {
        int port = 8080;
        try {
            ServerSocket server = new ServerSocket(port,1024);
            Socket socket = server.accept();
            new Thread(new ServerHandler(socket)).start();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //做相应的结尾动作
        }

    }
    static class ServerHandler implements Runnable {
        private Socket socket;
        public ServerHandler(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            BufferedReader in = null;
            PrintWriter out = null;
            try{
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(),true);
                String expression;
                String result;
                while(true){
                    //通过BufferedReader读取一行
                    //如果已经读到输入流尾部，返回null,退出循环
                    //如果得到非空值，就尝试计算结果并返回
                    if((expression = in.readLine())==null) break;
                    System.out.println("服务器收到消息：" + expression);
                    try{
                        result = "返回"+expression;
                    }catch(Exception e){
                        result = "计算错误：" + e.getMessage();
                    }
                    out.println(result);
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                //一些必要的清理工作，由于代码篇幅长，此处就不贴了
            }
        }
    }
}

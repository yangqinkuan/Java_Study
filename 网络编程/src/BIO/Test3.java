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
            //����Ӧ�Ľ�β����
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
                    //ͨ��BufferedReader��ȡһ��
                    //����Ѿ�����������β��������null,�˳�ѭ��
                    //����õ��ǿ�ֵ���ͳ��Լ�����������
                    if((expression = in.readLine())==null) break;
                    System.out.println("�������յ���Ϣ��" + expression);
                    try{
                        result = "����"+expression;
                    }catch(Exception e){
                        result = "�������" + e.getMessage();
                    }
                    out.println(result);
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                //һЩ��Ҫ�������������ڴ���ƪ�������˴��Ͳ�����
            }
        }
    }
}

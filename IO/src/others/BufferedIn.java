package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * ��װ����
 * @author Administrator
 *
 */
public class BufferedIn {
	public static void main(String[] args) throws IOException {
		InputStream is = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		System.out.println("�����롣����");
		String msg = br.readLine();
		System.out.println(msg);
	}
}

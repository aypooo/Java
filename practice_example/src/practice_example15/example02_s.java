package practice_example15;
import java.io.*;
import java.util.*;
import java.net.*;
public class example02_s {

	public static void main(String[] args) {
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		try {
			listener = new ServerSocket(9999);
			System.out.println("Ÿ�Ӽ����Դϴ�.");
			socket = listener.accept();
			System.out.println("����Ǿ����ϴ�");
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			TimerThread th = new TimerThread(out);
			th.start();
			th.join();
			
			while(true) {
				out.write(th + "\n");
				out.flush();
				
			}
		}catch(IOException e) {
			System.out.println("Ŭ���̾�Ʈ���� ä���� ����Ǿ����ϴ�. ");
		}
		

	}

}
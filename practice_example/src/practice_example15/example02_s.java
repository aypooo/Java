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
			System.out.println("타임서버입니다.");
			socket = listener.accept();
			System.out.println("연결되었습니다");
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			TimerThread th = new TimerThread(out);
			th.start();
			th.join();
			
			while(true) {
				out.write(th + "\n");
				out.flush();
				
			}
		}catch(IOException e) {
			System.out.println("클라이언트와의 채팅이 종료되었습니다. ");
		}
		

	}

}

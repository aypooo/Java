package practice_example15;
import java.io.*;
import java.net.*;

public class example01_s {

	public static void main(String[] args) {
		BufferedReader in = null;
		ServerSocket listener = null;
		Socket socket = null;
		try {
			listener = new ServerSocket(9999);
			System.out.println("연결을 기다리고 있습니다......");
			socket = listener.accept();
			System.out.println("연결 되었습니다.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true) {
				String inputMessage = in.readLine();
				if(inputMessage.equals("끝")) {
					System.out.println("클라이언트에서 연결을 종료하였습니다.");
				}
				System.out.println("클라이언트:" +inputMessage);
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				socket.close();
				listener.close();
			}catch(IOException e) {
				System.out.println("클라이언트와 채팅 중 오류가 발생했습니다.");
			}
		}

	}

}

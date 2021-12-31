package practice_example15;
import java.io.*;
import java.net.*;

public class example02_c {

	public static void main(String[] args) {
		BufferedReader in = null;
		Socket socket = null;
		try {
			socket = new Socket("localhost",9999);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true) {
				String inputMessage = in.readLine();
				System.out.println(inputMessage);
			}
		
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				if(socket !=null)socket.close();
			}catch (IOException e) {
				System.out.println("서버와의 접속 중 오류가 발생했습니다.");
			}
		}

	}

}

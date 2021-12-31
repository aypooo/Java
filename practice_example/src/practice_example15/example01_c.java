package practice_example15;
import java.io.*;
import java.net.*;
import java.util.*;
public class example01_c {

	public static void main(String[] args) {
		BufferedWriter out = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		try {
			socket = new Socket("localhost", 9999);
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true){
				System.out.println("보내기>>");
				String outputMessage = scanner.nextLine();
				if(outputMessage.equals("끝")) {
					out.write(outputMessage+"\n");
					out.flush();
					break;
				}
				out.write(outputMessage+"\n");
				out.flush();
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				scanner.close();
				if(socket != null) socket.close();
			}catch(IOException e) {
				System.out.println("서버와 채팅 중 오류가 발생했습니다. ");
			}
		}

	}

}

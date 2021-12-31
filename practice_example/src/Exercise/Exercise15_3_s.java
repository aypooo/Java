package Exercise;
import java.io.*;
import java.net.*;
import java.util.*;

public class Exercise15_3_s {

	public static void main(String[] args) {
		//서버프로그램
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		try {
			listener = new ServerSocket(8888);//서버 소켓 생성
			System.out.println("연결을 기다리고 있습니다.....");
			socket = listener.accept();
			System.out.println("연결되었습니다.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				String inputMessage = in.readLine(); //클라이언트로부터 한 행 읽기
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트에서 bye로 연결을 종효하였음");
					break;
				}
				System.out.println("클라이언트:"+inputMessage);
				System.out.println("보내기>>");//프롬프트
				String outputMessage = scanner.nextLine(); //키보드에서 한 행 읽기
				out.write(outputMessage +"\n"); //키보드에서 읽은 문자열 전송
				
			}
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				scanner.close();
				socket.close();
				listener.close();
			}catch(IOException e) {
				System.out.println("클라이언트와 채팅 중 오류가 발생했습니다.");
			}
		}

	}

}

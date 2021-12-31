package Exercise;
import java.io.*;
import java.net.*;
import java.util.*;

public class Exercise15_3_c {

	public static void main(String[] args) {
		//클라이언트프로그램
		BufferedReader in = null;
		BufferedWriter out = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		try {
			socket = new Socket("localhost",9999);//클라이언트 소켓 생성. 서버 연결
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				System.out.print("보내기>>");//프롬프트
				String outputMessage = in.readLine(); //키보드부터 한 행 읽기
				if(outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage+"\n");//bye 문자열 전송
					out.flush();
					break;
				}
				out.write(outputMessage+"\n");//bye 문자열 전송
				out.flush();
				System.out.println("서버:"+outputMessage);
				
				String inputMessage = in.readLine(); //키보드에서 한 행 읽기
				System.out.println("서버:"+inputMessage);
				
			}
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				scanner.close();
				if(socket !=null) socket.close(); //클라이언트 소켓 닫기
			//여기 덜침
			}catch(IOException e) {
				System.out.println("서버와 채팅 중 오류가 발생했습니다.");
			}
		}

	}

}

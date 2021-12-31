package Exercise;
import java.io.*;
import java.net.*;
import java.util.*;

public class Exercise15_3_c {

	public static void main(String[] args) {
		//Ŭ���̾�Ʈ���α׷�
		BufferedReader in = null;
		BufferedWriter out = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		try {
			socket = new Socket("localhost",9999);//Ŭ���̾�Ʈ ���� ����. ���� ����
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				System.out.print("������>>");//������Ʈ
				String outputMessage = in.readLine(); //Ű������� �� �� �б�
				if(outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage+"\n");//bye ���ڿ� ����
					out.flush();
					break;
				}
				out.write(outputMessage+"\n");//bye ���ڿ� ����
				out.flush();
				System.out.println("����:"+outputMessage);
				
				String inputMessage = in.readLine(); //Ű���忡�� �� �� �б�
				System.out.println("����:"+inputMessage);
				
			}
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				scanner.close();
				if(socket !=null) socket.close(); //Ŭ���̾�Ʈ ���� �ݱ�
			//���� ��ħ
			}catch(IOException e) {
				System.out.println("������ ä�� �� ������ �߻��߽��ϴ�.");
			}
		}

	}

}

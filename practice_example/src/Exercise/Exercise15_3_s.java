package Exercise;
import java.io.*;
import java.net.*;
import java.util.*;

public class Exercise15_3_s {

	public static void main(String[] args) {
		//�������α׷�
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		try {
			listener = new ServerSocket(8888);//���� ���� ����
			System.out.println("������ ��ٸ��� �ֽ��ϴ�.....");
			socket = listener.accept();
			System.out.println("����Ǿ����ϴ�.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				String inputMessage = in.readLine(); //Ŭ���̾�Ʈ�κ��� �� �� �б�
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("Ŭ���̾�Ʈ���� bye�� ������ ��ȿ�Ͽ���");
					break;
				}
				System.out.println("Ŭ���̾�Ʈ:"+inputMessage);
				System.out.println("������>>");//������Ʈ
				String outputMessage = scanner.nextLine(); //Ű���忡�� �� �� �б�
				out.write(outputMessage +"\n"); //Ű���忡�� ���� ���ڿ� ����
				
			}
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				scanner.close();
				socket.close();
				listener.close();
			}catch(IOException e) {
				System.out.println("Ŭ���̾�Ʈ�� ä�� �� ������ �߻��߽��ϴ�.");
			}
		}

	}

}

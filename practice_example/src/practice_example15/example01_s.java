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
			System.out.println("������ ��ٸ��� �ֽ��ϴ�......");
			socket = listener.accept();
			System.out.println("���� �Ǿ����ϴ�.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true) {
				String inputMessage = in.readLine();
				if(inputMessage.equals("��")) {
					System.out.println("Ŭ���̾�Ʈ���� ������ �����Ͽ����ϴ�.");
				}
				System.out.println("Ŭ���̾�Ʈ:" +inputMessage);
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				socket.close();
				listener.close();
			}catch(IOException e) {
				System.out.println("Ŭ���̾�Ʈ�� ä�� �� ������ �߻��߽��ϴ�.");
			}
		}

	}

}
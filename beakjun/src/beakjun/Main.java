package beakjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		int cnt = 0;
		for(int i=0;i<9;i++) {
			int a= Integer.parseInt(st.nextToken());
			if(a>max) {
				max=a;
				cnt=i;
			}
			System.out.println(max);
			System.out.println(cnt);
		}
	}

}

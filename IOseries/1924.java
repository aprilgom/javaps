import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{

		int[] dpm = {31,28,31,30,31,30,31,31,30,31,30,31};
		String[] dotw = {"SUN","MON","TUE","WED","THU","FRI","SAT"};

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		int mon = Integer.parseInt(s[0]);
		int days = Integer.parseInt(s[1]);
		for(int i = 0;i<mon-1;i++){
			days += dpm[i];
		}
		System.out.println(dotw[days%7]);

	}
}

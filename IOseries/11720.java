import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split("");
		int sum = 0;
		for(String i:s){
			sum += Integer.parseInt(i);
		}
		System.out.println(sum);
	}
}

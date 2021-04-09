import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] cnts = new int[10001];
		for(int i = 0;i<N;i++){
			int n = Integer.parseInt(br.readLine());
			cnts[n]++;
		}
		for(int i = 1;i<=10000;i++){
			for(int j = 0;j<cnts[i];j++){
				bw.write(String.valueOf(i));
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

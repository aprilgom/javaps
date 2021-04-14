import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] sq = new int[n];
		for(int i = 0;i<n;i++){
			sq[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(sq);
		for(int i:sq){
			bw.write(String.valueOf(i));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}

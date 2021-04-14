import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dots = new int[n][2];
		for(int i = 0;i<n;i++){
			String[] s = br.readLine().split(" ");
			dots[i][0] = Integer.parseInt(s[0]);
			dots[i][1] = Integer.parseInt(s[1]);
		}
		Arrays.sort(dots,(a,b)->{
			if(a[1] == b[1]){
				return Integer.compare(a[0],b[0]);
			}
			return Integer.compare(a[1],b[1]);
		});
		for(int[] i:dots){
			System.out.print(i[0]);
			System.out.print(" ");
			System.out.print(i[1]);
			System.out.print("\n");
		}
	}
}

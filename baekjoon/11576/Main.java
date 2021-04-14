import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int A = Integer.parseInt(s[0]);
		int B = Integer.parseInt(s[1]);
		br.readLine();
		String[] numl = br.readLine().split(" ");
		int[] al = Arrays.stream(numl)
			.mapToInt(i->Integer.parseInt(i))
			.toArray();
		int mul = 1;
		int sum = 0;
		for(int i = 0;i<al.length;i++){
			sum = sum*A + al[i];
		}
		Stack<Integer> lb = new Stack<>();
		while(sum>0){
			lb.push(sum%B);
			sum /= B;
		}
		StringBuilder sb = new StringBuilder();
		while(!lb.isEmpty()){
			sb.append(lb.pop()).append(" ");
		}
		System.out.println(sb);
	}
}

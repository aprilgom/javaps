import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<Integer> is = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++){
			is.add(Integer.parseInt(st.nextToken()));
		}
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<M;i++){
			int m = Integer.parseInt(st.nextToken());
			if(is.contains(m)){
				sb.append(1);
			}else{
				sb.append(0);
			}
			sb.append(" ");
		}
		System.out.println(sb);
	}
}

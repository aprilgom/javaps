import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Queue<Integer> A = new ArrayDeque<>();
		Queue<Integer> B = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++){
			A.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<M;i++){
			B.add(Integer.parseInt(st.nextToken()));
		}
		Queue<Integer> C = new ArrayDeque<>();
		while((!A.isEmpty())&&(!B.isEmpty())){
			if(A.element() < B.element()){
				C.add(A.remove());
			}else{
				C.add(B.remove());
			}
		}
		while(!A.isEmpty()){
			C.add(A.remove());
		}
		while(!B.isEmpty()){
			C.add(B.remove());
		}
		StringBuilder sb = new StringBuilder();
		while(!C.isEmpty()){
			sb.append(C.remove()).append(" ");
		}
		System.out.println(sb);
	}
}

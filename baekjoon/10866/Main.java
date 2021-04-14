import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>(N);
		for(int i = 0;i<N;i++){
			String[] s = br.readLine().split(" ");
			Integer p = 0;
			switch(s[0]){
				case "push_front":
					dq.offerFirst(Integer.parseInt(s[1]));
					break;
				case "push_back":
					dq.offerLast(Integer.parseInt(s[1]));
					break;
				case "pop_front":
					p = dq.pollFirst();
					if(p == null){
						p = -1;
					}
					System.out.println(p);
					break;
				case "pop_back":
					p = dq.pollLast();
					if(p == null){
						p = -1;
					}
					System.out.println(p);
					break;
				case "size":
					System.out.println(dq.size());
					break;
				case "empty":
					if(dq.isEmpty()){
						System.out.println(1);
					}else{
						System.out.println(0);
					}
					break;
				case "front":
					p = dq.peekFirst();
					if(p == null){
						p = -1;
					}
					System.out.println(p);
					break;
				case "back":
					p = dq.peekLast();
					if(p == null){
						p = -1;
					}
					System.out.println(p);
					break;
			}
		}
	}
}

import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		List<Integer> l = new ArrayList<>();
		for(int i = 1;i<=N;i++){
			l.add(i);
		}
		ListIterator<Integer> li = l.listIterator();
		List<Integer> ret = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		while(l.size()>0){
			Integer c = 0;
			for(int i = 0;i<K;i++){
				if(li.hasNext()){
					c = li.next();
				}else{
					li = l.listIterator();
					c = li.next();
				}
			}
			sb.append(String.valueOf(c)+", ");
			li.remove();
		}
		sb.deleteCharAt(sb.length()-1);
		sb.deleteCharAt(sb.length()-1);
		sb.append('>');
		System.out.println(sb);
	}
}

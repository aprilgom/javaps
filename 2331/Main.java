import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int A = Integer.parseInt(s[0]);
		int P = Integer.parseInt(s[1]);
		Set<Integer> visited = new HashSet<>();
		List<Integer> sq = new ArrayList<>();
		int a = A;
		while(!visited.contains(a)){
			visited.add(a);
			sq.add(a);
			a = getNext(a,P);
		}
		while(!(sq.get(sq.size()-1) == a)){
			sq.remove(sq.size()-1);
		}
		sq.remove(sq.size()-1);
		System.out.println(sq.size());
	}
	static int getNext(int a,int p){
		int ret = 0;
		while(a>0){
			ret += Math.pow(a%10,p);
			a /= 10;
		}
		return ret;
	}
}

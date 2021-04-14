import java.util.*;
import java.io.*;

class Conf{
	public int s,e;
	public Conf(int s,int e){
		this.s = s;
		this.e = e;
	}
}
public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Conf> pq = new PriorityQueue<>((a,b)->{
			if(a.e == b.e){
				return a.s - b.s;
			}
			return a.e - b.e;
		});
		for(int i = 0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			pq.add(new Conf(s,e));
		}
		int time = 0;
		int ret = 0;
		while(!pq.isEmpty()){
			Conf cf = pq.remove();
			if(time > cf.s){
				continue;
			}
			time = cf.e;
			ret++;
		}
		System.out.println(ret);
	}
}

import java.util.stream.IntStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;

public class Solution{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		ArrayList<Integer> lpipes = new ArrayList<Integer>();
		for(int i = 0;i<M;i++){
			int lp = sc.nextInt();
			lpipes.add(lp);
		}
		ArrayList<Integer> spipes = new ArrayList<Integer>();
		int N = sc.nextInt();
		for(int i = 0;i<N;i++){
			int sp = sc.nextInt();
			spipes.add(sp);
		}
		AtomicInteger max_pipe_n = new AtomicInteger(0);
		spipes
			.stream()
			.sorted()
			.forEach(sp->{
				System.out.println(sp);
				int minlpidx = IntStream
					.range(0,lpipes.size())
					.filter(n->lpipes.get(n)>=sp)
					.reduce((i,j)->lpipes.get(i)>lpipes.get(j)?j:i)
					.orElse(-1);
				if(minlpidx>=0){
					lpipes.set(minlpidx,lpipes.get(minlpidx)-sp);
					max_pipe_n.incrementAndGet();
				}
			});
		System.out.println(max_pipe_n);
	}
}

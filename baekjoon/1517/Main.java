import java.util.*;
import java.util.stream.*;
import java.io.*;

class Fenwick{
	Map<Integer,Integer> _data;
	int N;
	public Fenwick(int n){
		_data = new HashMap<>();
		N = n;
	}
	int getData(int idx){
		if(_data.containsKey(idx)){
			return _data.get(idx);
		}else{
			_data.put(idx,0);
			return 0;
		}
	}
	public void update(int idx,int diff){
		while(idx<=N){
			int tmp = getData(idx);
			_data.put(idx,tmp + diff);
			idx += (idx&-idx);
		}
	}
	public int sum(int idx){
		int ret = 0;
		while(idx>0){
			ret += getData(idx);
			idx -= idx&-idx;
		}
		return ret;
	}
}
public class Main{
	static Fenwick fw;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<int[]> ls = new ArrayList<>();
		for(int i = 0;i<N;i++){
			int tmp = Integer.parseInt(st.nextToken());
			ls.add(new int[]{i+1,tmp});
		}

		ls = ls.stream()
			.sorted((a,b)->{
				if(b[1] == a[1]){
					return b[0] - a[0];
				}
				return b[1] - a[1];
			})
			.collect(Collectors.toList());

		fw = new Fenwick(N+1);
		long ret = 0;
		for(int[] i:ls){
			ret += fw.sum(i[0]-1);
			fw.update(i[0],1);
		}
		System.out.println(ret);
	}
}

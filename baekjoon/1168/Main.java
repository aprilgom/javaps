import java.util.*;
import java.io.*;
class Fenwick{
	public int[] data;
	public Fenwick(int[] p){
		data = new int[p.length+1];
		for(int i = 0;i<p.length;i++){
			update(i,p[i]);
		}
	}
	public void update(int idx,int diff){
		idx++;
		while(idx<data.length){
			data[idx] += diff;
			idx += (idx&-idx);
		}
	}
	public int sum(int idx){
		idx++;
		int ret = 0;
		while(idx>0){
			ret += data[idx];
			idx -= (idx&-idx);
		}
		return ret;
	}
	public int sum(int l,int r){
		if(l>r){
			return sum(r) + sum(l,data.length-2);
		}
		return sum(r) - sum(l-1);
	}
}

public class Main{
	static int[] man;
	static int N;
	static int K;
	static Fenwick fw;
	static List<Integer> yps;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
		man = new int[N];
		Arrays.fill(man,1);
		fw = new Fenwick(man);
		yps = new ArrayList<>();
		jose();
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		for(int i:yps){
			sb.append(i).append(", ");
		}
		sb.delete(sb.length()-2,sb.length());
		sb.append('>');
		System.out.println(sb);
	}
	static void jose(){
		int f = find(0,0,N-1,K);
		fw.update(f,-1);
		yps.add(f+1);
		int len = fw.sum(0,N-1); 
		while(len >= K){
			f = find(f,f,(N+f-1)%N,K);
			fw.update(f,-1);
			len--;
			yps.add(f+1);
		}
		while(len > 1){
			if(K%len != 0){
				f = find(f,f,(N+f-1)%N,K%len);
			}else{
				f = find(f,f,(N+f-1)%N,len);//놓쳤던거
			}
			fw.update(f,-1);
			len--;
			yps.add(f+1);
		}
		if(K != 1){
			f = find(f,f,(N+f-1)%N,1);
			yps.add(f+1);
		}
	}
	static int find(int start,int left,int right,int target){
		int mid = 0;
		int rmid = 0;
		int sum = 0;
		if(left > right){
			right += N;
		}
		while(left <= right){
			mid = (left + right)/2;
			rmid = mid%N;
			sum = fw.sum(start,rmid);
			if(sum < target){
				left = mid+1;//놓쳤던거
			}else if(sum > target){
				right = mid;
			}else{
				if(fw.sum(rmid,rmid) == 1){
					break;
				}
				right = mid;
			}
		}
		return rmid;
	}
}

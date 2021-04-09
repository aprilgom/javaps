import java.io.*;
import java.util.*;

class UQ{
	int[] data;
	int start = 0;
	int back = 0;
	int size = 0;
	int max;
	public UQ(int n){
		data = new int[n];
		max = n;
	}
	public void offer(int p){
		data[back] = p;
		back = ++back%max;
		size++;
	}
	public int poll(){
		if(start == back){
			return -1;
		}
		int ret = data[start];
		start = ++start%max;
		size--;
		return ret;
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
	public int front(){
		if(start == back){
			return -1;
		}
		return data[start];
	}
	public int back(){
		if(start == back){
			return -1;
		}
		return data[back-1];
	}
}
public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		UQ q = new UQ(N);
		for(int i = 0;i<N;i++){
			String[] s = br.readLine().split(" ");
			switch(s[0]){
				case "push":
					q.offer(Integer.parseInt(s[1]));
				break;
				case "pop":
					System.out.println(q.poll());
				break;
				case "size":
					System.out.println(q.size());
				break;
				case "empty":
					if(q.isEmpty()){
						System.out.println(1);
					}else{
						System.out.println(0);
					}
				break;
				case "front":
					System.out.println(q.front());
				break;
				case "back":
					System.out.println(q.back());
				break;
			}
		}
	}
}

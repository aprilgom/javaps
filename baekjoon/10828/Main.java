import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stk stk = new Stk(N);
		for(int i = 0;i<N;i++){
			String[] s = br.readLine().split(" ");
			switch(s[0]){
				case "push":
					stk.push(Integer.parseInt(s[1]));
					break;
				case "pop":
					System.out.println(stk.pop());
					break;
				case "size":
					System.out.println(stk.size());
					break;
				case "empty":
					System.out.println(stk.empty());
					break;
				case "top":
					System.out.println(stk.top());
					break;
			}
		}
	}
}
class Stk{
	int[] data;
	int top = -1;
	public Stk(int n){
		data = new int[n];
	}
	public void push(int i){
		top++;
		data[top] = i;
	}
	public int pop(){
		if(top == -1)return -1;
		return data[top--];
	}
	public int size(){
		return top+1;
	}
	public int empty(){
		if(top == -1){
			return 1;
		}
		return 0;
	}
	public int top(){
		if(top==-1)return -1;
		return data[top];
	}
}

import java.util.*;
import java.io.*;

public class Main{
	static char[] digits;
	static int[][][] dp;
	static int N,m;
	static String e;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		dp = new int[1<<14][20][2];
		for(int tc = 0;tc<TC;tc++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			e = st.nextToken();
			N = e.length();
			digits = e.toCharArray();
			Arrays.sort(digits);
			m = Integer.parseInt(st.nextToken());
			for(int i = 0;i<(1<<14);i++){
				for(int j = 0;j<20;j++){
					Arrays.fill(dp[i][j],-1);
				}
			}
			System.out.println(sol(0,0,0,0));
		}
	}
	/*
	 * idx : 현재 가격 e의 인덱스.
	 * taken : 정렬된 숫자판 digits에서 어느 숫자판을 사용하였는지. 
	 *		예) 01100 : 1번째와 2번째 숫자판을 사용하였음.
	 * mod : 지금까지 만든 가격을 m으로 나눈 나머지.
	 *		가격 모두를 넘겨주지 않아도 그 자릿수에서의 나머지만 넘겨줘도 됨.
	 * less : 앞에서 만든 가격이 이미 현재 가격보다 싼가? 1이면 yes. 0이면 no.
	 */
	static int sol(int idx,int taken,int mod,int less){
		if(idx == N){
			return (less == 1 && mod == 0) ? 1:0;
		}
		if(dp[taken][mod][less] != -1){
			return dp[taken][mod][less];
		}
		int ret = 0;
		for(int i = 0;i<N;i++){
			//이미 쓰인 숫자일경우.
			if((taken & (1<<i)) > 0){
				continue;
			}
			//과거 가격이 현재 가격보다 싸야함.
			if(less != 1 && e.charAt(idx) < digits[i]){
				continue;
			}
			//같은 숫자는 한 번만 선택하도록.
			//예: 2(1) 2(2) 4 와 2(2) 2(1) 4는 같은 경우이기에
			//중복해서 세면 안됨.
			if(
				i > 0 &&
				digits[i-1] == digits[i] &&
				(taken & (1<<(i-1))) == 0
			){
				continue;
			}
			int nextTaken = taken | (1<<i);
			int nextMod = (mod*10 + digits[i] - '0')%m;
			int nextLess = (less == 1 || e.charAt(idx) > digits[i]) ? 1:0;
			ret += sol(idx+1,nextTaken,nextMod,nextLess);
			ret %= 1000000007;
		}
		dp[taken][mod][less] = ret;
		return ret;
	}
}

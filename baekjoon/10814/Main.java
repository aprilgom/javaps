import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Member[] members = new Member[n];
		for(int i = 0;i<n;i++){
			String[] s = br.readLine().split(" ");
			members[i] = new Member();
			members[i].age = Integer.parseInt(s[0]);
			members[i].name = s[1];
		}
		Arrays.sort(members,(a,b)->{
			return a.age-b.age;
		});
		for(Member i:members){
			System.out.print(i.age);
			System.out.print(" ");
			System.out.print(i.name);
			System.out.print("\n");
		}
	}
}
class Member{
	public int age;
	public String name;
}

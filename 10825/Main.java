import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Student[] students = new Student[n];
		for(int i = 0;i<n;i++){
			String[] s = br.readLine().split(" ");
			students[i] = new Student();
			students[i].name = s[0];
			students[i].score[0] = Integer.parseInt(s[1]);
			students[i].score[1] = Integer.parseInt(s[2]);
			students[i].score[2] = Integer.parseInt(s[3]);
		}
		Arrays.sort(students,(a,b)->{
			if(a.score[0] == b.score[0]){
				if(a.score[1] == b.score[1]){
					if(a.score[2] == b.score[2]){
						return a.name.compareTo(b.name);
					}
					return b.score[2] - a.score[2];
				}
				return a.score[1] - b.score[1];
			}
			return b.score[0] - a.score[0];
		});
		for(Student i:students){
			bw.write(i.name);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
class Student{
	public String name;
	public int[] score;
	public Student(){
		score = new int[3];
	}
}

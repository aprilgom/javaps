import java.util.*;
import java.io.*;

class Node{
	public double x,y;
	public Node(double X,double Y){
		x = X;
		y = Y;
	}
	public static double getDist(Node a, Node b){
		double dx = Math.abs(a.x-b.x);
		double dy = Math.abs(a.y-b.y);
		return dx*dx + dy*dy;
	}
	public static Node getP(Node a,Node b){
		return new Node((2*a.x+b.x)/3,(2*a.y+b.y)/3);
	}
	public static Node getQ(Node a,Node b){
		return new Node((a.x+2*b.x)/3,(a.y+2*b.y)/3);
	}
}

public class Main{

	static Node a,b,c,d;
	static Node minho_l,kangho_l,minho_r,kangho_r;
	static Node minho_p,minho_q,kangho_p,kangho_q;

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] is = Arrays.stream(br.readLine().split(" "))
			.mapToInt(i->Integer.parseInt(i))
			.toArray();
		a = new Node(is[0],is[1]);
		b = new Node(is[2],is[3]);
		c = new Node(is[4],is[5]);
		d = new Node(is[6],is[7]);
		minho_l = a;
		minho_r = b;
		kangho_l = c;
		kangho_r = d;
		while(
				Node.getDist(minho_l,minho_r)>0.00000000000001 && 
				Node.getDist(kangho_l,kangho_r)>0.0000000000001
				){
			minho_p = Node.getP(minho_l,minho_r);
			kangho_p = Node.getP(kangho_l,kangho_r);
			double p_dist = Node.getDist(minho_p,kangho_p);

			minho_q = Node.getQ(minho_l,minho_r);
			kangho_q = Node.getQ(kangho_l,kangho_r);
			double q_dist = Node.getDist(minho_q,kangho_q);


			if(p_dist > q_dist){
				minho_l = minho_p;
				kangho_l = kangho_p;
			}else if(p_dist < q_dist){
				minho_r = minho_q;
				kangho_r = kangho_q;
			}else{
				minho_l = minho_p;
				kangho_l = kangho_p;

				minho_r = minho_q;
				kangho_r = kangho_q;
			}
		}
		double ret = Math.sqrt(Node.getDist(minho_l,kangho_l));
		System.out.println(String.format("%.6f",ret));

	}
}

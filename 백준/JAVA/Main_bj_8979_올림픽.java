import java.util.PriorityQueue;
import java.util.Scanner;

class Medal implements Comparable<Medal>{
	int country;
	int g;
	int s;
	int c;
	public Medal(int country,int g, int s, int c) {
		super();
		this.country =country;
		this.g = g;
		this.s = s;
		this.c = c;
	}
	@Override
	public int compareTo(Medal o) {
		if(this.g==o.g) {
			if(this.s==o.s) {
				return -(this.c-o.c);
			}else return -(this.s-o.s);
		}else return -(this.g-o.g);
	}
	
}
public class Main_bj_8979_올림픽 {

	static int N;//1부터 N까지
	static int K;
	static int[] cnt;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		PriorityQueue<Medal> pq=new PriorityQueue<Medal>();
		N=sc.nextInt();
		K=sc.nextInt();
		for(int i=0; i<N; i++) {
			int index=sc.nextInt();
			int g=sc.nextInt();
			int s=sc.nextInt();
			int c=sc.nextInt();
			pq.offer(new Medal(index,g,s,c));
		}
		int rank=1;
		Medal tmp = pq.poll();
		if(tmp.country==K) {
			System.out.println(rank);
			System.exit(0);
		}
		int same=0;
		while(!pq.isEmpty()) {
			Medal m = pq.poll();
			if(!(tmp.g==m.g && tmp.s==m.s &&tmp.c==m.c)){
				tmp=m;
				rank++;
				if(same>0) {
					rank+=same;
					same=0;
				}
			}else {
				same++;
			}
			if(m.country==K) {
				System.out.println(rank);
				System.exit(0);
			}
			
		}
		
	}

}

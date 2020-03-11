package day3;

import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

class Connect implements Comparable<Connect>{
	long d;
	int from;
	int to;
	public Connect(long d, int from, int to) {
		super();
		this.d = d;
		this.from = from;
		this.to = to;
	}
	@Override
	public int compareTo(Connect o) {
		return Long.compare(this.d, o.d);
	}
	
	
}
public class Solution_d4_1251_하나로 {

	static int N;
	static long total;
	static int[] parents;
	static double E;
	static long[] X;
	static long[] Y;
	static long[][] dist;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(new InputStreamReader(System.in));
		int T=sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N=sc.nextInt();
			X=new long[N];
			Y=new long[N];
			dist=new long[N][N];
			parents=new int[N];
			for(int i=0; i<N; i++) X[i]=sc.nextLong();
			for(int i=0; i<N; i++) Y[i]=sc.nextLong();
			E=sc.nextDouble();
			//입력끝
			
			for(int i=0; i<N; i++) parents[i]=i;
			PriorityQueue<Connect> pq=new PriorityQueue<Connect>();
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					if(i==j)continue;
					long L=(X[i]-X[j])*(X[i]-X[j])+(Y[i]-Y[j])*(Y[i]-Y[j]);
					dist[i][j]=L;
					dist[j][i]=L;
					pq.offer(new Connect(L,i,j));
				}
			}
			int cnt=0;
			total=0;
			while(!pq.isEmpty()) {
				if(cnt==N-1) break;
				Connect c=pq.poll();
				if(isUnion(c.from,c.to)) continue;
				cnt++;
				total+=c.d;
				
			}
			System.out.println("#"+tc+" "+Math.round(E*total));
		}
	}

	private static boolean isUnion(int from, int to) {
		int pf=find(from);
		int pt=find(to);
		if(pf==pt) return true;
		parents[(int) pf]=pt;
		return false;
	}

	private static int find(int x) {
		if(parents[x]==x) return x;
		else return parents[x]=find(parents[x]);
	}

}

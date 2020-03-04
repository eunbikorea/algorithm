import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Node{
	int node;
	int val;
	public Node(int node, int val) {
		super();
		this.node = node;
		this.val = val;
	}
	
}
public class Solution_d4_5684_운동 {
	final static int INF= 987654321;
	public static int N,M;//건물, 도로
	public static List[] map;//연결체크
	//public static boolean[] visit;//방문체크
	public static int[] dist;
	public static int ans;
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			ans=Integer.MAX_VALUE;
			N=sc.nextInt();
			M=sc.nextInt();
			//map=new int[N+1][N+1];//1번부터 N까지임
			map=new ArrayList[N+1];
			dist=new int[N+1];
	        for(int i = 1; i <= N; i++)
	        	map[i] = new ArrayList<>();
			for(int i=0; i<M; i++) {
				int s=sc.nextInt();
				int e=sc.nextInt();
				int c=sc.nextInt();
				map[s].add(new Node(e,c));
			}
			for(int i=1; i<=N; i++) {
				solve(i);
			}
			
			System.out.println("#"+tc+" "+(ans==Integer.MAX_VALUE? -1:ans));
		}

	}
	private static void solve(int start) {
		for(int i=1; i<=N; i++) {
			dist[i]=INF;
		}
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		pq.offer(new int[] {start,0});
		while(!pq.isEmpty()) {
			int[] a=pq.poll();
			int now = a[0];
			int nowDist = a[1];
			if(now==start) {
				if(ans>dist[start])ans=dist[start];
			}
			for(int i=0; i<map[now].size(); i++) {
				Node node = (Node) map[now].get(i);
				int next=node.node;
				int val=node.val;
				if(nowDist+val<dist[next]) {
					dist[next]=nowDist+val;
					pq.offer(new int[] {next,nowDist+val});
				}
				
			}
		}
		
		
	}

}

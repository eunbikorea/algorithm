import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Main_bj_6118_숨바꼭질 {
	
	static int N,M;
	static int minNode, distResult, cntNode;
	static List[] node;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		node=new ArrayList[N+1];
		visit=new boolean[N+1];
		for(int i=1; i<=N; i++)
			node[i]=new ArrayList<>();
		for(int i=0; i<M; i++) {
			int from=sc.nextInt();
			int to=sc.nextInt();
			node[from].add(to);
			node[to].add(from);
		}
		solve();
		System.out.print(minNode+" "+distResult+" "+cntNode);
	}
	private static void solve() {
		Queue<int[]> q=new LinkedList<int[]>();
		visit[1]=true;
		q.offer(new int[] {1,0});
		while(!q.isEmpty()) {
			int[] a=q.poll();
			int now=a[0];
			int dist=a[1];
			if(dist>distResult) {
				distResult=dist;
				minNode=now;
				cntNode=1;
			}else if(dist==distResult) {
				if(minNode>now) {
					minNode=now;
				}
				cntNode++;
			}
			for(int i=0; i<node[now].size(); i++) {
				int next=(int)node[now].get(i);
				if(visit[next]==false) {
					visit[next]=true;
					q.offer(new int[] {next, dist+1});
				}
			}
		}
	}

}

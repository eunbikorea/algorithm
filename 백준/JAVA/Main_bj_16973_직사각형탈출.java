import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos implements Comparable<Pos>{
	int x;
	int y;
	int cnt;
	public Pos(int x, int y, int cnt) {
		super();
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pos o) {
		
		return Integer.compare(this.cnt, o.cnt);
	}
	
	
}
public class Main_bj_16973_직사각형탈출 {

	static int N,M;//행,열
	static int[][] map;
	static boolean[][] visit;
	static int H,W,sx,sy,fx,fy;
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N+1][M+1];
		visit=new boolean[N+1][M+1];
		for(int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=1; j<=M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st=new StringTokenizer(br.readLine()," ");
		H=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		sx=Integer.parseInt(st.nextToken());
		sy=Integer.parseInt(st.nextToken());
		fx=Integer.parseInt(st.nextToken());
		fy=Integer.parseInt(st.nextToken());
		
		int ans=987654321;
		Queue<Pos> q=new LinkedList<Pos>();
		visit[sx][sy]=true;
		q.offer(new Pos(sx,sy,0));
		while(!q.isEmpty()) {
			Pos p=q.poll();
			if(p.x==fx && p.y==fy) {
				ans=p.cnt;
				break;
			}
			for(int i=0; i<4; i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
				if(nx<1||ny<1||nx>N||ny>M||visit[nx][ny]==true)
					continue;
				if(!isPossible(nx,ny))
					continue;
				visit[nx][ny]=true;
				q.offer(new Pos(nx,ny,p.cnt+1));
					
			}
		}
		
		System.out.println(ans==987654321? -1:ans);
	}
	private static boolean isPossible(int x, int y) {
		for(int i=x; i<x+H; i++) {
			for(int j=y; j<y+W; j++) {
				if(i<1||j<1||i>N||j>M||map[i][j]==1)
					return false;
			}
		}
		return true;
	}

}

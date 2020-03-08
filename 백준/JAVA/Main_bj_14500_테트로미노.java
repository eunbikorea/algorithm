import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_14500_테트로미노 {

	static int N,M,ans=0;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		visit=new boolean[N][M];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}//입력끝
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visit[i][j]=true;
				dfs(i,j,1,map[i][j]);
				visit[i][j]=false;
				unusual(i,j);
			}
		}
		System.out.println(ans);

	}
	private static void unusual(int x, int y) {
		if((x==0&&y==0) ||(x==0&&y==M-1) || (x==N-1&&y==0) || (x==N-1 &&y==M-1))
			return;
		int cnt=1;
		int total=map[x][y];
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0||ny<0||nx>=N||ny>=M) continue;
			cnt++;
			total+=map[nx][ny];
		}
		if(cnt==4) {
			if(ans<total)ans=total;
		}else if(cnt==5) {
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				int tmp=total-map[nx][ny];
				if(ans<tmp) ans=tmp;
			}
		}
	}
	private static void dfs(int x, int y, int cnt, int sum) {
		if(cnt==4) {
			if(ans<sum)ans=sum;
			return;
		}
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0||ny<0||nx>=N||ny>=M||visit[nx][ny]==true)continue;
				visit[nx][ny]=true;
				dfs(nx,ny,cnt+1,sum+map[nx][ny]);
				visit[nx][ny]=false;
			
		}
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_1405_미친로봇 {

	static int N;
	static double ans=0.0;
	static double[] percent;
	static boolean[][] visit= new boolean[30][30];
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		percent=new double[4];
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		
		for(int i=0; i<4; i++) {
			percent[i]=Integer.parseInt(st.nextToken())*0.01;
		}
		
		solve(14,14,0,1.0);
		System.out.println(ans);
	}
	private static void solve(int x, int y, int cnt, double chance) {
		if(cnt==N) {
			ans+=chance;
			return;
		}
		visit[x][y]=true;
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(visit[nx][ny]==true)continue;
			visit[nx][ny]=true;
			solve(nx,ny,cnt+1,chance*percent[i]);
			visit[nx][ny]=false;
		}
		visit[x][y]=false;
	}

}

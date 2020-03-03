import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_2814_최장경로 {

	public static int N, M, ans;
	public static int[][] map;
	public static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans=0;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N + 1][N + 1];
			visit = new boolean[N + 1];
			for(int i=0; i<M; i++) {
				 st = new StringTokenizer(br.readLine(), " ");
				 int num1=Integer.parseInt(st.nextToken());
				 int num2=Integer.parseInt(st.nextToken());
				 map[num1][num2]=1;
				 map[num2][num1]=1;
			}
			for(int i=1; i<=N; i++) {
				visit[i]=true;
				dfs(i,1);
				visit[i]=false;
			}
			System.out.println("#"+tc+" "+ans);
		}

	}

	private static void dfs(int index, int cnt) {
		if(ans<cnt)ans=cnt;
		for(int j=1; j<=N; j++) {
			if(map[index][j]==1 && visit[j]==false) {
				visit[j]=true;
				dfs(j,cnt+1);
				visit[j]=false;
			}
		}
	}

}

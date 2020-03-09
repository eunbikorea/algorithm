import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d5_7396_종구의딸이름짓기 {

	static int N, M;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_7396.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			visit=new boolean[N][M];
			// visit=new boolean[N][M];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			sb.append(map[0][0]);
			Queue<int[]> q = new LinkedList<int[]>();
			visit[0][0]=true;
			q.offer(new int[] { 0, 0 });
			//loop:
			int cnt=1;
			while (cnt<N+M-1) {
				Queue<int[]> nq = new LinkedList<int[]>();
				int qSize = q.size();
				char min = 'z'+1;
				while (qSize--> 0) {
					int[] arr = q.poll();
					int x = arr[0];
					int y = arr[1];
					
					for (int i = 0; i < 2; i++) {
						int nx=x+dx[i];
						int ny=y+dy[i];
						if(nx<0||ny<0||nx>=N||ny>=M||visit[nx][ny]==true)continue;
						visit[nx][ny]=true;
						if(map[nx][ny]<min) {
							while(!nq.isEmpty())nq.poll();
							nq.offer(new int[] {nx,ny});
							min=map[nx][ny]
;						}else if(map[nx][ny]==min) {
							nq.offer(new int[] {nx,ny});
						}
						
						
					}
					
				}
				cnt++;
				sb.append(min);
				while(!q.isEmpty())q.poll();
				q.addAll(nq);
			}
			System.out.println("#"+tc+" "+sb.toString());
		}
	}

}

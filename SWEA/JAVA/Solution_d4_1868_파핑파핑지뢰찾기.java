package day6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d4_1868_파핑파핑지뢰찾기 {

	static int N, ans;
	static char[][] map;
	static int[][] visit;
	static int[] dx = { 0, 0, 1, -1, 1, 1, -1, -1 };
	static int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };
	static Queue<int[]> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			q = new LinkedList<int[]>();
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visit = new int[N][N];
			ans = 0;
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			} // 입력끝

			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.' && visit[i][j] == 0) {
						int mines = 0;
						for (int k = 0; k < 8; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							if (nx < 0 || ny < 0 || nx >= N || ny >= N)
								continue;
							if (map[nx][ny] == '*')
								mines++;
						}
						if (mines == 0) {
							visit[i][j] = 1;
							q.offer(new int[] { i, j });
							bfs();
							//print();
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]=='.') {
						ans++;
					}
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
		
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();

		}
		System.out.println();

	}

	private static void bfs() {
		ans++;
		while (!q.isEmpty()) {
			Queue<int[]> tmp = new LinkedList<int[]>();
			int[] a = q.poll();
			int x = a[0];
			int y = a[1];
			int mines = 0;
			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				if (map[nx][ny] == '*')
					mines++;

				else if (map[nx][ny] == '.' && visit[nx][ny] == 0) {
					// visit[nx][ny]=1;
					tmp.offer(new int[] { nx, ny });
				}
			}
			if (mines == 0) {
				map[x][y] = 'x';
				while (!tmp.isEmpty()) {
					int[] arr = tmp.poll();
					visit[arr[0]][arr[1]] = 1;
					q.offer(arr);
				}
			} else {
				map[x][y] = 'x';
			}
		}

	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

public class Solution_5656_벽돌깨기 {

	static int N, W, H, ans;// 횟수 가로 세로
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = 987654321;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			solve(0);
			if(ans==987654321) ans=0;
			System.out.println("#" + tc + " " + ans);
		}

	}

	private static void solve(int cnt) {
		if (cnt == N) {
			// 남은 벽돌 세기
			// print();
			int result = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] > 0)
						result++;
				}
			}
			if (ans > result)
				ans = result;
			return;
		}
		int[][] copy = new int[H][W];
		mapCopy(copy, map);

		for (int k = 0; k < H; k++)for (int c = 0; c < W; c++) {
			copy[k][c] = map[k][c];
		}
		for (int j = 0; j < W; j++) {
			for (int i = 0; i < H; i++) {
				if (map[i][j] > 0) {
					breaking(i, j);
					move();
					solve(cnt + 1);
					mapCopy(map, copy);
					//print();
					break;
				}
			}
		}

	}

	private static void print() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

	private static void move() {
		for (int j = 0; j < W; j++) {
			Queue<Integer> q = new LinkedList<Integer>();
			for (int i = H - 1; i >= 0; i--) {
				if (map[i][j] > 0) {
					q.offer(map[i][j]);
					map[i][j] = 0;
				}
			}
			int i = H - 1;
			while (!q.isEmpty()) {
				map[i][j] = q.poll();
				i--;
			}
		}
	}

	private static void breaking(int x, int y) {
		visit = new boolean[H][W];
		Queue<Point> q = new LinkedList<Point>();
		visit[x][y] = true;
		q.offer(new Point(x, y));
		while (!q.isEmpty()) {
			Point p = q.poll();
			int val = map[p.x][p.y] - 1;
			map[p.x][p.y] = 0;
			if (val > 0) {
				for (int i = 0; i < 4; i++) {
					for (int c = 1; c <= val; c++) {
						int nx = p.x + dx[i] * c;
						int ny = p.y + dy[i] * c;

						if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == 0 || visit[nx][ny] == true)
							continue;
						visit[nx][ny] = true;
						q.offer(new Point(nx, ny));
					}
				}
			}
		}

	}

	private static void mapCopy(int[][] copy, int[][] origin) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				copy[i][j] = origin[i][j];
			}
		}

	}

}

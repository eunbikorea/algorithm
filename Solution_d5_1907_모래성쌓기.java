import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d5_1907_모래성쌓기 {

	public static int H, W, ans;
	public static int[][] map;
	public static int[] dx = { 0, 0, 1, -1, 1, -1, 1, -1 };
	public static int[] dy = { 1, -1, 0, 0, 1, -1, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = 0;
			Queue<int[]> q = new LinkedList<int[]>();
			st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				String s = br.readLine();
				for (int j = 0; j < W; j++) {
					if (s.charAt(j) != '.')
						map[i][j] = s.charAt(j) - '0';
				}
			} // 입력끝
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 0) {
						for (int d = 0; d < 8; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							if (nx < 0 || ny < 0 || nx >= H || ny >= W)
								continue;
							if (map[nx][ny] > 0) {
								map[nx][ny]--;
								if (map[nx][ny] == 0) {
									map[nx][ny] = -1;
									q.offer(new int[] { nx, ny });
								}
							}

						}
					}
				}

			}
			while (!q.isEmpty()) {
				int size = q.size();
				while (size--> 0) {
					int[] a = q.poll();
					int x = a[0];
					int y = a[1];
					for (int d = 0; d < 8; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						if (nx < 0 || ny < 0 || nx >= H || ny >= W)
							continue;
						if (map[nx][ny] > 0) {
							map[nx][ny]--;
							if (map[nx][ny] == 0) {
								map[nx][ny] = -1;
								q.offer(new int[] { nx, ny });
							}
						}

					}
				}
				ans++;
			}

			System.out.println("#" + tc + " " + ans);

		}

	}

}
/*
 * XXXXX X675X X584X X656X XXXXX
 */

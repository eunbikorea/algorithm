import java.util.Scanner;

public class Main {

	static int N, M, x, y, K;
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };// 우좌상하 0123
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dice = { 0, 0, 0, 0, 0, 0, 0 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < K; i++) {
			change(sc.nextInt() - 1);
		}
		System.out.println(sb.toString());

	}

	private static void change(int dir) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if (nx < 0 || ny < 0 || nx >= N || ny >= M)
			return;
		int[] copy = dice.clone();
		if (dir == 0) {// 우
			dice[6] = copy[3];
			dice[3] = copy[1];
			dice[1] = copy[4];
			dice[4] = copy[6];
		} else if (dir == 1) {// 좌
			dice[6] = copy[4];
			dice[3] = copy[6];
			dice[1] = copy[3];
			dice[4] = copy[1];
		} else if (dir == 2) {// 상
			dice[2] = copy[1];
			dice[1] = copy[5];
			dice[5] = copy[6];
			dice[6] = copy[2];
		} else if (dir == 3) {// 하
			dice[1] = copy[2];
			dice[2] = copy[6];
			dice[6] = copy[5];
			dice[5] = copy[1];
		}
		if (map[nx][ny] == 0) {
			map[nx][ny] = dice[6];
		} else {
			dice[6] = map[nx][ny];
			map[nx][ny] = 0;
		}
		sb.append(dice[1] + "\n");
		x = nx;
		y = ny;
	}

}
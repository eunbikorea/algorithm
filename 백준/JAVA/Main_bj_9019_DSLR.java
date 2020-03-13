import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main_bj_9019_DSLR {

	static class State {
		int now;
		String ans;

		public State(int now, String ans) {
			super();
			this.now = now;
			this.ans = ans;
		}

	}
	static int A,B;
	static boolean[] chk;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			chk = new boolean[10000];
			chk[A] = true;
			
			Queue<State> q = new LinkedList<State>();
			q.offer(new State(A, ""));
			while (!q.isEmpty()) {
				State s = q.poll();
				
				if (s.now == B) {
					System.out.println(s.ans);
					break;
				}
				int D = 2 * s.now;
				int S = s.now - 1;
				// D
				if (D > 9999) {
					D%=10000;//D%=9999로 함;
					if (chk[D] == false) {
						chk[D] = true;
						q.offer(new State(D, s.ans+"D"));
					}
				} else {
					if (chk[D] == false) {
						chk[D] = true;
						q.offer(new State(D, s.ans+"D"));
					}
				}
				// S
				if (S == -1) {
					if (chk[9999] == false) {
						chk[9999] = true;
						q.offer(new State(9999,  s.ans+"S"));
					}
				} else {
					if (chk[S] == false) {
						chk[S] = true;
						q.offer(new State(S,  s.ans+"S"));

					}
				}
				// L
				int tmp=(s.now%1000)*10;
				tmp+=s.now/1000;
				if (chk[tmp] == false) {
					chk[tmp] = true;
					q.offer(new State(tmp,s.ans+"L"));
				}
				// R
				tmp=(s.now%10)*1000;
				tmp+=(s.now/10);
				if (chk[tmp] == false) {
					chk[tmp] = true;
					q.offer(new State(tmp,s.ans+"R"));
				}
			}
		}
	}

}

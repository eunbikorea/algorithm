import java.io.*;
import java.util.*;

class Document {
	int index;
	int val;

	public Document(int index, int val) {
		super();
		this.index = index;
		this.val = val;
	}

}

public class Main_bj_1966_프린터큐 {

	public static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Queue<Document> q1 = new LinkedList<Document>();
			Queue<Document> q2 = new LinkedList<Document>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				int n=Integer.parseInt(st.nextToken());
				q1.offer(new Document(i,n));
			}
			int ans=0;
			while(true) {
			Document front = q1.poll();
			int index = front.index;
			int val = front.val;
			boolean f=false;
			while(!q1.isEmpty()) {
				Document next = q1.poll();
				q2.offer(next);
				if(f==false && val<next.val) {
					f=true;
				}
			}
			if(f==false){
				ans++;
				if(index==M) {
					System.out.println(ans+" ");
					break;
				}
			}else {
				q2.offer(front);
			}
			while(!q2.isEmpty()) {
				q1.offer(q2.poll());
			}
			}
		}

	}

}

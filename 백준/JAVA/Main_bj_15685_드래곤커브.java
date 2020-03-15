import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Dragon{
	int x;
	int y;
	int d;
	int g;
	public Dragon(int x, int y, int d, int g) {
		super();
		this.x = x;
		this.y = y;
		this.d = d;
		this.g = g;
	}
	
}
public class Main_bj_15685_드래곤커브 {

	static int N;
	static Dragon[] dragonCurve;
	static boolean[][] visit;
	static int[] dx= {0,-1,0,1};
	static int[] dy= {1,0,-1,0};
	//우상좌하
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		dragonCurve=new Dragon[N];
		visit=new boolean[101][101];
		for(int i=0; i<N; i++) {//x,y반대로 입력받기
			st=new StringTokenizer(br.readLine()," ");
			int x; int y; int d; int g;
			y=Integer.parseInt(st.nextToken());
			x=Integer.parseInt(st.nextToken());
			d=Integer.parseInt(st.nextToken());
			g=Integer.parseInt(st.nextToken());
			dragonCurve[i]=new Dragon(x,y,d,g);
		}
		for(int i=0; i<N; i++) {
			draw(dragonCurve[i]);
		}
		int ans=0;
		for(int i=0; i<=99; i++) {
			for(int j=0; j<=99; j++) {
				if(visit[i][j]==true && visit[i][j+1]==true
					&&visit[i+1][j]==true && visit[i+1][j+1]==true)
					ans++;
			}
		}
		System.out.println(ans);
		
	}


	private static void draw(Dragon dragon) {
		int x=dragon.x;	int y=dragon.y;
		int d=dragon.d; int g=dragon.g;
		visit[x][y]=true;
		int nx=x+dx[d];
		int ny=y+dy[d];
		visit[nx][ny]=true;
		if(g==0)return;
		Deque<Integer> dq=new ArrayDeque<Integer>();
		
		dq.add(d);
		x=nx; y=ny;
		while(g-->0) {
			Deque<Integer> tmp=new ArrayDeque<Integer>();
			tmp.addAll(dq);
			while(!dq.isEmpty()) {
				int nd=dq.pollLast();
				if(nd<3)nd++;
				else nd=0;
				nx=x+dx[nd];
				ny=y+dy[nd];
				visit[nx][ny]=true;
				//System.out.println(nx+","+ny);
				tmp.offerLast(nd);
				x=nx; y=ny;
			}
			dq.addAll(tmp);
		}
	}
}

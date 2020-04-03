import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pos implements Comparable<Pos>{
	int x;
	int y;
	int d;
	int c;
	public Pos(int x, int y, int d, int c) {
		super();
		this.x = x;
		this.y = y;
		this.d = d;
		this.c = c;
	}
	@Override
	public int compareTo(Pos o) {
		return Integer.compare(this.c, o.c);
	}
	
}
public class Main_bj_6087_레이저통신 {

	static int R,C;
	static char[][] map;
	static boolean[][][] visit;
	static int[] dx= {0,-1,0,1};
	static int[] dy= {-1,0,1,0};
	//좌상우백
	static int[] dr= {1,2,3,0};
	static int[] dl= {3,0,1,2};
	static int sx,sy,ex,ey;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		C=Integer.parseInt(st.nextToken());//열
		R=Integer.parseInt(st.nextToken());//행
		map=new char[R][C];
		visit=new boolean[R][C][4];
		boolean f=false;
		for(int i=0; i<R; i++) {
			String s=br.readLine();
			for(int j=0; j<C; j++){
				map[i][j]=s.charAt(j);
				if(map[i][j]=='C') {
					if(f==false) {
						f=true;
						sx=i; sy=j;
						
					}else {
						ex=i; ey=j;
					}
					map[i][j]='.';
				}
			}
		}//입력끝
		PriorityQueue<Pos> pq=new PriorityQueue<Pos>();
		for(int i=0; i<4; i++) {
			visit[sx][sy][i]=true;
			pq.offer(new Pos(sx,sy,i,0));
		}
		//System.out.println(sx+","+sy+","+ex+","+ey);
		while(!pq.isEmpty()) {
			Pos p=pq.poll();
			//System.out.println(p.x+","+p.y);
			
			if(p.x==ex && p.y==ey) {
				System.out.println(p.c);
				break;
			}
			int nx=p.x+dx[p.d];
			int ny=p.y+dy[p.d];
			if(nx<0||ny<0||nx>=R||ny>=C||visit[nx][ny][p.d] || map[nx][ny]=='*') {
				continue;
			}
			visit[nx][ny][p.d]=true;
			
			pq.offer(new Pos(nx,ny,dr[p.d],p.c+1));
			pq.offer(new Pos(nx,ny,dl[p.d],p.c+1));
			pq.offer(new Pos(nx,ny,p.d,p.c));
			
			
		}
	}

}

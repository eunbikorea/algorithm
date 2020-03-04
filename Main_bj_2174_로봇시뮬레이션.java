import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Robot{
	int x;
	int y;
	int dir;
	public Robot(int x, int y, int dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
}
public class Main_bj_2174_로봇시뮬레이션 {

	public static int R,C;
	public static int N,M;
	public static int[][] map;
	public static Robot[] rb;
	public static int[] dx= {-1,0,0,1};
	public static int[] dy= {0,-1,1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		C=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		rb=new Robot[N+1];//인덱스 1부터
		map=new int[R+1][C+1];
		for(int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int y=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken());
			int d=0;
			char c=st.nextToken().charAt(0);
			if(c=='N') d=3;//맵을 상하반전 시켜서 N과 S을 바꿔줘야함
			else if(c=='W') d=1;
			else if(c=='E') d=2;
			//else if(c=='S') d=0;
			rb[i]=new Robot(x,y,d);
			map[x][y]=1;
		}
		//명령 실행
		for(int i=1; i<=M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int index=Integer.parseInt(st.nextToken());
			char order=st.nextToken().charAt(0);
			int cnt=Integer.parseInt(st.nextToken());
			if(order!='F') cnt%=4;
			for(int c=0; c<cnt; c++) {
				if(order=='R') {//맵을 상하반전 시켜서 R과 L을 바꿔줘야함
					if(rb[index].dir==0) rb[index].dir=1;
					else if(rb[index].dir==1) rb[index].dir=3;
					else if(rb[index].dir==2) rb[index].dir=0;
					else if(rb[index].dir==3) rb[index].dir=2;
				}else if(order=='L') {
					if(rb[index].dir==0) rb[index].dir=2;
					else if(rb[index].dir==1) rb[index].dir=0;
					else if(rb[index].dir==2) rb[index].dir=3;
					else if(rb[index].dir==3) rb[index].dir=1;
				}else if(order=='F') {
					int x = rb[index].x;
					int y = rb[index].y;
					int dir = rb[index].dir;
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					if(nx<1||ny<1||nx>R||ny>C) {
						System.out.println("Robot "+index+" crashes into the wall");
						System.exit(0);
					}
					if(map[nx][ny]==1) {
						int Y=0;
						for(int z=1; z<=N; z++) {
							if(rb[z].x==nx && rb[z].y==ny)
								Y=z;
						}
						System.out.println("Robot "+index+" crashes into robot "+Y);
						System.exit(0);
					}
					map[x][y]=0;
					map[nx][ny]=1;
					rb[index].x=nx;
					rb[index].y=ny;
				}
			}
		}
		System.out.println("OK");
	}

}

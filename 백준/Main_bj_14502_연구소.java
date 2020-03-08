import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bj_14502_연구소 {

	static int N,M,ans=0;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	static ArrayList<int[]> list=new ArrayList<int[]>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==0) list.add(new int[] {i,j});
			}
		}//입력끝
		//벽세우기
		
		for(int i=0; i<list.size()-2; i++) {
			for(int j=i+1; j<list.size()-1; j++) {
				for(int z=j+1; z<list.size(); z++) {
					visit=new boolean[N][M];//매번 새로 생성해줘야함..
					int[] arr_i=list.get(i);
					int[] arr_j=list.get(j);
					int[] arr_z=list.get(z);
					map[arr_i[0]][arr_i[1]]=1;
					map[arr_j[0]][arr_j[1]]=1;
					map[arr_z[0]][arr_z[1]]=1;
					spread();//퍼뜨리기
					map[arr_i[0]][arr_i[1]]=0;
					map[arr_j[0]][arr_j[1]]=0;
					map[arr_z[0]][arr_z[1]]=0;
				}
			}
		}
//		map[1][0]=1;
//		map[0][1]=1;
//		map[3][5]=1;
//		spread();
		System.out.println(ans);
		

	}
	private static void spread() {
		int cnt=0;//안전영역
		int[][] temp=new int[N][M];
		mapCopy(temp,map);
		Queue<int[]> q=new LinkedList<int[]>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==2) {
					visit[i][j]=true;
					q.offer(new int[] {i,j});
				}
			}
		}
		//System.out.println(q.size());
		while(!q.isEmpty()) {
			int[] a=q.poll();
			int x=a[0];
			int y=a[1];
			//System.out.println(x+","+y);
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M||visit[nx][ny]==true
						||map[nx][ny]==1)continue;
				map[nx][ny]=2;
				visit[nx][ny]=true;
				q.offer(new int[] {nx,ny});
			}
		}
		//안전영역 세기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0)cnt++;
			}
		}
	//	print();
		
		if(ans<cnt) {
			ans=cnt;
			//print();
		}
		mapCopy(map,temp);
	}
	private static void mapCopy(int[][] a1, int[][] a2) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				a1[i][j]=a2[i][j];
			}
		}
	}
	private static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}

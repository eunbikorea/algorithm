import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_bj_12100_2048 {

	static int N,ans=0;
	static int[][] map;
	//static int[][] copy;
	static int[] dx= {0,-1,0,1};
	static int[] dy= {-1,0,1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st;
		map=new int[N][N];
		//copy=new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(ans);
	}
	private static void dfs(int cnt) {
		if(cnt==5) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]>ans) ans= map[i][j];
				}
			}
			return;
		}
		for(int d=0; d<4; d++) {
			int[][] copy=new int[N][N];
			copyMap(copy,map);
			move(d);
			dfs(cnt+1);
			copyMap(map,copy);
		}
	}
	private static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void move(int d) {
		if(d==0) {//좌로 밀기
			for(int i=0; i<N; i++) {
				Deque<Integer> dq=new ArrayDeque<Integer>();
				boolean f=false;
				int tmp=-1;
				for(int j=0; j<N; j++) {
					if(map[i][j]!=0) {//숫자가 있으면
						if(tmp!=map[i][j]) {//이전 숫자랑 같지않으면 그냥 넣기
						dq.offerLast(map[i][j]);
						tmp=map[i][j];
						f=false;
						}else if(tmp==map[i][j]) {//이전 숫자랑 같으면
							if(f==false) {//이전에 계산 작업안했으면
								int val = dq.pollLast()*2;
								dq.offerLast(val);
								f=true;
							}else {//이전에 계산 작업헀으면 그냥 넣기
								dq.offerLast(map[i][j]);
								tmp=map[i][j];
								f=false;
							}
						}
						map[i][j]=0;
					}
				}
				int j=0;
				while(!dq.isEmpty()) {
					map[i][j]=dq.pollFirst();
					j++;
				}
			}
		}
		if(d==1) {//위로 밀기
			for(int j=0; j<N; j++) {
				Deque<Integer> dq=new ArrayDeque<Integer>();
				boolean f=false;
				int tmp=-1;
				for(int i=0; i<N; i++) {
					if(map[i][j]!=0) {//숫자가 있으면
						if(tmp!=map[i][j]) {//이전 숫자랑 같지않으면 그냥 넣기
						dq.offerLast(map[i][j]);
						tmp=map[i][j];
						f=false;
						}else if(tmp==map[i][j]) {//이전 숫자랑 같으면
							if(f==false) {//이전에 계산 작업안했으면
								int val = dq.pollLast()*2;
								dq.offerLast(val);
								f=true;
							}else {//이전에 계산 작업헀으면 그냥 넣기
								dq.offerLast(map[i][j]);
								tmp=map[i][j];
								f=false;
							}
						}
						map[i][j]=0;
					}
				}
				int i=0;
				while(!dq.isEmpty()) {
					map[i][j]=dq.pollFirst();
					i++;
				}
			}
		}
		if(d==2) {//오른쪽으로 밀기
			for(int i=0; i<N; i++) {
				Deque<Integer> dq=new ArrayDeque<Integer>();
				boolean f=false;
				int tmp=-1;
				for(int j=N-1; j>=0; j--) {
					if(map[i][j]!=0) {//숫자가 있으면
						if(tmp!=map[i][j]) {//이전 숫자랑 같지않으면 그냥 넣기
						dq.offerLast(map[i][j]);
						tmp=map[i][j];
						f=false;
						}else if(tmp==map[i][j]) {//이전 숫자랑 같으면
							if(f==false) {//이전에 계산 작업안했으면
								int val = dq.pollLast()*2;
								dq.offerLast(val);
								f=true;
							}else {//이전에 계산 작업헀으면 그냥 넣기
								dq.offerLast(map[i][j]);
								tmp=map[i][j];
								f=false;
							}
						}
						map[i][j]=0;
					}
				}
				int j=N-1;
				while(!dq.isEmpty()) {
					map[i][j]=dq.pollFirst();
					j--;
				}
			}
		}
		if(d==3) {//아래로 밀기
			for(int j=0; j<N; j++) {
				Deque<Integer> dq=new ArrayDeque<Integer>();
				boolean f=false;
				int tmp=-1;
				for(int i=N-1; i>=0; i--) {
					if(map[i][j]!=0) {//숫자가 있으면
						if(tmp!=map[i][j]) {//이전 숫자랑 같지않으면 그냥 넣기
						dq.offerLast(map[i][j]);
						tmp=map[i][j];
						f=false;
						}else if(tmp==map[i][j]) {//이전 숫자랑 같으면
							if(f==false) {//이전에 계산 작업안했으면
								int val = dq.pollLast()*2;
								dq.offerLast(val);
								f=true;
							}else {//이전에 계산 작업헀으면 그냥 넣기
								dq.offerLast(map[i][j]);
								tmp=map[i][j];
								f=false;
							}
						}
						map[i][j]=0;
					}
				}
				int i=N-1;
				while(!dq.isEmpty()) {
					map[i][j]=dq.pollFirst();
					i--;
				}
			}
		}
	}
	private static void copyMap(int[][] arr1, int[][] arr2) {
		
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr1[i][j]=arr2[i][j];
				}
			}
		
		
	}

}

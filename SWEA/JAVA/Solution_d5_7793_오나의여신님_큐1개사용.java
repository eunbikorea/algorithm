package day1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Solution_d5_7793_오나의여신님_큐1개사용 {

	static class Point{
		int x;
		int y;
		int depth;
		boolean isDevil;
		public Point(int x, int y, int depth, boolean isDevil) {
			super();
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.isDevil = isDevil;
		}
		
		
	}
	static int N,M,ans;
	static char[][] map;
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	static Queue<Point> points;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			ans=Integer.MAX_VALUE;
			st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			map=new char[N][M];
			points=new LinkedList<Point>();
			Point player=null;
			for(int i=0; i<N; i++) {
				String s=br.readLine();
				for(int j=0; j<M; j++) {
					map[i][j]=s.charAt(j);
					if(map[i][j]=='*') {
						points.offer(new Point(i,j,0,true));
					}
					if(map[i][j]=='S') {
						player=new Point(i,j,0,false);
					}
				}
			}
			points.offer(player);//*****S
			
			while(!points.isEmpty()) {
				Point front=points.poll();
				for(int i=0; i<4; i++) {
					int nx=front.x+dx[i];
					int ny=front.y+dy[i];
					
					if(nx<0||ny<0||nx>=N||ny>=M)continue;
					if(front.isDevil) {
						if(map[nx][ny]=='.' || map[nx][ny]=='S') {
							map[nx][ny]='*';
							points.offer(new Point(nx,ny,front.depth+1,true));
						}
					}else {
						if(map[nx][ny]=='D') {
							if(ans>front.depth+1)
							ans= front.depth+1;
						}else if(map[nx][ny]=='.') {
							map[nx][ny]='S';
							points.offer(new Point(nx,ny,front.depth+1,false));
						}
					}
				}
					
				
			}
			System.out.println("#"+tc+" "+(ans==Integer.MAX_VALUE? "GAME OVER":ans));
			
		}
	}
	

}

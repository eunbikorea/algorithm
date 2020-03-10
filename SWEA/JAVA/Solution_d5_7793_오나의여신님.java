package day1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
public class Solution_d5_7793_오나의여신님 {

	static int N,M,ans;
	static char[][] map;
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			ans=Integer.MAX_VALUE;
			Queue<Point> devil=new LinkedList<Point>();//악마큐
			Queue<Point> su=new LinkedList<Point>();//수연큐
			st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			map=new char[N][M];
			for(int i=0; i<N; i++) {
				String s=br.readLine();
				for(int j=0; j<M; j++) {
					map[i][j]=s.charAt(j);
					if(map[i][j]=='*') {
						devil.offer(new Point(i,j));
					}
					if(map[i][j]=='S') {
						su.offer(new Point(i,j));
					}
				}
			}
			
			int cnt=0;
			loop:
			while(true) {
				int dSize=devil.size();//악마큐싸이즈
				int sSize=su.size();//수연큐싸이즈
				if(sSize==0) {
					break;
				}
				while(dSize-->0) {
					Point p=devil.poll();
					for(int i=0; i<4; i++) {
						int nx=p.x+dx[i];
						int ny=p.y+dy[i];
						if(nx<0||ny<0||nx>=N||ny>=M)continue;
						if(map[nx][ny]=='.' || map[nx][ny]=='S') {
							map[nx][ny]='*';
							devil.offer(new Point(nx,ny));
						}
								
						
						
					}
				}

				while(sSize-->0) {
					Point p=su.poll();
					
					for(int i=0; i<4; i++) {
						int nx=p.x+dx[i];
						int ny=p.y+dy[i];
						if(nx<0||ny<0||nx>=N||ny>=M)continue;
						if(map[nx][ny]=='D') {
							ans=cnt+1;
							break loop;
						}
						if(map[nx][ny]=='.') {
							map[nx][ny]='S';
							su.offer(new Point(nx,ny));
						}
					}
				}
				cnt++;
			}
			System.out.println("#"+tc+" "+(ans==Integer.MAX_VALUE? "GAME OVER":ans));
			
		}
	}
	

}

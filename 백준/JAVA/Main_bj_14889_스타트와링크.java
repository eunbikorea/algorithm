import java.util.Arrays;
import java.util.Scanner;

public class Main_bj_14889_스타트와링크 {

	static int N,ans=987654321;
	static int[][] map;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		map=new int[N][N];
		chk=new boolean[N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		dfs(1,0);
		System.out.println(ans);
		
	}
	private static void dfs(int index,int cnt) {
		if(cnt==N/2) {
			//System.out.println(Arrays.toString(chk));
			int start=0,link=0;
			for(int i=0; i<N; i++) {
				if(chk[i]==true) {
					for(int j=0; j<N; j++) {
						if(chk[j]==true) {
							start+=map[i][j];
						}
					}
				}else if(chk[i]==false) {
					for(int j=0; j<N; j++) {
						if(chk[j]==false) {
							link+=map[i][j];
						}
					}
				}
			}
			if(ans>Math.abs(start-link))
				ans=Math.abs(start-link);
			return;
		}
		if(index==N) {
			return;
		}
		chk[index]=true;
		dfs(index+1,cnt+1);
		chk[index]=false;
		dfs(index+1,cnt);
		
	}

}

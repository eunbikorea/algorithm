import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_bj_1707_이분그래프 {

	static int V,E;
	static List[] list;
	static int color[];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int K=sc.nextInt();
		for(int tc=1; tc<=K; tc++) {
			V=sc.nextInt();
			E=sc.nextInt();
			list =new ArrayList[V+1];
			for(int i=1; i<=V; i++) {
				list[i]=new ArrayList();
			}
			color=new int[V+1];
			for(int e=0; e<E; e++) {
				int n1=sc.nextInt();
				int n2=sc.nextInt();
				list[n1].add(n2);
				list[n2].add(n1);//이거 추가 안해서 틀림
			}
			for(int i=1; i<=V; i++) {
				if(color[i]==0) {
					dfs(i,1);
				}
			}
			if(isPossible()) {
				System.out.println("YES");
			}else System.out.println("NO");
			
		}
	}
	private static boolean isPossible() {
		for(int i=1; i<=V; i++) {
			for(int j=0; j<list[i].size(); j++) {
				if(color[i]==color[(int)list[i].get(j)]) {
					return false;
				}
			}
		}
		return true;
	}
	private static void dfs(int node, int c) {
		color[node]=c;
		for(int i=0; i<list[node].size(); i++) {
			int next=(int)list[node].get(i);
			if(color[next]==0) {
				dfs(next,3-c);
			}
		}
	}

}

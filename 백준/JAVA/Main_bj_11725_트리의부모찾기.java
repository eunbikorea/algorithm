import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_bj_11725_트리의부모찾기 {

	static int N;
	static int[] parent;
	static boolean[] visit;
	static List[] nodes;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		parent=new int[N+1];
		visit=new boolean[N+1];
		nodes=new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			nodes[i]=new ArrayList();
		}
		for(int i=1; i<=N-1; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int num1=Integer.parseInt(st.nextToken());
			int num2=Integer.parseInt(st.nextToken());
			nodes[num1].add(num2);
			nodes[num2].add(num1);
		}
		find(1);
		for(int i=2; i<=N; i++) {
			System.out.print(parent[i]+"\n");
		}
	}
	private static void find(int nodeNum) {
		visit[nodeNum]=true;
		for(int i=0; i<nodes[nodeNum].size(); i++) {
			int next= (int) nodes[nodeNum].get(i);
			if(visit[next]==false) {
				visit[next]=true;
				parent[next]=nodeNum;
				find(next);
			}
		}
	}

}

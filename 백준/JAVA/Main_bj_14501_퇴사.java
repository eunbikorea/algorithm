import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_14501_퇴사 {

	static int N,ans=0;
	static int[] T;//시간
	static int[] P;//돈
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		T=new int[N+1];
		P=new int[N+1];
		for(int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			T[i]=Integer.parseInt(st.nextToken());
			P[i]=Integer.parseInt(st.nextToken());
		}//입력끝
		for(int i=1; i<=N; i++) {
			dfs(i,P[i],P[i]);
		}
		System.out.println(ans);
	}
	private static void dfs(int day, int sum, int preVal) {
		if(day+T[day]>N+1) {
			if(ans<sum-preVal)ans=sum-preVal;
			return;
		}
		if(day+T[day]==N+1) {
			if(ans<sum)ans=sum;
			return;
		}
		int next=day+T[day];
		for(int i=next; i<=N; i++) {
			dfs(i,sum+P[i],P[i]);
		}
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_1309_동물원 {

	final static int MOD=9901;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] dp=new int[N][3]; //0두칸모두빈칸, 1 왼쪽칸에 배치, 2오른쪽칸에 배치
		dp[0][0]=1;
		dp[0][1]=1;
		dp[0][2]=1;
		for(int i=1; i<N; i++) {
			dp[i][0]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%MOD;//이전 배치에 모두 가능
			dp[i][1]=(dp[i-1][0]+dp[i-1][2])%MOD;//이전 경우의 같은 열에 둔 경우 제외하고 가능
			dp[i][2]=(dp[i-1][0]+dp[i-1][1])%MOD;//이전 경우의 같은 열에 둔 경우 제외하고 가능
		}
		System.out.println((dp[N-1][0]+dp[N-1][1]+dp[N-1][2])%MOD);

	}

}

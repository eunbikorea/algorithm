import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_2579_계단오르기 {

	static int N;
	static int[] step;
	static int[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		step=new int[301];
		dp=new int[301];
		for(int i=1; i<=N; i++) {
			step[i]=Integer.parseInt(br.readLine());
		}
		dp[1]=step[1];
		dp[2]=step[1]+step[2];
		dp[3]=Math.max(step[1]+step[3], step[2]+step[3]);
		
		for(int i=4; i<=N; i++) {
			dp[i]=Math.max(dp[i-2]+step[i], dp[i-3]+ step[i - 1]+step[i]);
			
		}
		System.out.println(dp[N]);
	}

}

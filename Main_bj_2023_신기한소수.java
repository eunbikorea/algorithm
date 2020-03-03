import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_bj_2023_신기한소수 {

	public static int N;
	public static boolean f;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dfs("", 0);
		System.out.println(sb.toString());
	}

	private static void dfs(String s, int cnt) {
		if (cnt == N) {
			sb.append(s+'\n');
			return;
		}
		for(int i=1; i<=9; i++) {
			if(isPrime(Integer.parseInt(s+i))) {
				dfs(s+i,cnt+1);
			}
		}
		
	}

	private static boolean isPrime(int num) {
		if(num==1) return false;
		
		for(int i=2; i<num; i++) {
			if(num%i==0) return false;
		}
		return true;
	}
}

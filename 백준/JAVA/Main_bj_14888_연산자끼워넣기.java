import java.util.Scanner;

public class Main_bj_14888_연산자끼워넣기 {

	static int N;
	static long min=Long.MAX_VALUE;
	static long max=Long.MIN_VALUE;
	static int[] num;
	static int[] op;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		num=new int[N];
		op=new int[4];
		for(int i=0; i<N; i++) {
			num[i]=sc.nextInt();
		}
		for(int i=0; i<4; i++) {
			op[i]=sc.nextInt();
		}
		for(int i=0; i<4; i++) {
			if(op[i]==0)continue;
			op[i]--;
			dfs(num[0],i,1);
			op[i]++;
			
		}
		System.out.print(max+"\n"+min);
		
	}
	private static void dfs(long sum, int oi,int index) {
		if(oi==0) sum+=num[index];
		else if(oi==1) sum-=num[index];
		else if(oi==2) sum*=num[index];
		else if(oi==3) sum/=num[index];
		if(index==N-1) {
			if(sum<min)min=sum;
			if(sum>max)max=sum;
			return;
		}
		for(int i=0; i<4; i++) {
			if(op[i]==0)continue;
			op[i]--;
			dfs(sum,i,index+1);
			op[i]++;

		}
	}

}

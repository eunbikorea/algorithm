import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_2343_기타레슨 {

	static int N,M;
	static int[] lesson;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int left=0;
		int right=0;
		lesson=new int[N];
		st= new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			
			lesson[i]=Integer.parseInt(st.nextToken());
			right+=lesson[i];
			if(left<lesson[i]) left=lesson[i];
		}
		while(left<=right) {
			int mid=(left+right)/2;
			int sum=0;
			int cnt=0;
			for(int i=0; i<N; i++) {
				if(sum+lesson[i]>mid) {
					sum=0;
					cnt++;
				}
				sum+=lesson[i];
			}
			if(sum!=0)cnt++;
			if(cnt<=M) right=mid-1;
			else left=mid+1;
		}
		System.out.println(left);
	}

}

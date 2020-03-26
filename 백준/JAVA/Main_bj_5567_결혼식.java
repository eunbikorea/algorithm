import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_bj_5567_결혼식 {

	static int N,M,cnt=0;
	static List[] list;
	static boolean[] chk;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list=new ArrayList[N+1];
		chk= new boolean[N+1];
		for(int i=1; i<=N; i++)
			list[i]=new ArrayList();
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int me=Integer.parseInt(st.nextToken());
			int friend=Integer.parseInt(st.nextToken());
			list[me].add(friend);
			list[friend].add(me);//이거 또 추가 안했네.. 주의하자!
		}
		chk[1]=true;
		start(1);
		System.out.println(cnt);
	}
	private static void start(int num) {
		for(int i=0; i<list[num].size(); i++) {
			int next=(int) list[num].get(i);
			if(chk[next]==false) {
				chk[next]=true;
				cnt++;
			}
			
			
			for(int j=0; j<list[next].size(); j++) {
				int next2=(int) list[next].get(j);
				if(chk[next2]==false) {
					chk[next2]=true;
					cnt++;
				}
			}
		}
		
	}

}

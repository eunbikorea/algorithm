import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_bj_1764_듣보잡 {

	public static int N,M;
	//public static String[] arr1;
	public static HashSet<String> hs=new HashSet<String>();
	public static ArrayList<String> ans = new ArrayList<String>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		//arr1=new String[N];
		//arr2=new String[M];
		for(int i=0; i<N; i++) {
			//arr1[i]=br.readLine();
			hs.add(br.readLine());
		}
		for(int i=0; i<M; i++) {
			String s=br.readLine();
			if(hs.contains(s)) {
				ans.add(s);
			}
			
		}
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int i=0; i<ans.size(); i++) {
			System.out.println(ans.get(i));
		}

	}

}

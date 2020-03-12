package day4;

import java.io.*;
import java.util.*;

public class Solution_d4_7701_염라대왕의이름정렬 {

	static int N;
	static StringBuilder sb;
	static HashSet<String> hs;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb=new StringBuilder();
			sb.append("#"+tc+"\n");
			N=Integer.parseInt(br.readLine());
			hs=new HashSet<String>();
			for(int i=0; i<N; i++) {
				String s=br.readLine();
				hs.add(s);
			}
			List list = new ArrayList(hs);
			Collections.sort(list, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					if(o1.length()==o2.length()) {
						return o1.compareTo(o2);
					}else return o1.length()-o2.length();
				}
			});
			for(int i=0; i<list.size(); i++) {
				sb.append(list.get(i)+"\n");
			}
		
			System.out.print(sb.toString());
		}
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_1543_문서검색 {

	static char[] document;
	static char[] str;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		document=br.readLine().toCharArray();
		str=br.readLine().toCharArray();
		int cnt=0;
		
		for(int i=0; i<=document.length-str.length; i++) {//부등호 <로 해서 틀림
			if(found(i)) {
				cnt++;
				i+=str.length-1;//-1안해줘서 틀림
			}
		}
		System.out.println(cnt);

	}
	private static boolean found(int idx) {
		for(int i=0; i<str.length; i++) {
			if(str[i]!=document[idx+i]) return false;
		}
		return true;
	}

}

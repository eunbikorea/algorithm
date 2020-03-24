import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_14405_피카츄 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		
		boolean f=false;
		
		for(int i=0; i<str.length(); i++) {
			boolean innerF=false;
			if(i+1<str.length() && 
					(str.substring(i, i+2).equals("pi") ||str.substring(i, i+2).equals("ka"))){
				i++;
				if(f==false) f=true;
				innerF=true;
			}else if(i+2<str.length() && str.substring(i, i+3).equals("chu")) {
				i+=2;
				if(f==false) f=true;
				innerF=true;
			}
			if(f==false || innerF==false) {
				System.out.println("NO");
				System.exit(0);
			}
			
		}
		System.out.println("YES");
	}

}

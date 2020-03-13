package day5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Code{
	int[] parCnt;
	int dotCnt;
	public Code(int[] parCnt, int dotCnt) {
		super();
		this.parCnt = parCnt;
		this.dotCnt = dotCnt;
	}
	
}
public class Solution_d4_3378_스타일리쉬들여쓰기 {

	static int p,q;
	static StringBuilder sb;
	static String[] pStr,qStr;
	static Code[] pCode;
	static Code[] qCode;
	static List<int[]> rcs;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			rcs=new ArrayList<int[]>();
			sb=new StringBuilder();
			st=new StringTokenizer(br.readLine()," ");
			p=Integer.parseInt(st.nextToken());
			q=Integer.parseInt(st.nextToken());
			pStr=new String[p];
			qStr=new String[q];
			pCode=new Code[p];
			qCode=new Code[q];
			for(int i=0; i<p; i++) {
				pStr[i]=br.readLine();
			}
			for(int i=0; i<q; i++) {
				qStr[i]=br.readLine();
			}//입력끝
			//System.out.println(Arrays.deepToString(pStr));
			//System.out.println(Arrays.deepToString(qStr));
			pCode[0]=new Code(new int[] {0,0,0},0);
			for(int i=1; i<p; i++) {
				int[] tmp=new int[3];
				tmp[0]+=getCharNumber(pStr[i-1],'(');
				tmp[0]-=getCharNumber(pStr[i-1],')');
				tmp[1]+=getCharNumber(pStr[i-1],'{');
				tmp[1]-=getCharNumber(pStr[i-1],'}');
				tmp[2]+=getCharNumber(pStr[i-1],'[');
				tmp[2]-=getCharNumber(pStr[i-1],']');
				int cnt=0;
				int index=0;
				while(pStr[i].charAt(index)=='.') {
					index++;
					cnt++;
				}
				
				int[] preArr=new int[3];
				for(int z=0; z<3; z++) {
					preArr[z]=pCode[i-1].parCnt[z]+tmp[z];
				}
				
				pCode[i]=new Code(preArr,cnt);
			}
			getRCS();
			sb.append("#"+tc+" "+0);
			if(rcs.size()==0) {//RCS 경우의 수 없을때
				for(int i=1; i<q; i++) {
					if(qStr[i].charAt(0)=='(' 
						||qStr[i].charAt(0)=='{' ||qStr[i].charAt(0)=='}'
						||qStr[i].charAt(0)=='[' ||qStr[i].charAt(0)==']')
						sb.append(" "+(-1));
					else sb.append(" "+0);
				}
			}else if(rcs.size()==1) {//RCS 경우의 수 1
				setQcode();
				for(int i=1; i<q; i++) {
					int[] rcsArr=rcs.get(0);
					
					int[] par=qCode[i].parCnt;
					sb.append(" "+(int)(rcsArr[0]*par[0]+rcsArr[1]*par[1]+rcsArr[2]*par[2]));
				}
			}else {//RCS 경우의 수 2이상
				setQcode();
				
				for(int i=1; i<q; i++) {
					int[] par=qCode[i].parCnt;
					boolean f=false;
					int tmp=0;
					for(int k=0; k<rcs.size(); k++) {
						int[] rcsArr=rcs.get(k);
						int res=rcsArr[0]*par[0]+rcsArr[1]*par[1]+rcsArr[2]*par[2];
						if(f==false) {
							f=true;
							tmp=res;
						}else {
							if(tmp!=res) {
								tmp=-1;
								break;
							}
						}
					}
					sb.append(" "+tmp);
				}
			}
			System.out.println(sb.toString());
		}
	}
	private static void setQcode() {
		qCode[0]=new Code(new int[] {0,0,0},0);
		for(int i=1; i<q; i++) {
			int[] tmp=new int[3];
			tmp[0]+=getCharNumber(qStr[i-1],'(');
			tmp[0]-=getCharNumber(qStr[i-1],')');
			tmp[1]+=getCharNumber(qStr[i-1],'{');
			tmp[1]-=getCharNumber(qStr[i-1],'}');
			tmp[2]+=getCharNumber(qStr[i-1],'[');
			tmp[2]-=getCharNumber(qStr[i-1],']');
			
			//preArr에 qCode[i-1].parCnt를 넣어서 했더니 주소값이 넘어가려서 값이 같이 변했다...위에 pCode만들때도 마찬가지!
			int[] preArr=new int[3];
			for(int z=0; z<3; z++) {
				preArr[z]=qCode[i-1].parCnt[z]+tmp[z];
			}
			qCode[i]=new Code(preArr,0);
		}
		
	}
	private static void getRCS() {
		for(int i=1; i<21; i++) {
			for(int j=1; j<21; j++) {
				for(int z=1; z<21; z++) {
					if(isPossible(i,j,z)) rcs.add(new int[] {i,j,z});
				}
			}
		}
		
	}
	private static boolean isPossible(int i, int j, int z) {
		for(int pi=1; pi<p; pi++) {
			int[] par=pCode[pi].parCnt;
			int dot=pCode[pi].dotCnt;
			if(dot!=(i*par[0]+j*par[1]+z*par[2]))return false;
		}
		return true;
	}
	private static int getCharNumber(String str, char ch) {
		int cnt=0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)==ch) cnt++;
		}
		return cnt;
	}

}

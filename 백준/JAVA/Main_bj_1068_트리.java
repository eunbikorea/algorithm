import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//참고: https://ppikanyang.tistory.com/entry/1068%EB%B2%88-%ED%8A%B8%EB%A6%AC

public class Main_bj_1068_트리 {
	
	static int N;
	static int[][] nodes;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		nodes=new int[N][2];//0부모노드 1자식수
		for(int i=0; i<N; i++) {
			nodes[i][0]=sc.nextInt();
		}
		getChildNum();
		remove(sc.nextInt());
		System.out.println(getAnswer());
	}

	private static int getAnswer() {
		int cnt=0;
		for(int i=0; i<N; i++) {
			if(nodes[i][0]!=-2 &&nodes[i][1]==0) {
				cnt++;
			}
		}
		return cnt;
	}

	private static void remove(int num) {
		if(nodes[num][0]!=-1) {//루트노드아니면
			nodes[nodes[num][0]][1]--;//부모노드의 자식수 줄이기
		}
		nodes[num][0]=-2;//지워진 노드 표시
		if(nodes[num][1]>0) {//자식이 있으면
			for(int i=0; i<N; i++) {
				if(nodes[i][0]==num) {
					remove(i);
				}
			}
		}
		
	}

	private static void getChildNum() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(nodes[j][0]==i) nodes[i][1]++;
			}
		}
		
	}
}

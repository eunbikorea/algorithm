import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_d5_4534_트리흑백색칠 {
    static final int MOD = 1000000007;
    static int N;
    static List[] adj;
    static long[][] memo; //색상, 정점 번호
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T= sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            adj = new ArrayList[N+1];
            for(int i = 1; i <= N; i++)
                adj[i] = new ArrayList<>();
            memo = new long[2][N+1];
            for(int i = 1; i < N; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                adj[a].add(b);
                adj[b].add(a);
            }
            long ans = ( dfs(1, 0, -1) + dfs(1, 1, -1) ) % MOD;
            System.out.println("#" + tc + " " + ans);
        }
    }
    
    
    static long dfs(int v, int color, int parent) {
        //memo[color][v] 값이 존재한다면, 다시 계산하지 않고, 알고 있던값 리턴
        if(memo[color][v] != 0)
            return memo[color][v];
        long ret = 1;
        
        //color가 흑(0)인 경우.
        //자식 노드들을 백(1)으로 칠한 경우의 경우의수들의 곱
        if( color == 0 ) {
            //현재 정점 v에서 연결된 모든 간선에 대해서
            for(int i = 0; i < adj[v].size(); i++) {
                if( (int)(adj[v].get(i)) != parent ) {
                    ret *= dfs((int)(adj[v].get(i)), 1, v);
                    ret %= MOD;
                }
            }
        }
        //color가 백(1)인 경우
        else {
            for(int i = 0; i < adj[v].size(); i++) {
                if((int)( adj[v].get(i)) != parent ) {
                    //자식 노드들을 백(0)으로 칠한 경우의 경우의수 들의 곱
                    ret *= ( dfs((int)(adj[v].get(i)), 1, v) + dfs((int)(adj[v].get(i)), 0, v)  );
                    ret %= MOD;
                    //자식 노드들을 흑(1)으로 칠한 경우의 경우의수 들의 곱
                }
            }
        }
        //memo[color][v] 에 기록
        memo[color][v] = ret;
        return ret;
    }
}
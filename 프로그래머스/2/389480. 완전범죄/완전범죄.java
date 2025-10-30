import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int A = n; // A의 '미만' 용량
        int B = m; // B의 '미만' 용량
        int cnt = info.length;

        // dp[a][b] = A가 a, B가 b 사용한 상태가 가능
        boolean[][] dp = new boolean[A][B];
        dp[0][0] = true;

        for (int i = 0; i < cnt; i++) {
            int wa = info[i][0]; // A에 넣을 때 증가량
            int wb = info[i][1]; // B에 넣을 때 증가량

            boolean[][] next = new boolean[A][B];

            for (int a = 0; a < A; a++) {
                for (int b = 0; b < B; b++) {
                    if (!dp[a][b]) continue;

                    // A에 넣는 경우 (미만 조건 유지)
                    int na = a + wa;
                    if (na < A) {
                        next[na][b] = true;
                    }

                    // B에 넣는 경우 (미만 조건 유지)
                    int nb = b + wb;
                    if (nb < B) {
                        next[a][nb] = true;
                    }
                }
            }
            dp = next;
        }

        // 가능한 상태 중 A 사용량 최소값
        int ans = -1;
        outer:
        for (int a = 0; a < A; a++) {
            for (int b = 0; b < B; b++) {
                if (dp[a][b]) {
                    ans = a;
                    break outer;
                }
            }
        }
        return ans;
    }
}

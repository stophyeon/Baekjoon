import java.util.*;
class Solution {

    public int solution(int[][] triangle) {
        int len = triangle.length;
        
        // dp 배열의 크기를 올바르게 초기화
        int[][] dp = new int[len][];
        for (int i = 0; i < len; i++) {
            dp[i] = new int[i + 1];
        }
        
        dp[0][0] = triangle[0][0];
        int answer = 0;
        
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
                if (i == len - 1 && answer < dp[i][j]) {
                    answer = dp[i][j];
                }
            }
        }
        
        return answer;
    }
}
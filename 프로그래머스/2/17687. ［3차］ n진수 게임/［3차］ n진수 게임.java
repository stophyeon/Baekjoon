class Solution {
    
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<100000; i++){
            String k = Integer.toString(i,n);
            sb.append(k);
        }
        String[] str = sb.toString().split("");
        for(int i=0; i<t*m; i+=m){
            answer.append(str[p+i-1].toUpperCase());
        }
        return answer.toString();
    }
    
}
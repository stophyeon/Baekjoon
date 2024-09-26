class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        double dt = Double.valueOf(d);
        double kt= Double.valueOf(k);
        
        for(int i=0; i<=d; i++){
            if(i*k>d) break;
            int count=0;
            double lim = Math.sqrt(Math.pow(dt,2)-Math.pow(Double.valueOf(i*k),2))/kt;
            int limit = (int)lim;
            answer+=limit+1;
        }
        return answer;
    }
}
class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long total=0;
        for(int i=1; i<=count; i++){
            total+=Long.valueOf(i*price);
        }
        
        if(total<money) return 0;
        else{
            answer = Math.abs(money-total);
            return answer;
        }
    }
}
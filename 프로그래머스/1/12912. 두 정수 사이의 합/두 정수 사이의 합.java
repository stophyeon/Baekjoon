class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        if(a==b) return a;
        long sum = a+b;
        long len=0;
        if(a>=0&&b>=0){
            len = Math.abs(a-b)+1;
        }
        else if(a<0&&b<0){
            len = Math.abs(Math.abs(a)-Math.abs(b))+1;
        }
        else{
            len = Math.abs(a)+Math.abs(b)+1;
        }
        
        if(len%2==0){
            answer=(len/2)*sum;
        }else{
            answer = (len/2)*sum+sum/2;
        }
        return answer;
    }
}
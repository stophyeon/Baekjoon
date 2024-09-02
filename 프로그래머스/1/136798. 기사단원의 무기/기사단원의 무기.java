class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 1;
        for(int i=2; i<=number; i++){
            int count = cal(i);
            if(count>limit) answer+=power;
            else{answer+=count;}
        }
        return answer;
    }
    public int cal(int n){
        int count=0;
        for(int i=1; i<=Math.sqrt(n); i++){
            if(n%i==0){
                if(i==Math.sqrt(n)){count++;}
                else{count+=2;}
            } 
            
        }
        System.out.println(count);
        return count;
    }
}
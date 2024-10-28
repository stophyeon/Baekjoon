class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int res=arrayA[0];
        int agcd=0;
        int bgcd=0;
        for(int i=1; i<arrayA.length; i++){
            res=gcd(res,arrayA[i]);
        }
        agcd=res;
        res=arrayB[0];
        for(int i=1; i<arrayB.length; i++){
            res=gcd(res,arrayB[i]);
        }
        bgcd=res;
        for(int a : arrayA){
            if(a%bgcd==0) {bgcd=0; break;}
        }
        
        for(int b : arrayB){
            if(b%agcd==0) {agcd=0; break;}
        }
        
        answer = Math.max(answer,agcd);
        answer = Math.max(answer,bgcd);
        //System.out.println(agcd);
        //System.out.println(bgcd);
        
        return answer;
    }
    public int gcd(int a, int b){
        if(a%b==0) return b;
        return gcd(b,a%b);
    }
}
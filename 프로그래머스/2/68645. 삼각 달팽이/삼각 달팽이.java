class Solution {
    public int[] solution(int n) {
        int num=0;
        if(n%2==0){
            num=(n+1)*(n/2);
        }
        else{
            num=(n+1)*(n/2)+(n+1)/2;
        }
        int[] answer = new int[num];
        int size=n;
        int[][] map = new int[n][n];
        int r=0;
        int c=0;
        //0-왼, 1- 아래, 2-오
        int dir=0;
        map[0][0]=1;
        for(int i=2; i<=num; i++){
            if(dir==0){
                r++;
                map[r][c]=i;
                if(r==size-1) dir=1;
                continue;
            }
            if(dir==1){
                c++;
                map[r][c]=i;
                //System.out.println(r);
                if(c==size-1||map[r][c+1]!=0) dir=2;
                continue;
            }
            if(dir==2){
                r--;
                c--;
                if(map[r-1][c-1]!=0){dir=0; size--;}
                map[r][c]=i;
            }
        }
        int idx=0;
        for(int k=0; k<n; k++){
            for(int j=0; j<k+1; j++){
                answer[idx]=map[k][j];
                idx++;
            }
        }
        
        return answer;
    }
}
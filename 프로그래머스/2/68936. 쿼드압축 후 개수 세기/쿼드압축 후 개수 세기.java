class Solution {
    int[] answer = new int[2];
    int size;
    int[][] s;
    public int[] solution(int[][] arr) {
        size=arr.length;
        s=arr;
        dfs(0,0,size);
        return answer;
    }
    public void dfs(int r1, int c1, int len){
        if(len==1){
            if(s[r1][c1]==1) answer[1]+=1;
            else{answer[0]+=1;}
            return;
        }
        if(isAllOne(r1,c1,len)){answer[1]+=1; return;}
        if(isAllZero(r1,c1,len)){answer[0]+=1; return;}
        dfs(r1,c1,len/2);
        dfs(r1,c1+len/2,len/2);
        dfs(r1+len/2,c1,len/2);
        dfs(r1+len/2,c1+len/2,len/2);
    }
    public boolean isAllOne(int r1, int c1, int len){
        for(int i=r1; i<r1+len; i++){
            for(int j=c1; j<c1+len; j++){
                if(s[i][j]!=1) return false;
            }
        }
        return true;
    }
    public boolean isAllZero(int r1, int c1, int len){
        for(int i=r1; i<r1+len; i++){
            for(int j=c1; j<c1+len; j++){
                if(s[i][j]!=0) return false;
            }
        }
        return true;
    }
}
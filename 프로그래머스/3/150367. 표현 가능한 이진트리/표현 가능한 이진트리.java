class Solution {
    int[] answer;
    String[] binary;
    
    
    public int[] solution(long[] numbers) {
        answer = new int[numbers.length];
        binary = new String[numbers.length];
        
        
        //이진트리 노드 개수
        for(int i=0; i<numbers.length; i++){
            String str = Long.toString(numbers[i],2);
            int len = str.length();
            StringBuilder s = new StringBuilder();
            if(len==1) {binary[i]=str; continue;}
            if(len<=3){
                for(int j=0; j<3-len; j++){
                    s.append("0");
                }
                binary[i]=s.toString()+str;
                continue;
            }
            if(len<=7){
                for(int j=0; j<7-len; j++){
                    s.append("0");
                }
                binary[i]=s.toString()+str;
                continue;
            }
            if(len<=15){
                for(int j=0; j<15-len; j++){
                    s.append("0");
                }
                binary[i]=s.toString()+str;
                continue;
            }
            if(len<=31){
                for(int j=0; j<31-len; j++){
                    s.append("0");
                }
                binary[i]=s.toString()+str;
                continue;
            }
            if(len<=63){
                for(int j=0; j<63-len; j++){
                    s.insert(j,"0");
                }
                binary[i]=s.toString()+str;
                continue;
            }
        }
        
        //노드수에 맞게 이진수 변환
        for(int i=0; i<numbers.length; i++){
            if(numbers[i]==0){answer[i]=0; continue;}
            if(numbers[i]==1){answer[i]=1; continue;}
            answer[i] = 1;
            dfs(i,0,binary[i].length()-1,binary[i].length());
        }
        return answer;
    }
    
    public void dfs(int idx,int s, int e, int size){
        int m = size/2;
        if(m == 0) {return;}
        if(binary[idx].charAt(s+m) == '0'){
            for(int i = s; i <= e; i++){
                if(binary[idx].charAt(i) == '1'){answer[idx]=0; return;}
            }
        }
        dfs(idx,s+1+m,e,m);
        dfs(idx,s,e-1-m,m);
    }
}
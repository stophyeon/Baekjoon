import java.util.*;
class Solution {
    int[] peach;
    int max=-1;
    List<int[]> list = new ArrayList<>();
    public int[] solution(int n, int[] info) {
        peach=info;
        int[] lion =new int[11];
        dfs(n,0,lion);
        if(max==-1) return new int[]{-1};
        Collections.sort(list,(o1,o2)->{
           for(int i=10; i>=0; i--){
               if(o1[i]==o2[i]) continue;
               return o2[i]-o1[i];
           } 
            return 0;
        });
        
        return list.get(0);
    }
    
    public void dfs(int arrow, int idx, int[] lion){
        if(arrow==0){
            int a=0;
            int b=0;
            for(int i=0; i<=10; i++){
                if(peach[i]==0&&lion[i]==0) continue;
                if(peach[i]>=lion[i]) a+=10-i;
                else{b+=10-i;}
            }
            if(b>a){
                if(max<b-a){
                    max=b-a;
                    list.clear();
                    list.add(lion.clone());
                }
                if(max==b-a){
                    list.add(lion.clone());
                }
            }
            return;
        }
        
        for(int i=idx; i<11; i++){
            lion[i]+=1;
            dfs(arrow-1,i,lion);
            lion[i]-=1;
        }
    }
}
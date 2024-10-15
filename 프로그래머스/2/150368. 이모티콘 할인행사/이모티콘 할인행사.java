import java.util.*;
class Solution {
    List<int[]> res = new ArrayList<>();
    int[][] user;
    int[] e;
    int len;
    public int[] solution(int[][] users, int[] emoticons) {
        user=users;
        e=emoticons;
        len=emoticons.length;
        for(int i=10; i<=40; i+=10){
            dfs(0,i,new int[users.length]);
        }
        Collections.sort(res,(r1,r2)->{
            if(r1[0]==r2[0]){
                return r2[1]-r1[1];
            }
            return r2[0]-r1[0];
        });
        return res.get(0);
    }
    public void dfs(int depth, int per, int[] total){
        if(depth==len){
            int plus=0;
            int t=0;
            for(int i=0; i<user.length; i++){
                if(total[i]>=user[i][1]) {plus++;}
                else{t+=total[i];}
            }
            res.add(new int[]{plus,t});
            return;
        }
        int price=(e[depth]/100)*(100-per);
        for(int i=0; i<user.length; i++){
            if(user[i][0]<=per) total[i]+=price;
            //System.out.print(total[i]);
            //System.out.print(",");
        }
        System.out.println();
        for(int i=10; i<=40; i+=10){
            dfs(depth+1,i,Arrays.copyOf(total,total.length));
        }
    }
}
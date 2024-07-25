import java.util.*;
class Solution {
    String[] dic;
    int answer = 51;
    int len;
    String ans;
    public int solution(String begin, String target, String[] words) {
        int count=0;
        len=words.length;
        dic = words;
        ans=target;
        for(String word : words){
            if(target.equals(word)){count++;}
        }
        if(count==0){return 0;}
        boolean[] visited = new boolean[words.length];
        dfs(begin,0,visited);
        return answer;
    }
    void dfs(String word,int count,boolean[] visited){
        if(word.equals(ans) && count<answer){answer=count;}
        boolean[] visit = Arrays.copyOf(visited,len);
        for(int i=0; i<len; i++){
            if(contain(dic[i],word)&&!visit[i]){
                visit[i]=true;
                System.out.println(dic[i]);
                dfs(dic[i],count+1,visit);
            }
        }
    }
    boolean contain(String s1,String s2){
        int count=0;
        String[] arr1 = s1.split("");
        
        String[] arr2 = s2.split("");
        
        for(int i=0; i<arr1.length; i++){
            if(arr1[i].equals(arr2[i])){count++;}
        }
        if(count==arr1.length-1) return true;
        else{ return false;}
    }
}
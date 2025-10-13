import java.util.*;

class Solution {
    int[] answer;
    public int[] solution(long[] numbers) {
        answer = new int[numbers.length];
        for(int i=0; i<numbers.length; i++){
            answer[i]=1;
        }
        int idx=0;
        for(long number : numbers){
            //10진수 2진수 변환
            String tree = Long.toBinaryString(number);
            //System.out.println(tree);
            //포화이진트리 크기에 맞춰 길이 조정
            String fullTree = chgLength(tree);
            //System.out.println(fullTree);
            //더미노드의 자식노드에 더미노드만 있는지 확인
            int len = fullTree.length();
            
            String root = fullTree.substring(len/2,(len/2)+1);
            
            if(!dfs(fullTree)) answer[idx]=0;
            idx++;
            
        }
        
        return answer;
    }
    
    public boolean dfs(String tree){
        if (tree.length() == 1) return true;
        int mid = tree.length() / 2;
        char root = tree.charAt(mid);
        String left = tree.substring(0, mid);
        String right = tree.substring(mid + 1);

        // 더미 노드(0)가 부모인데 자식 중 1이 있으면 불가능
        if (root == '0' && (left.contains("1") || right.contains("1")))
            return false;

        return dfs(left) && dfs(right);
    }
    
    public String chgLength(String tree){
        int len = tree.length();
        int n=1;
        
        while(len>n){
            n = n * 2 + 1;
            
        }
        //System.out.println(n);
        String full="";
        
        for(int i=0; i<n-len; i++){
            full+="0";
        }
        return full+tree;
    }
}
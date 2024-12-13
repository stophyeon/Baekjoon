import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        int idx=0;
        for(int i=1; i<=order.length; i++){
            if(idx==order.length-1) break;
            if(i!=order[idx]) st.push(i);
            if(i==order[idx]) {answer++;idx++;}
            if(!st.isEmpty()){
                int s = st.peek();
                while(s==order[idx]){
                    answer++;
                    idx++;
                    //System.out.println(s);
                    st.pop();
                    if(st.isEmpty()) break;
                    s=st.peek();
                    
                }
            }
            
            
        }
        
        
        return answer;
    }
}
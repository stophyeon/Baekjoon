import java.util.*;
class Solution {
    public int[] solution(int[] answers){
        
        int sol1=0;
        int sol2=0;
        int sol3=0;
        int len = answers.length;
        int[] s1 = {1,2,3,4,5};
        int[] s2 = {2,1,2,3,2,4,2,5};
        int[] s3 = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i=0; i<len; i++){
            if(s1[i-5*(i/5)]==answers[i]) sol1++;
            if(s2[i-8*(i/8)]==answers[i]) sol2++;
            if(s3[i-10*(i/10)]==answers[i]) sol3++;
        }
        
        int[] a = {sol1,sol2,sol3};
        List<Integer> ans = new ArrayList<>();
        int max=0;
        for(int i=0; i<3; i++){
            if(max<a[i]) {
                ans.removeAll(ans);
                ans.add(i+1);
                max=a[i];
            }
            else if(max==a[i]) ans.add(i+1);
        }
        return ans.stream().mapToInt(x->x).toArray();
    }
}
import java.util.*;
class Solution {
    HashSet<Integer> set = new HashSet<>();
    int[] number;
    public int solution(int[] elements) {
        number = elements;
        int total=0;
        for(int e : elements){
            set.add(e);
            total+=e;
        }
        set.add(total);
        for(int i=2; i<elements.length; i++){
            cal(i);
        }
        return set.size();
    }
    public void cal(int idx){
        for(int i=0; i<number.length; i++){
            int total=0;
            for(int j=0; j<idx; j++){
                if(i+j>=number.length){
                    total+=number[i+j-number.length];
                }
                else{total+=number[i+j];}
            }
            set.add(total);
        }
    }
}
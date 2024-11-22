import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                if(!set.contains(numbers[i]+numbers[j])){
                    set.add(numbers[i]+numbers[j]);
                    list.add(numbers[i]+numbers[j]);
                }
            }
        }
        list.sort((n1,n2)->n1-n2);
        return list.stream().mapToInt(x->x).toArray();
    }
}
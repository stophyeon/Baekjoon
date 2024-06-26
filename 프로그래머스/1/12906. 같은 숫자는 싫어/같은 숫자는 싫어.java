import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int n = arr[0];
        list.add(n);
        for(int i=1; i<arr.length; i++){
            if(n!=arr[i]){list.add(arr[i]);n=arr[i];}
        }
        int[] answer = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return answer;
    }
}
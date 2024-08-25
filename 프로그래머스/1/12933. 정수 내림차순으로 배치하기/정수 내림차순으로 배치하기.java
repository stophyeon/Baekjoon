import java.util.Arrays;
import java.util.Collections;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] str = String.valueOf(n).split("");
        int[] arr = new int[str.length];
        for(int i=0; i< str.length; i++){
            arr[i]=Integer.parseInt(str[i]);
        }
        Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arr2,Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int a : arr2){
            sb.append(a);
        }
        answer = Long.valueOf(sb.toString());
        return answer;
    }
}
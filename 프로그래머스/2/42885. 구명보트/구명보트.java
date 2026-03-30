import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        //오른쪽(무거운)부터 사람을 담다가 limit보다 크면 왼쪽(가벼운)에서 탐색
        int left = 0;
        int right = people.length-1;
        int cnt = 0;
        while(right>=0&&left<people.length&&left<=right){
            int total=0;
            cnt = 0;
            //무거운 사람 담기
            while(right>0){
                total+=people[right];
                if(total>limit) {
                    total-=people[right];
                    break;
                }
                right--;
                cnt++;
                if(cnt==2) break;
            }
            
            //가벼운 사람 담기
            while(cnt<2 && left<people.length){
                total+=people[left];
                if(total>limit) {
                    total-=people[left];
                    break;
                }
                left++;
                cnt++;
                if(cnt==2) break;
            }
            answer++;
        }
        
        return answer;
    }
}
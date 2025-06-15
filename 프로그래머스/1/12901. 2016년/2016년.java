class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] days = {"FRI","SAT","SUN","MON","TUE","WED","THU"}; 
        int[] months = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        int cal_m=0;
        for(int i=0; i<a; i++){
            cal_m +=months[i];
        }
        System.out.println(cal_m);
        int res=cal_m+b-1;
        System.out.println(res);
        answer=days[res%7];
        return answer;
    }
}
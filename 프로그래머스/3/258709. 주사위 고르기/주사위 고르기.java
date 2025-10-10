import java.util.*;

class Solution {
    int max=0;
    int win=0;
    int[] answer;
    int n=0;
    int[][] dices;
    List<Integer> diceA= new ArrayList<>();
    List<Integer> diceB= new ArrayList<>();
    public int[] solution(int[][] dice) {
        n = dice.length;
        dices=dice;
        //System.out.println(n);
        answer = new int[n/2];
        
        dfs(new ArrayList<>(),0);
        for(int i=0; i< answer.length; i++){
            answer[i]+=1;
        }
        Arrays.sort(answer);
        return answer;
    }
    
    public void dfs(List<Integer> dice, int cnt){
        //주사위 조합 선택완료 시
        if(dice.size()==n/2){
            win=0;
            simulation(dice);
            if(win>max){
                max=win;
                answer=dice.stream().mapToInt(Integer::intValue).toArray();
            }
            return;
        }
        //dice 조합 생성
        for(int i=cnt; i<n; i++){
            dice.add(i);
            dfs(dice,i+1);
            dice.remove(dice.size()-1);
        }
    }
    
    public void simulation(List<Integer> A){
        diceA=A;
        //B 주사위 조합 생성
        diceB.clear();
        for(int i=0; i<n; i++){
            if(!A.contains(i)) diceB.add(i);
        }
        
        //A,B 주사위 조합 경우의 수
        List<Integer> sumA = chooseSumA();
        List<Integer> sumB = chooseSumB();
        
        //이진탐색
        Collections.sort(sumB);
        
        for(int sum : sumA){
            int idx = Collections.binarySearch(sumB,sum);
            if(idx<0) {
                idx = -idx-1;
            }
            else{
                while(idx>0&&sumB.get(idx-1)>=sum){
                    idx--;
                }
            }
            win+=idx;
        }
        return;
    }
    public List<Integer> chooseSumA(){
        List<Integer> list = new ArrayList<>();
        list.add(0);

        for (int diceIdx : diceA) {
            List<Integer> temp = new ArrayList<>();
            for (int num : list) {
                for (int face : dices[diceIdx]) {
                    temp.add(num + face);
                }
            }
            list = temp;
        }
        return list;
    }
    
    public List<Integer> chooseSumB(){
        List<Integer> list = new ArrayList<>();
        list.add(0);

        for (int diceIdx : diceB) {
            List<Integer> temp = new ArrayList<>();
            for (int num : list) {
                for (int face : dices[diceIdx]) {
                    temp.add(num + face);
                }
            }
            list = temp;
        }
        return list;
    }
    
    public void chooseA(List<Integer> num){
        if(num.size()==n/2){
            chooseB(new ArrayList<>(),num);
            return;
        }
        for(int i=0; i<6; i++){
            num.add(i);
            chooseA(num);
            num.remove(num.size()-1);
        }
    }
    
    public void chooseB(List<Integer> num, List<Integer> A){
        if(num.size()==n/2){
            cal(A,num);
            return;
        }
        for(int i=0; i<6; i++){
            num.add(i);
            chooseB(num,A);
            num.remove(num.size()-1);
        }
    }
    
    public void cal(List<Integer> A,List<Integer> B){
        int sumA=0;
        int sumB=0;
        for(int i=0; i<n/2; i++){
            sumA+=dices[diceA.get(i)][A.get(i)];
            sumB+=dices[diceB.get(i)][B.get(i)];
        }
        if(sumA>sumB) win++;
        return;
    }
}
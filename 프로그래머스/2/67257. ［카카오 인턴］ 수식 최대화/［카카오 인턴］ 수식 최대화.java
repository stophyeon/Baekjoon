import java.util.*;
class Solution {
    long max=Integer.MIN_VALUE;
    String[] operation = new String[3];
    public long solution(String expression) {
        
        HashMap<Integer, String> number = new HashMap<>();
        HashMap<Integer, String> op = new HashMap<>();
        String num= "";
        int cnt=0;
        for(int i=0; i<expression.length(); i++){
            if(Character.isDigit(expression.charAt(i))){
                num+=Character.toString(expression.charAt(i));
            }
            else{
                number.put(cnt,num);
                num= "";
                cnt++;
                op.put(cnt,Character.toString(expression.charAt(i)));
                cnt++;
            }
        }
        number.put(cnt,num);
        List<String> res = new ArrayList<>();
        for(int i=0; i<number.size()+op.size(); i++){
            if(number.containsKey(i)){
                res.add(number.get(i));
                continue;
            }
            if(op.containsKey(i)){
                res.add(op.get(i));
                continue;
            }
        }
        
        operation[0]="*";
        operation[1]="+";
        operation[2]="-";
        for(int i=0; i<3; i++){
            boolean[] visited = new boolean[3];
            visited[i]=true;
            List<String> ex = new ArrayList<>(res);
            dfs(ex,operation[i],visited);
        }
        
        return max;
    }
    public void dfs(List<String> ex, String op, boolean[] visited){
        
        for(int i=0; i<ex.size(); i++){
            if(ex.get(i).equals(op)){
                long res=0;
                long num1 = Long.valueOf(ex.get(i-1));
                long num2 = Long.valueOf(ex.get(i+1));
                if(op.equals("*")) res = num1*num2;
                if(op.equals("+")) res = num1+num2;
                if(op.equals("-")) res = num1-num2;
                ex.remove(i-1);
                ex.remove(i-1);
                ex.remove(i-1);
                ex.add(i-1,String.valueOf(res));
                i--;
            }
        }
        if(ex.size()==1){
            max = Math.max(max,Math.abs(Long.valueOf(ex.get(0))));
            return;
        }
        for(int i=0; i<3; i++){
            if(visited[i]) continue;
            visited[i]=true;
            List<String> exp = new ArrayList<>(ex);
            dfs(exp,operation[i],visited);
            visited[i]=false;
        }
    }
}
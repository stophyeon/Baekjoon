import java.util.*;
class Solution {
    int max;
    int[] law = {2,3,4,5,6,7,8,9};
    public String[] solution(String[] expressions) {
        List<String> ans = new ArrayList<>();
        int len = expressions.length;
        String[][] s = new String[len][5];
        for(int i=0; i<len; i++){
            s[i] = expressions[i].split(" ");
        }
        
        for(int i=0; i<len; i++){
            int num1=Integer.parseInt(s[i][0]);
            int num2=Integer.parseInt(s[i][2]);
            
            if(!s[i][4].equals("X")){
                int res=Integer.parseInt(s[i][4]);
                findMax(num1,num2,res);
                String op = s[i][1]; 
                cal(num1,num2,res,op);
            }
            else{
                findMax(num1,num2,0);
                ans.add(expressions[i]);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for(int l : law){
            if(l!=0) {res.add(l);}
        }
        
        if(res.size()==1){
            int r = res.get(0);
            for(int i=0; i<ans.size(); i++){
                String sr = ans.get(i);
                StringBuilder sb = new StringBuilder(ans.get(i));
                sb.delete(sb.length()-1,sb.length());
                sb.append(sol(sr,r));
                ans.set(i,sb.toString());
            }
        }
        else{
            //res중 최솟값보다 작은 수의 덧셈 뺄셈이면 진행
            //int min = Collections.min(res);
            //int resMax=0;
            for(int i=0; i<ans.size(); i++){
                String sr = ans.get(i);
                StringBuilder sb = new StringBuilder(ans.get(i));
                sb.delete(sb.length()-1,sb.length());
                sb.append("?");
                ans.set(i,sb.toString());
                int[] arr = new int[res.size()];
                for(int j=0; j<res.size(); j++){
                   arr[j]=Integer.parseInt(sol(sr,res.get(j)));
                   //System.out.println(arr[j]);
                }
                if(Arrays.stream(arr).max().getAsInt()==Arrays.stream(arr).min().getAsInt()){
                    sb.delete(sb.length()-1,sb.length());
                    sb.append(arr[0]);
                    ans.set(i,sb.toString());
                }
            }
            
            
        }
        
        return ans.toArray(new String[ans.size()]);
    }
    public void findMax(int num1, int num2, int res){
        int n1 = num1/10;
        int n2 = num1%10;
        int n3 = num2/10;
        int n4 = num2%10;
        int n5 = (res/10)/10;
        int n6 = (res/10)%10;
        int n7 = res%10;
        int[] numbers = {n1,n2,n3,n4,n5,n6,n7};
        int m = Arrays.stream(numbers).max().getAsInt();
        if(max<m) max=m;
        for(int i=0; i<law.length; i++){
            if(law[i]<=max) law[i]=0;
        }
    }
    public String sol(String s,int k){
        String[] sarr = s.split(" ");
        int num1=Integer.parseInt(sarr[0]);
        int num2=Integer.parseInt(sarr[2]);
        int n1 = num1/10;
        int n2 = num1%10;
        int n3 = num2/10;
        int n4 = num2%10;
        
        int result=0;
        if(sarr[1].equals("+")){
            if(n2+n4>=k){
                result+=(n2+n4)%k;
                //result+=((n1+n3)/k)*100+((n1+n3)%k)*10;
                if(n1+n3+((n2+n4)/k)>=k){
                    result+=((n1+n3+((n2+n4)/k))/k)*100+((n1+n3+((n2+n4)/k))%k)*10;
                }
                else{
                    result+=(n1+n3+((n2+n4)/k))*10;
                }
            }
            else{
                result+=(n2+n4);
                if(n1+n3>=k){
                    result+=((n1+n3)/k)*100+((n1+n3)%k)*10;
                }
                else{
                    result+=(n1+n3)*10;
                }
            }
            
        }
        else{
            result+=(n1-n3)*10;
            
            if(n2<n4){
                result-=10;
                result+=n2+k-n4;
                
            }
            else{
                result+=n2-n4;
                
            }
        }
        return String.valueOf(result);
    }
    public void cal(int num1,int num2, int res, String op){
        int n1 = num1/10;
        int n2 = num1%10;
        int n3 = num2/10;
        int n4 = num2%10;
        int n5 = (res/10)/10;
        int n6 = (res/10)%10;
        int n7 = res%10;
        for(int i=0; i<law.length; i++){
            if(law[i]==0) continue;
            int k = law[i];
            if(op.equals("+")){
                int r=(n1*k+n2)+(n3*k+n4);
                //System.out.println(r);
                //System.out.println(n5*k+n6);
                if(r!=n5*k*k+n6*k+n7) {law[i]=0; continue;}
                
            }
            else{
                int r=(n1*k+n2)-(n3*k+n4);
                //System.out.println(r);
                //System.out.println(n5*k+n6);
                if(r!=n5*k*k+n6*k+n7) {law[i]=0; continue;}
            }
        }
    }
}
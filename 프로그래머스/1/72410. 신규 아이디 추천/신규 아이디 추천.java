import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        //1
        new_id=new_id.toLowerCase();
        String[] str = new_id.split("");
        List<Integer> rem = new ArrayList<>();
        StringBuilder sb = new StringBuilder(new_id);
        //2
        for(int i=0; i<str.length; i++){
            if(!Character.isLetter(str[i].charAt(0))&&!Character.isDigit(str[i].charAt(0))){
                if(!str[i].equals("-")&&!str[i].equals("_")&&!str[i].equals(".")){
                    rem.add(i);
                }
            }
        }
        for(int i=0; i<rem.size(); i++){
            sb.delete(rem.get(i)-i,rem.get(i)-i+1);
        }
        //3
        int count=0;
        for(int i=0; i<sb.toString().length(); i++){
            if(sb.charAt(i)=='.'){count++;}
            if(sb.charAt(i)!='.'){count=0;}
            if(count>=2){
                if(i-count<0){
                    sb.replace(0,i+1,".");
                    i=-1;
                    count=0;
                } 
                else{
                    sb.replace(i-count+1,i+1,".");
                    i-=count+1;
                    count=0;
                }
            }
        }
        //4
        boolean check=true;
        while(check){
            
            if(sb.charAt(0)!='.'&&sb.charAt(sb.toString().length()-1)!='.'){
                check = false;
                continue;
            }
            if(sb.charAt(0)=='.'){sb.deleteCharAt(0);}
            if(sb.toString().equals("")){
                check = false;
                
                continue;
            }
            if(sb.charAt(sb.toString().length()-1)=='.'){sb.deleteCharAt(sb.toString().length()-1);}
        }
        //5
        if(sb.toString().equals("")){
            sb.append("a");
        }
        //6
        if(sb.toString().length()>=16){
            sb = new StringBuilder(sb.substring(0,15));
            while(sb.charAt(sb.length()-1)=='.'){
                sb.deleteCharAt(sb.length()-1);
            }
        }
        //7
        
        while(sb.toString().length()<3){
            sb.append(String.valueOf(sb.charAt(sb.length()-1)));
        }
        
        
        System.out.println(sb.toString());
        return sb.toString();
    }
}
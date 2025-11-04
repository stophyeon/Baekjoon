import java.util.*;
import java.util.stream.Collectors;

class Solution {
    HashMap<String,Integer> ban = new HashMap<>();
    public String solution(long n, String[] bans) {
        String answer = "";
        for(String b : bans){
            ban.put(b,0);
        }
        //알파벳 26자리
        //삭제전 n번 주문 글자수 탐색
        long cnt = 26;
        int len = 1;
        while(cnt<n){
            len+=1;
            cnt+=Math.pow(26,len);
        }
        //해당 글자 수 첫번째 주문에서 n번째 주문 탐색
        String start="";
        for(int i=0; i<len; i++){
            start+="a";
        }
        
        
        //각 자리수 별로 a에서 더해야할 수 계산
        List<Integer> list = new ArrayList<>();
        long k = n-(cnt-(long)Math.pow(26,len))-1;
        
        while(k/26!=0){
            list.add((int)(k%26));
            k=k/26;
        }
        list.add((int)k);
        //각 자리수에 더해서 n번째 주문 탐색
        String spell = getSpell(start,len,list);
        
        //bans의 문자열이 n번째 주문보다 앞에있으면 뒤에 주문으로
        int step = calSpell(spell);                     
        if(ban.containsKey(spell)){
            step++;
        }
        return makeAns(spell,step);
    }
    
    public String makeAns(String spell,int step){
        
        String ans = spell;
        while(step!=0){
            boolean chg = false;
            int idx = ans.length()-1;
            char c = ans.charAt(idx);
            c = (char)(c+1);
            //z까지
            while(c=='{'){
                ans = ans.substring(0,idx)+"a"+ans.substring(idx+1);
                idx--;
                if(idx==-1){
                    ans="a"+ans;
                    idx=ans.length()-1;
                    chg=true;
                    break;
                }
                c = (char)(ans.charAt(idx)+1);
            }
            //z 전
            if(!chg) ans = ans.substring(0,idx)+String.valueOf(c)+ans.substring(idx+1);
            if(ban.containsKey(ans)) continue;
            step--;
        }
        return ans;
    }
    
    public int calSpell(String spell){
        int num=0;
        for(String key : ban.keySet()){
            if(key.length()<spell.length()) num++;
            else if(key.length()==spell.length()){
                if(key.compareTo(spell)<0) num++;
            }
        }
        return num;
    }
    
    public String getSpell(String start,int len, List<Integer> list){
        String res = "";
        
        for(int i=list.size()-1; i>=0; i--){
            int num = list.get(i);
            //System.out.println(num);
            char c = start.charAt(len-1);
            
            c = (char)(c+num);      
            
            res += String.valueOf(c);
        }
        return start.substring(0,len-list.size())+res;
    }
}
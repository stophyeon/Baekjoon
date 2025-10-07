import java.util.*;
class Solution {
    List<String> answer = new ArrayList<>();
    String[] m;
    String[] or;
    int max=1;
    List<String> ans = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        or= orders;
        //단품 메뉴 종류 저장
        List<String> menu = new ArrayList<>();
        for(String ord : orders){
            String[] order = ord.split("");
            for(String o : order){
                if(menu.contains(o)) continue;
                menu.add(o);
            }
            
        }
        Collections.sort(menu);
        m = menu.toArray(new String[menu.size()]);
        // for(int i=0; i<m.length; i++){
        //     System.out.print(m[i]+",");
        // }
        
        for(int c : course){
            //course 개수에 맞게 조합생성
            //생성한 조합 중 2번이상인 최대개수 찾기
            max=1;
            ans.clear();
            dfs(c,new ArrayList<>(),0 );
            for(int i=0; i<ans.size(); i++){
                answer.add(ans.get(i));
            }
            
        }
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }
    
    public void dfs(int depth,List<String> course,int start ){
        if(course.size()==depth){
            // for(int i=0; i<course.size(); i++){
            //     System.out.print(course.get(i)+",");
            // }
            
            checkCnt(course);
            return;
        }
        for(int i=start; i<m.length; i++){
            
            course.add(m[i]);
            
            dfs(depth, course,i+1);
            
            course.remove(course.size()-1);
        }
        
    }
    
    public void checkCnt(List<String> course){
        int cnt=0;
        
        for(int i=0; i< or.length; i++){
            boolean check = true;
            for(int j=0; j<course.size(); j++){
                if(or[i].indexOf(course.get(j))==-1) {check=false; break;}
            }
            if(check) cnt++;
        }
        //System.out.println(cnt);
        if(cnt==max&&cnt>1){
           String a="";
            for(int i=0; i<course.size(); i++){
                a+=course.get(i);
            }
            ans.add(a);
        }
        if(cnt>max&&cnt>1){
            max=cnt;
            String a="";
            ans.clear();
            for(int i=0; i<course.size(); i++){
                a+=course.get(i);
            }
            ans.add(a);
        }
    }
}
import java.util.HashMap;
import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book, Comparator.comparing(String::length));
        HashMap<String,Integer> phone = new HashMap<>();
Loop1 : for(String book : phone_book){
            for(int i=1; i < book.length(); i++){
                String n = book.substring(0,i);
                if(phone.containsKey(n)){answer=false;break Loop1;}
            }
            phone.put(book,1);
        }
        return answer;
    }
}
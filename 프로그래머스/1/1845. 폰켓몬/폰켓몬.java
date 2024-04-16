import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length/2;
        HashMap<Integer,Integer> pokemon = new HashMap<>(); 
        for(int num : nums){
            if(!pokemon.containsKey(num)){pokemon.put(num,1);}
            else{pokemon.put(num,pokemon.get(num)+1);}
        }
        int pok = pokemon.keySet().size();
        if(pok<answer){answer=pok;}
        return answer;
    }
}
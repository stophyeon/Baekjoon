class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for(int i=0; i<targets.length; i++){
            int res=0;
            String[] t=targets[i].split("");
            for(int j=0; j<t.length; j++){
                int min=101;
                for(int k=0; k<keymap.length; k++){
                    String[] key=keymap[k].split("");
                    for(int l=0; l<key.length; l++){
                        if(key[l].equals(t[j])){
                            if(l+1<min){min=l+1;}
                        }
                    }
                }
                if(min==101){res=-1;break;}
                else{res+=min;}
            }
            answer[i]=res;
        }
        return answer;
    }
}
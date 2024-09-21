class Solution {
    public String solution(String s, int n) {
        String[] alp={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String answer = "";
        String[] str = s.split("");
        for(int i=0; i<str.length; i++){
            if(str[i].equals(" ")) continue;
            char c = str[i].charAt(0);
            if(Character.isLowerCase(c)){
                for(int j=0; j<alp.length; j++){
                    if(alp[j].toLowerCase().equals(str[i])){
                        //System.out.println(j);
                        if(j+n>=26){str[i] = alp[j+n-26].toLowerCase();}
                        else{str[i] = alp[j+n].toLowerCase();break;}
                    }
                }   
            }
            else{
                for(int j=0; j<alp.length; j++){
                    if(alp[j].equals(str[i])){
                        //System.out.println(j);
                        if(j+n>=26){str[i] = alp[j+n-26];}
                        else{str[i] = alp[j+n];break;}
                    }
                }
            }
            
        }
        for(String sr : str){
            answer+=sr;
        }
        return answer;
    }
}
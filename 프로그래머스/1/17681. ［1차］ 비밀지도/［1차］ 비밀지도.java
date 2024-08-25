class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] binary1 = new String[n];
        String[] binary2 = new String[n];
        for(int i=0; i<n; i++){
            String ans ="";
            String b1 = Integer.toBinaryString(arr1[i]);
            String b2 = Integer.toBinaryString(arr2[i]);
            if(b1.length()<n){
                String zero ="";
                for(int k=0; k<n-b1.length(); k++){zero+="0";}
                String bin1 = zero+b1;
                binary1 = bin1.split("");
            }
            if(b2.length()<n){
                String zero ="";
                for(int k=0; k<n-b2.length(); k++){zero+="0";}
                String bin2 = zero+b2;
                binary2 = bin2.split("");
            }
            if(b1.length()==n){
                binary1 = b1.split("");
            }
            if(b2.length()==n){
                binary2=b2.split("");
            }
            for(int j=0; j<n; j++){
                if(binary1[j].equals("1") || binary2[j].equals("1")){ans+="#";}
                if(binary1[j].equals("0") && binary2[j].equals("0")){ans+=" ";}
            }
            answer[i]=ans;
        }
        return answer;
    }
}
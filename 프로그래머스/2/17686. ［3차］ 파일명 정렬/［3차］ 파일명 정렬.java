import java.util.*;

class Solution {
    class Node{
        int index;
        String head;
        int number;
        String fileNm;
        public String getHead(){
            return head;
        }
        public int getNumber(){
            return number;
        }
        public int getIndex(){
            return index;
        }
        public Node(int index,String head, int number, String fileNm){
            this.index=index;
            this.head=head;
            this.number=number;
            this.fileNm=fileNm;
        }
    }
    Node[] nodes;
    public String[] solution(String[] files) {
    
        String[] answer = new String[files.length];
        nodes = new Node[files.length];
        //System.out.println("NO".compareTo("no"));
        for(int i=0; i<files.length; i++){
            String[] file = files[i].split("");
            String head  ="";
            String number="";
            int j=0;
            while(!isNumber(file[j])){
                head+=file[j];
                j++;
                if(j==file.length) break;
            }
            while(j<=file.length&&isNumber(file[j])){
                number+=file[j];
                j++;
                if(j==file.length) break;
            }
            nodes[i] = new Node(i,head,Integer.parseInt(number),files[i]);
        }
        Node[] nd = Arrays.stream(nodes).sorted((n1,n2)->{
            if(n1.head.equalsIgnoreCase(n2.head)){
               if(n1.number==n2.number){
                   
                   return n1.index-n2.index;
               } 
               return n1.number-n2.number;
            }
            return n1.head.compareToIgnoreCase(n2.head);
        }).toArray(Node[]::new);
        
        for(int i=0; i<nd.length; i++){
            
            answer[i] = nd[i].fileNm;
        }
        return answer;
    }
    
    public boolean isNumber(String s){
        try{
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
     
}

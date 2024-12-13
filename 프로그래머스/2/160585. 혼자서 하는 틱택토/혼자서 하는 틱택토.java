class Solution {
    public int solution(String[] board) {
        int answer = 0;
        int[][] map = new int[3][3];
        int o=0;
        int x=0;
        boolean xbingo=false;
        boolean obingo=false;
        int r=0;
        int c=0;
        for(String b : board){
            String[] ox = b.split("");
            c=0;
            for(String t : ox){
                if(t.equals("O")) {o++;map[r][c]=1;}
                if(t.equals("X")){x++;map[r][c]=2;}
                c++;
            }
            r++;
        }
        int on=0;
        int xn=0;
        //가로
        for(int i=0; i<3; i++){
            on=0;
            xn=0;
            for(int j=0; j<3; j++){
                if(map[i][j]==0) {break;}
                if(map[i][j]==1) {on++;}
                if(map[i][j]==2) {xn++;}
            }
            if(on==3) obingo=true;
            if(xn==3) {xbingo=true;}
        }
        //세로
        on=0;
        xn=0;
        
        for(int i=0; i<3; i++){
            on=0;
            xn=0;
            for(int j=0; j<3; j++){
                if(map[j][i]==0) {break;}
                if(map[j][i]==1) {on++;}
                if(map[j][i]==2) {xn++;}
            }
            if(on==3) obingo=true;
            if(xn==3) {xbingo=true;}
        }
        //대각선
        on=0;
        xn=0;
        for(int i=0; i<3; i++){
            if(map[i][i]==0) {break;}
            if(map[i][i]==1) {on++;}
            if(map[i][i]==2) {xn++;}
        }
        if(on==3) obingo=true;
        if(xn==3) {xbingo=true;}
        on=0;
        xn=0;
        for(int i=0; i<3; i++){
            if(map[i][2-i]==0) {break;}
            if(map[i][2-i]==1) {on++;}
            if(map[i][2-i]==2) {xn++;}
        }
        if(on==3) obingo=true;
        if(xn==3) {xbingo=true;}
        
         // System.out.println(obingo);
         // System.out.println(xbingo);
         // System.out.println(o);
         // System.out.println(x);
        if(obingo&&xbingo) return 0;
        if(o<x) return 0;
        if(obingo) {
            if(o!=x+1) return 0;
        }
        if(xbingo){
            if(x!=o) return 0;
        } 
        if(o-x>1) return 0;
        return 1;
    }
}
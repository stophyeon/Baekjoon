import java.util.*;
class Solution {
    class Node{
        int x;
        int y;
        int d;
        public Node(int x,int y, int d){
            this.x=x;
            this.y=y;
            this.d=d;
        }
    }
    
    public int solution(int[][] maps) {
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int answer = 10000;
        int desy=maps.length;
        int desx=maps[0].length;
        boolean[][] visited = new boolean[desy][desx];
        Queue<Node> q= new LinkedList<>();
        
        q.add(new Node(0,0,1));
        
        
        while(!q.isEmpty()){
            Node n = q.poll();
            //System.out.println(n.x+" "+n.y+" "+"거리:"+n.d);
            if(n.x==desx-1 && n.y==desy-1 && n.d<answer){answer=n.d;}
            for(int i=0; i<4; i++){
                int nx = n.x+dx[i];
                int ny = n.y+dy[i];
                if(nx>=0 && ny>=0 && nx<desx && ny<desy){
                    if(maps[ny][nx]==1&& !visited[ny][nx]){
                        q.add(new Node(nx,ny,n.d+1));
                        visited[ny][nx]=true;
                    }
                }
            }
        }
        if(answer==10000) return -1;
        else{return answer;}
        
    }
}
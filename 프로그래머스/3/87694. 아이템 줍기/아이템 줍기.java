import java.util.*;
class Solution {
    int[][] map = new int[102][102];
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        //높이, 너비
        int h,w=0;
        //테두리 외 공간 저장
        //[우상단 r,우상단 c, h-2, w-2]
       for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;

            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    if (y > y1 && y < y2 && x > x1 && x < x2) {
                        map[y][x] = 2;
                    }
                    else if (map[y][x] != 2) {
                        map[y][x] = 1;
                    }
                }
            }
        }
        
        
        int sx = characterX * 2;
        int sy = characterY * 2;
        int ex = itemX * 2;
        int ey = itemY * 2;
        boolean[][] visited = new boolean[102][102];
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2)->p1[2]-p2[2]);
        pq.add(new int[]{sx,sy,0});
        visited[sy][sx]=true;
        
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            if(node[0]==ex&&node[1]==ey){
                answer = node[2]/2;
                break;
            }
            for(int i=0; i<4; i++){
                int nx = node[0]+dr[i];
                int ny = node[1]+dc[i];
                if(!inRange(nx,ny)) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx]!=1) continue;
                
                pq.add(new int[]{nx,ny,node[2]+1});
                visited[ny][nx]=true;
            }
        }
        
        return answer;
    }
    
    public boolean inRange(int r, int c){
        return r>=0&&c>=0&&r<102&&c<102;
    }
    
    
}
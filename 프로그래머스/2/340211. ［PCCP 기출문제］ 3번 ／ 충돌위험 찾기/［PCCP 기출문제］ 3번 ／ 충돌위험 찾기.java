import java.util.*;
class Solution {
    public class Robot{
        int r;
        int c;
        int[] disr;
        int[] disc;
        public Robot(int r, int c, int[] disr,int[] disc){
            this.r=r;
            this.c=c;
            this.disr=disr;
            this.disc=disc;
        }
    }
    int[][] map;
    Robot[] robots;
    int answer = 0;
    public int solution(int[][] points, int[][] routes) {
        
        map=new int[101][101];
        robots = new Robot[routes.length];
        int c=0;
        for(int[] route : routes){
            int[] disr = new int[route.length-1];
            int[] disc = new int[route.length-1];
            int fr=points[route[0]-1][0]-1;
            int fc=points[route[0]-1][1]-1;
            int sr=0;
            int sc=0;
            int dr=0;
            int dc=0;
            for(int i=0; i<route.length-1; i++){
                sr = points[route[i]-1][0]-1;
                sc = points[route[i]-1][1]-1;
                dr = points[route[i+1]-1][0]-1;
                dc = points[route[i+1]-1][1]-1;
                disr[i] = sr-dr;
                disc[i] = sc-dc;
            }
            robots[c] = new Robot(fr,fc,disr,disc);
            map[fr][fc] += 1;
            c++;
        }
        int count=0;
        check();
        while(count!=robots.length){
            
            for(int i=0; i<robots.length; i++){
                if(robots[i]==null) continue;
                move(next(i),i);
            }
            check();
            for(int i=0; i<robots.length; i++){
                if(robots[i]==null) continue;
                count+=isArrive(i);
            }
            
        }
        
        
        return answer;
    }
    public int next(int index){
        int step=0;
        for(int i=0; i<robots[index].disr.length; i++){
            if(robots[index].disr[i]!=0 || robots[index].disc[i]!=0){step=i; break;}
        }
        return step;
    }
    public int isArrive(int index){
        int len = robots[index].disr.length;
        if(robots[index].disr[len-1]==0&&robots[index].disc[len-1]==0){
            //if(map[robots[index].r][robots[index].c]>=2) answer++;
            map[robots[index].r][robots[index].c]-=1;
            robots[index]=null;
            return 1;
        }
        return 0;
    }
    
    public void move(int step,int index){
        map[robots[index].r][robots[index].c]-=1;
        if(robots[index].disr[step]<0){
            robots[index].disr[step]+=1;
            robots[index].r+=1;
        }
        else if(robots[index].disr[step]>0){
            robots[index].disr[step]-=1;
            robots[index].r-=1;
        }
        else{
            if(robots[index].disc[step]>0){
                robots[index].disc[step]-=1;
                robots[index].c-=1;
            }
            if(robots[index].disc[step]<0){
                robots[index].disc[step]+=1;
                robots[index].c+=1;
            }
        }
        map[robots[index].r][robots[index].c]+=1;
    }
    public void check(){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(map[i][j]>=2) answer++;
                //System.out.print(map[i][j]);
            }
            //System.out.println("");
        }
        //System.out.println("");
    }
}
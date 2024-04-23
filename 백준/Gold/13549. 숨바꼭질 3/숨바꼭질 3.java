import java.util.*;
import java.io.*;
public class Main{
    
    static int des;
    static int res=Integer.MAX_VALUE;
     
    static boolean[] visited;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        des = Integer.parseInt(st.nextToken());
        visited= new boolean[100_001];

        bfs(start);
        System.out.println(res);
        
    }
    static void bfs(int start){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start,0));
        visited[start]=true;
        while(!q.isEmpty()){
            Node node = q.poll();
            
            
               
                if(node.index==des && res>node.time){res=node.time;}
                if(node.index*2<=100000 && !visited[2*node.index]){
                     q.add(new Node(node.index*2,node.time));
                     visited[2*node.index]=true;
                }
                if(node.index-1>=0 && !visited[node.index-1]){
                     q.add(new Node(node.index-1,node.time+1));
                    visited[node.index-1]=true;
                }
                if(node.index+1<=100000 && !visited[node.index+1]){
                     q.add(new Node(node.index+1,node.time+1));
                    visited[node.index+1]=true;
                }
                

            
        }

    }    
}
class Node{
        int index;
        int time;
        public Node(int index,int time){
            this.time=time;
            this.index=index;
        }
    }
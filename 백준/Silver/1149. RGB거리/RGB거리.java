import  java.util.*;
import  java.io.*;
public class Main {
    static int n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map= new int[n][3];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            map[i][0]=Integer.parseInt(st.nextToken());
            map[i][1]=Integer.parseInt(st.nextToken());
            map[i][2]=Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<n; i++){
            map[i][0]+=Math.min(map[i-1][1],map[i-1][2]);
            map[i][1]+=Math.min(map[i-1][0],map[i-1][2]);
            map[i][2]+=Math.min(map[i-1][0],map[i-1][1]);
        }
        System.out.println(Math.min(map[n-1][0],Math.min(map[n-1][1],map[n-1][2])));
    }
}
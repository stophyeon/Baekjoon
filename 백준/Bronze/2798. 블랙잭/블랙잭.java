import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        int res = blackJack(arr,m);
        System.out.println(res);
    }
    static int blackJack(int[] arr, int m){
        int res=0;
        int sub=300000;
        int size = arr.length;
        for(int i=0; i<size; i++){
            for(int j =i+1; j<size; j++){
                for(int k=j+1; k<size; k++){
                    int p = arr[i]+arr[j]+arr[k];
                    if(m-p<0){continue;}
                    if(m==p){res=p;return res;}
                    if(m-p<sub){res=p;sub=m-p;}
                    
                }
            }
        }
        return res;
    }
}
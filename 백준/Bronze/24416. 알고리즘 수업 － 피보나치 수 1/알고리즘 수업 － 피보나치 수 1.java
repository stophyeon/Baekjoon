import java.util.Scanner;
public class Main{
    static int dp=0;
    static int recall=0;
    static int[] fib = {};
    
    public static void fibDp(int n,int[] fib){
        for(int i=2; i<n; i++){
            fib[i]=fib[i-1]+fib[i-2];
            dp++;
        }
        
    }
    public static int fibRecall(int n){
        
        if(n==1||n==2){return 1;}
        else{recall++;return fibRecall(n-1)+fibRecall(n-2);}
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fib= new int[n];
        fib[0]=1;
        fib[1]=1;
        int r =fibRecall(n);
        fibDp(n,fib);
        System.out.println(recall+1);
        System.out.println(n-2);
    }
}
class Solution {
    int[] deliverie;
    int[] pickup;
    int c;
    long answer = 0;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        deliverie=deliveries;
        pickup=pickups;
        c=cap;
        int index=n-1;
        while(true){
            int n1=0;
            int n2=0;
            index=truck(index);
            for(int j=0; j<n; j++){
                if(deliverie[j]!=0 || pickup[j]!=0) break;
                if(deliverie[j]==0) n1++;
                if(pickup[j]==0) n2++;
            }
            if(n1==n&&n2==n) break;
        }
        
        return answer*2;
    }
    
    public int truck(int idx){
        int d=0;
        int p=0;
        int md=0;
        int mp=0;
        int max=-1;
        for(int i = idx; i>=0; i--){
            if(deliverie[i]!=0){
                max=Math.max(max,i);
            }
            if(d+deliverie[i]>c) {
                deliverie[i]-=c-d;
                md=i;
                break;
            }
            else{
                d+=deliverie[i];
                deliverie[i]=0;
            }   
        }
        for(int i=idx; i>=0; i--){
            if(pickup[i]!=0){
                max=Math.max(max,i);
            }
            if(p+pickup[i]>c) {
                pickup[i]-=c-p;
                mp=i;
                break;  
            }
            else{
               p+=pickup[i];
               pickup[i]=0; 
            }
        }
        
        answer+=max+1;
        return Math.max(md,mp);
    }
}
class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int start = h1*3600+m1*60+s1;
        int end = h2*3600+m2*60+s2;
        
        
        if(start%360==0||start%360==12) answer++;
        
        while(start<end){
            double h_loc=(start/(double)120)%360;
            double m_loc=(start/(double)10)%360;
            double s_loc=(start*6)%360;
            
            double nh_loc=((start+1)/(double)120)%360;
            double nm_loc=((start+1)/(double)10)%360;
            double ns_loc=((start+1)*6)%360;
            //System.out.println(nh_loc);
            if(ns_loc==0) ns_loc=360;
            if(nm_loc==0) nm_loc=360;
            if(nh_loc==0) nh_loc=360;
            if(s_loc<h_loc&&ns_loc>=nh_loc) answer++; 
            if(s_loc<m_loc&&ns_loc>=nm_loc) answer++;
            if(nm_loc==nh_loc) answer--;
            start++;
        }
        
        return answer;
    }
}
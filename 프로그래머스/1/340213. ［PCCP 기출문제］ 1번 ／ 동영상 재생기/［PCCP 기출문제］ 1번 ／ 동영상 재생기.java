class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        String[] v = video_len.split(":");
        int total_len = Integer.parseInt(v[0])*60+Integer.parseInt(v[1]);
        String[] p = pos.split(":");

        int p_len = Integer.parseInt(p[0])*60+Integer.parseInt(p[1]);
        String[] op1 = op_start.split(":");
        int op_st_len = Integer.parseInt(op1[0])*60+Integer.parseInt(op1[1]);
        String[] op2 = op_end.split(":");
        int op_end_len = Integer.parseInt(op2[0])*60+Integer.parseInt(op2[1]);
        
        for(String com : commands){
            if(com.equals("prev")){
                p_len-=10;
                if(p_len<0) p_len=0;
            }
            else if(com.equals("next")){
                if(p_len>=op_st_len&&p_len<=op_end_len){
                    p_len=op_end_len;
                }
                p_len+=10;
                if(p_len>=total_len) p_len=total_len;
            }
            if(p_len>=op_st_len&&p_len<=op_end_len){
                    p_len=op_end_len;
            }
            //System.out.println(p_len);
        }
        int m = p_len/60;
        int s = p_len%60;
        if(m<10){
            if(s<10) return "0"+String.valueOf(m)+":"+"0"+String.valueOf(s);
            else{return "0"+String.valueOf(m)+":"+String.valueOf(s);}
        }
        else{
            if(s<10) return String.valueOf(m)+":"+"0"+String.valueOf(s);
            else{return String.valueOf(m)+":"+String.valueOf(s);}
        }
        
    }
}
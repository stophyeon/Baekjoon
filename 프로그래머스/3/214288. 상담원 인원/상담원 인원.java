import java.util.*;

class Solution {
    //상담자 총 인원(최대 300명)
    int p;
    //각 유형별 상담인원 수 저장
    HashMap<Integer,Integer> table = new HashMap<>();
    //각 유형별 상담인원[시각, 요청시간] 대기 저장
    HashMap<Integer,List<int[]>> delay = new HashMap<>();
    int answer = Integer.MAX_VALUE;
    public int solution(int k, int n, int[][] reqs) {
        //상담자 총 인원(최대 300명)
        p = reqs.length;
        
        for(int i=1; i<=k; i++)
            table.put(i,1);
        //각 상담인원 정보 유형별 저장
        for(int[] req : reqs){
            if(!delay.containsKey(req[2])){
                List<int[]> list = new ArrayList<>();
                list.add(new int[]{req[0],req[1]});
                delay.put(req[2],list);    
            }
            else{
                delay.get(req[2]).add(new int[]{req[0],req[1]});
            }
        }
        int[] table = new int[k+1];
        dfs(1,n-k,k,table);
        // for(int i=1; i<=k; i++){
        //     System.out.println(i+" : "+table.get(i));
        // }
        return answer;
    }
    public void dfs(int depth, int remain, int k, int[] countArr) {
        if (depth == k) {
            // 마지막 유형에는 남은 멘토를 전부 몰아줍니다.
            countArr[depth] = remain + 1; // 기본 1명 + 추가 배정
            // 배정이 끝났으므로 시뮬레이션 돌려서 최솟값 갱신
            answer = Math.min(answer, simulation(k, countArr));
            return;
        }
        
        // 현재 depth 유형에 i명을 추가 배정
        for (int i = 0; i <= remain; i++) {
            countArr[depth] = i + 1; // 기본 1명 + i명
            dfs(depth + 1, remain - i, k, countArr);
        }
    }
    public int simulation(int k,int[] table) {
        HashMap<Integer,PriorityQueue<Integer>> counsel = new HashMap<>();
        for(int idx=1; idx<=k; idx++){
            PriorityQueue<Integer> pq = new PriorityQueue<>((p1,p2)->p1-p2);
            counsel.put(idx,pq);
        }
        //대기시간 합
        int total=0;
        //상담 유형별로 상담원에게 배치
        for(int type : delay.keySet()){
            for(int[] next : delay.get(type)){
                PriorityQueue<Integer> pq = counsel.get(type);
                //즉시 상담가능 시 
                if(pq.size()<table[type]){
                    pq.add(next[0]+next[1]);
                } else{
                    int end = pq.poll();
                    if(end<next[0]){
                        pq.add(next[0]+next[1]);
                    }
                    else{
                        pq.add(end+next[1]);
                        //대기시간 계산
                        total+=end-next[0];    
                    }
                }
            }  
        }
        return total;
    }
}

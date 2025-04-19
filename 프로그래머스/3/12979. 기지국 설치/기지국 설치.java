class Solution {
    static int answer = 0;
    public int solution(int n, int[] stations, int w) {
        int size  = stations.length; 
        int range = (w * 2) + 1;
        int end   = 0; 
        int index = 0;
        
        while(end < n) {
            if(index < size){
                int po = stations[index++];
                
                if(end < po - w) { 
                   int need = po - w - end - 1;
                   answer += need / range;
                   answer += need % range == 0 ? 0 : 1; 
                }
                end = po + w;
                continue;
            }   
            
            int need = n - end;
            answer += need / range;
            answer += need % range == 0 ? 0 : 1; 
            end = n;
        }
        
        return answer;
    }
}

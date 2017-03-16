public class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] times= new boolean[24*60];
        for(String s:timePoints){
          //  String[] ts= s.split(":");
            int t=60*(Integer.parseInt(s.substring(0,2)));
            t+=Integer.parseInt(s.substring(3));
            if(times[t]) return 0;
            times[t]=true;
        }
        int min=Integer.MAX_VALUE;
        int p=Integer.MAX_VALUE;
        int q=Integer.MIN_VALUE;
        int prev=0;
        for(int i=0;i<24*60;i++){
            if(times[i]){
                if(p!=Integer.MAX_VALUE)
                min=Math.min(min,i-prev);
                p=Math.min(i,p);
                q=Math.max(q,i);
                prev=i;
            }
        }
        
        return Math.min(min,60*24-q+p);
    }
}
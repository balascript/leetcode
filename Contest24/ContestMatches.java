public class ContestMatches {
    public String findContestMatch(int n) {
        List<String> ans= new ArrayList(n);
        for(int i=1;i<=n;i++)
            ans.add(i+"");
        return process(ans);
    }
    
    public String process(List<String> singles){
        if(singles.size()==2)
            return createPair(singles.get(0),singles.get(1));
        
        List<String> ans= new ArrayList();
        int l=singles.size();
        int start=0;
        int end=l-1;
        while(start<end){
            ans.add(createPair(singles.get(start++),singles.get(end--)));
        }
        return process(ans);
        
    }
    
    public String createPair(String a, String b){
        return "("+a+","+b+")";
    }
}
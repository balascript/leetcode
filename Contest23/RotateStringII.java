public class RotateStringII {
    public String reverseStr(String s, int k) {
        if(s.length()<=1)
            return s;
        char[] arr = s.toCharArray();
        if(k>arr.length)
            {
                reverse(arr,0,arr.length);
                return new String(arr);
            }
        if(2*k>s.length())
            {
                reverse(arr,0,k);
                return new String(arr);
            }
            int i=0,start=0,end=0;
        for(i=0;i< arr.length/(2*k);i++){
            start= i*2*k;
            reverse(arr,start,k);
            end=start+2*k -1;
        }
        if(arr.length-end+1 > k)
            {
                reverse(arr,end+1,k);
                end=end+k;
            }
        else{
               reverse(arr,++end,arr.length-end); 
            }

        
        return new String(arr);
    }
    
    public void reverse(char[] arr, int start, int n){
        if(n<2) return;
        int end=start+n-1;
        while(start<end){
            swap(arr,start++ ,end--);
        }
        
    }
    public void swap(char[] arr, int i, int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
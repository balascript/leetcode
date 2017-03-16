import java.security.*;
import java.math.BigInteger;

public class Codec {

    private Map<String,String> forward = new HashMap();
    private Map<String,String> backward = new HashMap();
    private SecureRandom random = new SecureRandom();
        
    public String nextSessionId() {
        return new BigInteger(32, random).toString(32);
    }
    
    public synchronized void add(String key, String value) {
            forward.put(key, value);
    }
    public synchronized String getForward(String key) {
            return forward.get(key);
    }
        
    public synchronized String getBackward(String key) {
            return backward.get(key);
    }
          
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String tinyurl= this.nextSessionId();
        this.add(tinyurl,longUrl);
        //System.out.println("http://tinyurl.com/"+tinyurl);
        return "http://tinyurl.com/"+tinyurl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if(shortUrl.length()<20)
            return "";
        return getForward(shortUrl.substring(19));
    }

}
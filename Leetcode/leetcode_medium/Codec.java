package leetcode_medium;

import java.util.HashMap;

public class Codec {
	
	HashMap<String, String> urlMap;
	String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
	int count = 6;
	
	public Codec() {
		
		urlMap = new HashMap<String, String>(); 
		
	}
	
	public String decode(String shortUrl) {
        
		String longUrl = urlMap.get(shortUrl);
		return longUrl;
		
    }
	
	public String encode(String longUrl) {
        
		String shortUrl = "http://tinyurl.com/";
		
		while(count-- >= 0) {
			
			int position = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			shortUrl += ALPHA_NUMERIC_STRING.charAt(position);
			
		}
		
//		System.out.println(shortUrl);
		urlMap.put(shortUrl, longUrl);
		
		return shortUrl;
		
    }
	
	public static void main (String args[]) {
		
		String url = "https://leetcode.com/problems/design-tinyurl";
		
		Codec codec = new Codec();
		String encoded_url = codec.encode(url);
		
		System.out.println(encoded_url);
		
		String decoded_url = codec.decode(encoded_url);
		
		System.out.println(decoded_url);

	}

}

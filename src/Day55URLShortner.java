import java.util.HashMap;
import java.util.Random;

/*
 * Implement a URL shortener with the following methods:

shorten(url), which shortens the url into a six-character alphanumeric string, such as zLg6wl.
restore(short), which expands the shortened string into the original url. If no such shortened string exists, return null.
Hint: What if we enter the same URL twice?

 */

public class Day55URLShortner {

	String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	HashMap<String, String> hmap = new HashMap<String, String>();
	Random rand = new Random();
	String key = "";
	
	public String getKey() {
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 6; i++) {
			sb.append(characters.charAt(rand.nextInt(62)));
		}
		return sb.toString();
	}
	
	//Encodes the URL to tiny one
	public String encode(String longUrl) {
		String key = getKey();
		hmap.put(key, longUrl);
		return "http://tinyurl.com/" + key;
	}
	
	//Decode the tiny Url to long one
	public String decode(String shortUrl) {
		
		return hmap.get(shortUrl.replace("http://tinyurl.com/", ""));
	}
	
	public static void main(String[] args) {
		
		
		String longUrl = "https://blog.csdn.net/katrina95/article/details/79029900";
		String longUrl2 = "abcdefg";
		
		Day55URLShortner code = new Day55URLShortner();
		String shortUrl = code.encode(longUrl);
		System.out.println("The tiny URL is: " + shortUrl);
		System.out.println("The tiny URL is: " + code.encode(longUrl2));
		
		System.out.println("The long Url is: " + code.decode(shortUrl));

	}

}

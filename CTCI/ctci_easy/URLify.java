package ctci_easy;

public class URLify {
	
	public static void main(String args[]) {
		
		String s = "Mr John Smith   ";
		int len = 13;
		
		System.out.println(urlify(s, len));
		
	}
	
	public static String urlify(String s, int len) {
		
		char arr[] = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < arr.length; i++) {
			if(len == 0) {
				break;
			} else {
				if(arr[i] == ' ') {
					sb.append("%20");
				} else {
					sb.append(arr[i]);
				}
				len--;
			}
//			System.out.println(sb.toString());
		}
		
		
		return sb.toString();
	}

}

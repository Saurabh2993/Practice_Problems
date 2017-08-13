package test_Package;

public class Merge_Strings {
	
	public static void main(String args[]) {
		
		String strings[] = {"hi", "hello", "i", "am", "studying"}; 
		System.out.println(MergeStrings(strings));
		
	}
	
	static String MergeStrings(String[] strings) {
        
        int[] char_count = new int[26];
        
        for(String s : strings) {
        	for(char c : s.toCharArray()) {
                int index = c - 'a';
                if(index >= 0 && index < 26)
                    char_count[index]++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < char_count.length; i ++) {
            int count = char_count[i];
            for(int j = 0; j < count; j ++) {
                sb.append((char)(i + 97));
            }
        }
        
        return sb.toString();

    }

}

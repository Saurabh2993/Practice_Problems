package leetcode_easy;

public class Int_Hex {
	
	public static void main(String args[]) {
		
		Int_Hex x = new Int_Hex();
		
		System.out.println(x.toHex(-1000));
		
	}
	
	public String toHex(int num) {
		
		if(num == 0)
			return "0";
		
		StringBuilder sb = new StringBuilder();
		char c[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		
		while(num != 0) {
			sb.insert(0, c[(num & 15)]);
			num = num >>> 4;
		}
		
		return sb.toString();
		
	}
}

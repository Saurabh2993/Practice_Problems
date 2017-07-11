package bitManipulation;

public class ConvertDecimalFractionToBinary {
	
	public static void main(String args[]) {
		
		double n = 0.625;
		ConvertDecimalFractionToBinary c = new ConvertDecimalFractionToBinary();
		
		System.out.println(c.convertToBinary(n));
		
	}
	
	public String convertToBinary(double n) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(".");
		
		while(n != 0) {
			if(sb.length() >= 32) {
				return "ERROR";
			}
			n = n * 2;
			
			if(n >= 1) {
				sb.append(1);
				n -= 1;
			} else {
				sb.append(0);
			}
		}
		
		return sb.toString();
	}

}

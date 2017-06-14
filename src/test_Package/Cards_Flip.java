package test_Package;

public class Cards_Flip {
	
	public static void main(String args[]) {
		
		boolean cards[] = new boolean[50];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = true;
		}
		
		for(int pass = 1; pass < 51; pass++) {
			for (int i = 0; i < 50; i++) {
				if((i+1) % pass == 0)
					cards[i] ^= true;
			}
		}
		
		int count = 0;
		for (int i = 0; i < cards.length; i++) {
			if(!cards[i])
				count++;
		}
		System.out.println(count);
	}
}

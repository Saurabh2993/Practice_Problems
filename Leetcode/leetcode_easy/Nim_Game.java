/*You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
*/



/*
Logic: The first person who plays should try to get the number of stones equal to a multiple of 4 to win. If the number of stones is already a multiple of 4, then the first player has to remove atleast one stone in which case the second player can bring the number down to a multiple of 4.
*/

package leetcode_easy;

public class Nim_Game {
	
	public static void main(String args[]) {
		
		int stones = 22221;
		boolean possibility = canWinNim(stones);
		
		System.out.println(possibility);
		
	}
	
	public static boolean canWinNim(int n) {
		
		if(n % 4 == 0) {
		    return false;
		} else {
		    return true;
		}
	}
}
package leetcode_easy;

public class Student_Attendance_Record_1 {
	
	public static void main(String args[]) {
		
		String s = "PPLLALPP";
		Student_Attendance_Record_1 r = new Student_Attendance_Record_1();
		System.out.println(r.checkRecord(s));
		
	}
	
	public boolean checkRecord(String s) {
		
		int count_a = 0;
		int count_l = 0;
		
		for(int i = 0; i < s.length(); i ++) {
			if(s.charAt(i) == 'A') {
				count_a++;
				if(count_a > 1) {
					return false;
				}
				count_l = 0;
			} else if(s.charAt(i) == 'L') {
				count_l ++;
				if(count_l > 2) {
					return false;
				}
			} else {
				count_l = 0;
			}
		}
        
		return true;
    }

}

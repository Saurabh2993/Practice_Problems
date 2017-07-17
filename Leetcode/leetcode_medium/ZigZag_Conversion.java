package leetcode_medium;

public class ZigZag_Conversion {
	
	public static void main(String args[]) {
		
		String s = "PAYPALISHIRING";
		int nRows = 3;
		ZigZag_Conversion z = new ZigZag_Conversion();
		System.out.println(z.convert(s, nRows));
		
	}
	
	public String convert(String s, int nRows) {
        
        if(nRows == 1) {
            return s;
        }
        
        int columns = 0;
        int count = 0;
        int len = s.length();
        
        while(count < len) {
            count += nRows;
            columns++;
            int index = 0;
            
            while(index < (nRows - 2) && count < len) {
                index++;
                columns++;
                count++;
            }
        }
        // System.out.println(columns);
        
        char[][] char_matrix = new char[nRows][columns];
        int string_index = 0;
        
        for(int j = 0; j < columns && string_index < len; j = j + nRows - 1) {
            int col_index = j;
            int row_index = 0;
            for(row_index = 0; row_index < nRows && string_index < len; row_index++) {
                char_matrix[row_index][j] = s.charAt(string_index++);
            }
            row_index -= 2;
            col_index++;
            while(row_index > 0 && string_index < len) {
                char_matrix[row_index --][col_index ++] = s.charAt(string_index++);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nRows; i ++) {
            for(int j = 0; j < columns; j ++) {
                if(char_matrix[i][j] != '\u0000') {
                    sb.append(char_matrix[i][j]);
                }
            }
        }
        
        return sb.toString();
    }

}

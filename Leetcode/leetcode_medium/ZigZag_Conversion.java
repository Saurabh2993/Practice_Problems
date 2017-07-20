package leetcode_medium;

public class ZigZag_Conversion {
	
	public static void main(String args[]) {
		
		String s = "PAYPALISHIRING";
		int nRows = 3;
		ZigZag_Conversion z = new ZigZag_Conversion();
		System.out.println(z.convert(s, nRows));
		
	}
	
	/*public String convert(String s, int nRows) {
        
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
    }*/

	public String convert(String s, int nRows) {
		
		StringBuilder sb = new StringBuilder();
		int len = s.length();
		
		int array_length = 2 * nRows - 2;
		int array_count = (int) Math.ceil(len / (double) array_length);
		char[][] splitArray = new char[array_count][array_length];
		
		int string_index = 0;
		
		for(int i = 0; i < array_count && string_index < len; i ++) {
			for(int j = 0; j < array_length && string_index < len; j ++) {
				splitArray[i][j] = s.charAt(string_index++);
			}
		}
		
		int index1 = 0;
		int index2 = array_length - 1;
		
		for(int i = 0; i < nRows; i ++) {
			if(i == 0) {
				for(int j = 0; j < array_count; j ++) {
					if(splitArray[j][index1] != '\u0000') {
						sb.append(splitArray[j][index1]);
					}
				}
				index1++;
				continue;
			}
			if(i == nRows - 1) {
				for(int j = 0; j < array_count; j ++) {
					if(splitArray[j][index1] != '\u0000') {
						sb.append(splitArray[j][index1]);
					}
				}
				continue;
			}
			for(int j = 0; j < array_count; j ++) {
				if(splitArray[j][index1] != '\u0000') {
					sb.append(splitArray[j][index1]);
				}
				if(splitArray[j][index2] != '\u0000') {
					sb.append(splitArray[j][index2]);
				}
			}
			index1++;
			index2++;
		}

		return sb.toString();
	}
}

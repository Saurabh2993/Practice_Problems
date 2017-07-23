package test_Package;

import java.util.List;
import java.util.ArrayList;

public class EvaluateExpression {
	
	public static void main(String args[]) {
		
		String s = "-x-23=5+x";
		EvaluateExpression e = new EvaluateExpression();
		System.out.println(e.evaluate(s));
		
	}
	
	
	public String evaluate(String s) {
		
		int equalsIndex = s.indexOf("=");
		String lhs = simplify(s.substring(0, equalsIndex));
		String rhs = simplify(s.substring(equalsIndex + 1));
//		System.out.println(lhs);
//		System.out.println(rhs);
		String expression = negateAndAppendTo(lhs, rhs);
//		System.out.println(expression);
		
		return getFinalAnswer(expression);
	}
	
	private String simplify(String s) {
		
		StringBuilder sb = new StringBuilder();
		List<Integer> nums = new ArrayList<>();
		int value = 0;
		
		for(int i = 0; i < s.length(); i ++) {
			value = 0;
			char current = s.charAt(i);
			if(current == 'x') {
				if(i == 0) {
					sb.append(current);
				} else if (s.charAt(i - 1) == '-') {
					sb.append("-x");
				} else {
					sb.append("+x");
				}
			} else if((current - '0') >= 0 && (current - '0') <= 9) {
				if(i == 0) {
					value = (current - '0');
				} else if(s.charAt(i - 1) - '0' >= 0 && s.charAt(i - 1) - '0' <= 9) {
					value = nums.remove(nums.size() - 1);
					if(value >= 0) {
						value = value * 10 + (current - '0');
					} else {
						value = value * 10 - (current - '0');
					}
				} else {
					if(s.charAt(i - 1) == '-') {
						value = -(current - '0');
					} else {
						value = (current - '0');
					}
				}
			}
			nums.add(value);
//			System.out.println(nums);
		}
		int sum = 0;
		for(int i : nums) {
			sum += i;
		}
//		System.out.println(sum);
		
		if(sum > 0) {
			sb.append("+");
			sb.append(sum);
		} else {
			sb.append(sum);
		}
		
		return sb.toString();
	}
	
	private String negateAndAppendTo(String lhs, String rhs) {
		StringBuilder sb = new StringBuilder();
		sb.append(lhs);
		for(int i = 0; i < rhs.length(); i ++) {
			if(rhs.charAt(i) == '+') {
				sb.append('-');
			} else if(rhs.charAt(i) == '-') {
				sb.append('+');
			} else {
				sb.append(rhs.charAt(i));
			}
		}
		
		return sb.toString();
	}
	
	private String getFinalAnswer(String exp) {
		
		int pos_x_count = 0;
		int neg_x_count = 0;
		int value = 0;
		List<Integer> nums = new ArrayList<>();
		
		for(int i = 0; i < exp.length(); i++) {
			char current = exp.charAt(i);
			value = 0;
			if(current == 'x') {
				if(i == 0) {
					pos_x_count ++;
				} else if(exp.charAt(i - 1) == '-') {
					neg_x_count++;
				} else {
					pos_x_count++;
				}
			} else if((current - '0') >= 0 && (current - '0') <= 9) {
				if(i == 0) {
					value = (current - '0');
				} else if(exp.charAt(i - 1) - '0' >= 0 && exp.charAt(i - 1) - '0' <= 9) {
					value = nums.remove(nums.size() - 1);
					if(value >= 0) {
						value = value * 10 + (current - '0');
					} else {
						value = value * 10 - (current - '0');
					}
				} else {
					if(exp.charAt(i - 1) == '-') {
						value = -(current - '0');
					} else {
						value = (current - '0');
					}
				}
			}
			nums.add(value);
//			System.out.println(nums);
		}
		
		int sum = 0;
		for(int i : nums) {
			sum += i;
		}
//		System.out.println(sum);
		
		if(pos_x_count == neg_x_count) {
			return "infinite solutions";
		}
		
		StringBuilder sb = new StringBuilder();
		int x_count = pos_x_count - neg_x_count;
		sb.append("x=");
		double answer = sum / (double) x_count;
		sb.append(answer);
		
		return sb.toString();
	}

}

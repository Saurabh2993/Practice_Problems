package leetcode_hard;

import java.util.ArrayList;
import java.util.List;

public class Insert_Interval {
	
	class Interval {
		int start;
		int end;
		
		public Interval() {
			start = 0;
			end = 0;
		}
	
		public Interval(int s, int e)
		{
			start = s;
			end = e;
		}
	}
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        List<Interval> answer = new ArrayList<>();
        if(intervals.size() == 0) {
            answer.add(newInterval);
            return answer;
        }
        
        boolean overlapping_intervals[] = new boolean[intervals.size()];
        int index = 0;
        int lower_limit = newInterval.start;
        int upper_limit = newInterval.end;
        
        for(Interval x : intervals) {
            // if((x.start < newInterval.start && x.end < newInterval.start) || (x.start > newInterval.end && x.end > newInterval.start)) {
            if(x.end < newInterval.start || x.start > newInterval.end) {
                overlapping_intervals[index++] = false;
                continue;
            } else {
                overlapping_intervals[index++] = true;
                lower_limit = Math.min(lower_limit, x.start);
                upper_limit = Math.max(upper_limit, x.end);
            }
        }
        
        // System.out.println(lower_limit + "  " + upper_limit);
        newInterval.start = lower_limit;
        newInterval.end = upper_limit;
        
        boolean newIntervalAdded = false;
        
        for(int i = 0; i < overlapping_intervals.length; i ++) {
            if(!(overlapping_intervals[i])) {
                if((intervals.get(i).start > upper_limit) && !newIntervalAdded){
                    newIntervalAdded = true;
                    answer.add(newInterval);
                }
                
                answer.add(intervals.get(i));
                // System.out.println(intervals.get(i).start + "  " + intervals.get(i).end);
            } else if(!newIntervalAdded) {
                newIntervalAdded = true;
                answer.add(newInterval);
                // System.out.println(newInterval.start + "  " + newInterval.end);
            }
        }
        
        if(!newIntervalAdded) {
            answer.add(newInterval);
        }
        
        return  answer;
    }

}

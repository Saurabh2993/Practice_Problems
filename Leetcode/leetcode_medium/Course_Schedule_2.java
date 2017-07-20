package leetcode_medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_Schedule_2 {
	
	public static void main(String args[]) {
		
		int n = 7;
		int prereq[][] = {{4, 0}, {0, 1}, {4, 1}, {0, 2}, {6, 3}, {0, 5}, {1, 5}, {2, 5}};
		
		Course_Schedule_2 cs = new Course_Schedule_2();
		System.out.println(cs.findOrder(n, prereq));
		
	}
	

	public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> dependent_courses = new HashMap<Integer, List<Integer>>();
        HashMap<Integer, Integer> prereq_count = new HashMap<>();
		Queue<Integer> independent_courses = new LinkedList<>();
        ArrayList<Integer> course_seq = new ArrayList<>();
		
        for (int i = 0; i < prerequisites.length; i++) {
			int course = prerequisites[i][0];
            int pre_req = prerequisites[i][1];
            if(prereq_count.containsKey(course)) {
                prereq_count.put(course, prereq_count.get(course) + 1);
            } else {
                prereq_count.put(course, 1);
            }
            if(dependent_courses.containsKey(pre_req)) {
                List<Integer> temp = dependent_courses.get(pre_req);
                temp.add(course);
                dependent_courses.put(pre_req, temp);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(course);
                dependent_courses.put(pre_req, temp);
            }
		}
        
        for(int i = 0; i < numCourses; i ++) {
            if(!prereq_count.containsKey(i)) {
                independent_courses.add(i);
                course_seq.add(i);
            }
        }
        
        while(independent_courses.size() != 0 && course_seq.size() != numCourses) {
            // System.out.println(course_seq);
            int current = independent_courses.remove();
            if(dependent_courses.containsKey(current)) {
                List<Integer> temp = dependent_courses.get(current);
                for(int i : temp) {
                    int count = prereq_count.get(i);
                    if(count == 0) {
                        continue;
                    } else {
                        count--;
                        if(count == 0) {
                            independent_courses.add(i);
                            course_seq.add(i);
                        }
                        prereq_count.put(i, count);
                    }
                }
            }
            
        }
        // System.out.println(course_seq);
        
       if(course_seq.size() == numCourses) {
           int answer[] = new int[numCourses];
           int index = 0;
           for(int i : course_seq) {
               answer[index++] = i;
           }
           return answer;
       } else {
           return new int[0];
       }
    }
}

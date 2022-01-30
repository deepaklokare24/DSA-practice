package com.mosh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 *
 * Problem Description

 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.



 Problem Constraints
 0 <= |intervals| <= 105



 Input Format
 First argument is the vector of intervals

 second argument is the new interval to be merged



 Output Format
 Return the vector of intervals after merging



 Example Input
 Input 1:

 Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
 Input 2:

 Given intervals [1, 3], [6, 9] insert and merge [2, 6] .


 Example Output
 Output 1:

 [ [1, 5], [6, 9] ]
 Output 2:

 [ [1, 9] ]


 Example Explanation
 Explanation 1:

 (2,5) does not completely merge the given intervals
 Explanation 2:

 (2,6) completely merges the given
 */

public class MockInterview1 {
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));

        System.out.println(intervals);
        Interval input = new Interval(2, 5);
        ArrayList<Interval> result = insert(intervals, input);

    }

    private static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result =  new ArrayList<Interval>();

        for(Interval interval : intervals){
            System.out.println(interval.start + " - " + interval.end);
            if(newInterval.start >= interval.start && newInterval.start <= interval.end){

            }
        }

        return result;
    }
}

package stack;

import java.util.ArrayDeque;
import java.util.Deque;

//Link : https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
public class LargestHistogram {

    public static long getMaxArea(long[] hist, long n) {

        if (hist.length == 0) {
            return 0;
        }
        long maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        int i = 1;
        stack.push(0);

        while (i<hist.length) {

            while (i<hist.length &&  (stack.isEmpty() || hist[i] > hist[stack.peek()])) {
                stack.push(i++);
            }
            int pos = stack.pop();

            long area = stack.isEmpty() ? hist[pos] * i : hist[pos] * (i - stack.peek()-1);
            if (maxArea < area) {
                maxArea = area;
            }
        }

        while ( !stack.isEmpty()) {
            int pos = stack.pop();
            long area = stack.isEmpty() ? hist[pos] * i : hist[pos] * (i - stack.peek()-1);
            if (maxArea < area) {
                maxArea = area;
            }
        }

        return maxArea;
    }
}

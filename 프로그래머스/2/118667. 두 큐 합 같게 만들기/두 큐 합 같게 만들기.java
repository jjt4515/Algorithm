import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int q: queue1){
            sum1 += q;
            q1.offer(q);
        }
        for (int q: queue2) {
            sum2 += q;
            q2.offer(q);
        }

        long mid = (sum1+sum2)/2;

        while (!q2.isEmpty() && !q1.isEmpty()) {
            if(answer>(queue1.length+queue2.length)*2) return -1;
            if (sum2 == mid) {
                return answer;
            }
            else if (sum2 > mid) {
                int num = q2.poll();
                q1.offer(num);
                sum2 -= num;
                answer++;
            } else {
                int num = q1.poll();
                q2.offer(num);
                sum2 += num;
                answer++;
            }
            
        }
        return -1;
    }
}
import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int del = 0;
        int pic = 0;
        int idx = n-1;
        long answer = 0;
        while (idx >= 0) {
            while (del < deliveries[idx] || pic < pickups[idx]) {
                del += cap;
                pic += cap;
                answer += 2*(idx+1);
            }

            del -= deliveries[idx];
            pic -= pickups[idx];

            idx--;
        }
        return answer;
    }
}
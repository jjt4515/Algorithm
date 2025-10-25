import java.util.*;
class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int pTime = makeTime(play_time);
        int aTime = makeTime(adv_time);
        
        int[] times = new int[pTime+1];
        
        int[][] logTimes = new int[logs.length][2];
        
        for (int i=0;i<logs.length;i++) {
            String log = logs[i];   
            String[] l = log.split("-");
            int start = makeTime(l[0]);
            int end = makeTime(l[1]);
            times[start] += 1;
            times[end] -= 1;
        }
        
        for (int i = 1; i <= pTime; i++) {
            times[i] += times[i - 1];
        }
        
        long totalTime = 0;
        
        for (int i=0;i<aTime;i++) {
            totalTime += times[i];
        }
        
        int ansTime = 0;
        long maxSum = totalTime;    
        
        for (int startTime=1;startTime<=pTime-aTime;startTime++) {
            totalTime += (times[startTime+aTime-1] - times[startTime-1]);
            if (totalTime > maxSum) {
                maxSum = totalTime;
                ansTime = startTime;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int ansHour = ansTime / 3600;
        int ansMinute = (ansTime % 3600) / 60;
        int ansSec = ansTime % 60;
        
        if (ansHour < 10) sb.append(0);
        sb.append(ansHour).append(":");
        
        if (ansMinute < 10) sb.append(0);
        sb.append(ansMinute).append(":");
        
        if (ansSec < 10) sb.append(0);
        sb.append(ansSec);
        
        return sb.toString();
        
    }
    
    public int makeTime(String s) {
        String[] t = s.split(":");
        int hour = Integer.parseInt(t[0]);
        int minute = Integer.parseInt(t[1]);
        int sec = Integer.parseInt(t[2]);
        return hour*60*60 + minute*60 + sec;
    }
}

import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(today, ".");
        int tYear = Integer.parseInt(st.nextToken());
        int tMonth =  Integer.parseInt(st.nextToken());
        int tDay =  Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> hm = new HashMap<>();
        for (String s: terms) {
            String[] data = s.split(" ");
            hm.put(data[0], Integer.parseInt(data[1]));
        }
        
        for (int i=0;i<privacies.length;i++) {
            String[] privacy = privacies[i].split(" ");
            String[] time = privacy[0].split("\\.");
            int year = Integer.parseInt(time[0]);
            int month = Integer.parseInt(time[1]);
            int day = Integer.parseInt(time[2]);
            String person = privacy[1];
            int m = hm.get(person);
            
            month += m;
            while (month > 12) {
                year ++;
                month -= 12;
            }
            boolean flag = false;
            if (year < tYear) {
                flag = true;
            } else if (year > tYear) {
            } else {
                if (month < tMonth) {
                    flag = true;
                } else if (month > tMonth) {
                } else {
                    if (day <= tDay) {
                        flag = true;
                    } 
                }
            }
            if (flag == true) {
                answer.add(i+1);
            }
        }
        
        int[] ans = new int[answer.size()];
        int idx = 0;
        for (int a: answer) {
            ans[idx++] = a;
        }
        return ans;
    }
}
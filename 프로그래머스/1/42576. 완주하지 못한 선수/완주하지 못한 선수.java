import java.util.*;
import java.io.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (String s: participant) {
            hm.put(s, hm.getOrDefault(s,0) + 1);
        }
        
        for (String s: completion) {
            int num = hm.get(s);
            if (num == 1)
                hm.remove(s);
            else 
                hm.put(s,num-1);
        }
        
        String answer = null;
        for (String s: hm.keySet()) {
            answer = s;
            break;
        }

        return answer;
    }
}
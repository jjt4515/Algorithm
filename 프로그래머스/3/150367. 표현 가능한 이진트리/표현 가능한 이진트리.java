import java.util.*;
class Solution {
    static boolean flag;
    public int[] solution(long[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        for (int i=0;i<n;i++) {
            long num = numbers[i];
            ArrayList<Integer> al = new ArrayList<>();
            while (num > 0) {
                al.add((int)(num % 2));
                num = num / 2;
            }
            
            int p = 1;
            while (true) {
                int size = al.size();
                if (size < Math.pow(2, p) - 1) {
                    al.add(0);
                } else if (size == Math.pow(2, p) - 1) {
                    break;
                } else {
                    p++;
                }
            }
            
            Collections.reverse(al);

            int size = al.size();
            flag = true;
            
            if(search(al, 0, size-1) == 0) flag = false;
            
            if (flag) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
    
    public int search(ArrayList<Integer> al, int left, int right) {
        int mid = (left + right) / 2;
        
        if (left == right) {
            return al.get(mid);
        }
        
        int leftRes = search(al, left, mid-1);
        int rightRes = search(al, mid+1, right);
        
        if (al.get(mid) == 1) 
            return 1;

        if (leftRes == 0 && rightRes == 0)
            return 0;

        flag = false;
        return 0;
    }
}
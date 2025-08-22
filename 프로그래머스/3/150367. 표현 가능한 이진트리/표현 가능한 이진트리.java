class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i=0;i<numbers.length;i++) {
            String binary = toBin(numbers[i]);
            int num = flagFunc(binary, 0, binary.length()-1);
            if (num == -1)
                answer[i] = 0;
            else
                answer[i] = 1;
        }
        return answer;
    }
    
    public String toBin(long num) {
        StringBuilder sb = new StringBuilder();
        while (num>0) {
            sb.append(num % 2);
            num /= 2;
        }
        int k = 1;
        while (true) {
            if (sb.length() > Math.pow(2,k)-1) {
                k+=1;
            } else {
                break;
            }
        }
        for (int i=0;i<Math.pow(2,k)-1 - sb.length();i++) {
            sb.append('0');
        }
        sb.reverse();
        return sb.toString();
    }
    
    public int flagFunc(String s, int left, int right) {
        int mid = (left + right) / 2;
        if (left >= right) {
            if (s.charAt(mid) == '1')
                return 1;
            else 
                return 0;
        } 
        int leftCheck = flagFunc(s, left, mid-1);
        int rightCheck = flagFunc(s, mid+1, right);
        if (leftCheck == -1 || rightCheck == -1)
            return -1;
        if (s.charAt(mid) == '1'){
            return 1;
        } else {
            if (leftCheck == 0 && rightCheck == 0) 
                return 0;
            else
                return -1;
        }

        
    }
}
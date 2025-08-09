import java.util.*;

class Solution {
    static int size;
    static boolean[] choice;
    static int maxCnt;
    static int answer[];
    static int[][] dice;
    
    public int[] solution(int[][] dice) {
        size = dice.length;
        choice = new boolean[size+1];
        answer = new int[size/2];
        backtracking(0, dice, 1);
        
        return answer;
    }
    
    static void backtracking(int depth, int[][] dice, int start) {
        if (depth == size/2){
            ArrayList<Integer> arrA = new ArrayList<>();
            ArrayList<Integer> arrB = new ArrayList<>();
            ArrayList<Integer> res = new ArrayList<>();
            
            int winCnt = 0;
            
            for (int i=1;i<size+1;i++){
                if (choice[i] == true) {
                    res.add(i);
                    ArrayList<Integer> tempA = new ArrayList<>();
               
                    for (int y: dice[i-1]) {
                        if (arrA.size() == 0) {
                            tempA.add(y);
                        }
                        else {
                            for (int x: arrA) {
                                tempA.add(x+y);
                            }
                        }
                    }
                    arrA.clear();
                    for (int x: tempA) {
                        arrA.add(x);
                    }
                } 
                else {
                    ArrayList<Integer> tempB = new ArrayList<>();

                    for (int y: dice[i-1]) {
                        if (arrB.size() == 0) {
                            tempB.add(y);
                        } else {
                            for (int x: arrB) {
                                tempB.add(x+y);
                            }
                        }
                    }

                    arrB.clear();
                    for (int x: tempB) {
                        arrB.add(x);
                    }
                }
            }
            
            Collections.sort(arrB);
            for (int a: arrA) {
                winCnt += binarySearch(a, arrB);

                if (winCnt > maxCnt) {
                    maxCnt = winCnt;
                    for (int i=0;i<size/2;i++) {
                        answer[i] = res.get(i);
                    }
                }
            }
            return;
        }
        for (int i=start;i<size+1;i++){
            choice[i] = true;
            backtracking(depth+1, dice, i+1);
            choice[i] = false;
        }
    }
    
    static int binarySearch(int a, ArrayList<Integer> arrB) {
        int left = 0;
        int right = arrB.size() - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arrB.get(mid) >= a) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return right;
    }
    
}
import java.util.*;
class Solution {
    
    static int N;
    static boolean[] visited;
    static ArrayList<Integer> aAll;
    static ArrayList<Integer> bAll;
    static int winCnt;
    static int maxCnt = 0;
    static int[] answer;

    public int[] solution(int[][] dice) {
        N = dice.length;
        visited = new boolean[N];
        
        for (int i=0;i<N;i++) {
            visited[i] = true;
            backtracking(i,1,dice);
            visited[i] = false;
        }
        
        return answer;
    }
    
    public void backtracking(int idx, int depth, int[][] dice) {
        if (depth == N/2) {
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();     
            
            for (int i=0;i<N;i++) {
                if (visited[i]) 
                    a.add(i);
                else 
                    b.add(i);
            }
            
            aAll = new ArrayList<>();
            bAll = new ArrayList<>();
            winCnt = 0;
            
            // for (int aa: a) {
            //     System.out.print(aa + " ");
            // }
            // System.out.println();
            
            backtracking2(a,0,0,0,dice);
            backtracking2(b,0,0,1,dice);
        
            Collections.sort(aAll);
            Collections.sort(bAll);

            for (int x: aAll) {
                binarySearch(x, bAll);
            }
            
            if (winCnt > maxCnt) {
                maxCnt = winCnt;
                answer = new int[a.size()];
                for (int i=0;i<a.size();i++) {
                    answer[i] = a.get(i)+1;
                }
            }
            return;
        }
        
        for (int i=idx+1;i<N;i++) {
            visited[i] = true;
            backtracking(i,depth+1,dice);
            visited[i] = false;
        }
    }
    
    public void backtracking2(ArrayList<Integer> al, int idx, int sum, int type, int[][] dice) {
        if (idx > (N/2-1)) {
            if (type == 0) {
                aAll.add(sum);
            } else {
                bAll.add(sum);
            }
            return;
        }
    
        int diceIdx = al.get(idx);

        for (int i=0;i<6;i++) {
            int newSum = sum + dice[diceIdx][i];
            backtracking2(al, idx+1, newSum, type, dice);
        }
    }
    
    public void binarySearch(int x, ArrayList<Integer> bs) {
        int left = 0;
        int right = bs.size()-1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (x > bs.get(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        winCnt+=right;
    }
}
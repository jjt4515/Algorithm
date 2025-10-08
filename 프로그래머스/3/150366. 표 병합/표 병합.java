import java.util.*;
class Solution {
    static String[][] map;
    static int[] parents;
    static final int N = 50;
    static final int N2 = 2500;
    
    public String[] solution(String[] commands) {
        map = new String[N+1][N+1];
        parents = new int[N2+1];
        for (int i=0;i<=N2;i++) 
        {
            parents[i] = i;
        }
        
        ArrayList<String> answer = new ArrayList<>();
        
        for (int i=0;i<commands.length;i++) {
            String[] command = commands[i].split(" ");
            
            String com = command[0];
            int row, col, row2, col2;
            String word, word2;
            int x, p, pr, pc;
            switch (com) {
                case "UPDATE":
                    if (command.length == 4) {
                        row = Integer.parseInt(command[1]);
                        col = Integer.parseInt(command[2]);
                        word = command[3];
                        
                        x = getIdx(row,col);
                        p = find(x);
                        
                        int[] rc = getRowCol(p);
                        pr = rc[0];
                        pc = rc[1];
                        
                        map[pr][pc] = word;
                    } else {
                        word = command[1];
                        word2 = command[2];
                        
                        for (int r=1;r<=N;r++) {
                            for (int c=1;c<=N;c++) {
                                x = getIdx(r,c);
                                p = find(x);
                                int[] rc = getRowCol(p);
                                pr = rc[0];
                                pc = rc[1]; 
                        
                                if (map[pr][pc] != null && map[pr][pc].equals(word)) {
                                    map[r][c] = word2;
                                }
                            }
                        }
                    }

                    break;
                case "MERGE":
                    row = Integer.parseInt(command[1]);
                    col = Integer.parseInt(command[2]);
                    row2 = Integer.parseInt(command[3]);
                    col2 = Integer.parseInt(command[4]);
                    
                    int x1 = getIdx(row, col);
                    int x2 = getIdx(row2, col2);
                    
                    union(x1,x2);
                    
                    break;
                case "UNMERGE":
                    row = Integer.parseInt(command[1]);
                    col = Integer.parseInt(command[2]);
                    
                    x = getIdx(row, col);
                    p = find(x);
                    
                    int[] rc = getRowCol(p);
                    pr = rc[0];
                    pc = rc[1];
                    
                    String s = map[pr][pc];
                    
                    for (int k=1;k<=N2;k++)
                        find(k);
                    
                    ArrayList<Integer> unmerges = new ArrayList<>();
                    for (int k=1;k<=N2;k++) {
                        if (parents[k] == p) {
                            parents[k] = k;
                            rc = getRowCol(k);
                            map[rc[0]][rc[1]] = null;
                        }
                    }
                    map[row][col] = s;
                    
                    break;
                    
                case "PRINT":
                    row = Integer.parseInt(command[1]);
                    col = Integer.parseInt(command[2]);
                    
                    x = getIdx(row, col);
                    p = find(x);
                    
                    rc = getRowCol(p);
                    pr = rc[0];
                    pc = rc[1];
        
                    if (map[pr][pc] == null) {
                        answer.add("EMPTY");
                    } else {
                        answer.add(map[pr][pc]);
                    }
                    
                    break;
                default:
                    break;
            }
        }
        String[] ans;
        ans = new String[answer.size()];
        for (int i=0;i<answer.size();i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }
    
    public int find(int x) {
        if (x == parents[x])
            return x;
        
        return parents[x] = find(parents[x]);
    }
    
    public void union(int x1, int x2) {
        int p1 = find(x1);
        int p2 = find(x2);
        
        if (p1 == p2)
            return;
        
        int[] rc = getRowCol(p1);
        int row1 = rc[0];
        int col1 = rc[1];
        
        rc = getRowCol(p2);
        int row2 = rc[0];
        int col2 = rc[1];

        if (map[row1][col1] == null && map[row2][col2] != null) {
            parents[p1] = p2;
        } else {
            parents[p2] = p1;
        }
        
        return;
    }
    
    public int[] getRowCol(int x) {
        x -= 1;
        int row = x / N + 1;
        int col = x % N + 1;
        return new int[]{row, col};
    }
    
    public int getIdx(int row, int col) {
        return (row-1)*N + col;
    }
    
}
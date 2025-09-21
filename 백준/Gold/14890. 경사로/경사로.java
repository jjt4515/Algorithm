

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int ans = 0;
    static int n;
    static int l;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0;i<n;i++) {
            pass(i,0);
            pass(i,1);
        }

        System.out.println(ans);

    }

    public static void pass(int line, int option) {
        boolean flag = true;
        if (option == 0) {
            int prev = map[line][0];
            int[] buf = new int[l];
            int idx = 0;
            buf[idx] = prev;

            for (int i=1;i<n;i++) {
                int cur = map[line][i];
                if (prev + 1 == cur) {
                    if (idx == l-1) {
                        idx = 0;
                        buf[idx] = cur;
                    } else {
                        flag = false;
                        break;
                    }
                } else if (prev == cur + 1) {
                    for (int k=1;k<l;k++) {
                        if (i+k >= n || cur != map[line][i+k]) {
                            flag = false;
                            break;
                        }
                    }

                    idx = -l;

                } else if (prev == cur) {
                    if (idx < l-1) {
                        idx ++;
                        if (idx >= 0) {
                            buf[idx] = cur;
                        }
                    }
                } else {
                    flag = false;
                    break;
                }

                prev = cur;
            }
        } else {
            int prev = map[0][line];
            int[] buf = new int[l];
            int idx = 0;
            buf[idx] = prev;

            for (int i=1;i<n;i++) {
                int cur = map[i][line];
                if (prev+1 == cur) {
                    if (idx == l - 1) {
                        idx = 0;
                        buf[idx] = cur;
                    } else {
                        flag = false;
                        break;
                    }
                } else if (prev == cur+1) {
                    for (int k = 1; k < l; k++) {
                        if (i + k >= n || cur != map[i + k][line]) {
                            flag = false;
                            break;
                        }
                    }

                    idx = -l;

                } else if (prev == cur) {
                    if (idx < l-1) {
                        idx ++;
                        if (idx >= 0) {
                            buf[idx] = cur;
                        }
                    }
                } else {
                    flag = false;
                    break;
                }

                prev = cur;
            }
        }

        if (flag) {
            ans ++;
        }
        
    }
}





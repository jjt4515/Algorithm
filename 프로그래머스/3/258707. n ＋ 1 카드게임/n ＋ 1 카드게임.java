import java.util.*;
class Solution {
    public int solution(int coin, int[] cards) {
        HashSet<Integer> firstCards = new HashSet<>();
        HashSet<Integer> newCards = new HashSet<>();
        int round = 0;
        
        int n = cards.length;
        for (int i=0;i<n/3;i++) {
            firstCards.add(cards[i]);
        }
        
        while (true) {
            round++;
            int right = n/3 - 1 + round*2;
            
            if (right >= n)
                break;
            
            newCards.add(cards[right-1]);
            newCards.add(cards[right]);
            
            boolean flag = false;
            for (int num : firstCards) {
                if (firstCards.contains(n+1-num)) {
                    firstCards.remove(n+1-num);
                    firstCards.remove(num);
                    flag = true;
                    break;
                }
            }
            
            if (!flag) {
                if (coin >= 1) {
                    for (int num : firstCards) {
                        if (newCards.contains(n+1-num)) {
                            newCards.remove(n+1-num);
                            firstCards.remove(num);
                            coin--;
                            flag = true;
                            break;
                        }
                    }   
                }
            }
            
            if (!flag) {
                if (coin >= 2) {
                    for (int num : newCards) {
                        if (newCards.contains(n+1-num)) {
                            newCards.remove(n+1-num);
                            newCards.remove(num);
                            coin-=2;
                            flag = true;
                            break;
                        }
                    }   
                }
            }         
           
            if (!flag)
                break;
        }
        
        return round;
        
    }
}
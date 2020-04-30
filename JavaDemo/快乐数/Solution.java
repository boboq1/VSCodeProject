package JavaDemo.快乐数;

import java.util.Set;
import java.util.HashSet;

public class Solution {
    private int getNext(int n) {
        int res = 0;
        while (n != 0) {
            int mod = n % 10;
            res += mod * mod;
            n = n / 10;
        }
        return res;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

}
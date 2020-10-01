/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quytd1502;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 *
 * @author Admin
 */
public class Quytd1502 {

    static int findMinLength(String arr[], int n) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= (n - 1); i++) {
            if (arr[i].length() < min) {
                min = arr[i].length();
            }
        }
        return min;
    }

    static boolean allContainsPrefix(String arr[], int n,
            String str, int start, int end) {
        for (int i = 0; i <= (n - 1); i++) {
            String arr_i = arr[i];

            for (int j = start; j <= end; j++) {
                if (arr_i.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    static String commonPrefix(String arr[], int n) {
        int index = findMinLength(arr, n);
        String prefix = "";
        int low = 0, high = index - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (allContainsPrefix(arr, n, arr[0], low,
                    mid)) {
                prefix = prefix + arr[0].substring(low,
                        mid + 1);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return prefix;
    }

    public static void main(String args[]) {
        System.out.println("-------------1------------");
        String example1[] = {"floower", "flow", "flight"};
        String example2[] = {"dog", "racecar", "car"};
        int n = example1.length;
        int m = example2.length;

        String ans = commonPrefix(example1, n);
        String ani = commonPrefix(example2, m);

        if (ans.length() > 0) {
            System.out.println("Example1" + ans);
        }
        if (ani.length() > 0) {
            System.out.println("Example2" + ani);
        } else {
            System.out.println("There is no common prefix  among the input strings");
        }
        System.out.println("------------2-----------");
        int[] S = {1, 2, 3};
        Arrays.sort(S);
        Deque<Integer> out = new ArrayDeque<>();
        findPowerSet(S, out, S.length - 1);
    }

    public static void findPowerSet(int[] S, Deque<Integer> out, int i) {
        if (i < 0) {
            System.out.println(out);
            return;
        }
        out.addLast(S[i]);
        findPowerSet(S, out, i - 1);
        out.pollLast();
        while (i > 0 && S[i] == S[i - 1]) {
            i--;
        }
        findPowerSet(S, out, i - 1);
    }
    
}

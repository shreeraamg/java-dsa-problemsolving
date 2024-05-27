package problemsolving.array;

// Special Array With X Elements Greater Than or Equal X
// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/description/
public class Leetcode1608 {
    public static int specialArray(int[] nums) {
        for(int i=0; i<=nums.length; i++) {
            int count = 0;
            for (int num : nums) {
                if (num >= i)
                    count++;
            }
            if(count == i)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Sample Test Cases
        int result1 = specialArray(new int[]{3, 5}); // 2
        int result2 = specialArray(new int[]{0, 0}); // -1
        int result3 = specialArray(new int[]{0, 4, 3, 0, 4}); // 3
    }
}

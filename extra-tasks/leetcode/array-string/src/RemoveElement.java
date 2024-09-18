import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        var nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int test1 = removeElement(nums, 2);
        System.out.println(test1);
        System.out.println(Arrays.toString(nums));

    }

    public static int removeElement(int[] nums, int val) {
        var n = nums.length - 1;
        var i = 0;

        while (i <= n) {
            if (nums[i] == val) {
                nums[i] = nums[n];
                n--;
            } else {
                i++;
            }
        }
        return n + 1;
    }
}

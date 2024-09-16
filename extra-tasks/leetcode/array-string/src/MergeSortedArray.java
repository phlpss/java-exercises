import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function,
 * but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n,
 * where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */

public class MergeSortedArray {
    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        merge(new int[]{7, 8, 9, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        merge(new int[]{1}, 1, new int[]{}, 0);
        merge(new int[]{0}, 0, new int[]{1}, 1);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        var mi = m - 1;
        var ni = n - 1;
        var pivot = m + n -1;

        while(ni >= 0) {
            if(mi >=0 && nums1[mi] > nums2[ni]) {
                nums1[pivot] = nums1[mi];
                mi--;
            } else {
                nums1[pivot] = nums2[ni];
                ni--;
            }
            pivot--;
        }
        System.out.println(Arrays.toString(nums1));
    }
}
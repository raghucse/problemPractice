package JavaConcepts.Inheritance;

/**
 * Created by raghu on 3/14/2017.
 */
import java.util.*;

class OptimalPartition {

    public List<List<Integer>> partitions(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        int n = nums.length;

        // Sort array, then collapse it.
        Arrays.sort(nums);
        List<Integer> collapsed = new ArrayList<>();
        int[] info = collapse(nums, collapsed);
        int max = info[0], sum = info[1];

        // Use binary search to find appropriate value;
        int rangeMin = max; // The minimum value of number of elements in a given bin
        int rangeMax = sum; // The maximum value of number of elements in a given bin
        int num = binarySearch(collapsed, rangeMin, rangeMax, k);

        // Finish the partition using 'num';
        int i = 0;
        while (i < n) {
            List<Integer> item = new ArrayList<>();
            int counter = 0;
            while (counter++ < num && i<n) {
                item.add(nums[i++]);
            }
            result.add(item);
        }
        return result;
    }

    /* After sorting the original array, convert it into another array, element of which
     * is the number of consecutive equal number.
     */
    private int[] collapse(int[] nums, List<Integer> collapsed) {
        int prev = nums[0];
        int counter = 1;
        int sum = 0, max = 0;
        for (int i=1; i<nums.length; ++i) {
            if (nums[i] == prev) counter++;
            else {
                collapsed.add(counter);
                max = Math.max(max, counter);
                sum+=counter;
                counter = 1;
                prev = nums[i];
            }
        }
        collapsed.add(counter);
        max = Math.max(max, counter);
        sum+=counter;
        return new int[] {max, sum};
    }

    private int binarySearch(List<Integer> collapsed, int start, int end, int k) {
        if (start > end) return -1;
        int mid = start + (end - start)/2;
        if (partition(collapsed, mid, k)) {
            int left = binarySearch(collapsed, start, mid-1, k);
            if (left != -1) return left;
            return mid;
        }
        return binarySearch(collapsed, mid+1, end, k);
    }

    // Greedily allocate element from left to right using given 'maximum number of elements in a bin'
    private boolean partition(List<Integer> collapsed, int max, int k) {
        int n = collapsed.size();
        int counter = 0;
        int partitionNum = 0;
        for (int i=0; i<n; ++i) {
            if (counter+collapsed.get(i)<=max) {
                counter += collapsed.get(i);
            } else {
                counter = 0;
                i--;
                partitionNum++;
            }
        }
        partitionNum++;
        return partitionNum<=k;
    }

    public static void main(String[] args) {
        OptimalPartition o = new OptimalPartition();
        for (List<Integer> part: o.partitions(new int[] {5, 2, 3, 6, 1, 6}, 3)) {
            System.out.println(part);
        }
        for (List<Integer> part: o.partitions(new int[] {1, 1, 1, 1, 1, 1}, 3)) {
            System.out.println(part);
        }
        for (List<Integer> part: o.partitions(new int[] {1, 1, 1, 1, 2, 2, 3}, 2)) {
            System.out.println(part);
        }

        for (List<Integer> part: o.partitions(new int[] {1, 2, 3, 4, 4, 5, 6, 7, 8,9,10}, 3)) {
            System.out.println(part);

        }
    }
}

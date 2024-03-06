public class SplitSearch {
    public static void main(String[] args) {
        // You can add your test cases here if needed
    }

    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;

        // Finding the range of the search space
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }

        // Applying binary search
        while (start < end) {
            int mid = start + (end - start) / 2;
            int pieces = 1;
            int sum = 0;

            // Counting the number of pieces with maximum sum as mid
            for (int num : nums) {
                if (sum + num > mid) {
                    // Start a new subarray
                    sum = num;
                    pieces++;
                } else {
                    // Continue adding to the current subarray
                    sum += num;
                }
            }

            // Adjusting search space based on the number of pieces
            if (pieces > k) {
                // If we need more pieces, increase the minimum maximum sum
                start = mid + 1;
            } else {
                // If we can reduce the maximum sum, try to minimize it
                end = mid;
            }
        }

        // Printing the elements of the array corresponding to the split
        int sum = 0;
        int pieces = 1;
        for (int num : nums) {
            if (sum + num > end) {
                // Start a new subarray
                System.out.println();
                sum = num;
                pieces++;
            } else {
                // Continue adding to the current subarray
                sum += num;
            }
            System.out.print(num + "");
        }
        System.out.println(); // Print a new line after printing the elements

        return end; // Return the minimum maximum sum
    }
}

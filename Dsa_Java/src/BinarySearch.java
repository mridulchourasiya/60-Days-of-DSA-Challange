public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-12, -11, -3, -1, 0, 2, 3, 4, 8, 19, 22, 44, 89};
        int target = 4;
        int ans = binarySearch(arr, target);
        System.out.println(ans);
    }

    // return Index
    // return -1 if it does not exist
    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // find the middle element
            int mid = start + (end - start) / 2; // Corrected calculation of mid index
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

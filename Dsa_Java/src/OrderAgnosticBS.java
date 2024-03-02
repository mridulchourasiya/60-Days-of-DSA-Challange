public class OrderAgnosticBS {
    public static void main(String[] args) {
        //  int[] arr = {-12, -11, -3, -1, 0, 2, 3, 4, 8, 19, 22, 44, 89};
        int[] arr = {99, 88, 33, 22, 10, 9, 3, 1, -1};
        int target = 22;
        int ans = orderAgnosticBs(arr, target);
        System.out.println(ans);
    }

    static int orderAgnosticBs(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // chack if the array sorted in ascending or decending order
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {

                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }


        return -1;
    }

}

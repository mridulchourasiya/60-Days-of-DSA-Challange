public class Mountain {

    public static void main(String[] args) {

    }

    int search(int[] arr, int target) {
        int peak = peakIndexInMouantainArray(arr);
        int firstTry = orderAgnosticBs(arr, target, 0, peak);
        if (firstTry != -1) {
            return firstTry;
        }
        return orderAgnosticBs(arr, target, peak + 1, arr.length - 1);
    }

    public int peakIndexInMouantainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                // you are in dec part of an array
                // this may be the ans, but look at left
                // this may end  ! = mid - 1
                end = mid;
            } else {
                start = mid + 1;
            }
        }


        return start;   // in the end , start is equal to the end always pointing the end

    }

    static int orderAgnosticBs(int[] arr, int target, int start, int end) {


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

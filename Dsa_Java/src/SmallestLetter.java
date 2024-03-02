public class SmallestLetter {
    public static void main(String[] args) {
        char[] letters = {'a', 'c', 'f', 'h'};
        char target = 'i';
        char ans = nextGreatestLetter(letters, target);
        System.out.println(ans);
    }

    // return the smallest letter greater than target
    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        char result = letters[0]; // Initialize result with the first letter

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] > target) {
                result = letters[mid];
                end = mid - 1; // Continue searching on the left side
            } else {
                start = mid + 1; // Search on the right side
            }
        }
        return result;
    }
}

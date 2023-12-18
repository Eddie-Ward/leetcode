package daily;

class Solution {
    public int maxProductDifference(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int smaller = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        int larger = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num >= largest) {
                larger = largest;
                largest = num;
            } else if (num > larger) {
                larger = num;
            }

            if (num <= smallest) {
                smaller = smallest;
                smallest = num;
            } else if (num < smaller) {
                smaller = num;
            }
        }

        return (largest * larger) - (smallest * smaller);
    }
}

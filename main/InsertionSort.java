
import services.Sorting;

public class InsertionSort implements Sorting {

    @Override
    public void sort(double[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Given Array can not be Null!");
        }

        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                swap(nums, i, i - 1);
                int j = i - 1;
                while (j > 0 && nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                    j--;
                }
            }
        }

    }

    private void swap(double[] nums, int firstID, int secondID) {
        if (firstID != secondID) {
            double tmp;
            tmp = nums[firstID];
            nums[firstID] = nums[secondID];
            nums[secondID] = tmp;
        }
    }
}

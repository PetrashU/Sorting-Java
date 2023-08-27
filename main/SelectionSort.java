
import services.Sorting;

public class SelectionSort implements Sorting {

    @Override
    public void sort(double[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input Array can not be null!");
        }

        int n = nums.length;
        int minValID;

        for (int i = 0; i < n - 1; i++) {
            minValID = i;

            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minValID]) {
                    swap(nums, minValID, j);
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

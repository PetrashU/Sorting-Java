
import java.util.ArrayList;
import java.util.List;
import services.HeapExtension;
import services.Sorting;

public class HeapSort implements Sorting {

    private List<Double> data;
    private HeapExtension heap;

    @Override
    public void sort(double[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array cannot be null!");
        }

        int n = nums.length;

        data = boxingData(nums);
        heap = new Heap(data);

        heap.build();

        for (int i = n - 1; i > 0; i--) {
            swap(0, i);
            heap.heapify(0, i);
        }

        System.arraycopy(unboxingData(data), 0, nums, 0, n);

    }

    private List<Double> boxingData(double[] nums) {
        List<Double> numsAsList = new ArrayList<>();

        for (Double num : nums) {
            numsAsList.add(num);
        }

        return numsAsList;
    }

    private double[] unboxingData(List<Double> list) {
        double[] nums = new double[list.size()];

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        return nums;
    }

    private void swap(int firstId, int secondId) {
        if (firstId != secondId) {
            Double firstVal = data.get(firstId);
            data.set(firstId, data.get(secondId));
            data.set(secondId, firstVal);
        }
    }

}

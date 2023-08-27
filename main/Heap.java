
import java.util.List;
import services.HeapExtension;
import services.HeapInterface;

public class Heap<T extends Comparable<T>> implements HeapInterface<T>, HeapExtension {

    private List<T> data;
    private boolean heaped = true;

    public Heap(List<T> data) {
        this.data = data;
        heaped = isHeap();
    }

    @Override
    public void put(T item) {
        if (item == null) {
            //throw new ArrayIndexOutOfBoundsException("Can't pop a null on Heap!"); ////opcjonalne( jeżeli chcemy nie zautomatyzować, lecz kontrolować użytkownika)
            return;
        }

        if (!heaped) {
            build();
        }

        data.add(item);

        int i = data.size() - 1;
        while ((i > 0) && (data.get(i).compareTo(data.get((i - 1) / 2)) > 0)) {
            T tmp = data.get((i - 1) / 2);
            data.set((i - 1) / 2, data.get(i));
            data.set(i, tmp);
            i = (i - 1) / 2;

        }

    }

    @Override
    public T pop() {
        if (data.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Heap is empty, can't pop element!");
        }
        if (!heaped) {
            //throw new IllegalStateException("Heap is not sorted. Run build() method after Heap initialization!");  //opcjonalne( jeżeli chcemy nie zautomatyzować, lecz kontrolować użytkownika)
            build();

        }

        T toPop = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.remove(data.size() - 1);

        heapify(0, data.size());

        return toPop;

    }

    @Override
    public void build() {
        int n = data.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(i, n);
        }
        heaped = true;
    }

    @Override
    public void heapify(int startId, int endId) {
        if (data.isEmpty()) {
            return;
        }
        T root = data.get(startId);
        int rootId = startId;
        int maxId = rootId;
        int leftId = 2 * startId + 1;
        int rightId = 2 * startId + 2;
        if (rightId < data.size()) {
            if (rightId < endId) {
                T right = data.get(rightId);
                if (right.compareTo(root) > 0) {
                    maxId = rightId;
                }
            }
        }
        if (leftId < data.size()) {
            if (leftId < endId) {
                T left = data.get(leftId);
                if (left.compareTo(data.get(maxId)) > 0) {
                    maxId = leftId;
                }
            } else {
                return;
            }
        } else {
            return;
        }
        if (maxId == rootId) {
            return;
        }
        T tmp = data.get(rootId);
        data.set(rootId, data.get(maxId));
        data.set(maxId, tmp);

        heapify(maxId, endId);

    }

    private boolean isHeap() {
        int n = data.size();
        if (n > 1) {
            for (int i = 0; i <= (n - 2) / 2; i++) {
                if (data.get(2 * i + 1).compareTo(data.get(i)) > 0) {
                    return false;
                }

                if (2 * i + 2 < n && data.get(2 * i + 2).compareTo(data.get(i)) > 0) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }
}

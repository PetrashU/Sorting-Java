
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HeapTest {

    private Heap heap;

    @Before
    public void beforeEach() {
        List<Double> nums = new ArrayList<>();
        heap = new Heap(nums);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void gdyWyjmujemyZPustegoKopca() {
        //when
        heap.pop();

        //then
        assert false;
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void gdyDodajemyNull() {
        //given
        Double item = null;

        //when
        heap.put(item);
        heap.pop();

        //then
        assert false;
    }

    @Test
    public void gdyPutPoKonstruktorzeBezBuild() {
        //given
        List<Double> lista = new ArrayList<>();
        double a = 1;
        for (int i = 0; i < 100; i++) {
            lista.add(a);
            a++;
        }
        heap = new Heap(lista);

        //when
        heap.put(1000.0);

        //then
        assertEquals(1000.0, heap.pop());
        assertEquals(100.0, heap.pop());
    }

    @Test
    public void gdyPopPoKonstruktorzeBezBuild() {
        //given
        List<Double> nums = new ArrayList<>(Arrays.asList(75.0, 100.0, 75.0, 150.0, 20.0));
        heap = new Heap(nums);

        //when
        List<Double> poped = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            poped.add((Double) heap.pop());
        }

        //then
        List<Double> expected = new ArrayList<>(Arrays.asList(150.0, 100.0, 75.0, 75.0, 20.0));
        Assert.assertEquals(expected, poped);
    }

    @Test
    public void testPop() {
        //given
        heap.put(100.0);
        heap.put(89.0);
        heap.put(99.0);
        heap.put(77.0);
        heap.put(80.0);
        List<Double> poped = new ArrayList<>();

        //when
        for (int i = 0; i < 5; i++) {
            poped.add((Double) heap.pop());
        }

        //then
        List<Double> expected = new ArrayList<>(Arrays.asList(100.0, 99.0, 89.0, 80.0, 77.0));
        Assert.assertEquals(expected, poped);

    }

    @Test
    public void gdyWkladamyStringi() {
        //given
        heap.put("Ala");
        heap.put("I");
        heap.put("Ola");
        heap.put("Maja");
        heap.put("Psa");
        heap.put("I");
        heap.put("Kota");
        List<String> poped = new ArrayList<>();

        //when
        for (int i = 0; i < 7; i++) {
            poped.add((String) heap.pop());
        }

        //then
        List<String> expected = new ArrayList<>(Arrays.asList("Psa", "Ola", "Maja", "Kota", "I", "I", "Ala"));
        Assert.assertEquals(expected, poped);
    }

    @Test
    public void gdyDodajemyListeStringow() {
        //given
        List<String> list = new ArrayList<>(Arrays.asList("Ala", "I", "Ola", "Maja", "Psa", "I", "Kota"));
        heap = new Heap(list);

        List<String> poped = new ArrayList<>();

        //when
        for (int i = 0; i < 7; i++) {
            poped.add((String) heap.pop());
        }

        //then
        List<String> expected = new ArrayList<>(Arrays.asList("Psa", "Ola", "Maja", "Kota", "I", "I", "Ala"));
        Assert.assertEquals(expected, poped);
    }

    @Test
    public void testBuildDlaDouble() {
        //given
        List<Double> list = new ArrayList<>(Arrays.asList(23.0, 17.0, 150.0, -125.0, 1.0));
        heap = new Heap(list);
        List<Double> poped = new ArrayList<>();

        //when
        heap.build();

        //then
        for (int i = 0; i < 5; i++) {
            poped.add((Double) heap.pop());
        }
        List<Double> expected = new ArrayList<>(Arrays.asList(150.0, 23.0, 17.0, 1.0, -125.0));
        Assert.assertEquals(expected, poped);
    }

    @Test
    public void testBuildDlaString() {
        //given
        List<String> list = new ArrayList<>(Arrays.asList("Ala", "I", "Ola", "Maja", "Psa", "I", "Kota"));
        heap = new Heap(list);
        List<String> poped = new ArrayList<>();

        //when
        heap.build();

        //then
        for (int i = 0; i < 7; i++) {
            poped.add((String) heap.pop());
        }
        List<String> expected = new ArrayList<>(Arrays.asList("Psa", "Ola", "Maja", "Kota", "I", "I", "Ala"));
        Assert.assertEquals(expected, poped);
    }

    @Test
    public void gdyWkladamyWartosciLosowe() {
        //given
        Random generator = new Random(1);
        List<Integer> poped = new ArrayList<>();

        //when
        for (int i = 0; i < 10; i++) {
            heap.put(generator.nextInt(-100, 100));
        }
        for (int i = 0; i < 10; i++) {
            poped.add((Integer) heap.pop());
        }

        //then
        List<Integer> expected = new ArrayList<>(Arrays.asList(88, 85, 78, 48, 13, 4, -46, -53, -66, -94));
        Assert.assertEquals(expected, poped);
    }

}

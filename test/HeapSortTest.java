
import java.util.Random;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.Sorting;

public class HeapSortTest {

    private Sorting sorter;

    @Before
    public void beforeEach() {
        sorter = new HeapSort();
    }

    @Test(expected = IllegalArgumentException.class)
    public void GdyTablicaJestNull() {
        //given
        double[] nums = null;

        //when
        sorter.sort(nums);

        //then 
        assert false;

    }

    @Test
    public void GdyTablicaJestPusta() {
        //given
        double[] nums = {};

        //when
        sorter.sort(nums);

        //then
        int expectedSize = 0;
        Assert.assertEquals(expectedSize, nums.length);
    }

    @Test
    public void GdyTablicaMaJedenElement() {
        //given
        double[] nums = {1};

        //when
        sorter.sort(nums);

        //then
        double[] expected = {1};
        Assert.assertArrayEquals(expected, nums, 0);
    }

    @Test
    public void GdyTablicaMaDwaElementyRoznePosortowaneMalejaco() {
        //given
        double[] nums = {4.5, 3.5};

        //when
        sorter.sort(nums);

        //then
        double[] expected = {3.5, 4.5};
        Assert.assertArrayEquals(nums, expected, 0);
    }

    @Test
    public void GdyTablicaMaDwaElementyRoznePosortowaneRosnaco() {
        //given
        double[] nums = {6.7, 7.6};

        //when
        sorter.sort(nums);

        //then
        double[] expected = {6.7, 7.6};
        Assert.assertArrayEquals(nums, expected, 0);
    }

    @Test
    public void GdyTablicaMaDwaElementyRowne() {
        //given
        double[] nums = {5.6, 5.6};

        //when
        sorter.sort(nums);

        //then
        double[] expected = {5.6, 5.6};
        Assert.assertArrayEquals(nums, expected, 0);
    }

    @Test
    public void GdyTablicaMaTrzyElementyRoznePosortowaneMalejaco() {
        //given
        double[] nums = {4.5, 3.5, 2.9};

        //when
        sorter.sort(nums);

        //then
        double[] expected = {2.9, 3.5, 4.5};
        Assert.assertArrayEquals(nums, expected, 0);
    }

    @Test
    public void GdyTablicaMaTrzyElementyRoznePosortowaneRosnaco() {
        //given
        double[] nums = {6.7, 7.6, 105.67};

        //when
        sorter.sort(nums);

        //then
        double[] expected = {6.7, 7.6, 105.67};
        Assert.assertArrayEquals(nums, expected, 0);
    }

    @Test
    public void GdyTablicaMaTrzyElementyRozne() {
        //given
        double[] nums = {5.6, 3.5, 12.79};

        //when
        sorter.sort(nums);

        //then
        double[] expected = {3.5, 5.6, 12.79};
        Assert.assertArrayEquals(nums, expected, 0);
    }

    @Test
    public void GdyTablicaMaTrzyElementyWTymDwaRowne() {
        //given
        double[] nums = {5.6, 5.6, 4.6};

        //when
        sorter.sort(nums);

        //then
        double[] expected = {4.6, 5.6, 5.6};
        Assert.assertArrayEquals(nums, expected, 0);
    }

    @Test
    public void GdyTablicaMaTrzyElementyRowne() {
        //given
        double[] nums = {5.6, 5.6, 5.6};

        //when
        sorter.sort(nums);

        //then
        double[] expected = {5.6, 5.6, 5.6};
        Assert.assertArrayEquals(nums, expected, 0);
    }

    @Test
    public void gdyTablicaJestPiecioelementowaPosortowanaRosnaco() {
        //given
        double[] nums = {1, 2, 3, 4, 5};

        //when
        sorter.sort(nums);

        //then
        double[] expected = {1, 2, 3, 4, 5};
        Assert.assertArrayEquals(expected, nums, 0);

    }

    @Test
    public void gdyTablicaJestPiecioelementowaPosortowanaMalejaco() {
        //given
        double[] nums = {5, 4, 3, 2, 1};

        //when
        sorter.sort(nums);

        //then
        double[] expected = {1, 2, 3, 4, 5};
        Assert.assertArrayEquals(expected, nums, 0);
    }

    @Test
    public void gdyTablicaJestPiecioelementowaMaDwieRowneWartosci() {
        //given
        double[] nums = {7, 9, 15, 3, 7};

        //when
        sorter.sort(nums);

        //then
        double[] expected = {3, 7, 7, 9, 15};
        Assert.assertArrayEquals(expected, nums, 0);

    }

    @Test
    public void gdyTablicaJestPiecioelementowaMaTrzyRowneWartosci() {
        //given
        double[] nums = {7, 9, 15, 7, 7};

        //when
        sorter.sort(nums);

        //then
        double[] expected = {7, 7, 7, 9, 15};
        Assert.assertArrayEquals(expected, nums, 0);

    }

    @Test
    public void gdyTablicaMaPiecElementowIPierwszyJestNaZlymMiejscu() {
        //given
        double[] nums = {5, 1, 2, 3, 4};

        //when
        sorter.sort(nums);

        //then
        double[] expected = {1, 2, 3, 4, 5};
        Assert.assertArrayEquals(expected, nums, 0);

    }

    @Test
    public void gdyTablicaMaPiecElementowIOstatniJestNaZlymMiejscu() {
        //given
        double[] nums = {2, 3, 4, 5, 1};

        //when
        sorter.sort(nums);

        //then
        double[] expected = {1, 2, 3, 4, 5};
        Assert.assertArrayEquals(expected, nums, 0);

    }

    @Test
    public void gdyTablicaMaDziesiecLosowychElementow() {
        //given
        double[] nums = new double[10];
        Random generator = new Random(100);
        for (int i = 0; i < 10; i++) {
            nums[i] = generator.nextDouble(100);
        }

        //when
        sorter.sort(nums);

        //then
        double[] expected = {19, 23, 48, 52, 61, 62, 66, 68, 72, 77};
        Assert.assertArrayEquals(expected, nums, 1);
    }

}

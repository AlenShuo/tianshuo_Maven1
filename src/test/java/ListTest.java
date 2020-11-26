import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListTest {
    private static List list = new List();
    @BeforeClass
    public static void setUp() throws Exception {
        list.setArray(new int[]{0});
        System.out.println("start testing");
    }

    @After
    public void tearDown() throws Exception {
        list.setArray(new int[]{0});
        System.out.println("end testing");
    }

    @Test
    public void sort() {
        list.setArray(new int[]{32,13,5,9,15,21,23,60,54,33});
        list.sort();
        int[] a = list.getArray();
        assertArrayEquals(new int[]{5,9,13,15,21,23,32,33,54,60}, a);
    }

    @Test
    public void mergeSort() {
        int[] a = new int[]{6,4,3,7,9,5,8,1,10,2};
        a = list.mergeSort(a);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10}, a);
    }

    @Test
    public void merge() {
        int[] b = list.merge(new int[]{1,3,5,7,9}, new int[]{2,4,6,8,10});
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10}, b);
    }
}
package ro.redeul.katas.binarySearch;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

import static ro.redeul.katas.binarySearch.FindOccurrenceCount.binarySearch;
import static ro.redeul.katas.binarySearch.FindOccurrenceCount.count;

public class FindOccurrenceCountTest {

    @Test
    public void testBinarySearch() throws Exception {
        assertEquals(binarySearch(new int[]{}, 1), -1);
        assertEquals(binarySearch(new int[]{1}, 1), 0);
        assertEquals(binarySearch(new int[]{1, 2, 3, 4, 5, 6}, 1), 0);
        assertEquals(binarySearch(new int[]{1, 2, 3, 4, 5, 6}, 3), 2);
        assertEquals(binarySearch(new int[]{1, 2, 3, 4, 5, 6}, 6), 5);
        assertEquals(binarySearch(new int[]{1, 2, 3, 4, 5, 6}, 7), -1);
    }

    @Test
    public void testFindCount() throws Exception {
        assertEquals(count(new int[]{}, 1), 0);
        assertEquals(count(new int[]{1}, 1), 1);
        assertEquals(count(new int[]{1, 2, 3, 4, 5, 6}, 1), 1);
        assertEquals(count(new int[]{1, 2, 3, 4, 5, 6}, 3), 1);
        assertEquals(count(new int[]{1, 2, 3, 4, 5, 6}, 6), 1);
        assertEquals(count(new int[]{1, 2, 3, 4, 5, 6}, 7), 0);

        assertEquals(count(new int[]{1, 2, 2, 2, 5, 6}, 2), 3);
        assertEquals(count(new int[]{1, 2, 3, 3, 5, 6}, 3), 2);
        assertEquals(count(new int[]{1, 2, 3, 5, 5, 6}, 5), 2);
        assertEquals(count(new int[]{1, 2, 3, 4, 6, 6}, 6), 2);
    }
}
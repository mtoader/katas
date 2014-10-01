package ro.redeul.katas.binarySearch;

public class FindOccurrenceCount {


    interface Invariant {
        boolean test(int l, int h);
    }


    public static int count(int data[], int x) {

        int max = data.length;

        int s[] = search(data, -1, max, (l, h) -> l < x && x <= h);
        if (s[1] >= max || data[s[1]] != x)
            return 0;

        int e[] = search(data, s[1], max, (l, h) -> l <= x && x < h);
        return 1 + e[0] - s[1];
    }

    private static int[] search(int[] data, int l, int h, Invariant invariant) {
        while (1 < h - l) {
            int m = l + (h - l) / 2;

            int left = l < 0 ? Integer.MIN_VALUE : data[l];
            int right = m >= data.length ? Integer.MAX_VALUE : data[m];

            if (invariant.test(left, right)) {
                h = m;
            } else {
                l = m;
            }
        }

        return new int[]{l, h};
    }

    public static int binarySearch(int[] data, final int x) {

//        if ( data.length == 0 )
//            return -1;
//
        int bounds[] = search(data, -1, data.length, (l, r) -> l <= x && x <= r);

        if ( bounds[0] >= 0 && data[bounds[0]] == x )
            return bounds[0];

        if ( bounds[1] < data.length && data[bounds[1]] == x)
            return bounds[1];

        return -1;
    }
}



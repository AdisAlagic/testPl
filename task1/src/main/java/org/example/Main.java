package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Should be presented 2 int arguments");
        }
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        System.out.println(getArrayPath(n, m));
    }

    public static String getArrayPath(int n, int m) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] arr = createArray(n);
        int first = arr[0];
        int offset = 0;
        int[] tempArr;
        do {
            tempArr = stepInArray(m, offset, arr);
            answer.add(tempArr[0]);
            offset += m - 1;
        } while (tempArr[m - 1] != first);
        StringBuilder builder = new StringBuilder();
        answer.forEach(builder::append);
        answer.clear();
        return builder.toString();
    }

    public static int[] createArray(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Array should be more then 0 size");
        }
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public static int[] stepInArray(int m, int offset, int[] array) {
        int[] result = new int[m];
        for (int i = offset, j = 0; j < m; i++, j++) {
            result[j] = getCycle(i, array);
        }
        return result;
    }

    public static int getCycle(int index, int[] array) {
        final int cachedSize = array.length;
        int realIndex = index;
        while (realIndex >= cachedSize) {
            realIndex -= cachedSize;
        }
        return array[realIndex];
    }
}

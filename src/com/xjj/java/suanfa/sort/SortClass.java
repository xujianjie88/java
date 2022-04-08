package com.xjj.java.suanfa.sort;

import java.util.Arrays;

public class SortClass {

    public static void main(String[] args) {
        int[] array = new int[]{3, 1, 6, 9, 10, 78, 9, 100};
        // ð������
        bubblingSort(array);
        System.out.println(Arrays.toString(array));

        // ���ֲ���
        int index = halveFind(array, array[0], array[array.length - 1], 78);
        System.out.println(index);

    }

    /**
     * ð������
     *
     * @return
     */
    public static int[] bubblingSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * ��������
     *
     * @return
     */
    public static int[] quicklySort(int[] array) {
        //
        return array;
    }

    /**
     * ���ֲ���
     *
     * @return
     */
    public static int halveFind(int[] array, int low, int high, int member) {
        //�Կ�ֵ�����ж�
        if (array == null || low > high) {
            return -1;
        }

        if (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == member) {
                return mid;
            } else if (array[mid] < member) {
                return halveFind(array, mid + 1, high, member);
            } else {
                return halveFind(array, low, mid - 1, member);
            }
        }

        return -1;
    }


}

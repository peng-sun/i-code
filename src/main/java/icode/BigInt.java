package icode;

import java.util.Arrays;

public class BigInt {

    private int[] array;

    public BigInt(int[] array) {this.array = array;}

    public BigInt(long num) {
        if (num == 0) {array = new int[]{0}; return;}

        long tempNum = num;
        int len = 0;
        while (tempNum > 0) {
            tempNum /= 10;
            len++;
        }

        array = new int[len];
        int i = len - 1;
        while (num > 0) {
            array[i] = (int) (num % 10);
            num /= 10;
            i--;
        }
    }

    public void increment() {
        int carryon = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (carryon == 0 && i != array.length - 1) {
                return;
            }

            int cur = array[i] + carryon;
            if (cur >= 10) {
                carryon = 1;
                array[i] = cur - 10;
            } else {
                carryon = 0;
                array[i] = cur;
            }
        }

        if (carryon == 1) {
            int[] temp = array;
            array = new int[temp.length + 1];
            for (int i =  temp.length - 1; i >= 0; i--) {
                array[i + 1] = temp[i];
            }
            array[0] = 1;
        }
    }

    public void add(BigInt bi) {
        int len = Math.max(array.length, bi.array.length);
        int[] temp = new int[len];
        int i = array.length - 1, j = bi.array.length - 1;
        int index = len - 1;
        int carryon = 0;
        while (i >= 0 || j >= 0) {
            int cur = (i < 0 ? 0 : array[i])
                    + (j < 0 ? 0 : bi.array[j])
                    + carryon;

            if (carryon >= 10) {
                carryon = 1;
                temp[index] = cur - 10;
            } else {
                carryon = 0;
                temp[index] = cur;
            }
            i--;
            j--;
            index--;
        }

        if (carryon == 1) {
            array = new int[temp.length + 1];
            for (int k = temp.length - 1; k >= 0; k--) {
                array[k + 1] = temp[k];
            }
            array[0] = 1;
        } else {
            array = new int[temp.length];
            for (int k = temp.length - 1; k >= 0; k--) {
                array[k] = temp[k];
            }
        }

    }

    public void print() {
        System.out.println(Arrays.toString(array));
    }
    public static void main(String[] args) {

        BigInt bi1 = new BigInt(999L);
        bi1.print();
        bi1.increment();
        bi1.print();

        bi1.add(bi1);
        bi1.print();
    }
}

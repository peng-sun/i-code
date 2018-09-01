package icode.iteration;

public class BackspaceStringCompare {
    public static boolean compare(String str1, String str2) {
        int i = str1.length() - 1, j = str2.length() - 1;
        int skip1 = 0, skip2 = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (str1.charAt(i) == '#') {skip1++; i--;}
                else if (skip1 > 0) {i--; skip1--;}
                else break;
            }

            while (j >= 0) {
                if (str2.charAt(j) == '#') {skip2++; j--;}
                else if (skip2 > 0) {j--; skip2--;}
                else break;
            }

            if (i >= 0 && j >= 0 && str1.charAt(i) != str2.charAt(j)) return false;

            if ((i >= 0) != (j >= 0)) return false;

            i--; j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "a#b#";
        String str2 = "ab##";

        System.out.println(compare(str1, str2));
    }
}

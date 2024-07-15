import arraylist.MyArrayList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        MyArrayList<Integer> ar = new MyArrayList<>();
        for (int i = 1; i <= n; i++) {
            ar.add(scan.nextInt());
        }
        ar.bubbleSort(true);
        for (int i = 0; i < n; i++) {
            System.out.println(ar.get(i));
        }
    }
}

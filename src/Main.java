import arraylist.MyArrayList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arList = new ArrayList<>();
        Collections.addAll(arList, 15, 10, 12, 13, 17, 11, 9, 2, 3, 4, 5, 6, 7, 8, 9);

        Vector<Integer> vList = new Vector<>(arList);

        Stack<Integer> stList = new Stack<>();
        stList.addAll(arList);

        LinkedList<Integer> liList = new LinkedList<>(arList);

        MyArrayList<Integer> myArList1 = new MyArrayList<>();
        for (Integer i : arList) {
            myArList1.add(i);
        }

        MyArrayList<Integer> myArList2 = new MyArrayList<>();
        myArList2.addAll(arList);

        MyArrayList<Integer> myArList3 = new MyArrayList<>(arList);

        System.out.print("ArrayList: ");
        sortPrint(arList);

        System.out.print("Vector: ");
        sortPrint(vList);

        System.out.print("Stack: ");
        sortPrint(stList);

        System.out.print("LinkedList: ");
        sortPrint(liList);

        myArList1.bubbleSort();
        System.out.print("MyArrayList inserting with add method: ");
        for (int i = 0; i < myArList1.size(); i++) {
            System.out.print(myArList1.get(i) + " ");
        }
        System.out.println();

        myArList2.bubbleSort();
        System.out.print("MyArrayList inserting with addAll method: ");
        for (int i = 0; i < myArList2.size(); i++) {
            System.out.print(myArList2.get(i) + " ");
        }
        System.out.println();

        myArList3.bubbleSort();
        System.out.print("MyArrayList inserting with MyArrayList constructor: ");
        for (int i = 0; i < myArList2.size(); i++) {
            System.out.print(myArList2.get(i) + " ");
        }
        System.out.println();
    }

    public static <E extends Comparable<E>> void sortPrint(List<E> ar) {
        MyArrayList.bubbleSort(ar);
        for (E i : ar) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

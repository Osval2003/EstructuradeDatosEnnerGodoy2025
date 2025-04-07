package umg.edu.gt.desarrollo.estructuradedatos2025.clases;

import java.util.TreeMap;
import java.util.TreeSet;

public class ClaseArboles {

    // basado en un arbol red-black
    // O(lon n)
    public void TreeSetExample() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(8);
        treeSet.add(1);

        System.out.println(treeSet); // 1 2 5 8

    }

    // basado en un arbol red-black
    // O(lon n)
    public void TreeMapExample() {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Juan", 25);
        treeMap.put("Ana", 28);
        treeMap.put("Carlos", 17);

        System.out.println(treeMap); // { Carlos=17, Juan=25, Ana=28 }

    }

}

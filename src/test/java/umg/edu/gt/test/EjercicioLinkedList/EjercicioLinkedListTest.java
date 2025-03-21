package umg.edu.gt.test.EjercicioLinkedList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioLinkedList;

public class EjercicioLinkedListTest {


    // Problema 1: Test eliminar duplicados
    @Test
    public void testEliminarDuplicados() {
        EjercicioLinkedList ejercicio = new EjercicioLinkedList();
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(1);
        lista.add(2);
        lista.add(2);
        lista.add(3);
        lista.add(3);
        lista.add(3);

        ejercicio.eliminarDuplicados(lista);

        assertEquals(3, lista.size());  // Verificamos que haya solo 3 elementos
        assertTrue(lista.contains(1));
        assertTrue(lista.contains(2));
        assertTrue(lista.contains(3));
    }

    // Problema 2: Test invertir lista
    @Test
    public void testInvertirLista() {
        EjercicioLinkedList ejercicio = new EjercicioLinkedList();
        LinkedList<String> lista = new LinkedList<>();
        lista.add("a");
        lista.add("b");
        lista.add("c");

        ejercicio.invertirLista(lista);

        assertEquals(3, lista.size());  // Verificamos que la lista no haya cambiado de tamaño
        assertEquals("d", lista.get(0)); //Forzamos a que falle, ahi deberia de llevar una letra c
        assertEquals("b", lista.get(1));
        assertEquals("a", lista.get(2));
    }

    // Problema 3: Test intercalar listas
    @Test
    public void testIntercalarListas() {
        EjercicioLinkedList ejercicio = new EjercicioLinkedList();
        LinkedList<Integer> lista1 = new LinkedList<>();
        lista1.add(1);
        lista1.add(4);
        lista1.add(6);

        LinkedList<Integer> lista2 = new LinkedList<>();
        lista2.add(2);
        lista2.add(3);
        lista2.add(5);

        LinkedList<Integer> resultado = ejercicio.intercalarListas(lista1, lista2);


        assertEquals(6, resultado.size());  // Verificamos que el tamaño de la nueva lista sea 6
        assertEquals((Integer) 1, resultado.get(0));
        assertEquals((Integer) 2, resultado.get(1));
        assertEquals((Integer) 3, resultado.get(2));
        assertEquals((Integer) 4, resultado.get(3));
        assertEquals((Integer) 5, resultado.get(4));
        assertEquals((Integer) 6, resultado.get(5));
    }
}
package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.util.LinkedList;

public class EjercicioLinkedList {
	
	/** INSTRUCCIONES
 	Escriba el algoritmo que resuelve el problema en esta clase.
	Debe crear un package llamado umg.edu.gt.test.EjercicioLinkedList que corresponda al Test de esta clase.
	Genere un Test por cada ejemplo y fuerce que uno de esos Test falle, puede implementar retornar un resultado
	y compararlo con el esperado.
	 */
	
	// Usando LinkedList de Java Collections, resuelva los siguientes problemas
	// Problema 1: Dada una LinkedList<Integer>, escribir un método que elimine los valores duplicados, dejando solo la primera aparición de cada número.
	public void eliminarDuplicados(LinkedList<Integer> listaEnteros)
	{
		// Recorremos la lista con dos índices para comparar cada elemento con los siguientes
		for(int i = 0; i < listaEnteros.size(); i++)
		{
			// Comparamos el valor actual con el siguiente
			for(int j = i + 1; j < listaEnteros.size(); j++)
			{
				// Si encontramos un valor duplicado, lo eliminamos
				if(listaEnteros.get(i).equals(listaEnteros.get(j)))
				{
					listaEnteros.remove(j);
					// Ajustamos el índice para continuar la búsqueda sin perder elementos
					j--;
				}
			}
		}
	}
	// Problema 2: Implementar un método que invierta los elementos de una LinkedList<String> sin usar otra lista o ArrayList.
	public void invertirLista(LinkedList<String> listaString)
	{
		int cabeza = 0;  // Índice del primer elemento
		int cola = listaString.size() - 1;  // Índice del último elemento

		// Intercambiamos los elementos mientras cabeza sea menor que cola
		while(cabeza < cola)
		{
			// Guardamos temporalmente el valor en la cabeza
			String temporal = listaString.get(cabeza);
			// Intercambiamos los elementos
			listaString.set(cabeza, listaString.get(cola));
			listaString.set(cola, temporal);

			// Movemos los índices hacia el centro de la lista
			cola--;
			cabeza++;
		}
	}
	// Problema 3: Dadas dos listas enlazadas ordenadas de enteros, escribir un método que devuelva una nueva LinkedList<Integer> con los elementos de ambas listas intercalados en orden.

	public  LinkedList<Integer> intercalarListas(LinkedList<Integer> lista1, LinkedList<Integer> lista2) {
		LinkedList<Integer> resultado = new LinkedList<>(); // Lista donde guardaremos el resultado
		int i1 = 0, i2 = 0;

		// Recorremos ambas listas hasta llegar al final de alguna de ellas
		while (i1 < lista1.size() && i2 < lista2.size()) {
			// Comparamos los elementos de ambas listas y agregamos el menor
			if (lista1.get(i1) <= lista2.get(i2)) {
				resultado.add(lista1.get(i1));  // Agregar el elemento de lista1
				i1++; // Avanzamos en lista1
			} else {
				resultado.add(lista2.get(i2));  // Agregar el elemento de lista2
				i2++; // Avanzamos en lista2
			}
		}

		// Si aún quedan elementos en lista1, los agregamos al resultado
		while (i1 < lista1.size()) {
			resultado.add(lista1.get(i1));
			i1++;
		}

		// Si aún quedan elementos en lista2, los agregamos al resultado
		while (i2 < lista2.size()) {
			resultado.add(lista2.get(i2));
			i2++;
		}

		return resultado; // Devolvemos la lista resultante
	}
}
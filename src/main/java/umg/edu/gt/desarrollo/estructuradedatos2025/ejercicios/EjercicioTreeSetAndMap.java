package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class EjercicioTreeSetAndMap {

    /** INSTRUCCIONES
     Escriba el algoritmo que resuelve el problema en esta clase.
     Debe crear un package llamado umg.edu.gt.test.EjercicioTree que corresponda al Test de esta clase.
     Genere un Test por cada ejemplo y fuerce que uno de esos Test falle, puede implementar retornar un resultado
     y compararlo con el esperado.
     */

	/* EJERCICIO 1: Análisis de Frecuencia de Palabras (TreeMap)
	 * 📜 Descripción: Escriba un programa que lea un texto de un archivo y cuente la frecuencia de cada palabra, ordenándolas alfabéticamente.
		🔹 Instrucciones:
			Leer un archivo de texto (.txt).
			Dividir el texto en palabras (ignorando puntuaciones y convirtiéndolas a minúsculas).
			Almacenar cada palabra en un TreeMap<String, Integer>, donde la clave es la palabra y el valor es el número de veces que aparece.
			Imprimir las palabras en orden alfabético junto con su frecuencia.
	 */



    public static class AnalisisFrecuencia {

        public static void main(String[] args) {
            File archivo = new File("C:\\TxtEjer1\\TxtEjercicio1.txt");
            if (!archivo.exists()) {
                System.out.println("El archivo no existe.");
                return;
            } else {
                System.out.println("El archivo existe.");
            }

            // Llamamos al nuevo método
            Map<String, Integer> resultado = contarFrecuenciaPalabras(archivo);

            // Imprimimos resultado
            for (Map.Entry<String, Integer> entry : resultado.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        // Método para contar la frecuencia de palabras desde un archivo
        public static Map<String, Integer> contarFrecuenciaPalabras(File archivo) {
            TreeMap<String, Integer> frecuenciaPalabras = new TreeMap<>();

            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] palabras = linea.toLowerCase().split("\\W+");

                    for (String palabra : palabras) {
                        if (!palabra.isEmpty()) {
                            frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }

            return frecuenciaPalabras;
        }
    }


	/* EJERCICIO 2: Rastreador de Versiones de Código (TreeMap)
		📜 Descripción: Desarrolle un programa que simule un rastreador de versiones de archivos en un sistema de control de versiones.
		🔹 Instrucciones:
			Utilice un TreeMap<Integer, String>, donde la clave representa el número de versión y el valor es el contenido de esa versión del código.
			Debe permitir:
			Agregar una nueva versión con una clave autoincrementada.
			Obtener una versión específica dada su clave.
			Obtener la última versión disponible.
			Eliminar una versión específica si es necesario.

			Salida:
				Agregar versión 1: "System.out.println('Hola Mundo');"
				Agregar versión 2: "System.out.println('Hola Java');"
				Última versión: "System.out.println('Hola Java');"
				Versión 1: "System.out.println('Hola Mundo');"

	 *
	 */




    public static class RastreadorVersiones {
        private TreeMap<Integer, String> versiones;

        public RastreadorVersiones() {
            // Inicializamos el TreeMap vacío
            versiones = new TreeMap<>();
        }

        // Agregar una nueva versión
        public void agregarVersion(String contenido) {
            // La clave se genera automáticamente como el siguiente número de versión
            int nuevaVersion = versiones.isEmpty() ? 1 : versiones.lastKey() + 1;
            versiones.put(nuevaVersion, contenido);
            System.out.println("Agregar versión " + nuevaVersion + ": \"" + contenido + "\"");
        }

        // Obtener una versión específica por número
        public String obtenerVersion(int numeroVersion) {
            if (versiones.containsKey(numeroVersion)) {
                return "Versión " + numeroVersion + ": \"" + versiones.get(numeroVersion) + "\"";
            } else {
                return "Versión no encontrada.";
            }
        }

        // Obtener la última versión disponible
        public String obtenerUltimaVersion() {
            if (!versiones.isEmpty()) {
                int ultimaClave = versiones.lastKey();
                return "Última versión: \"" + versiones.get(ultimaClave) + "\"";
            } else {
                return "No hay versiones disponibles.";
            }
        }

        // Eliminar una versión específica
        public void eliminarVersion(int numeroVersion) {
            if (versiones.containsKey(numeroVersion)) {
                versiones.remove(numeroVersion);
                System.out.println("Versión " + numeroVersion + " eliminada.");
            } else {
                System.out.println("No se puede eliminar, versión no encontrada.");
            }
        }

        // Mostrar todas las versiones
        public void mostrarTodasLasVersiones() {
            for (Map.Entry<Integer, String> entry : versiones.entrySet()) {
                System.out.println("Versión " + entry.getKey() + ": \"" + entry.getValue() + "\"");
            }
        }

        public static void main(String[] args) {
            // Crear el rastreador de versiones
            RastreadorVersiones rastreador = new RastreadorVersiones();

            // Agregar algunas versiones
            rastreador.agregarVersion("System.out.println('Hola Mundo');");
            rastreador.agregarVersion("System.out.println('Hola Java');");

            // Obtener la última versión
            System.out.println(rastreador.obtenerUltimaVersion());

            // Obtener una versión específica
            System.out.println(rastreador.obtenerVersion(1));

            // Eliminar una versión
            rastreador.eliminarVersion(1);

            // Mostrar todas las versiones después de eliminar
            rastreador.mostrarTodasLasVersiones();
        }
    }


    /** EJERCICIO 3: Sistema de Gestión de Eventos (TreeSet)
     📜 Descripción: Implemente un sistema para administrar eventos ordenados cronológicamente.
     🔹 Instrucciones:
     Utilice un TreeSet<Evento>, donde cada Evento debe contener:
     fecha (LocalDateTime)
     nombre (String)
     ubicación (String)
     Los eventos deben ordenarse automáticamente por fecha y hora.
     Debe permitir:
     Agregar un nuevo evento.
     Mostrar la lista de eventos en orden cronológico.
     Obtener el próximo evento a ocurrir.
     Eliminar un evento pasado automáticamente después de una consulta.

     Salida:
     Próximo evento: "Conferencia de Java", 2025-05-10 10:00, Auditorio A
     Lista de eventos:
     1. "Taller de Machine Learning", 2025-04-15 14:00, Sala 3
     2. "Conferencia de Java", 2025-05-10 10:00, Auditorio A

     */


    public static class  Evento implements Comparable<Evento> {
        private LocalDateTime fecha;
        private String nombre;
        private String ubicacion;

        public Evento(LocalDateTime fecha, String nombre, String ubicacion) {
            this.fecha = fecha;
            this.nombre = nombre;
            this.ubicacion = ubicacion;
        }

        public LocalDateTime getFecha() {
            return fecha;
        }

        public String getNombre() {
            return nombre;
        }

        public String getUbicacion() {
            return ubicacion;
        }

        @Override
        public int compareTo(Evento otroEvento) {
            return this.fecha.compareTo(otroEvento.getFecha());
        }

        @Override
        public String toString() {
            return "\"" + nombre + "\", " + fecha + ", " + ubicacion;
        }
    }

    public static class GestionEventos {
        private TreeSet<Evento> eventos;

        public GestionEventos() {
            eventos = new TreeSet<>();
        }

        // Agregar un nuevo evento
        public void agregarEvento(LocalDateTime fecha, String nombre, String ubicacion) {
            Evento nuevoEvento = new Evento(fecha, nombre, ubicacion);
            eventos.add(nuevoEvento);
            System.out.println("Evento agregado: " + nuevoEvento);
        }

        // Mostrar todos los eventos en orden cronológico
        public void mostrarEventos() {
            System.out.println("Lista de eventos:");
            int contador = 1;
            for (Evento evento : eventos) {
                System.out.println(contador + ". " + evento);
                contador++;
            }
        }

        // Obtener el próximo evento a ocurrir
        public Evento obtenerProximoEvento() {
            Iterator<Evento> iterator = eventos.iterator();
            while (iterator.hasNext()) {
                Evento evento = iterator.next();
                if (evento.getFecha().isAfter(LocalDateTime.now())) {
                    return evento;
                }
            }
            return null;
        }

        // Eliminar eventos pasados
        public void eliminarEventosPasados() {
            Iterator<Evento> iterator = eventos.iterator();
            while (iterator.hasNext()) {
                Evento evento = iterator.next();
                if (evento.getFecha().isBefore(LocalDateTime.now())) {
                    iterator.remove();
                    System.out.println("Evento pasado eliminado: " + evento);
                }
            }
        }

        public static void main(String[] args) {
            // Crear el gestor de eventos
            GestionEventos gestor = new GestionEventos();

            // Agregar algunos eventos
            gestor.agregarEvento(LocalDateTime.of(2025, 4, 15, 14, 0), "Taller de Machine Learning", "Sala 3");
            gestor.agregarEvento(LocalDateTime.of(2025, 5, 10, 10, 0), "Conferencia de Java", "Auditorio A");

            // Mostrar la lista de eventos
            gestor.mostrarEventos();

            // Obtener el próximo evento
            Evento proximoEvento = gestor.obtenerProximoEvento();
            if (proximoEvento != null) {
                System.out.println("Próximo evento: " + proximoEvento);
            } else {
                System.out.println("No hay eventos futuros.");
            }

            // Eliminar eventos pasados
            gestor.eliminarEventosPasados();

            // Mostrar la lista de eventos después de eliminar los pasados
            gestor.mostrarEventos();
        }
    }


}
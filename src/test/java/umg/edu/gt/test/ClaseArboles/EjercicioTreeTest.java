package umg.edu.gt.test.ClaseArboles;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap.AnalisisFrecuencia;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap.RastreadorVersiones;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap.GestionEventos;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap.Evento;

class TestEjercicios {

    // Test para AnalisisFrecuencia (Ejercicio de Frecuencia de Palabras)
    @Test
    void testFrecuenciaPalabras() throws IOException {
        // Crear un archivo temporal para las pruebas
        File tempFile = new File("test.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("Hola mundo, mundo Java, hola.");
        }

        // Ejecutar el análisis de frecuencia
        Map<String, Integer> frecuencia = AnalisisFrecuencia.contarFrecuenciaPalabras(tempFile);

        // Verificar las frecuencias
        assertEquals(2, frecuencia.get("hola"));
        assertEquals(2, frecuencia.get("mundo"));
        assertEquals(1, frecuencia.get("java"));

        // Limpiar el archivo temporal
        tempFile.delete();
    }

    // Test para RastreadorVersiones (Ejercicio de Rastreo de Versiones)
    @Test
    void testRastreoVersiones() {
        // Crear un rastreador de versiones
        RastreadorVersiones rastreador = new RastreadorVersiones();

        // Agregar versiones
        rastreador.agregarVersion("System.out.println('Hola Mundo');");
        rastreador.agregarVersion("System.out.println('Hola Java');");

        // Verificar la última versión
        String ultimaVersion = rastreador.obtenerUltimaVersion();
        assertTrue(ultimaVersion.contains("Hola Java"));

        // Verificar una versión específica
        String version1 = rastreador.obtenerVersion(1);
        assertTrue(version1.contains("Hola Mundo"));

        // Eliminar una versión y verificar
        rastreador.eliminarVersion(1);
        String versionEliminada = rastreador.obtenerVersion(1);
        assertEquals("Versión no encontrada.", versionEliminada);
    }

    // Test para GestionEventos (Ejercicio de Gestión de Eventos)
    @Test
    void testGestionEventos() {
        // Crear gestor de eventos
        GestionEventos gestor = new GestionEventos();

        // Agregar eventos
        gestor.agregarEvento(LocalDateTime.of(2025, 4, 15, 14, 0), "Taller de Machine Learning", "Sala 3");
        gestor.agregarEvento(LocalDateTime.of(2025, 5, 10, 10, 0), "Conferencia de Java", "Auditorio A");

        // Verificar que el próximo evento es el correcto
        Evento proximoEvento = gestor.obtenerProximoEvento();
        assertNotNull(proximoEvento);
        assertEquals("Taller de Machine Learning", proximoEvento.getNombre());

        // Eliminar eventos pasados
        gestor.eliminarEventosPasados();

        // Verificar que el evento pasado fue eliminado
        gestor.mostrarEventos();
    }
}

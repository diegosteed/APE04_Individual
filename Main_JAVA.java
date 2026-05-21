/**
 * ============================================================
 *  APE04 - Clases, Objetos y Métodos
 *  Asignatura : Algoritmos y Lógica de Programación
 *  Carrera    : Software
 *  Docente    : José Ruben Caiza
 * ============================================================
 *  Clase Main – punto de entrada del sistema de control
 *  de estudiantes y calificaciones.
 * ============================================================
 */

import java.util.Scanner;

public class Main {

    // ── Método auxiliar: validar nota (0 – 10) ───────────────
    /**
     * Solicita una nota al usuario y la re-pide mientras
     * esté fuera del rango permitido [0, 10].
     *
     * @param sc      Scanner activo
     * @param mensaje Texto que se muestra al pedir la nota
     * @return        Nota válida ingresada por el usuario
     */
    public static double leerNota(Scanner sc, String mensaje) {
        double nota;
        do {
            System.out.print(mensaje);
            nota = sc.nextDouble();
            if (nota < 0 || nota > 10)
                System.out.println("  ⚠  Nota inválida. Ingrese un valor entre 0 y 10.");
        } while (nota < 0 || nota > 10);
        return nota;
    }

    // ── Método principal ──────────────────────────────────────
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        final int TOTAL = 5;
        Estudiante[] lista = new Estudiante[TOTAL];

        System.out.println("\n=========================================");
        System.out.println("  SISTEMA DE CONTROL DE ESTUDIANTES");
        System.out.println("=========================================\n");

        // ── Ingreso de datos ─────────────────────────────────
        for (int i = 0; i < TOTAL; i++) {
            System.out.println("─── Estudiante " + (i + 1) + " ───────────────────────");

            System.out.print("  Cédula   : ");
            String cedula = sc.next();

            System.out.print("  Nombre   : ");
            String nombre = sc.next();

            System.out.print("  Apellido : ");
            String apellido = sc.next();

            double n1 = leerNota(sc, "  Nota 1  : ");
            double n2 = leerNota(sc, "  Nota 2  : ");
            double n3 = leerNota(sc, "  Nota 3  : ");

            lista[i] = new Estudiante(cedula, nombre, apellido, n1, n2, n3);
            System.out.println();
        }

        // ── Listado completo ─────────────────────────────────
        System.out.println("\n=========================================");
        System.out.println("       LISTADO COMPLETO DE ESTUDIANTES");
        System.out.println("=========================================\n");

        int aprobados = 0, reprobados = 0;

        for (Estudiante e : lista) {
            e.mostrarInfo();
            if (e.getEstado().equals("Aprobado"))
                aprobados++;
            else
                reprobados++;
        }

        // ── Resumen ──────────────────────────────────────────
        System.out.println("\n=========================================");
        System.out.println("  RESUMEN FINAL");
        System.out.println("=========================================");
        System.out.println("  Total estudiantes : " + TOTAL);
        System.out.println("  Aprobados         : " + aprobados);
        System.out.println("  Reprobados        : " + reprobados);
        System.out.println("=========================================\n");

        sc.close();
    }
}

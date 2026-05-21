/**
 * ============================================================
 *  APE04 - Clases, Objetos y Métodos
 *  Asignatura : Algoritmos y Lógica de Programación
 *  Carrera    : Software
 *  Docente    : José Ruben Caiza
 * ============================================================
 *  Clase Estudiante – encapsula los datos y comportamientos
 *  de un estudiante del sistema de calificaciones.
 * ============================================================
 */
public class Estudiante {

    // ── Atributos privados ───────────────────────────────────
    private String cedula;
    private String nombre;
    private String apellido;
    private double nota1;
    private double nota2;
    private double nota3;
    private double promedio;
    private String estado;   // "Aprobado" o "Reprobado"

    // ── Constructor ──────────────────────────────────────────
    /**
     * Crea un Estudiante con sus tres notas y calcula
     * automáticamente promedio y estado.
     */
    public Estudiante(String cedula, String nombre, String apellido,
                      double nota1, double nota2, double nota3) {
        this.cedula   = cedula;
        this.nombre   = nombre;
        this.apellido = apellido;
        this.nota1    = nota1;
        this.nota2    = nota2;
        this.nota3    = nota3;
        calcularPromedio();
        determinarEstado();
    }

    // ── Getters ──────────────────────────────────────────────
    public String getCedula()   { return cedula;   }
    public String getNombre()   { return nombre;   }
    public String getApellido() { return apellido; }
    public double getNota1()    { return nota1;    }
    public double getNota2()    { return nota2;    }
    public double getNota3()    { return nota3;    }
    public double getPromedio() { return promedio; }
    public String getEstado()   { return estado;   }

    // ── Setters ──────────────────────────────────────────────
    public void setCedula(String cedula)     { this.cedula   = cedula;   }
    public void setNombre(String nombre)     { this.nombre   = nombre;   }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
        calcularPromedio();
        determinarEstado();
    }
    public void setNota2(double nota2) {
        this.nota2 = nota2;
        calcularPromedio();
        determinarEstado();
    }
    public void setNota3(double nota3) {
        this.nota3 = nota3;
        calcularPromedio();
        determinarEstado();
    }

    // ── Calcular promedio ────────────────────────────────────
    /**
     * Calcula el promedio de las tres notas y actualiza
     * el atributo correspondiente.
     */
    public void calcularPromedio() {
        this.promedio = (nota1 + nota2 + nota3) / 3.0;
    }

    // ── Determinar estado ────────────────────────────────────
    /**
     * Asigna "Aprobado" si el promedio es >= 7.00,
     * de lo contrario asigna "Reprobado".
     */
    public void determinarEstado() {
        this.estado = (promedio >= 7.00) ? "Aprobado" : "Reprobado";
    }

    // ── Mostrar información ──────────────────────────────────
    /**
     * Imprime en consola todos los datos del estudiante
     * con un formato tabular legible.
     */
    public void mostrarInfo() {
        System.out.println("┌─────────────────────────────────────────┐");
        System.out.printf ("│ Cédula   : %-30s│%n", cedula);
        System.out.printf ("│ Nombre   : %-30s│%n", nombre + " " + apellido);
        System.out.printf ("│ Nota 1   : %-30.2f│%n", nota1);
        System.out.printf ("│ Nota 2   : %-30.2f│%n", nota2);
        System.out.printf ("│ Nota 3   : %-30.2f│%n", nota3);
        System.out.printf ("│ Promedio : %-30.2f│%n", promedio);
        System.out.printf ("│ Estado   : %-30s│%n", estado);
        System.out.println("└─────────────────────────────────────────┘");
    }
}

/*
 * APE04 - Clases, Objetos y Métodos
 * Asignatura: Algoritmos y Logica de Programacion
 * Carrera: Software - Universidad Tecnica de Ambato
 * Docente: Jose Ruben Caiza
 */
#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

class Estudiante {
private:
    string cedula, nombre, apellido;
    double nota1, nota2, nota3;
    double promedio;
    string estado;

public:

    Estudiante(string ced, string nom, string ape,
               double n1, double n2, double n3) {
        cedula=ced; nombre=nom; apellido=ape;
        nota1=n1; nota2=n2; nota3=n3;
        calcularPromedio();
        determinarEstado();
    }

    string getCedula()   { return cedula;   }
    string getNombre()   { return nombre;   }
    double getPromedio() { return promedio; }
    string getEstado()   { return estado;   }

    void setNota1(double n) { nota1=n; calcularPromedio(); determinarEstado(); }
    void setNota2(double n) { nota2=n; calcularPromedio(); determinarEstado(); }
    void setNota3(double n) { nota3=n; calcularPromedio(); determinarEstado(); }

    void calcularPromedio() {
        promedio = (nota1 + nota2 + nota3) / 3.0;
    }

    void determinarEstado() {
        estado = (promedio >= 7.00) ? "Aprobado" : "Reprobado";
    }

    void mostrarInfo() {
        cout << "Cedula  : " << cedula << endl;
        cout << "Nombre  : " << nombre << " " << apellido << endl;
        cout << fixed << setprecision(2);
        cout << "Promedio: " << promedio << endl;
        cout << "Estado  : " << estado  << endl;
        cout << endl;
    }
};


double leerNota(const string& msg) {
    double n;
    do {
        cout << msg; cin >> n;
        if (n < 0 || n > 10) cout << "Nota invalida. Rango permitido: 0 - 10\n";
    } while (n < 0 || n > 10);
    return n;
}

int main() {
    const int TOTAL = 5;
    Estudiante* lista[TOTAL];

    for (int i = 0; i < TOTAL; i++) {
        string ced, nom, ape;
        cout << "Cedula  : "; cin >> ced;
        cout << "Nombre  : "; cin >> nom;
        cout << "Apellido: "; cin >> ape;
        double n1 = leerNota("Nota 1: ");
        double n2 = leerNota("Nota 2: ");
        double n3 = leerNota("Nota 3: ");
        lista[i] = new Estudiante(ced, nom, ape, n1, n2, n3);
    }

    int aprobados = 0, reprobados = 0;
    for (int i = 0; i < TOTAL; i++) {
        lista[i]->mostrarInfo();
        if (lista[i]->getEstado() == "Aprobado") aprobados++;
        else reprobados++;
        delete lista[i];
    }
    cout << "Aprobados : " << aprobados  << endl;
    cout << "Reprobados: " << reprobados << endl;
    return 0;
}

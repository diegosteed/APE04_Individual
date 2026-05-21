Algoritmo Estudiantes_Ape04
	Definir cedula, nombre, apellido Como Cadena
	Definir nota1, nota2, nota3, promedio Como Real
	Definir estado Como Cadena
	Definir i, aprobados, reprobados, total Como Entero
	Escribir 'Ingrese la cantidad de estudiantes: 'Sin Saltar
	Leer total
	aprobados <- 0
	reprobados <- 0
	Para i<-1 Hasta total Con Paso 1 Hacer
		Escribir 'Cedula  : 'Sin Saltar
		Leer cedula
		Escribir 'Nombre  : 'Sin Saltar
		Leer nombre
		Escribir 'Apellido: 'Sin Saltar
		Leer apellido
		Repetir
			Escribir 'Nota 1: 'Sin Saltar
			Leer nota1
		Hasta Que nota1>=0 Y nota1<=10
		Repetir
			Escribir 'Nota 2: 'Sin Saltar
			Leer nota2
		Hasta Que nota2>=0 Y nota2<=10
		Repetir
			Escribir 'Nota 3: 'Sin Saltar
			Leer nota3
		Hasta Que nota3>=0 Y nota3<=10
		promedio <- (nota1+nota2+nota3)/3
		Si promedio>=7 Entonces
			estado <- 'Aprobado'
			aprobados <- aprobados+1
		SiNo
			estado <- 'Reprobado'
			reprobados <- reprobados+1
		FinSi
		Escribir 'Cedula  : ', cedula
		Escribir 'Nombre  : ', nombre, ' ', apellido
		Escribir 'Promedio: ', promedio
		Escribir 'Estado  : ', estado
		Escribir ''
	FinPara
	Escribir 'Aprobados : ', aprobados
	Escribir 'Reprobados: ', reprobados
FinAlgoritmo

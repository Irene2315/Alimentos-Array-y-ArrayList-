package principal;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import clases.Alimento2;

public class Nutriscore_App_Arraylist {
	private static Scanner Scanner;
	Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		final String Nombre_fichero = ("recursos/alimentos");

		ArrayList<Alimento2> alimentosRecibidos = Alimento2.cargarDatos(Nombre_fichero);

		Scanner teclado = new Scanner(System.in);
		final int BUSCAR_ALIMENTO = 1;
		final int MOSTRAR_ALIMENTOS = 2;
		final int CALCULAR_CALORIAS = 3;
		final int SALIR = 0;
		int opcion_menu = 0;

		do {
			System.out.println("------MENU-------");
			System.out.println(BUSCAR_ALIMENTO + ". Buscar alimento");
			System.out.println(MOSTRAR_ALIMENTOS + ". Mostrar alimentos");
			System.out.println(CALCULAR_CALORIAS + ". Calcular calorias");
			System.out.println(SALIR + ". Salir");
			System.out.println("Elije una de las opciones");
			opcion_menu = teclado.nextInt();

			switch (opcion_menu) {
			case BUSCAR_ALIMENTO:
				buscador_alimentos(alimentosRecibidos);
				break;
			case MOSTRAR_ALIMENTOS:
				mostrar_alimentos(alimentosRecibidos);
				break;
			case CALCULAR_CALORIAS:
				calcular_calorias(alimentosRecibidos);
				break;
			case SALIR:
				System.out.println("ADIOS");
				break;
			default:
				System.out.println("Opcion incorrecta!");
			}
			System.out.println("");
		} while (opcion_menu != SALIR);
		teclado.close();

		Alimento2.guardarDatos(Nombre_fichero, alimentosRecibidos);
	}

	public static void buscador_alimentos(ArrayList<Alimento2> alimentos) {
		Scanner = new Scanner(System.in);

		String alimento_usuario;

		boolean figura;
		figura = false;

		System.out.println("Introduce el alimento que quieras buscar");

		alimento_usuario = Scanner.nextLine();
		for (int i = 0; i < alimentos.size(); i++) {
			Alimento2 alimento = alimentos.get(i);

			if (alimento.getNombres().equals(alimento_usuario)) {
				figura = true;

				System.out.println(alimentos.get(i));
			}
		}

		if (figura == false) {
			System.out.println("Este alimento no figura en el registro");
		}
	}

	public static void mostrar_alimentos(ArrayList<Alimento2> alimentos) {
		int posicion;
		int registros;
		Scanner = new Scanner(System.in);

		System.out.println("Introduce la posicion del alimento");
		posicion = Scanner.nextInt();
		System.out.println("Introduce el numero de registros a visualizar");
		registros = Scanner.nextInt();
		for (int i = 0; i < alimentos.size(); i++) {
			if (posicion == i) {
				for (int j = 0; j < alimentos.size(); j++) {
					if (registros != 0) {
						System.out.println(alimentos.get(j));
						
						j = j + 1;
						registros = registros - 1;

					}
				}

			}

		}
			
		}
	

	public static void calcular_calorias(ArrayList<Alimento2> alimentos) {
		String nombre, estado;
		double calorias;
		String nombre_usuario, estado_usuario;
		double gramos_usuario;
		double calorias_totales;
		Scanner = new Scanner(System.in);

		System.out.println("Introduce el nombre del alimento");
		nombre_usuario = Scanner.nextLine();
		System.out.println("Estado del alimento");
		estado_usuario = Scanner.nextLine();
		System.out.println("Introduce los gramos");
		gramos_usuario = Scanner.nextDouble();
		for (int i = 0; i < alimentos.size(); i++) {
			Alimento2 alimento = alimentos.get(i);
			nombre = alimento.getNombres();
			estado = alimento.getEstado();
			calorias = alimento.getCalorias();

			if (nombre.equals(nombre_usuario) && estado.equals(estado_usuario)) {
				calorias_totales = calorias * gramos_usuario;
				System.out.println("Las calorias totales son:" + calorias_totales);
			}

		}
	}
}

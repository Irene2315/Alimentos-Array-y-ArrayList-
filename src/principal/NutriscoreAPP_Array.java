package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import clases.Alimento;

public class NutriscoreAPP_Array {

	private static Scanner Scanner;

	public static void main(String[] args) throws FileNotFoundException {
		final String Nombre_fichero = ("recursos/alimentos");
		Alimento alimentosRecibidos[] = new Alimento[404];

		lectura(alimentosRecibidos, Nombre_fichero);
		// declaracion de constantes (final) para las opciones

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

		guardar(alimentosRecibidos);
	}

	public static void lectura(Alimento[] alimentos, String guardar_Fichero) throws FileNotFoundException {

		File file = new File(guardar_Fichero);
		Scanner scan = new Scanner(file);

		String linea;
		String[] partes;

		int i = 0;
		while (scan.hasNextLine()) {
			linea = scan.nextLine();
			partes = linea.split(";");

			Alimento alimento = new Alimento((partes[0]), (partes[1]), (Double.parseDouble(partes[2])),
					(Double.parseDouble(partes[3])), (Double.parseDouble(partes[4])), (Double.parseDouble(partes[5])),
					(partes[6]));

			alimentos[i] = alimento;
			i = i + 1;
		}
		scan.close();

	}

	public static void buscador_alimentos(Alimento[] Lista_Alimentos) {
		Scanner = new Scanner(System.in);

		String alimento_usuario;
		String nombre_alimento;

		boolean figura;
		figura = false;

		System.out.println("Introduce el alimento que quieras buscar");

		alimento_usuario = Scanner.nextLine();
		for (int i = 0; i < Lista_Alimentos.length; i++) {

			nombre_alimento = Lista_Alimentos[i].getNombres();
			if (nombre_alimento.equals(alimento_usuario)) {
				figura = true;

				System.out.println(Lista_Alimentos[i]);
			}
		}

		if (figura == false) {
			System.out.println("Este alimento no figura en el registro");
		}

	}

	public static void mostrar_alimentos(Alimento[] alimento) {
		int posicion;
		int registros;
		Scanner = new Scanner(System.in);

		System.out.println("Introduce la posicion del alimento");
		posicion = Scanner.nextInt();
		System.out.println("Introduce el numero de registros a visualizar");
		registros = Scanner.nextInt();

		for (int i = 0; i < alimento.length; i++) {
			if (posicion == i) {
				for (int j = 0; j < alimento.length; j++) {
					if (registros != 0) {

						System.out.println(alimento[j]);
						j = j + 1;
						registros = registros - 1;

					}
				}

			}

		}

	}

	public static void calcular_calorias(Alimento[] alimento) {
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
		for (int i = 0; i < alimento.length; i++) {
			nombre = alimento[i].getNombres();
			estado = alimento[i].getEstado();
			calorias = alimento[i].getCalorias();

			if (nombre.equals(nombre_usuario) && estado.equals(estado_usuario)) {
				calorias_totales = calorias * gramos_usuario;
				System.out.println("Las calorias totales son:" + calorias_totales);
			}

		}

	}

	public static void guardar(Alimento[] alimento) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("recursos/alimentos");
		for (int j = 0; j < alimento.length; j++) {
			writer.println(alimento[j].paraFichero());

		}
		System.out.println("Los nuevos cambios han sido guardados con exito!!");
		writer.close();
	}

}

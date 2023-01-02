package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Alimento2 {
	private String nombres;
	private String estado;
	private double calorias;
	private double carbohidratos;
	private double grasas;
	private double proteinas;
	private String tipos;
	
	public Alimento2() {
		
	}
	
	public Alimento2(String nombres,String estado,double calorias,double carbohidratos,double grasas,double proteinas,String tipos) {
		this.nombres=nombres;
		this.estado=estado;
		this.calorias=calorias;
		this.grasas=grasas;
		this.proteinas=proteinas;
		this.tipos=tipos;
		
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getCalorias() {
		return calorias;
	}

	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}

	public double getCarbohidratos() {
		return carbohidratos;
	}

	public void setCarbohidratos(double carbohidratos) {
		this.carbohidratos = carbohidratos;
	}

	public double getGrasas() {
		return grasas;
	}

	public void setGrasas(double grasas) {
		this.grasas = grasas;
	}

	public double getProteinas() {
		return proteinas;
	}

	public void setProteinas(double proteinas) {
		this.proteinas = proteinas;
	}

	public String getTipos() {
		return tipos;
	}

	public void setTipos(String tipos) {
		this.tipos = tipos;
	}

	public String toString() {
		return this.nombres + "-" + this.estado + "-" + this.calorias + "-"
				+ this.carbohidratos + "-" + this.grasas + "-" + this.proteinas + "-" + this.tipos;
	}
	public String paraFichero() { return this.nombres+ ";" + this.estado+";"+ this.calorias+";"
			   +this.carbohidratos+";"+this.grasas+";"+this.proteinas+";"+this.tipos;
		
	}
	
	public static ArrayList<Alimento2> cargarDatos(String Nombre_fichero) throws FileNotFoundException{
		ArrayList<Alimento2> alimentos = new ArrayList<Alimento2>();
		File file = new File(Nombre_fichero);
		
	Scanner lectorFichero= new Scanner (file);
	 String linea;
	 String[] partes;
	 
	 while(lectorFichero.hasNext()) {
		 linea= lectorFichero.nextLine();
		 partes =linea.split(";");
		 
		 Alimento2 alimentos_guardar = new Alimento2 ((partes[0]), (partes[1]), (Double.parseDouble(partes[2])),
					(Double.parseDouble(partes[3])), (Double.parseDouble(partes[4])), (Double.parseDouble(partes[5])),
					(partes[6]));
		         alimentos.add(alimentos_guardar);
	 }
	 lectorFichero.close();
	 return alimentos;
	}
	
	public static void guardarDatos(String Nombre_fichero,ArrayList <Alimento2> alimentos) throws FileNotFoundException {
		PrintWriter writer =new PrintWriter (Nombre_fichero);
		
		for (int i = 0; i < alimentos.size(); i++) {
			writer.println(alimentos.get(i).paraFichero());
		}
		System.out.println("Los nuevos cambios han sido guardados con exito!!");
		writer.close();
	}
	

    
}

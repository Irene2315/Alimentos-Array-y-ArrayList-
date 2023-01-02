package clases;

public class Alimento {

	private String nombres;
	private String estado;
	private double calorias;
	private double carbohidratos;
	private double grasas;
	private double proteinas;
	private String tipos;
	
	public Alimento() {
		
	}
	public Alimento(String nombres,String estado,double calorias,double carbohidratos,double grasas,double proteinas,String tipos) {
		this.nombres=nombres;
		this.estado=estado;
		this.calorias=calorias;
		this.carbohidratos=carbohidratos;
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
	public double getCarbohidatros() {
		return carbohidratos;
	}
	public void setCarbohidatros(double carbohidatros) {
		this.carbohidratos = carbohidatros;
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
		return   this.nombres + "-" + this.estado + "-" + this.calorias + "-"
				+ this.carbohidratos + "-" + this.grasas + "-" + this.proteinas + "-" + this.tipos ;
	}
	public String paraFichero() {
		return this.nombres + ";" +this.estado + ";"+ this.calorias+ ";"
	+this.carbohidratos+ ";"+this.grasas+";"+this.proteinas+";"+ this.tipos;
	}
	
	
	
}

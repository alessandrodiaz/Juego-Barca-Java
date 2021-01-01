
public class Individuo 
{

	
	// Constructor
	public Individuo(String nombre, String idMayuscula, String idMinuscula, String idPresa, int posicion) 
	{
		this.nombre = nombre;
		this.idMayuscula = idMayuscula;
		this.idMinuscula = idMinuscula;
		this.idPresa = idPresa;
		this.posicion = posicion;
	}

	//Consructor sobrecargado
	public Individuo(String nombre, String idMayuscula, String idMinuscula, int posicion)
	{
		this.nombre = nombre;
		this.idMayuscula = idMayuscula;
		this.idMinuscula = idMinuscula;
		this.posicion = posicion;
	}
	
	public String imprimirNombreIndividuo()
	{
		String barraNombre = nombre;
		int espacios = 9 - barraNombre.length();
		for(int num=0; num<espacios; num++)
		{
			barraNombre += " ";
		}
		return barraNombre;
	}
	
	public String nombreIndividuo()
	{
		return nombre;
	}
	
	public String letraMayuscula()
	{
		return idMayuscula;
	}
	
	public String letraMinuscula()
	{
		return idMinuscula;
	}
	
	public String letraPresa()
	{
		return idPresa;
	}
	
	public int posicionIndividuo()
	{
		return posicion;
	}
	
	public void moverIndividuo()
	{
		posicion++;
	}
	
	public void retrocederIndividuo()
	{
		posicion--;
	}
	
	
	private String nombre;
	private String idMayuscula;
	private String idMinuscula;
	private String idPresa;
	private int posicion;
}

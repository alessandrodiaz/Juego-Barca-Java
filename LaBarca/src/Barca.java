//import Lugar;
//import java.util.Vector;
// . *(no)
public class Barca extends Lugar
{

	public Barca(String lugarNombre, int posicion)
	{
		super(lugarNombre);
		//this.individuosEnLugar = individuosEnLugar;
		this.posicion = posicion;
	}

	//Posicion de la barca
	public int posicionBarca()
	{
		return posicion;
	}
	
	public void moverBarca()
	{
		if(posicionBarca()==1)
		{
			posicion++;
		}
		else
		{
			posicion--;
		}
			
	}
	
	public int dimeDondeEstaEnBarca(String id)
	{
		if(this.contadorDeIndividuos()==0)
		{
			return 4; //Posición arbitraria
		}
		else 
		{
			int dondeEsta=4;
			for(int cualIndividuo=0; cualIndividuo < individuosEnLugar.size(); cualIndividuo++)
			{
				if(individuosEnLugar.elementAt(cualIndividuo).letraMayuscula()==id)
				{
					dondeEsta = individuosEnLugar.elementAt(cualIndividuo).posicionIndividuo();
				}
			}
			return dondeEsta;
		}
	}
	
	public String companeroDeBarca()
	{
		String idCompanero = "";
		for(int cualIndividuo=0; cualIndividuo<individuosEnLugar.size(); cualIndividuo++)
		{
			if(individuosEnLugar.elementAt(cualIndividuo).letraMayuscula()!="R")
			{
				idCompanero = individuosEnLugar.elementAt(cualIndividuo).letraMayuscula();
			}
		}
		return idCompanero;
	}
	
	protected int posicion;
}

import java.util.Vector;

public class Lugar 
{
	
	protected String lugarNombre;
	protected Vector <Individuo> individuosEnLugar;
	
	public Lugar(String lugarNombre) 
	{
		this.lugarNombre = lugarNombre;
		individuosEnLugar = new Vector<Individuo>();
	}

	public void agregarEnLugar(Individuo individuo)
	{
		individuosEnLugar.addElement(individuo);
	}
	
	public void borrarDelLugar(Individuo individuo)
	{
		int indice;
		for(int cualIndividuo=0; cualIndividuo<individuosEnLugar.size(); cualIndividuo++)
		{
			
			if(individuosEnLugar.elementAt(cualIndividuo).letraMayuscula()==individuo.letraMayuscula())
			{
				indice = cualIndividuo;
				individuosEnLugar.remove(indice);
			}
		}
	}
	
	public boolean hayMuertosEnLugar()
	{
		boolean estaElRobot=false;
		for(int cualIndividuo=0; cualIndividuo<individuosEnLugar.size(); cualIndividuo++)
		{
			if(individuosEnLugar.elementAt(cualIndividuo).letraMayuscula().equals("R"))
			{
				estaElRobot=true;
			}
		}
		
		if (estaElRobot==true || individuosEnLugar.size()==0)
		{
			return false;
		}
		else 
		{
			boolean declaracionMuertos=false;
			for(int cualIndividuo=0; cualIndividuo<individuosEnLugar.size(); cualIndividuo++)
			{
				for(int individuoAComparar=0; individuoAComparar<individuosEnLugar.size(); individuoAComparar++)
				{
					if(individuosEnLugar.elementAt(cualIndividuo).letraMayuscula()==individuosEnLugar.elementAt(individuoAComparar).letraPresa())
					{
						System.out.println("\n-> El " + individuosEnLugar.elementAt(individuoAComparar).nombreIndividuo() + " ha matado al individuo " + individuosEnLugar.elementAt(cualIndividuo).nombreIndividuo());
						declaracionMuertos = true;
					}
				}
			}
			return declaracionMuertos;
		}
	}
	
	public int contadorDeIndividuos()
	{
		int cantidad = individuosEnLugar.size();
		return cantidad;
	}
	
	
}

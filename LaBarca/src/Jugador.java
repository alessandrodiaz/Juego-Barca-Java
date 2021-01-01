import java.util.Vector;
import java.util.Scanner;

public class Jugador 
{
	//Constructor
	public Jugador(Vector <Individuo> individuos, Barca laBarca, Orilla izquierda, Orilla derecha) 
	{
		this.individuos = individuos;
		this.laBarca = laBarca;
		this.izquierda = izquierda;
		this.derecha = derecha;
	}
	
	public void jugar()
	{
		boolean elJuegoContinua=true;
		while(elJuegoContinua==true)
		{
			String barrasLugares = imprimirBarrasLugares();
			String barrasIndividuos = imprimirBarrasIndividuos();
			System.out.println(barrasLugares);
			System.out.println(barrasIndividuos);
			this.accionJugador();
			if(laBarca.hayMuertosEnLugar()==true || izquierda.hayMuertosEnLugar()==true || derecha.hayMuertosEnLugar()==true)
			{
				System.out.println("\n-> HAS PERDIDO\n");
				elJuegoContinua=false;
			}
			else if(derecha.contadorDeIndividuos()==individuos.size())
			{
				System.out.println("\n-> ¡GANASTE!\n");
				elJuegoContinua=false;
			}	
		}
		System.exit(0);
	}
	
	//TENER CUIDADO CON == EQUALS
	public void accionJugador()
	{
		//@SuppressWarnings("resource")
		System.out.print("¿Qué deseas mover? ");
		Scanner input = new Scanner(System.in);
		String tecladoUsuario = input.nextLine();
		//input.close();	
		//laBarca.moverBarca();
		
		if(tecladoUsuario.equals("B") || tecladoUsuario.equals("b")) {
			if((laBarca.dimeDondeEstaEnBarca("R"))==(laBarca.posicionBarca()))
			{
				if(laBarca.posicionBarca()==1)
				{
					this.comoMoverIndividuo("R", false);
					if(laBarca.contadorDeIndividuos()==2)
					{
						String companiaRobot = "";
						companiaRobot = laBarca.companeroDeBarca();
						this.comoMoverIndividuo(companiaRobot, false);
						laBarca.moverBarca();
					}
					else
					{
						laBarca.moverBarca();
					}
				}
				else if(laBarca.posicionBarca()==2)
				{
					this.comoMoverIndividuo("R", false);
					if(laBarca.contadorDeIndividuos()==2)
					{
						String companiaRobot = "";
						companiaRobot = laBarca.companeroDeBarca();
						this.comoMoverIndividuo(companiaRobot, false);
						laBarca.moverBarca();
					}
					else
					{
						laBarca.moverBarca();
					}
				}
			}
			else
			{
				this.ordenNoValida();
			}
		}
		else
		{
			this.comoMoverIndividuo(tecladoUsuario, true);
		}
	}
	
	public void comoMoverIndividuo(String tecladoUsuario, boolean reversa)
	{
		for(int cualIndividuo=0; cualIndividuo<individuos.size(); cualIndividuo++)
		{
			if(individuos.elementAt(cualIndividuo).letraMayuscula().equals(tecladoUsuario) || individuos.elementAt(cualIndividuo).letraMinuscula().equals(tecladoUsuario))
			{
				if(individuos.elementAt(cualIndividuo).posicionIndividuo()==0)
				{
					if(laBarca.contadorDeIndividuos()==2)
					{
						this.ordenNoValida();
					}
					else if (laBarca.posicionBarca()==1)
					{
						individuos.elementAt(cualIndividuo).moverIndividuo();
						laBarca.agregarEnLugar(individuos.elementAt(cualIndividuo));
						izquierda.borrarDelLugar(individuos.elementAt(cualIndividuo));
					}
					else 
					{
						this.ordenNoValida();
					}
				}
				else if (individuos.elementAt(cualIndividuo).posicionIndividuo()==1)
				{
					if(laBarca.posicionBarca()==1 && reversa==false)
					{
						individuos.elementAt(cualIndividuo).moverIndividuo();
					}
					else if (reversa==true)
					{
						izquierda.agregarEnLugar(individuos.elementAt(cualIndividuo));
						laBarca.borrarDelLugar(individuos.elementAt(cualIndividuo));
						individuos.elementAt(cualIndividuo).retrocederIndividuo();
					}
				}
				else if (individuos.elementAt(cualIndividuo).posicionIndividuo()==2)
				{
					if(laBarca.posicionBarca()==2 && reversa==true)
					{
						derecha.agregarEnLugar(individuos.elementAt(cualIndividuo));
						laBarca.borrarDelLugar(individuos.elementAt(cualIndividuo));
						individuos.elementAt(cualIndividuo).moverIndividuo();
					}
					else if (reversa==false)
					{
						individuos.elementAt(cualIndividuo).retrocederIndividuo();
					}
				}
				else if (individuos.elementAt(cualIndividuo).posicionIndividuo()==3)
				{
					if(laBarca.contadorDeIndividuos()==2)
					{
						this.ordenNoValida();
					}
					else if (laBarca.posicionBarca()==2)
					{
						derecha.borrarDelLugar(individuos.elementAt(cualIndividuo));
						laBarca.agregarEnLugar(individuos.elementAt(cualIndividuo));
						individuos.elementAt(cualIndividuo).retrocederIndividuo();
					}
					else 
					{
						this.ordenNoValida();
					}
				}
				
			}
			else if (!tecladoUsuario.equals("B") && !tecladoUsuario.equals("b") && !tecladoUsuario.equals("R") && !tecladoUsuario.equals("r") && !tecladoUsuario.equals("Z") && !tecladoUsuario.equals("z") && !tecladoUsuario.equals("C") && !tecladoUsuario.equals("c") && !tecladoUsuario.equals("L") && !tecladoUsuario.equals("l"))
			{
				this.ordenNoValida();
			}
		}
		
	}
	
	public void ordenNoValida()
	{
		System.out.println("\n-> POR FAVOR ESCRIBE UNA ORDEN VÁLIDA\n");
		this.jugar();
	}
	
	public String imprimirBarrasLugares()
	{
		String barrasLugares = "";
		if(laBarca.posicionBarca()==1)
		{
			barrasLugares = "| IZQUIERDA |  BARCA    |           |  DERECHA  |"; 
		}
		else if(laBarca.posicionBarca()==2)
		{
			barrasLugares = "| IZQUIERDA |           |  BARCA    |  DERECHA  |";
		}
		return barrasLugares;
	}
	
	public String imprimirBarrasIndividuos()
	{
		String barrasIndividuos = "";
		for(int cualIndividuo = 0; cualIndividuo < individuos.size(); cualIndividuo++)
		{
			for(int lugarContador=0; lugarContador < 4; lugarContador++)
			{
				if(individuos.elementAt(cualIndividuo).posicionIndividuo()==lugarContador)
				{
					barrasIndividuos += "|  " + individuos.elementAt(cualIndividuo).imprimirNombreIndividuo();
					if(lugarContador == 3)
					{
						barrasIndividuos += "|\n";
					}
					else if(lugarContador == 2)
					{
						barrasIndividuos += "|           |\n";
					}
					else if(lugarContador==1)
					{
						barrasIndividuos += "|           |           |\n";
					}
					else if(lugarContador==0)
					{
						barrasIndividuos += "|           |           |           |\n";
					}
					break;				
				}
				else
				{
					barrasIndividuos += "|           ";
				}
			}
		}
		return barrasIndividuos;
	}
	
	private Vector<Individuo> individuos;
	private Barca laBarca;
	private Orilla izquierda;
	private Orilla derecha;

}

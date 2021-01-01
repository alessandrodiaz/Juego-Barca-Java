import java.util.Vector;

// Alt+Shift+Y Wrap 
//import Lugar; 

public class Main {

	public static void main(String[] args) {
		
		Individuo robot = new Individuo("Robot", "R", "r", 0);
		Individuo lechuga = new Individuo("Lechuga", "L", "l", 0);
		Individuo conejo = new Individuo("Conejo", "C", "c", "L", 0);
		Individuo zorro = new Individuo("Zorro", "Z", "z", "C", 0);
		
		//Vector inicial de tamano 4
		Vector <Individuo> individuos = new Vector<Individuo>(4);
		
		individuos.addElement(robot);
		individuos.addElement(lechuga);
		individuos.addElement(conejo);
		individuos.addElement(zorro);
				
		Barca laBarca = new Barca("BARCA", 1);
		Orilla izquierda = new Orilla("IZQUIERDA");
		Orilla derecha = new Orilla("DERECHA");
		Jugador usuario = new Jugador(individuos, laBarca, izquierda, derecha);
		
		izquierda.agregarEnLugar(robot);
		izquierda.agregarEnLugar(lechuga);
		izquierda.agregarEnLugar(conejo);
		izquierda.agregarEnLugar(zorro);
		
		System.out.println("\n··············   JUEGO LA BARCA   ··············\n");
		System.out.println("Tu objetivo es hacer que el robot lleve al zorro,\nconejo  y lechuga  a la  orilla  derecha sin que\nninguno  de ellos muera: El zorro mata al conejo\ny el conejo se come a la lechuga. \n \nLas instrucciones son: \n- Presiona la letra  inicial del Individuo para\n  subirlo a la barca. \n- Se aconseja que para bajar un individuo de la\n  barca, primero bajar al robot para evitar que\n  un individuo muera.\n\n ");
		
		//Inicia el juego
		usuario.jugar();
		
	}
}
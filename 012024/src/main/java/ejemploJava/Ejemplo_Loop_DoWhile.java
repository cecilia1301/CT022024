package ejemploJava;

public class Ejemplo_Loop_DoWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int b = 10;
		
		do {
			//Este codigo dentro del "Do" se imprime incluso si la condicion del while es falsa
			System.out.println("El valor de B es: " + b);
			b++;
		}while(b <= 20);

	}

}
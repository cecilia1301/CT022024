package ejemploJava;

public class Ejemplo_Array_Unidimensional {

	public static void main(String[] args) {
		// Ejemplo de declaracion de arreglos
		
		int intArray[];
		int [] intarray2;
		double doublearray[];
		
		//Declarar un arreglo de strings
		String [] arr;
		
		//Asignar memoria para 5 strings
		arr = new String[5];
		
		//Inicializar el primer elemento del arreglo
		arr[0] = "cero";
		
		//Inicializar el segundo elemento del arreglo
		arr[1] = "uno";
		
		arr[2] = "dos";
		arr[3] = "tres";
		arr[4] = "cuatro";
		
		//Ejemplo de imprimir cada posicion del arreglo individualmente
		//System.out.println("La posicion del arreglo es: " + arr[0]);
		//System.out.println("La posicion del arreglo es: " + arr[1]);
		//System.out.println("La posicion del arreglo es: " + arr[2]);
		//System.out.println("La posicion del arreglo es: " + arr[3]);
		System.out.println("La posicion del arreglo es: " + arr[4]);
		System.out.println();
		
		for(int i = 0; i < arr.length; i++) {  //arr.lenght calcula la longitud del arreglo en un tipo de dato int
			System.out.println("Elemento en el indice " + i + ": " + arr[i] );
		}
		//Ejemplo de arreglo con enteros
		int[] intArr = new int[] {1,2,3,4,5,6,7,8};

	}

}

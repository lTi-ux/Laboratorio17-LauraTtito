import java.util.*;
public class Mapa {
	private Soldado[][] tablero;
	private List<Ejercito> ejercicios;
	private String tipoTerritorio;
	private final int filaMax = 10;
	private final int columnaMax = 10;
	
	public Mapa() {
		this.tablero = new Soldado[filaMax][columnaMax];
		this.ejercitos = new ArrayList<>();
		this.tipoTerritorio = generarTerritorio();
	}
	private String generarTerritorio() {
		 String[] territorios = {"Bosque", "Campo Abierto", "Montaña", "Desierto", "Playa"};
	        Random rand = new Random();
	        return territorios[rand.nextInt(territorios.length)];
	    }

	    public void generarEjercitos() {
	        // Crear dos reinos
	        Reino reino1 = new Reino("Inglaterra");
	        Reino reino2 = new Reino("Francia");

	        // Crear los ejércitos
	        Ejercito ejercito1 = new Ejercito(reino1, 1);
	        Ejercito ejercito2 = new Ejercito(reino2, 2);

	        // Crear soldados
	        for (int i = 0; i < 10; i++) {
	            Soldado soldado = new Soldado(i + 1, "Soldado" + (i + 1), new Random().nextInt(5) + 1,
	                    new Random().nextInt(5) + 1, new Random().nextInt(5) + 1, new Random().nextInt(3) + 1);
	            ejercito1.agregarSoldado(soldado);
	        }
	        for (int i = 0; i < 10; i++) {
	            Soldado soldado = new Soldado(i + 1, "Soldado" + (i + 1), new Random().nextInt(5) + 1,
	                    new Random().nextInt(5) + 1, new Random().nextInt(5) + 1, new Random().nextInt(3) + 1);
	            ejercito2.agregarSoldado(soldado);
	        }

	        // Añadir los ejércitos al mapa
	        ejercitos.add(ejercito1);
	        ejercitos.add(ejercito2);
	    }

	    public void posicionarEjercitos() {
	        Random rand = new Random();
	        for (Ejercito ejercito : ejercitos) {
	            for (Soldado soldado : ejercito.getSoldados()) {
	                int fila, columna;
	                do {
	                    fila = rand.nextInt(filaMax);
	                    columna = rand.nextInt(columnaMax);
	                } while (tablero[fila][columna] != null);  // Verificamos que no haya un soldado en esa posición
	                tablero[fila][columna] = soldado;
	            }
	        }
	    }

	    public void mostrarMapa() {
	        System.out.println("Territorio: " + tipoTerritorio);
	        System.out.print("    ");
	        for (char c = 'A'; c <= 'J'; c++) {
	            System.out.print(" " + c + " ");
	        }
	        System.out.println();
	        for (int i = 0; i < filaMax; i++) {
	            System.out.print(i + 1 + " | ");
	            for (int j = 0; j < columnaMax; j++) {
	                if (tablero[i][j] == null) {
	                    System.out.print("  - ");
	                } else {
	                    System.out.print(" " + tablero[i][j].toString().charAt(0) + " ");
	                }
	            }
	            System.out.println();
	        }
	    }

	    // Implementación de las batallas y otras funcionalidades vendrán aquí...
	}
	}
}

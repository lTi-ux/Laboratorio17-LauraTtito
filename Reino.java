
import java.util.*;

public class Reino {
    private String nombre;
    private Map<String, Boolean> bonusTerritorio;

    public Reino(String nombre) {
        this.nombre = nombre;
        this.bonusTerritorio = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    // Establece los bonos para el reino en función del territorio
    public void asignarBonus(String territorio) {
        switch (territorio) {
            case "Bosque":
                if (nombre.equals("Inglaterra") || nombre.equals("Sacro Imperio Romano-Germánico")) {
                    bonusTerritorio.put("Bosque", true);
                }
                break;
            case "Campo Abierto":
                if (nombre.equals("Francia") || nombre.equals("Sacro Imperio Romano-Germánico")) {
                    bonusTerritorio.put("Campo Abierto", true);
                }
                break;
            case "Montaña":
                if (nombre.equals("Castilla-Aragón")) {
                    bonusTerritorio.put("Montaña", true);
                }
                break;
            case "Desierto":
                if (nombre.equals("Moros")) {
                    bonusTerritorio.put("Desierto", true);
                }
                break;
            case "Playa":
                if (nombre.equals("Sacro Imperio Romano-Germánico")) {
                    bonusTerritorio.put("Playa", true);
                }
                break;
        }
    }

    public boolean tieneBonus(String territorio) {
        return bonusTerritorio.containsKey(territorio);
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transformador {
    
    // Clase interna para representar el objeto transformado
    static class Persona {
        String id;
        String nombre;
        int edad;
        
        Persona(String id, String nombre, int edad) {
            this.id = id;
            this.nombre = nombre;
            this.edad = edad;
        }
        
        @Override
        public String toString() {
            return "{ id: \"" + id + "\", nombre: \"" + nombre + "\", edad: " + edad + " }";
        }
    }
    
    public static List<Persona> transformar(Map<String, Object> data) {
        List<Persona> output = new ArrayList<>();
        
        // Obtener los arrays del mapa
        List<String> nombres = (List<String>) data.get("nombres");
        List<Integer> edades = (List<Integer>) data.get("edades");
        
        // Validar que los arrays existan y tengan la misma longitud
        if (nombres == null || edades == null || nombres.size() != edades.size()) {
            throw new IllegalArgumentException("Los arrays de nombres y edades deben existir y tener la misma longitud");
        }
        
        // Transformar los datos
        for (int i = 0; i < nombres.size(); i++) {
            String id = String.valueOf(i + 1);  // id empieza desde 1
            String nombre = nombres.get(i);
            int edad = edades.get(i);
            
            output.add(new Persona(id, nombre, edad));
        }
        
        return output;
    }
    
    public static void main(String[] args) {
        // Crear el objeto data
        Map<String, Object> data = new HashMap<>();
        
        List<String> nombres = new ArrayList<>();
        nombres.add("Bruno");
        nombres.add("Andrea");
        
        List<Integer> edades = new ArrayList<>();
        edades.add(20);
        edades.add(19);
        
        data.put("nombres", nombres);
        data.put("edades", edades);
        
        // Transformar
        List<Persona> resultado = transformar(data);
        
        // Mostrar resultado
        System.out.println("[");
        for (int i = 0; i < resultado.size(); i++) {
            System.out.print("  " + resultado.get(i));
            if (i < resultado.size() - 1) {
                System.out.println(",");
            } else {
                System.out.println();
            }
        }
        System.out.println("]");
        
        // Más ejemplos
        System.out.println("\n--- Otro ejemplo ---");
        Map<String, Object> data2 = new HashMap<>();
        
        List<String> nombres2 = new ArrayList<>();
        nombres2.add("Juan");
        nombres2.add("María");
        nombres2.add("Carlos");
        
        List<Integer> edades2 = new ArrayList<>();
        edades2.add(25);
        edades2.add(30);
        edades2.add(22);
        
        data2.put("nombres", nombres2);
        data2.put("edades", edades2);
        
        List<Persona> resultado2 = transformar(data2);
        for (Persona p : resultado2) {
            System.out.println(p);
        }
    }
}
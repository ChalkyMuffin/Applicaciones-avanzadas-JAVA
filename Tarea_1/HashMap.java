import java.util.LinkedHashMap;
import java.util.Map;

public class HashMap {
    public static void main(String[] args) {
        // Se declara como Map, pero se instancia como LinkedHashMap
        Map<String, Integer> edades = new LinkedHashMap<>();

        //  1. Agregar elementos (put)
        edades.put("Juan", 25);
        edades.put("María", 30);
        edades.put("Pedro", 22);

        //  Obtener valor por clave (get)
        System.out.println("Edad de María: " + edades.get("María")); // 30

        //  Verificar si existe una clave (containsKey)
        if (edades.containsKey("Juan")) {
            System.out.println("Juan está en el mapa.");
        }

        // Verificar si existe un valor (containsValue)
        if (edades.containsValue(22)) {
            System.out.println("Alguien tiene 22 años.");
        }

        //  Eliminar un elemento (remove)
        edades.remove("Pedro");

        //  Obtener el número de elementos (size)
        System.out.println("Total de personas: " + edades.size());

        //  Recorrer claves (keySet)
        System.out.println("Claves:");
        for (String nombre : edades.keySet()) {
            System.out.println(nombre);
        }

        // Recorrer valores (values)
        System.out.println("Valores:");
        for (Integer edad : edades.values()) {
            System.out.println(edad);
        }

        // Recorrer pares clave-valor (entrySet)
        System.out.println("Entradas:");
        for (Map.Entry<String, Integer> entrada : edades.entrySet()) {
            System.out.println(entrada.getKey() + " => " + entrada.getValue());
        }

        //  Reemplazar un valor (replace)
        edades.replace("María", 31);
        System.out.println("Nueva edad de María: " + edades.get("María"));

        // Limpiar todos los elementos (clear)
        edades.clear();
        System.out.println("¿Está vacío? " + edades.isEmpty()); // true
    }
}

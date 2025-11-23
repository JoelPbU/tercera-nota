public class Palindromos {
    
    public static boolean esPalindromo(String str) {
        // Convertir a minúsculas y remover acentos
        str = cleanUp(str.toLowerCase());
        
        // Remover espacios y caracteres especiales (mantener solo letras y números)
        str = str.replaceAll("[^a-z0-9]", "");
        
        // Si está vacío, se considera palíndromo
        if (str.isEmpty()) {
            return true;
        }
        
        // Comparar la cadena con su inversa
        String invertida = new StringBuilder(str).reverse().toString();
        return str.equals(invertida);
    }
    
    private static String cleanUp(String str) {
        // Remover acentos
        return str.replaceAll("[áàäâã]", "a")
                  .replaceAll("[éèëê]", "e")
                  .replaceAll("[íìïî]", "i")
                  .replaceAll("[óòöôõ]", "o")
                  .replaceAll("[úùüû]", "u")
                  .replaceAll("[ý]", "y")
                  .replaceAll("[ñ]", "n");
    }
    
    public static void main(String[] args) {
        // Números palindrómicos
        System.out.println("=== Números ===");
        System.out.println(esPalindromo("232"));        // true
        System.out.println(esPalindromo("110011"));     // true
        System.out.println(esPalindromo("54322345"));   // true
        System.out.println(esPalindromo("123"));        // false
        
        // Palabras palindrómicas
        System.out.println("\n=== Palabras ===");
        System.out.println(esPalindromo("ama"));        // true
        System.out.println(esPalindromo("radar"));      // true
        System.out.println(esPalindromo("nivel"));      // true
        System.out.println(esPalindromo("hello"));      // false
        System.out.println(esPalindromo("java"));       // false
        
        // Frases palindrómicas (ignorando espacios y acentos)
        System.out.println("\n=== Frases ===");
        System.out.println(esPalindromo("Ama la mala"));      // true
        System.out.println(esPalindromo("La ruta nos aporta utilidad y todo lo demás es una fila de números"));  // false
        System.out.println(esPalindromo("Oso"));              // true
        System.out.println(esPalindromo("Año"));              // true
        System.out.println(esPalindromo("A man a plan a canal Panama"));  // true (palíndromo inglés clásico)
        
        // Casos especiales
        System.out.println("\n=== Casos Especiales ===");
        System.out.println(esPalindromo(""));          // true (vacío)
        System.out.println(esPalindromo("a"));         // true (una letra)
        System.out.println(esPalindromo("11"));        // true
        System.out.println(esPalindromo("121"));       // true
    }
}
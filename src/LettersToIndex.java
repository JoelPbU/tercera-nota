public class LettersToIndex {
    
    public static String convertLettersToIndex(String str) {
        // Clean up del string: eliminar acentos, espacios y caracteres especiales
        str = cleanUp(str);
        
        // Convertir a minúsculas
        str = str.toLowerCase();
        
        // StringBuilder para construir el resultado
        StringBuilder result = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                // Obtener el índice en el alfabeto (A/a = 1, B/b = 2, etc.)
                int index = c - 'a' + 1;
                result.append(index);
            }
        }
        
        return result.toString();
    }
    
    private static String cleanUp(String str) {
        // Remover acentos
        str = str.replaceAll("[áàäâã]", "a")
                 .replaceAll("[éèëê]", "e")
                 .replaceAll("[íìïî]", "i")
                 .replaceAll("[óòöôõ]", "o")
                 .replaceAll("[úùüû]", "u")
                 .replaceAll("[ý]", "y")
                 .replaceAll("[ñ]", "n");
        
        // Remover espacios y caracteres especiales (mantener solo letras)
        str = str.replaceAll("[^a-zA-Z]", "");
        
        return str;
    }
    
    public static void main(String[] args) {
        // Ejemplos de uso
        System.out.println(convertLettersToIndex("ABC"));                    // 123
        System.out.println(convertLettersToIndex("Hello"));                  // 85121215
        System.out.println(convertLettersToIndex("The Quick Brown Fox"));   // 2085171921311223151423614215
        System.out.println(convertLettersToIndex("a b c"));                  // 123
        System.out.println(convertLettersToIndex("Café"));                   // 31615
        System.out.println(convertLettersToIndex("Python 3"));               // 161625201514
        System.out.println(convertLettersToIndex(""));                       // (vacío)
    }
}
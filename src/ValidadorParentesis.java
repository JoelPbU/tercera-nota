public class ValidadorParentesis {
    
    public static boolean esValido(String str) {
        // Si el string está vacío, es válido
        if (str == null || str.isEmpty()) {
            return true;
        }
        
        // Contador de paréntesis abiertos
        int contador = 0;
        
        for (char c : str.toCharArray()) {
            if (c == '(') {
                // Incrementar contador cuando encontramos un paréntesis abierto
                contador++;
            } else if (c == ')') {
                // Decrementar contador cuando encontramos un paréntesis cerrado
                contador--;
                
                // Si el contador es negativo, hay más paréntesis cerrados que abiertos
                if (contador < 0) {
                    return false;
                }
            }
            // Ignorar otros caracteres
        }
        
        // Al final, el contador debe ser 0 (todos los paréntesis están balanceados)
        return contador == 0;   
    }
    
    public static void main(String[] args) {
        // Ejemplos válidos
        System.out.println("=== Válidos ===");
        System.out.println(esValido("()"));                    // true
        System.out.println(esValido("(())((()())())"));        // true
        System.out.println(esValido("(()())"));                // true
        System.out.println(esValido("((()))"));                // true
        System.out.println(esValido(""));                      // true
        System.out.println(esValido("()()()"));                // true
        
        // Ejemplos inválidos
        System.out.println("\n=== Inválidos ===");
        System.out.println(esValido(")(()))")); // false
        System.out.println(esValido("("));                     // false
        System.out.println(esValido(")"));                     // false
        System.out.println(esValido("())"));                   // false
        System.out.println(esValido("((("));                   // false
        System.out.println(esValido(")))"));                   // false
        System.out.println(esValido(")("));                    // false
        
        // Con otros caracteres (los ignora)
        System.out.println("\n=== Con otros caracteres ===");
        System.out.println(esValido("(hello)"));               // true
        System.out.println(esValido("(a(b)c)"));               // true
        System.out.println(esValido("(a(b)c"));                // false
    }
}
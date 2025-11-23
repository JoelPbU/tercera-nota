public class StringEndsWith {
    
    public static boolean endsWith(String str, String ending) {
        return str.endsWith(ending);
    }
    
    public static void main(String[] args) {
        // Ejemplos de uso
        System.out.println(endsWith("abc", "bc"));      // true
        System.out.println(endsWith("abc", "d"));       // false
        System.out.println(endsWith("hello", "lo"));    // true
        System.out.println(endsWith("hello", "he"));    // false
        System.out.println(endsWith("test", "st"));     // true
        System.out.println(endsWith("code", ""));       // true
    }
}
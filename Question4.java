import java.util.Arrays;

public class Question4 {

    public static void main(String[] args) {
        String text = "  Hello Java World  ";
        String word = "Java";
        String sameWord = "Java";

        System.out.println("===== STRING METHODS =====");
        System.out.println("Original string: [" + text + "]");
        System.out.println("length(): " + text.length());
        System.out.println("isEmpty(): " + text.isEmpty());
        System.out.println("charAt(2): " + text.charAt(2));
        System.out.println("toString(): " + text.toString());
        System.out.println("equals(): " + word.equals(sameWord));
        System.out.println("compareTo(): " + word.compareTo(sameWord));
        System.out.println("contains(\"Java\"): " + text.contains("Java"));
        System.out.println("indexOf(\"Java\"): " + text.indexOf("Java"));
        System.out.println("lastIndexOf('a'): " + text.lastIndexOf('a'));
        System.out.println("startsWith(\"  \"): " + text.startsWith("  "));
        System.out.println("endsWith(\"  \"): " + text.endsWith("  "));
        System.out.println("matches(\"[A-Za-z]+\"): "
                + word.matches("[A-Za-z]+"));
        System.out.println("substring(2, 7): " + text.substring(2, 7));
        System.out.println("toLowerCase(): " + text.toLowerCase());
        System.out.println("trim(): [" + text.trim() + "]");
        System.out.println("replace(): " + text.replace("Java", "Python"));

        String sentence = "Java is easy";
        String[] words = sentence.split(" ");
        System.out.println("split(): " + Arrays.toString(words));
        System.out.println("join(): " + String.join("-", words));
        System.out.println("valueOf(12345): " + String.valueOf(12345));

        System.out.println("\\n===== STRINGBUFFER METHODS =====");
        StringBuffer buffer = new StringBuffer("Hello");
        buffer.append(" Java");
        System.out.println("append(): " + buffer);
        buffer.insert(5, " Beautiful");
        System.out.println("insert(): " + buffer);
        buffer.replace(0, 5, "Hi");
        System.out.println("replace(): " + buffer);
        buffer.delete(0, 3);
        System.out.println("delete(): " + buffer);
        buffer.reverse();
        System.out.println("reverse(): " + buffer);

        System.out.println("\\n===== STRINGBUILDER METHODS =====");
        StringBuilder builder = new StringBuilder("Hello");
        builder.append(" Java");
        System.out.println("append(): " + builder);
        builder.insert(5, " World");
        System.out.println("insert(): " + builder);
        builder.replace(0, 5, "Hi");
        System.out.println("replace(): " + builder);
        builder.delete(0, 3);
        System.out.println("delete(): " + builder);
        builder.reverse();
        System.out.println("reverse(): " + builder);
    }
}

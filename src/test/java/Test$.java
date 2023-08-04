import io.github.alexKitC.tool.$;

/**
 * @author alex
 * @version 1.0.0
 * @since 2023-08-04 11:02
 */
public class Test$ {
    public static void main(String[] args) {
        String str1 = $.format("I'm %s ^.^", "alex");
        String str2 = $.concatUnSafe("I'm ", "alex");
        String str3 = $.appendPrefix("alex", "I'm ");
        String str4 = $.appendSuffix("I'm ", "alex");
        String str5 = $.repeat("ha ", 3);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
    }
}

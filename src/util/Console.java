/**
 *
 * @author Lucas Oliveira
 */

package util;
import java.io.IOException;


public class Console {
    public static void clear(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls")
                    .inheritIO()
                    .start()
                    .waitFor();
            } 
            else {
                new ProcessBuilder("clear")
                    .inheritIO()
                    .start()
                    .waitFor();
            }
        } 
        catch (IOException | InterruptedException e) {
            System.out.println("Não foi possível limpar o console.");
        }
    }
}

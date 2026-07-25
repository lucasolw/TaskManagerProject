/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.io.IOException;

/**
 *
 * @author lucas
 */
public class Console {
    public static void clear(){ //Só funciona .jar executado no CMD
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

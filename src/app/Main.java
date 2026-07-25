
package app;
import java.util.Scanner;
import controller.TaskManager;
import view.TaskView;

/**
 *
 * @author Lucas Oliveira
 */

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        TaskView view = new TaskView(manager, sc);
        
        view.iniciar();
        
    }
}

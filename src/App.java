import javax.swing.JOptionPane;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] name = new String[1];
        String[] phone = new String[1];
        char op;

        for(int i = 0; i < name.length; i++) {
            System.out.println("Enter your name :");
            name[i] = input.nextLine();

        }

        for(int a = 0; a < phone.length; a++) {
            System.out.println("Enter phone number :");
            phone[a] = input.nextLine();

            if (phone[a].matches("\\d{10}")) {
                System.out.println("Valid phone");
            } else {
                System.out.println("Invalid phone");
                return;
            }
            

        }

        System.out.println("Select case type");
        System.out.println("1 - Emergency situation\n" + "\n" +  "2 - Normal situation");
        op = input.nextLine().charAt(0);

        switch (op) {
            case '1':
                System.out.println("sss");
                break;

            case '2':
                System.out.println("2222");
                break;
        }

        
        




        

       

        
    }
}

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] name = new String[1];
        String[] phone = new String[1];
        char op;

        System.out.println("==== Emergency Aid Request System ====");

        for (int i = 0; i < name.length; i++) { // ادخال الإسم 
            System.out.println("Enter your name :");
            name[i] = input.nextLine();
        }

        for (int a = 0; a < phone.length; a++) { // ادخال رقم الهاتف ويجب ان يكون 10 ارقام 
            System.out.println("Enter phone number :");
            phone[a] = input.nextLine();

            boolean Phone = phone[a].matches("\\d{10}");
            boolean Name = !name[0].trim().isEmpty(); // ادخال الاسم يجب ان يكون ليس فارغ 

            if (Phone && Name) {
                System.out.println("Requester accepted");
            } else {
                System.out.println("Requester rejected");
                return;
            }
        }

        System.out.println("Select case type");
        System.out.println("1 - medical condition\n\n2 - natural disaster situation\n\n3 - security situation");
        op = input.nextLine().charAt(0);
        

        switch (op) { // قائمة اختيار 
            case '1':
                System.out.println("An ambulance will be dispatched...");
                break;
            case '2':
                System.out.println("The request has been sent ...");
                break;
            case '3':
                System.out.println("");
                break;
        }
    }
}

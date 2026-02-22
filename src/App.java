import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] name = new String[1];
        String[] phone = new String[1];
        char op;

        System.out.println("==== Emergency Aid Request System ====");
//user, 2 conditions
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
                input.close();
                return;
            }
        }
//request, 2 conditions
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
                System.out.println("Security team will be notified...");
                break;
            default:
                System.out.println("Request Rejected");
                input.close();
                return;
        }

        System.out.println("Is the case urgent? Enter 1 for urgent, 2 for non urgent");
        int urgency = Integer.parseInt(input.nextLine()); // (syntax fix)

        if (urgency == 1) {
            System.out.println("The request has been sent ...");
        }
        if (urgency != 1) { // (syntax fix)
            System.out.println("Request Rejected");
            input.close();
            return;
        }

// ALERT, 2 conditions (new category)
        System.out.println("Do you want to send an alert? Enter 1 for yes, 2 for no");
        int alertOp = Integer.parseInt(input.nextLine());

        System.out.println("Enter your location :");
        String location = input.nextLine();

        // condition 1: alert choice must be 1 or 2
        // condition 2: location must not be empty (independent from responder)
        if ((alertOp == 1 || alertOp == 2) && !location.trim().isEmpty()) {
            if (alertOp == 1) {
                System.out.println("Alert sent with location: " + location);
            } else {
                System.out.println("No alert sent.");
            }
        } else {
            System.out.println("Request Rejected");
            input.close();
            return;
        }

// Responder, 2 conditions
        System.out.println("Is there capacity to accept this request?");
        System.out.println("Enter 1 to accept, 2 to reroute");
        int availability = Integer.parseInt(input.nextLine()); // (syntax fix)

        if (availability == 1) {
            System.out.println("Responders have been dispatched");
        }
        if (availability != 1) { // (syntax fix)
            System.out.println("Request has been rerouted");
            input.close();
            return;
        }

        // second responder condition (independent input)
        System.out.println("How many responders are needed? (1 to 5)");
        int respondersNeeded = Integer.parseInt(input.nextLine());

        if (respondersNeeded >= 1 && respondersNeeded <= 5) {
            System.out.println("Responders needed recorded: " + respondersNeeded);
        } else {
            System.out.println("Request Rejected");
            input.close();
            return;
        }

        input.close();
    }
}
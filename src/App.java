import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {

        System.out.println("==== Emergency Aid Request System ====");

//user, 2 conditions
        String ageStr = JOptionPane.showInputDialog("Enter your age :");
        String phoneInput = JOptionPane.showInputDialog("Enter phone number :");

        if (validateUser(ageStr, phoneInput)) {
            System.out.println("Requester accepted");
        } else {
            System.out.println("Requester rejected");
            return;
        }

//request, 2 conditions
        String opStr = JOptionPane.showInputDialog("Select case type\n1 - medical condition\n2 - natural disaster situation\n3 - security situation");
        char op = (opStr != null && !opStr.isEmpty()) ? opStr.charAt(0) : '0';

        processCaseType(op);

        String urgencyStr = JOptionPane.showInputDialog("Is the case urgent? Enter 1 for urgent, 2 for non urgent");
        if (!validateUrgency(urgencyStr)) {
            System.out.println("Request Rejected");
            return;
        }

// ALERT, 2 conditions (new category)
        String alertStr = JOptionPane.showInputDialog("Do you want to send an alert? Enter 1 for yes, 2 for no");
        String location = JOptionPane.showInputDialog("Enter your location :");

        if (validateAlert(alertStr, location)) {
            int alertOp = Integer.parseInt(alertStr);
            if (alertOp == 1) {
                System.out.println("Alert sent with location: " + location);
            } else {
                System.out.println("No alert sent.");
            }
        } else {
            System.out.println("Request Rejected");
            return;
        }

// Responder, 2 conditions
        String availabilityStr = JOptionPane.showInputDialog("Is there capacity to accept this request?\nEnter 1 to accept, 2 to reroute");
        
        if (validateAvailability(availabilityStr)) {
            System.out.println("Responders have been dispatched");
        } else {
            System.out.println("Request has been rerouted");
            return;
        }

        String respondersStr = JOptionPane.showInputDialog("How many responders are needed? (1 to 5)");
        if (validateRespondersCount(respondersStr)) {
            System.out.println("Responders needed recorded: " + respondersStr);
        } else {
            System.out.println("Request Rejected");
            return;
        }

        // الميثود الثامنة: التأكيد النهائي
        finalizeRequest();
    }

    // 1. ميثود: ادخال العمر ويجب ان يكون رقم وادخال رقم الهاتف ويجب ان يكون 10 ارقام 
    public static boolean validateUser(String age, String phone) {
        try {
            int ageVal = Integer.parseInt(age);
            return ageVal > 0 && phone != null && phone.matches("\\d{10}");
        } catch (Exception e) {
            return false;
        }
    }

    // 2. ميثود: قائمة اختيار 
    public static void processCaseType(char op) {
        switch (op) {
            case '1': System.out.println("An ambulance will be dispatched..."); break;
            case '2': System.out.println("The request has been sent ..."); break;
            case '3': System.out.println("Security team will be notified..."); break;
            default:
                System.out.println("Invalid Selection");
                System.exit(0);
        }
    }

    // 3. ميثود: (syntax fix) للجدية
    public static boolean validateUrgency(String urgencyStr) {
        try {
            int urgency = Integer.parseInt(urgencyStr);
            if (urgency == 1) {
                System.out.println("The request has been sent ...");
                return true;
            }
            return false;
        } catch (Exception e) { return false; }
    }

    // 4. ميثود: شرط اختيار التنبيه
    public static boolean validateAlert(String alertStr, String location) {
        try {
            int alertOp = Integer.parseInt(alertStr);
            return (alertOp == 1 || alertOp == 2) && location != null && !location.trim().isEmpty();
        } catch (Exception e) { return false; }
    }

    // 5. ميثود: (syntax fix) للقدرة الاستيعابية
    public static boolean validateAvailability(String availabilityStr) {
        try {
            int availability = Integer.parseInt(availabilityStr);
            return availability == 1;
        } catch (Exception e) { return false; }
    }

    // 6. ميثود: شرط عدد المستجيبين (independent input)
    public static boolean validateRespondersCount(String countStr) {
        try {
            int count = Integer.parseInt(countStr);
            return count >= 1 && count <= 5;
        } catch (Exception e) { return false; }
    }

    // 7. ميثود لإنهاء البرنامج في حال الرفض
    public static void terminateProgram(String message) {
        System.out.println(message);
        System.exit(0);
    }

    // 8. ميثود التأكيد النهائي لنجاح العملية كاملة
    public static void finalizeRequest() {
        JOptionPane.showMessageDialog(null, "Emergency Request Processed Successfully!");
        System.out.println("System Shutdown: Success.");
    }
}
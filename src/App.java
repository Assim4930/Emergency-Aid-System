import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {

        String[] name = new String[1];
        int[] phone = new int[1];
        char list;



        for(int i = 0; i < name.length; i++) {
            String input = JOptionPane.showInputDialog("Enter your name");
            String input1 = JOptionPane.showInputDialog("Enter your Mobile number");
            phone[i] = Integer.parseInt(input1);

        }

        switch (list) {
            case :

                break;
        
            default:
                break;
        }
        
    }
}

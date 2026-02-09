import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {

        String[] name = new String[1];
        int[] phone = new int[1];



        for(int i = 0; i < name.length; i++) {
            String input = JOptionPane.showInputDialog("Enter your name");
            String input1 = JOptionPane.showInputDialog("Enter your ID");
            phone[i] = Integer.parseInt(input1);

        }
        
    }
}

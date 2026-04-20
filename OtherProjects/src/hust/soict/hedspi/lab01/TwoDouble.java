

import javax.swing.JOptionPane;

public class TwoDouble {
    public static void main(String[] args) {
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number",
                JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the first number",
                JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        double difference = Math.abs(num1 - num2);
        double product = num1 * num2;

        double quotient;
        if (num2 != 0) {
            quotient = num1 / num2;
        } else {
            JOptionPane.showMessageDialog(null, "Division by 0 is not allowed!", "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, sum, "Sum", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, difference, "Difference", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, product, "Product", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, quotient, "Quotient", JOptionPane.INFORMATION_MESSAGE);

    }
}

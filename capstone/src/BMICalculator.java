import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator extends JFrame {
    private JPanel pnlMain;
    private JTextField tfName;
    private JTextField tfAge;
    private JTextField tfHeight;
    private JTextField tfWeight;
    private JRadioButton rbMale;
    private JRadioButton rbFemale;
    private JButton btnCalculate;

    private final JRadioButton[] rbGenders = {rbMale, rbFemale};
    private final String[] genderLabels = {"Male", "Female"};

    public BMICalculator() {
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tfName.getText();
                String gender = "Not selected";

                for (int i = 0; i < rbGenders.length; i++) {
                    if (rbGenders[i].isSelected()) {
                        gender = genderLabels[i];
                    }
                }

                try {
                    int age = Integer.parseInt(tfAge.getText().trim());
                    double height = Double.parseDouble(tfHeight.getText().trim());
                    double weight = Double.parseDouble(tfWeight.getText().trim());

                    double heightInMeters = height / 100;
                    double bmi = weight / (heightInMeters * heightInMeters);

                    String status;

                    if (bmi < 18.5) {
                        status = "Underweight";
                    } else if (bmi < 24.9) {
                        status = "Normal weight";
                    } else if (bmi < 29.9) {
                        status = "Overweight";
                    } else {
                        status = "Obese";
                    }

                    String output = "Name: " + name + "\nAge: " + age +  "\nGender: " + gender +  "\nBMI: " + String.format("%.2f", bmi) +  " (" + status + ")";

                    JOptionPane.showMessageDialog(null, output);
                    System.out.println(output);

                } catch (NumberFormatException ee) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers for age, height, and weight.");
                }
            }
        });
    }

    public static void main(String[] args) {
        BMICalculator frame = new BMICalculator();
        frame.setContentPane(frame.pnlMain);
        frame.setTitle("BMI Calculator");
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

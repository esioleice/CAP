import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class BMICalculator extends JFrame {
    private JPanel pnlMain;
    private JTextField tfName;
    private JTextField tfAge;
    private JTextField tfHeight;
    private JTextField tfWeight;
    private JRadioButton rbMale;
    private JRadioButton rbFemale;
    private JButton btnCalculate;

    BMICalculator() {
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = tfName.getText().trim();
                    int age = Integer.parseInt(tfAge.getText().trim());
                    double height = Double.parseDouble(tfHeight.getText().trim());
                    double weight = Double.parseDouble(tfWeight.getText().trim());

                    if (height <= 0 || weight <= 0) {
                        throw new IllegalArgumentException("Height and weight must be greater than 0.");
                    }

                    String gender = "";
                    if (rbMale.isSelected()) {
                        gender = "Male";
                    } else if (rbFemale.isSelected()) {
                        gender = "Female";
                    }

                    double heightInMeters = height / 100.0;
                    double bmi = weight / (heightInMeters * heightInMeters);
                    String status;

                    if (bmi < 18.5) {
                        status = "Underweight";
                    } else if (bmi < 24.9) {
                        status = "Normal";
                    } else if (bmi < 29.9) {
                        status = "Overweight";
                    } else {
                        status = "Obese";
                    }

                    String result = String.format("Hello, %s!\nYour BMI is: %.2f\nStatus: %s", name, bmi, status);
                    JOptionPane.showMessageDialog(null, result);

                    saveToFile(name, age, gender, height, weight, bmi, status);

                } catch (NumberFormatException f) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers for age, height, and weight.");
                } catch (IllegalArgumentException f) {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                } catch (Exception f) {
                    JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + f.getMessage());
                }
            }
        });
    }

    private void saveToFile(String name, int age, String gender, double height, double weight, double bmi, String status) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("bmi_records.txt", true))) {
            bw.write("Name: " + name + "\n");
            bw.write("Age: " + age + "\n");
            bw.write("Gender: " + gender + "\n");
            bw.write("Height: " + height + " cm\n");
            bw.write("Weight: " + weight + " kg\n");
            bw.write("BMI: " + String.format("%.2f", bmi) + "\n");
            bw.write("Status: " + status + "\n");
            bw.write("------\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving to file.");
        }
    }

    public static void main(String[] args) {
        BMICalculator app = new BMICalculator();
        app.setContentPane(app.pnlMain);
        app.setSize(500, 500);
        app.setLocationRelativeTo(null);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
import javax.swing.*;

public class BMICalculator extends JFrame {
    private JPanel pnlMain;
    private JTextField tfName;
    private JTextField tfAge;
    private JTextField tfHeight;
    private JTextField tfWeight;
    private JRadioButton rbMaleRadioButton;
    private JRadioButton rbFemale;
    private JButton btnCalculate;

    public BMICalculator() {

    }

    public static void main(String[] args) {
        BMICalculator app = new BMICalculator();
        app.setContentPane(app.pnlMain);
        app.setSize(400, 400);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }

}

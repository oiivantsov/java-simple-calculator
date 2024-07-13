import javax.swing.*;


public class CalcFrame extends JFrame {

    CalcFrame() {

        this.add(new CalcPanel());
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }


}

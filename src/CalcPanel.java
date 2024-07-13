import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcPanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 420;
    static final int SCREEN_HEIGHT = 550;

    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel topPanel;
    JPanel bottomPanel;

    Font myFont = new Font("Helvetica", Font.PLAIN, 23);

    double num1=0, num2=0, result=0;
    char operator;

    CalcPanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setLayout(null);
        this.setBackground(new Color(13,17,23,255));

        // Text Field
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(false);
        textField.setFocusable(false);
        textField.setFont(new Font("Helvetica", Font.PLAIN, 30));
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setBackground(new Color(13,17,23,255));
        textField.setForeground(Color.WHITE);
        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        // Function Buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        negButton = new JButton("(-)");
        delButton = new JButton("Del");
        clrButton = new JButton("Clear");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (JButton btn : functionButtons) {
            btn.addActionListener(this);
            btn.setFont(myFont);
            btn.setBackground(new Color(51,51,51,255));
            btn.setForeground(Color.WHITE);
            btn.setFocusable(false);
        }

        // Number Buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setBackground(new Color(51,51,51,255));
            numberButtons[i].setForeground(Color.WHITE);
            numberButtons[i].setFocusable(false);
        }

        // topPanel
        topPanel = new JPanel();
        topPanel.setBackground(new Color(13,17,23,255));
        topPanel.setBounds(50, 100, 300, 300);
        topPanel.setLayout(new GridLayout(4, 4, 10, 10));

        // row 1
        topPanel.add(numberButtons[1]);
        topPanel.add(numberButtons[2]);
        topPanel.add(numberButtons[3]);
        topPanel.add(addButton);

        // row 2
        topPanel.add(numberButtons[4]);
        topPanel.add(numberButtons[5]);
        topPanel.add(numberButtons[6]);
        topPanel.add(subButton);

        // row 3
        topPanel.add(numberButtons[7]);
        topPanel.add(numberButtons[8]);
        topPanel.add(numberButtons[9]);
        topPanel.add(mulButton);

        // row 4
        topPanel.add(decButton);
        topPanel.add(numberButtons[0]);
        topPanel.add(equButton);
        topPanel.add(divButton);

        // bottomPanel
        bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(13,17,23,255));
        bottomPanel.setBounds(50, 430, 300, 50);
        bottomPanel.setLayout(new GridLayout(1, 3, 10, 0));

        bottomPanel.add(negButton);
        bottomPanel.add(delButton);
        bottomPanel.add(clrButton);

        // buttons and textField to Panel
        this.add(textField);
        this.add(topPanel);
        this.add(bottomPanel);

    }

    public void actionPerformed(ActionEvent e) {

        for (int i=0; i < 10; i++) {
            if(e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource()==decButton) {
            textField.setText(textField.getText().concat(decButton.getText()));
        }

        if(e.getSource()==addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if(e.getSource()==subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource()==mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource()==divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource()==equButton) {
            num2=Double.parseDouble(textField.getText());
            result=Calculator.count(num1, num2, operator);
            textField.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
        if(e.getSource()==clrButton) {
            textField.setText("");
        }
        if(e.getSource()==delButton) {
            String string = textField.getText();
            textField.setText("");

            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }

        }



    }
}

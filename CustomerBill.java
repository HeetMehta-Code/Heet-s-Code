import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class d2 extends JFrame implements ActionListener {
    JLabel l, ll;
    JTextField t;
    JTextArea tt;
    JButton b1;

    d2() {
        setTitle("WA-send - Milk Bill Generator");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        l = new JLabel("Enter customer milk in liters:");
        l.setFont(new Font("Arial", Font.BOLD, 16));

        t = new JTextField(10);

        b1 = new JButton("Submit");
        b1.setBackground(Color.ORANGE);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);

        ll = new JLabel(); 
        ll.setFont(new Font("Arial", Font.BOLD, 14));
        ll.setForeground(Color.BLUE);

        tt = new JTextArea(10, 40);
        tt.setLineWrap(true);
        tt.setWrapStyleWord(true);
        tt.setEditable(false);
        tt.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(tt);

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(l, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        add(t, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        add(b1, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        add(ll, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        add(scrollPane, gbc);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            float liters = Float.parseFloat(t.getText());
            float amount = liters * 90;
            String message = String.format("Your March milk bill: %.2f liters x INR90 = INR%.2f", liters, amount);
            ll.setText(message);
            tt.setText("------- Milk Billing Receipt -------\n");
            tt.append("Customer Milk Quantity: " + liters + " liters\n");
            tt.append("Rate per Liter: INR90\n");
            tt.append("-----------------------------------\n");
            tt.append("Total Amount Payable: INR" + amount + "/-\n");
            tt.append("Thank you for using WA-send!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new d2());
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class d1 extends JFrame implements ActionListener {
    JTextField a1;
    JRadioButton r1, r2;
    JLabel l1, l2, l3;
    ButtonGroup b1;
    JButton[] buttons;
    String[] routes = {
        "Gandhinagar--Amreli", "Gandhinagar--Rajkot", "Gandhinagar--Ambaji",
        "Gandhinagar--Vadodara", "Gandhinagar--Surat", "Gandhinagar--Ahmedabad",
        "Gandhinagar--Nadiyad", "Gandhinagar--Bhavnagar", "Gandhinagar--Jamnagar",
        "Gandhinagar--Junagadh", "Gandhinagar--Porbandar", "Gandhinagar--Kach",
        "Gandhinagar--Himmatnagar", "Gandhinagar--Valsad", "Gandhinagar--Morbi"
    };

    d1() {
        setTitle("GSRTC (Bus-Timing)");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(30, 30, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        l1 = createLabel("Enter your Name:");
        a1 = new JTextField(15);
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(l1, gbc);
        gbc.gridx = 1;
        panel.add(a1, gbc);

        l3 = createLabel("Enter your Gender:");
        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("Female");
        r1.setBackground(new Color(30, 30, 30));
        r2.setBackground(new Color(30, 30, 30));
        r1.setForeground(Color.WHITE);
        r2.setForeground(Color.WHITE);
        b1 = new ButtonGroup();
        b1.add(r1); b1.add(r2);
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(l3, gbc);
        gbc.gridx = 1;
        JPanel genderPanel = new JPanel();
        genderPanel.setBackground(new Color(30, 30, 30));
        genderPanel.add(r1); genderPanel.add(r2);
        panel.add(genderPanel, gbc);

        l2 = createLabel("Choose your Route:");
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(l2, gbc);

        buttons = new JButton[routes.length];
        JPanel buttonPanel = new JPanel(new GridLayout(5, 3, 10, 10));
        buttonPanel.setBackground(new Color(30, 30, 30));
        for (int i = 0; i < routes.length; i++) {
            buttons[i] = createRouteButton(routes[i]);
            buttonPanel.add(buttons[i]);
        }

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);

        add(panel);
        setVisible(true);
    }

    JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.YELLOW);
        label.setBackground(Color.BLACK);
        label.setOpaque(true);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    JButton createRouteButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.PINK);
        button.setForeground(Color.BLACK);
        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        String name = a1.getText();
        String gender = r1.isSelected() ? "Male" : r2.isSelected() ? "Female" : "Unspecified";
        String route = ae.getActionCommand();

        System.out.println("--------------------------------------------------");
        System.out.println(name + " (" + gender + ") - Selected Route: " + route);
        System.out.println("--------------------------------------------------");

        String msg = "";

        switch (route) {
            case "Gandhinagar--Amreli":
                System.out.println("Dhari--Visanagar || 8:30 AM");
                System.out.println("Gandhinagar--Girgadhada || 3:00 PM");
                System.out.println("Gandhinagar--Kodinar || 10:00 PM");
                msg = "Gandhinagar--Amreli (6hrs route)";
                break;

            case "Gandhinagar--Rajkot":
                System.out.println("Gandhinagar--Rajkot || 8:00 AM");
                System.out.println("Kheralu--Rajkot || 2:30 PM");
                System.out.println("Mansa--Rajkot || 9:30 AM");
                msg = "Gandhinagar--Rajkot (4hrs route)";
                break;

            case "Gandhinagar--Ambaji":
                System.out.println("Gandhinagar--Ambaji || 2:00 PM");
                msg = "Gandhinagar--Ambaji (3hrs route)";
                break;

            case "Gandhinagar--Vadodara":
                System.out.println("Gandhinagar--Vadodara || 9:00 AM");
                msg = "Gandhinagar--Vadodara (2hrs route)";
                break;

            case "Gandhinagar--Surat":
                System.out.println("Gandhinagar--Surat || 9:00 AM");
                msg = "Gandhinagar--Surat (6hrs route)";
                break;

            case "Gandhinagar--Ahmedabad":
                System.out.println("Special VIKAS ROOT available anytime");
                msg = "Gandhinagar--Ahmedabad (30min route)";
                break;

            case "Gandhinagar--Nadiyad":
                System.out.println("Gandhinagar--Anand || 4:00 PM");
                msg = "Gandhinagar--Nadiyad (4hrs route)";
                break;

            case "Gandhinagar--Bhavnagar":
                System.out.println("Gandhinagar--Bhavnagar || 3:00 PM");
                msg = "Gandhinagar--Bhavnagar (5hrs route)";
                break;

            case "Gandhinagar--Jamnagar":
                System.out.println("Gandhinagar--Jamnagar || 10:00 AM");
                msg = "Gandhinagar--Jamnagar (10hrs route)";
                break;

            case "Gandhinagar--Junagadh":
                System.out.println("Gandhinagar--Junagadh || 11:00 AM");
                msg = "Gandhinagar--Junagadh (7hrs route)";
                break;

            case "Gandhinagar--Porbandar":
                System.out.println("Gandhinagar--Porbandar || 1:30 PM");
                msg = "Gandhinagar--Porbandar (8hrs route)";
                break;

            case "Gandhinagar--Kach":
                System.out.println("Gandhinagar--Kach || 7:00 PM");
                msg = "Gandhinagar--Kach (12hrs route)";
                break;

            case "Gandhinagar--Himmatnagar":
                System.out.println("Gandhinagar--Himmatnagar || 9:00 AM");
                msg = "Gandhinagar--Himmatnagar (2hrs route)";
                break;

            case "Gandhinagar--Valsad":
                System.out.println("Gandhinagar--Valsad || 4:00 PM");
                msg = "Gandhinagar--Valsad (8hrs route)";
                break;

            case "Gandhinagar--Morbi":
                System.out.println("Gandhinagar--Morbi || 5:00 PM");
                msg = "Gandhinagar--Morbi (4hrs route)";
                break;

            default:
                msg = "This route is not available.";
        }

        JOptionPane.showMessageDialog(this, name + ", your selected route:\n" + msg);
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new d1());
    }
}

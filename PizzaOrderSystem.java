import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class d3 implements ActionListener {
    JFrame f;
    JMenuBar mb;
    JMenu file, edit, help;
    JMenuItem cut;
    JLabel l1, l2, l3, l4, l5, l6;
    JCheckBox c1, c2, c3;
    ButtonGroup bg;
    JRadioButton r1, r2, r3;
    JComboBox<String> cb;
    JList<String> ll;
    JPasswordField p;
    JTextField t1;
    JTextArea a;
    JButton b;

    d3() {
        f = new JFrame("Chizi Ke Pizza");
        f.setSize(800, 800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null); 
        f.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        mb = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        cut = new JMenuItem("Cut", new ImageIcon("apl.jpeg"));
        edit.add(cut);
        mb.add(file);
        mb.add(edit);
        mb.add(help);
        f.setJMenuBar(mb);

        l1 = createLabel("Enter your Name:");
        t1 = new JTextField(20);

        l2 = createLabel("Enter your Choice:");
        r1 = new JRadioButton("Spicy");
        r2 = new JRadioButton("Medium");
        r3 = new JRadioButton("No-Spicy");
        bg = new ButtonGroup();
        bg.add(r1); bg.add(r2); bg.add(r3);
        setRadioStyle(r1); setRadioStyle(r2); setRadioStyle(r3);

        l4 = createLabel("Enter your City:");
        cb = new JComboBox<>(new String[]{"Sector 1 to 30", "Kudasan", "Sargasan", "Raysan", "Vavol", "Randheja"});
        cb.setBackground(Color.pink);
        cb.setForeground(Color.blue);

        DefaultListModel<String> dm = new DefaultListModel<>();
        dm.addElement("Small");
        dm.addElement("Big");
        ll = new JList<>(dm);
        ll.setBackground(Color.green);
        ll.setForeground(Color.black);
        ll.setVisibleRowCount(2);

        l5 = createLabel("Enter your Mobile No:");
        p = new JPasswordField(20);

        l6 = createLabel("Choose your Pizza:");
        c1 = new JCheckBox("Garlic - INR300");
        c2 = new JCheckBox("Paneer - INR250");
        c3 = new JCheckBox("Peri-Peri - INR250");

        setCheckStyle(c1); setCheckStyle(c2); setCheckStyle(c3);

        l3 = createLabel("Description:");
        a = new JTextArea(5, 20);
        a.setLineWrap(true);
        a.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(a);

        b = new JButton("Submit");
        b.setBackground(Color.orange);
        b.setForeground(Color.black);
        b.addActionListener(this);


        int y = 0;

        addToFrame(gbc, 0, y, l1);    addToFrame(gbc, 1, y++, t1);
        addToFrame(gbc, 0, y, l2);    addToFrame(gbc, 1, y++, r1);
        addToFrame(gbc, 1, y++, r2);  addToFrame(gbc, 1, y++, r3);
        addToFrame(gbc, 0, y, l4);    addToFrame(gbc, 1, y++, cb);
        addToFrame(gbc, 0, y, new JLabel("Size:")); addToFrame(gbc, 1, y++, new JScrollPane(ll));
        addToFrame(gbc, 0, y, l5);    addToFrame(gbc, 1, y++, p);
        addToFrame(gbc, 0, y, l6);    addToFrame(gbc, 1, y++, c1);
        addToFrame(gbc, 1, y++, c2);  addToFrame(gbc, 1, y++, c3);
        addToFrame(gbc, 0, y, l3);    addToFrame(gbc, 1, y++, scrollPane);
        addToFrame(gbc, 1, y++, b);

        f.setVisible(true);
    }

    JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setOpaque(true);
        label.setBackground(Color.BLACK);
        label.setForeground(Color.ORANGE);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        return label;
    }

    void setRadioStyle(JRadioButton rb) {
        rb.setBackground(Color.WHITE);
        rb.setForeground(Color.DARK_GRAY);
    }

    void setCheckStyle(JCheckBox cb) {
        cb.setBackground(Color.LIGHT_GRAY);
        cb.setForeground(Color.DARK_GRAY);
    }

    void addToFrame(GridBagConstraints gbc, int x, int y, Component comp) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = (comp instanceof JScrollPane || comp instanceof JTextArea) ? 2 : 1;
        f.add(comp, gbc);
    }

    public void actionPerformed(ActionEvent ae) {
        System.out.println("**********************************");
        System.out.println("           YOUR ORDER             ");
        System.out.println("**********************************");
        System.out.println("Name: " + t1.getText());

        if (r1.isSelected()) System.out.println("Choice: Spicy");
        else if (r2.isSelected()) System.out.println("Choice: Medium");
        else if (r3.isSelected()) System.out.println("Choice: No-Spicy");

        System.out.println("City: " + cb.getSelectedItem());
        System.out.println("Size: " + ll.getSelectedValue());
        System.out.println("Mobile: " + new String(p.getPassword()));

        System.out.print("Pizza Selected: ");
        if (c1.isSelected()) System.out.print("Garlic ");
        if (c2.isSelected()) System.out.print("Paneer ");
        if (c3.isSelected()) System.out.print("Peri-Peri ");
        System.out.println();

        System.out.println("Description:\n" + a.getText());
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new d3());
    }
}

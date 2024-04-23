import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AirlineReservationSystem extends JFrame implements ActionListener {
    private JTextField nameField;
    private JComboBox<String> seatTypeComboBox;
    private JButton reserveButton;
    private JTextArea displayArea;

    public AirlineReservationSystem() {
        setTitle("Airline Reservation System");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Name: "));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Seat Type: "));
        String[] seatTypes = {"Economy", "Business", "First Class"};
        seatTypeComboBox = new JComboBox<>(seatTypes);
        inputPanel.add(seatTypeComboBox);
        reserveButton = new JButton("Reserve");
        reserveButton.addActionListener(this);
        inputPanel.add(reserveButton);
        add(inputPanel, BorderLayout.NORTH);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reserveButton) {
            String name = nameField.getText();
            String seatType = (String) seatTypeComboBox.getSelectedItem();
            reserveSeat(name, seatType);
        }
    }

    private void reserveSeat(String name, String seatType) {
        displayArea.append("Reserved seat for " + name + " in " + seatType + " class.\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AirlineReservationSystem system = new AirlineReservationSystem();
            system.setVisible(true);
        });
    }
}

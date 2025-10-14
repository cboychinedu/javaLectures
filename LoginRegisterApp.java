// Importing the necessary modules
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

// Creating a class called the LoginRegister app 
public class LoginRegisterApp extends JFrame {

    // Store users (username -> password)
    private HashMap<String, String> users = new HashMap<>();

    public LoginRegisterApp() {
        setTitle("Login & Register Application");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create a tabbed pane for Login and Register
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add styled tabs
        tabbedPane.addTab("Login", createLoginPanel());
        tabbedPane.addTab("Register", createRegisterPanel());

        add(tabbedPane);
        setVisible(true);
    }

    // Create the Login Panel
    private JPanel createLoginPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(173, 216, 230)); // Light blue background
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Login to Your Account", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel userLabel = new JLabel("Username:");
        JTextField usernameField = createStyledTextField();

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passwordField = createStyledPasswordField();

        JButton loginButton = createStyledButton("Login");
        JLabel messageLabel = new JLabel("", SwingConstants.CENTER);

        // Handle login button click
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (users.containsKey(username) && users.get(username).equals(password)) {
                messageLabel.setText("✅ Login successful! Welcome " + username);
            } else {
                messageLabel.setText("❌ Invalid username or password!");
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        panel.add(userLabel, gbc);
        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(passLabel, gbc);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(loginButton, gbc);

        gbc.gridy++;
        panel.add(messageLabel, gbc);

        return panel;
    }

    // Create the Register Panel
    private JPanel createRegisterPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(173, 216, 230)); // Light blue background
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Register a New Account", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel userLabel = new JLabel("Choose a Username:");
        JTextField usernameField = createStyledTextField();

        JLabel passLabel = new JLabel("Choose a Password:");
        JPasswordField passwordField = createStyledPasswordField();

        JButton registerButton = createStyledButton("Register");
        JLabel messageLabel = new JLabel("", SwingConstants.CENTER);

        // Handle register button click
        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                messageLabel.setText("⚠️ Please fill in all fields!");
            } else if (users.containsKey(username)) {
                messageLabel.setText("❌ Username already exists!");
            } else {
                users.put(username, password);
                messageLabel.setText("✅ Registration successful! You can now log in.");
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        panel.add(userLabel, gbc);
        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(passLabel, gbc);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(registerButton, gbc);

        gbc.gridy++;
        panel.add(messageLabel, gbc);

        return panel;
    }

    // 🔹 Styled helper methods
    private JTextField createStyledTextField() {
        JTextField field = new JTextField();
        field.setPreferredSize(new Dimension(200, 30)); // 30px height
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        return field;
    }

    private JPasswordField createStyledPasswordField() {
        JPasswordField field = new JPasswordField();
        field.setPreferredSize(new Dimension(200, 30)); // 30px height
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        return field;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(0, 102, 204));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Verdana", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return button;
    }

    public static void main(String[] args) {
        // Apply Nimbus Look and Feel for better visuals
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        new LoginRegisterApp();
    }
}

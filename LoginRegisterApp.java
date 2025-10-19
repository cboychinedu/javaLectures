// Importing the necessary modules
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.io.*; // For handling input/output streams
import java.net.*; // For handling network connections

// Creating a class called the LoginRegister app 
public class LoginRegisterApp extends JFrame {

    // Store users (username -> password)
    private HashMap<String, String> users = new HashMap<>();

    // Define the dark theme colors
    private final Color DARK_BACKGROUND = new Color(30, 30, 30);
    private final Color WHITE_FOREGROUND = Color.WHITE;
    private final Color INPUT_FIELD_BACKGROUND = new Color(50, 50, 50);
    private final Color ACCENT_BUTTON_COLOR = new Color(50, 150, 250); // Bright blue accent
    
    // Define the simulated backend API URL for registration
    private static final String REGISTRATION_API_URL = "https://api.example.com/register"; 

    public LoginRegisterApp() {
        setTitle("Login & Register Application (Dark Theme)");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        
        // Set the frame's content pane background to pure black
        getContentPane().setBackground(Color.BLACK);

        // Create a tabbed pane for Login and Register
        JTabbedPane tabbedPane = new JTabbedPane();
        
        // Style the tabbed pane for the dark theme (tabs themselves)
        tabbedPane.setForeground(WHITE_FOREGROUND);
        tabbedPane.setBackground(new Color(15, 15, 15)); 

        // Add styled tabs
        tabbedPane.addTab("Login", createLoginPanel());
        tabbedPane.addTab("Register", createRegisterPanel());

        add(tabbedPane);
        setVisible(true);
    }

    // Helper method to set foreground to white for labels
    private JLabel createStyledLabel(String text, int style, int size) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Arial", style, size));
        label.setForeground(WHITE_FOREGROUND); // Set text to white
        return label;
    }

    // Create the Login Panel
    private JPanel createLoginPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(DARK_BACKGROUND); // Black/Dark Gray background
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = createStyledLabel("Login to Your Account", Font.BOLD, 18);
        
        JLabel userLabel = createStyledLabel("Username:", Font.PLAIN, 12);
        JTextField usernameField = createStyledTextField();

        JLabel passLabel = createStyledLabel("Password:", Font.PLAIN, 12);
        JPasswordField passwordField = createStyledPasswordField();

        JButton loginButton = createStyledButton("Login");
        JLabel messageLabel = createStyledLabel("", Font.PLAIN, 14);
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 14));


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
        panel.setBackground(DARK_BACKGROUND); // Black/Dark Gray background
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = createStyledLabel("Register a New Account", Font.BOLD, 18);

        JLabel userLabel = createStyledLabel("Choose a Username:", Font.PLAIN, 12);
        JTextField usernameField = createStyledTextField();

        JLabel passLabel = createStyledLabel("Choose a Password:", Font.PLAIN, 12);
        JPasswordField passwordField = createStyledPasswordField();

        JButton registerButton = createStyledButton("Register");
        JLabel messageLabel = createStyledLabel("", Font.PLAIN, 14);
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 14));

        // Handle register button click
        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                messageLabel.setText("⚠️ Please fill in all fields!");
            } else if (users.containsKey(username)) {
                messageLabel.setText("❌ Username already exists locally!");
            } else {
                // 1. Perform local registration (for HashMap tracking)
                users.put(username, password);
                
                // 2. Asynchronously send data to the API
                registerUserWithApi(username, password, messageLabel);
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
    
    /**
     * Attempts to send registration data to a backend API using HttpURLConnection.
     * This runs on a separate thread to prevent blocking the GUI.
     */
    private void registerUserWithApi(String username, String password, JLabel messageLabel) {
        // Show loading message immediately on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> messageLabel.setText("⏳ Registering... sending data to API..."));

        // Use a new Thread to perform network operations
        new Thread(() -> {
            HttpURLConnection conn = null;
            try {
                // 1. Setup Connection
                URL url = new URL(REGISTRATION_API_URL);
                conn = (HttpURLConnection) url.openConnection();
                
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json; utf-8");
                conn.setRequestProperty("Accept", "application/json");
                conn.setDoOutput(true);
                
                // Set reasonable timeouts
                conn.setConnectTimeout(5000); 
                conn.setReadTimeout(5000);

                // 2. Prepare JSON Payload
                String jsonInputString = String.format(
                    "{\"username\": \"%s\", \"password\": \"%s\"}", 
                    username, password
                );

                // 3. Send Data
                try(OutputStream os = conn.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes("utf-8");
                    os.write(input, 0, input.length);           
                }
                
                // Simulate network latency for better user experience
                Thread.sleep(1500); 
                
                // 4. Read Response (Simulated)
                int code = conn.getResponseCode();
                
                // Check for a success response code (200-299)
                if (code >= 200 && code < 300) {
                    // Success, update UI back on the Event Dispatch Thread (EDT)
                    SwingUtilities.invokeLater(() -> {
                        // In a real app, you would read the server response message here
                        messageLabel.setText("✅ Registration successful and sent to API! (Simulated)");
                    });
                } else {
                    // API failure (e.g., 400 Bad Request, 500 Server Error)
                     SwingUtilities.invokeLater(() -> {
                        messageLabel.setText("❌ API Registration Failed. Server Response Code: " + code);
                    });
                }
            } catch (MalformedURLException e) {
                // Handle incorrect URL format
                SwingUtilities.invokeLater(() -> messageLabel.setText("❌ Internal Error: Invalid API URL."));
                System.err.println("URL Error: " + e.getMessage());
            } catch (IOException e) {
                // Handle network errors (e.g., no internet, API down/unreachable)
                 SwingUtilities.invokeLater(() -> {
                    messageLabel.setText("❌ Network Error: Could not connect to API.");
                    System.err.println("API Connection Error: " + e.getMessage());
                });
            } catch (Exception e) {
                // General exception, including Thread.sleep() exception
                SwingUtilities.invokeLater(() -> messageLabel.setText("❌ An unexpected error occurred."));
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    conn.disconnect();
                }
            }
        }).start(); // Start the new thread
    }


    // 🔹 Styled helper methods
    private JTextField createStyledTextField() {
        JTextField field = new JTextField();
        field.setPreferredSize(new Dimension(200, 30)); // 30px height
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        // Dark theme colors for input
        field.setBackground(INPUT_FIELD_BACKGROUND);
        field.setForeground(WHITE_FOREGROUND);
        field.setCaretColor(WHITE_FOREGROUND); // Ensure cursor is visible
        field.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        
        return field;
    }

    private JPasswordField createStyledPasswordField() {
        JPasswordField field = new JPasswordField();
        field.setPreferredSize(new Dimension(200, 30)); // 30px height
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        // Dark theme colors for input
        field.setBackground(INPUT_FIELD_BACKGROUND);
        field.setForeground(WHITE_FOREGROUND);
        field.setCaretColor(WHITE_FOREGROUND); // Ensure cursor is visible
        field.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        
        return field;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(ACCENT_BUTTON_COLOR); // Blue accent on dark background
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
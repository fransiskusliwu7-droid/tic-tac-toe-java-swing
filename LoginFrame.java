package com.mycompany.finalprojectpemdasjava;
import javax.swing.*;
import java.awt.*;

class LoginFrame extends JFrame {
    private JTextField txtUsername = new JTextField(15);
    private JPasswordField txtPassword = new JPasswordField(15);
    private JButton btnLogin = new JButton("Login");
    private PlayerService playerService = new PlayerService();

    public LoginFrame() {
        setTitle("Game Login"); setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); setLayout(new GridLayout(3, 2));
        add(new JLabel(" Username:")); add(txtUsername);
        add(new JLabel(" Password:")); add(txtPassword);
        add(new JLabel("")); add(btnLogin);
        btnLogin.addActionListener(e -> {
            Player player = playerService.login(txtUsername.getText(), new String(txtPassword.getPassword()));
            if (player != null) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                new MainMenuFrame(player).setVisible(true);
                this.dispose();
            } else { JOptionPane.showMessageDialog(this, "Invalid username or password!"); }
        });
    }
}
package Frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LogInFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	AddFrame addFrame = new AddFrame();
	private JLabel wrong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInFrame frame = new LogInFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogInFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Password:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(66, 103, 134, 22);
		contentPane.add(lblNewLabel);
		
		wrong = new JLabel("");
		wrong.setForeground(new Color(255, 0, 0));
		wrong.setBackground(new Color(255, 0, 0));
		wrong.setBounds(147, 135, 107, 13);
		contentPane.add(wrong);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if(textField.getText().equalsIgnoreCase("admin")) {
                    	
						addFrame.setVisible(true);
                    	dispose();
                    } else {
                    	wrong.setText("Wrong Password!");
                    }
                }
			}
		});
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(200, 103, 152, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equalsIgnoreCase("admin")) {
                	
					addFrame.setVisible(true);
                	dispose();
                } else {
                	wrong.setText("Wrong Password!");
                }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(147, 156, 107, 30);
		contentPane.add(btnNewButton);
		
		
	}
}

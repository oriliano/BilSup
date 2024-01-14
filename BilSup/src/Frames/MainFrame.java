package Frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Others.BilSupSys;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	ProteinFrame proteinFrame = new ProteinFrame();
	CreatineFrame creatineFrame = new CreatineFrame();
	VitaminFrame vitaminFrame = new VitaminFrame();
	LogInFrame logInFrame = new LogInFrame();
	/**
	 * Launch the application.
	 */
	public void fillCreatineBox() {
        creatineFrame.getComboBox().setModel(new DefaultComboBoxModel(BilSupSys.getCreatineNames()));
    }
	
	public void fillProteinBox() {
        proteinFrame.getComboBox().setModel(new DefaultComboBoxModel(BilSupSys.getProteinNames()));
    }
	
	public void fillVitaminBox() {
        vitaminFrame.getComboBox().setModel(new DefaultComboBoxModel(BilSupSys.getVitaminNames()));
    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e ) {
					e.printStackTrace();
				}
				BilSupSys.readFromFile();
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Products Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 71, 452, 153);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textArea.setText("Choose Supplement to display.");
		scrollPane.setViewportView(textArea);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString().equalsIgnoreCase("creatine")) {
					textArea.setText(BilSupSys.displayCreatine());
				} 
				else if(comboBox.getSelectedItem().toString().equalsIgnoreCase("multivitamin")) {
					textArea.setText(BilSupSys.displayVitamin());
				} else {
					textArea.setText(BilSupSys.displayProtein());
				}
			}
		});
		comboBox.setFont(new Font("Calibri", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Creatine", "Protein Powder", "Multivitamin"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(99, 17, 130, 31);
		contentPane.add(comboBox);
		
		
		JLabel lblNewLabel = new JLabel("Display:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(43, 11, 71, 40);
		contentPane.add(lblNewLabel);
		
		JButton addBtn = new JButton("SHOW PRODUCTS");
		addBtn.setFont(new Font("Calibri", Font.BOLD, 14));
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (comboBox.getSelectedItem().toString().equalsIgnoreCase("Creatine")) {
					fillCreatineBox();
					creatineFrame.setVisible(true);
					dispose();
				}
				else if(comboBox.getSelectedItem().toString().equalsIgnoreCase("Protein Powder"))
				{
					fillProteinBox();
					proteinFrame.setVisible(true);
					dispose();
				}
				else {
					fillVitaminBox();
					vitaminFrame.setVisible(true);
					dispose();
				}
			}
		});
		addBtn.setBounds(159, 246, 161, 31);
		contentPane.add(addBtn);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logInFrame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(398, 20, 85, 21);
		contentPane.add(btnNewButton);
	}
}

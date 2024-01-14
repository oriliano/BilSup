package Frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Others.BilSupSys;

import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class ProteinFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JComboBox comboBox;
	String type = "null";

	public JComboBox getComboBox() {
        return comboBox;
    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProteinFrame frame = new ProteinFrame();
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
	public ProteinFrame() {
		setTitle("Protein");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select flavour type");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(18, 39, 114, 13);
		contentPane.add(lblNewLabel);
		
		JLabel priceL = new JLabel("");
		priceL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		priceL.setBounds(310, 21, 219, 28);
		contentPane.add(priceL);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				priceL.setText("");
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Hiq", "ProteinOcean", "HardLine"}));
		comboBox.setBounds(98, 168, 103, 21);
		contentPane.add(comboBox);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Chocolate");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type = "chocolate";
				String brand = comboBox.getSelectedItem().toString();
                double price = BilSupSys.calPowder(brand, type);
                priceL.setText(price + "TL");
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonGroup_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(138, 6, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnBanana = new JRadioButton("Banana");
		rdbtnBanana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type = "banana";
				String brand = comboBox.getSelectedItem().toString();
                double price = BilSupSys.calPowder(brand, type);
                priceL.setText(price + "TL");
			}
		});
		rdbtnBanana.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonGroup_1.add(rdbtnBanana);
		rdbtnBanana.setBounds(138, 36, 103, 21);
		contentPane.add(rdbtnBanana);
		
		JRadioButton rdbtnStrawberry = new JRadioButton("Strawberry");
		rdbtnStrawberry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type = "strawberry";
				String brand = comboBox.getSelectedItem().toString();
                double price = BilSupSys.calPowder(brand, type);
                priceL.setText(price + "TL");
			}
		});
		rdbtnStrawberry.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonGroup_1.add(rdbtnStrawberry);
		rdbtnStrawberry.setBounds(138, 67, 85, 21);
		contentPane.add(rdbtnStrawberry);
		
		JLabel lblNewLabel_1 = new JLabel("Price:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(271, 21, 61, 27);
		contentPane.add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Select Brand:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(18, 167, 85, 21);
		contentPane.add(lblNewLabel_3);
		
		
		
		JButton btnNewButton = new JButton("Buy Protein Powder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BilSupSys.buyProtein(comboBox.getSelectedItem().toString());
				comboBox.setModel(new DefaultComboBoxModel(BilSupSys.getProteinNames()));
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(98, 212, 152, 39);
		contentPane.add(btnNewButton);
		
		JButton btnReturnProductPage = new JButton("Return Product Page");
		btnReturnProductPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mainFrame = new MainFrame();
				mainFrame.setVisible(true);
				dispose();
			}
		});
		btnReturnProductPage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnReturnProductPage.setBounds(298, 212, 152, 39);
		contentPane.add(btnReturnProductPage);
	}
}

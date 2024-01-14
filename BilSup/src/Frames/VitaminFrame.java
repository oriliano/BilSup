package Frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Others.BilSupSys;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VitaminFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	String vitType;
	String sexType;

	private JComboBox comboBox;
	
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
					VitaminFrame frame = new VitaminFrame();
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
	public VitaminFrame() {
		setTitle("Vitamins\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Sex:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(20, 24, 71, 32);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Female");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sexType = "female";
			}
		});
		rdbtnNewRadioButton.setSelected(true);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(84, 19, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sexType = "male";
			}
		});
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBounds(84, 42, 103, 21);
		contentPane.add(rdbtnMale);
		
		JLabel lblNewLabel_1 = new JLabel("Select Brand:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(20, 174, 87, 32);
		contentPane.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Hiq", "ProteinOcean", "Hardline"}));
		comboBox.setBounds(102, 181, 81, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("Select Type Of Vitamin:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 111, 135, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("A");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vitType = "A";
			}
		});
		rdbtnNewRadioButton_1.setSelected(true);
		buttonGroup_1.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNewRadioButton_1.setBounds(151, 117, 33, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("B");
		rdbtnNewRadioButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vitType = "b";
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_1_1);
		rdbtnNewRadioButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNewRadioButton_1_1.setBounds(193, 117, 40, 21);
		contentPane.add(rdbtnNewRadioButton_1_1);
		
		JRadioButton rdbtnNewRadioButton_1_1_1 = new JRadioButton("C");
		rdbtnNewRadioButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vitType = "c";
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_1_1_1);
		rdbtnNewRadioButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNewRadioButton_1_1_1.setBounds(235, 117, 45, 21);
		contentPane.add(rdbtnNewRadioButton_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(269, 24, 40, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel priceL = new JLabel("");
		priceL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		priceL.setBounds(300, 35, 197, 13);
		contentPane.add(priceL);
		
		JButton btnNewButton = new JButton("Buy Vitamin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				BilSupSys.buyVitamin(comboBox.getSelectedItem().toString());
				comboBox.setModel(new DefaultComboBoxModel(BilSupSys.getVitaminNames()));
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(102, 239, 144, 42);
		contentPane.add(btnNewButton);
		
		JButton btnReturnProductPage = new JButton("Return Products Page");
		btnReturnProductPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mainFrame = new MainFrame();
				mainFrame.setVisible(true);
				dispose();
			}
		});
		btnReturnProductPage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnReturnProductPage.setBounds(285, 239, 157, 42);
		contentPane.add(btnReturnProductPage);
		
		JButton calcBtn = new JButton("Calculate");
		calcBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!comboBox.getSelectedItem().equals("")) {
					String brandName = comboBox.getSelectedItem().toString();
					
					if (sexType == null || vitType == null) {
						priceL.setText("Select types!");
					} else {
						double price = BilSupSys.calVitamin(brandName, sexType, vitType);
		                priceL.setText(price + "TL");
					}
				}
					
			}
		});
		calcBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		calcBtn.setBounds(269, 66, 110, 25);
		contentPane.add(calcBtn);
	}

}

package Frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Others.BilSupSys;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class CreatineFrame extends JFrame {

	private JPanel contentPane;
	private JTextField scoopSizeF;
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
					CreatineFrame frame = new CreatineFrame();
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
	public CreatineFrame() {
		setTitle("Creatine ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter ScoopSize:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(20, 25, 110, 29);
		contentPane.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setBounds(105, 91, 110, 21);
		contentPane.add(comboBox);
		
		JLabel priceL = new JLabel("");
		priceL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		priceL.setBounds(324, 33, 208, 13);
		contentPane.add(priceL);
		
		scoopSizeF = new JTextField();
		scoopSizeF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(scoopSizeF.getText().equals("")) {
						priceL.setText("Enter Scoop Size!");
					} else {
						int size = Integer.parseInt(scoopSizeF.getText()); 
		                String brand = comboBox.getSelectedItem().toString();
		                double price = BilSupSys.calCreatine(brand, size);
		                priceL.setText(price + "TL");
						BilSupSys.buyCreatine(comboBox.getSelectedItem().toString());
					
					}
                }
			}
		});
		scoopSizeF.setBounds(122, 29, 110, 23);
		contentPane.add(scoopSizeF);
		scoopSizeF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Select Brand:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(23, 83, 80, 34);
		contentPane.add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Price:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(291, 25, 45, 29);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Buy Creatine");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(scoopSizeF.getText().equals("")) {
					priceL.setText("Enter Scoop Size!");
				} else {
					
					int size = Integer.parseInt(scoopSizeF.getText()); 
	                String brand = comboBox.getSelectedItem().toString();
	                double price = BilSupSys.calCreatine(brand, size);
	                priceL.setText(price + "TL");
					BilSupSys.buyCreatine(comboBox.getSelectedItem().toString());
					comboBox.setModel(new DefaultComboBoxModel(BilSupSys.getCreatineNames()));
				
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(74, 184, 163, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Return Products Page");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mainFrame = new MainFrame();
				mainFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(311, 185, 156, 42);
		contentPane.add(btnNewButton_1);
		
		
		
		JLabel dateL = new JLabel("");
		dateL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dateL.setBounds(376, 88, 45, 28);
		contentPane.add(dateL);
		
	}

}

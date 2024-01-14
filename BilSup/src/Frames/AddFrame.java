package Frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Others.BilSupSys;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class AddFrame extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField expiredate;
	private JTextField price;
	private JTextField weight;
	
	String type = "null"; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFrame frame = new AddFrame();
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
	public AddFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 31, 36, 22);
		contentPane.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(54, 35, 96, 19);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblPillSize = new JLabel("Pill Size:");
		lblPillSize.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPillSize.setBounds(61, 159, 64, 22);
		contentPane.add(lblPillSize);
		
		JComboBox pillsize = new JComboBox();
		pillsize.setEnabled(false);
		pillsize.setFont(new Font("Tahoma", Font.BOLD, 14));
		pillsize.setModel(new DefaultComboBoxModel(new String[] {"Small", "Medium", "Large"}));
		pillsize.setBounds(123, 162, 96, 21);
		contentPane.add(pillsize);
		
		JComboBox crBox = new JComboBox();
		crBox.setEnabled(false);
		crBox.setModel(new DefaultComboBoxModel(new String[] {"Mono", "Triplex"}));
		crBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		crBox.setBounds(123, 98, 96, 21);
		contentPane.add(crBox);
		
		JRadioButton creatine = new JRadioButton("Creatine");
		creatine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crBox.setEnabled(true);
				weight.setEnabled(false);
				pillsize.setEnabled(false);
				type = "Creatine";
			
			}
		});
		buttonGroup.add(creatine);
		creatine.setFont(new Font("Tahoma", Font.BOLD, 12));
		creatine.setBounds(21, 4, 103, 21);
		contentPane.add(creatine);
		
		JRadioButton protein = new JRadioButton("Protein Powder");
		protein.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crBox.setEnabled(false);
				weight.setEnabled(true);
				pillsize.setEnabled(false);
				type = "ProteinPowder";				
			}
		});
		buttonGroup.add(protein);
		protein.setFont(new Font("Tahoma", Font.BOLD, 12));
		protein.setBounds(145, 5, 131, 21);
		contentPane.add(protein);
		
		JRadioButton vitamin = new JRadioButton("Multi Vitamin");
		vitamin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crBox.setEnabled(false);
				weight.setEnabled(false);
				pillsize.setEnabled(true);
				type = "MultiVitamin";
			}
		});
		buttonGroup.add(vitamin);
		vitamin.setFont(new Font("Tahoma", Font.BOLD, 12));
		vitamin.setBounds(297, 4, 117, 21);
		contentPane.add(vitamin);
		
		JLabel lblBrandName = new JLabel("Brand Name:");
		lblBrandName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBrandName.setBounds(192, 31, 104, 22);
		contentPane.add(lblBrandName);
		
		expiredate = new JTextField();
		expiredate.setColumns(10);
		expiredate.setBounds(297, 68, 96, 19);
		contentPane.add(expiredate);
		
		JLabel lblNewLabel_1_1 = new JLabel("Expire Date:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(202, 64, 104, 22);
		contentPane.add(lblNewLabel_1_1);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(54, 68, 96, 19);
		contentPane.add(price);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(10, 64, 46, 22);
		contentPane.add(lblPrice);
		
		JLabel lblCreatineType = new JLabel("Creatine Type:");
		lblCreatineType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCreatineType.setBounds(10, 95, 118, 22);
		contentPane.add(lblCreatineType);
		
		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWeight.setBounds(61, 127, 64, 22);
		contentPane.add(lblWeight);
		
		weight = new JTextField();
		weight.setEnabled(false);
		weight.setColumns(10);
		weight.setBounds(123, 131, 96, 19);
		contentPane.add(weight);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ProteinOcean", "HIQ", "Hardline"}));
		comboBox.setBounds(297, 34, 96, 21);
		contentPane.add(comboBox);
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				
			    
			    
			    if (id.getText().isEmpty()|| price.getText().isEmpty()|| expiredate.getText().isEmpty())
			    {
			    	System.out.println("fill the blanks");
			    }else {
			    	int bid = Integer.parseInt(id.getText());
				    String bName = comboBox.getSelectedItem().toString();
				    int supprice = Integer.parseInt(price.getText());
				    String exDate = expiredate.getText();
				    String crType = crBox.getSelectedItem().toString();
				    String LightWeight = weight.getText() + "gr";
				    String psize = pillsize.getSelectedItem().toString();
			    	
			    	if (BilSupSys.add(type, bid, bName, supprice, exDate, crType, LightWeight, psize)) {
				    	System.out.println("Works");
				    } else {
				    	System.out.println("Does not");
				    }
			    }
			     
			    
			    
		
			}
		});
		add.setFont(new Font("Tahoma", Font.BOLD, 14));
		add.setBounds(123, 193, 96, 22);
		contentPane.add(add);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mainFrame = new MainFrame();
				mainFrame.setVisible(true);
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(266, 193, 96, 22);
		contentPane.add(btnCancel);
		
		
		
		
	}
}

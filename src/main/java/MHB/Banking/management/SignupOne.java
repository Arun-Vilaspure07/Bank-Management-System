package MHB.Banking.management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {
	long random;
	JTextField NameTextField, FnameTextField, DOBTextField, emailTextField, addressTextField, cityTextField,
			stateTextField, pincodeTextField;
	JButton next;
	JRadioButton male, female, other, married, unmarried;
	JDateChooser dateChooser;

	SignupOne() {
		setLayout(null);
		Random ran = new Random();
		random = Math.abs((ran.nextLong() % 900L) + 1000L);

		JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
		formno.setFont(new Font("Raleway", Font.BOLD, 38));
		formno.setBounds(140, 20, 600, 40);
		add(formno);

		JLabel personDetails = new JLabel("Page 1 : Personal Details");
		personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		personDetails.setBounds(290, 80, 400, 30);
		add(personDetails);

		JLabel Name = new JLabel("Name :");
		Name.setFont(new Font("Raleway", Font.BOLD, 20));
		Name.setBounds(100, 140, 100, 30);
		add(Name);

		NameTextField = new JTextField();
		NameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		NameTextField.setBounds(300, 140, 400, 30);
		add(NameTextField);

		JLabel Fname = new JLabel("Father's Name :");
		Fname.setFont(new Font("Raleway", Font.BOLD, 20));
		Fname.setBounds(100, 190, 200, 30);
		add(Fname);

		FnameTextField = new JTextField();
		FnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		FnameTextField.setBounds(300, 190, 400, 30);
		add(FnameTextField);

		JLabel DOB = new JLabel("Date Of Birth :");
		DOB.setFont(new Font("Raleway", Font.BOLD, 20));
		DOB.setBounds(100, 240, 200, 30);
		add(DOB);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(300, 240, 400, 30);
		dateChooser.setForeground(new Color(105, 105, 105));
		add(dateChooser);

		JLabel gender = new JLabel("Gender :");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);

		male = new JRadioButton("Male");
		male.setBounds(300, 290, 60, 30);
		male.setBackground(Color.white);
		add(male);

		female = new JRadioButton("Female");
		female.setBackground(Color.white);
		female.setBounds(450, 290, 100, 30);
		add(female);

		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);

		JLabel email = new JLabel("Email Address :");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 340, 200, 30);
		add(email);

		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		emailTextField.setBounds(300, 340, 400, 30);
		add(emailTextField);

		JLabel marital = new JLabel("Marital Status :");
		marital.setFont(new Font("Raleway", Font.BOLD, 20));
		marital.setBounds(100, 390, 200, 30);
		add(marital);

		married = new JRadioButton("Married");
		married.setBounds(300, 390, 70, 30);
		married.setBackground(Color.white);
		add(married);

		unmarried = new JRadioButton("Unmarried");
		unmarried.setBackground(Color.white);
		unmarried.setBounds(450, 390, 100, 30);
		add(unmarried);

		other = new JRadioButton("Other");
		other.setBackground(Color.white);
		other.setBounds(630, 390, 70, 30);
		add(other);

		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(unmarried);
		maritalgroup.add(other);

		JLabel address = new JLabel("Address :");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 440, 200, 30);
		add(address);

		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		addressTextField.setBounds(300, 440, 400, 30);
		add(addressTextField);

		JLabel city = new JLabel("City :");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 490, 200, 30);
		add(city);

		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		cityTextField.setBounds(300, 490, 400, 30);
		add(cityTextField);

		JLabel state = new JLabel("State :");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 540, 200, 30);
		add(state);

		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		stateTextField.setBounds(300, 540, 400, 30);
		add(stateTextField);

		JLabel pincode = new JLabel("Pincode :");
		pincode.setFont(new Font("Raleway", Font.BOLD, 20));
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);

		pincodeTextField = new JTextField();
		pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		pincodeTextField.setBounds(300, 590, 400, 30);
		add(pincodeTextField);

		next = new JButton("Next");
		next.setBackground(Color.darkGray);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);

		getContentPane().setBackground(Color.ORANGE);

		setSize(850, 800);
		setLocation(350, 10);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		String formno = "" + random; // long
		String Name = NameTextField.getText();
		String Fname = FnameTextField.getText();
		String DOB = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if (male.isSelected()) {
			gender = "Male";
		} else if (female.isSelected()) {
			gender = "Female";
		}
		String email = emailTextField.getText();
		String marital = null;
		if (married.isSelected()) {
			marital = "Married";
		} else if (unmarried.isSelected()) {
			marital = "unmarried";
		} else if (other.isSelected()) {
			marital = "other";
		}
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pin = pincodeTextField.getText();

		try {
			if (Name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required");
			} else {
				Connect c = new Connect();
				String query = "insert into signup values('" + formno + "','" + Name + "','" + Fname + "','" + DOB
						+ "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','"
						+ pin + "','" + state + "')";
				setVisible(false);
				new SignupTwo(formno).setVisible(true);
				c.s.executeUpdate(query);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) {
		new SignupOne();

	}
}

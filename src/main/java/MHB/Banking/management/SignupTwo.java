package MHB.Banking.management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class SignupTwo extends JFrame implements ActionListener {

	JTextField Pan, Aadhar;
	JButton next;
	JRadioButton Syes, Sno, Eyes, Eno;
	JComboBox religion, Category, Occupation, Education, Income;
	String formno;

	SignupTwo(String formno) {
		this.formno = formno;
		setLayout(null);

		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

		JLabel AdditionalDetails = new JLabel("Page 2 : Additional Details");
		AdditionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		AdditionalDetails.setBounds(290, 80, 400, 30);
		add(AdditionalDetails);

		JLabel Name = new JLabel("Religion :");
		Name.setFont(new Font("Raleway", Font.BOLD, 20));
		Name.setBounds(100, 140, 100, 30);
		add(Name);

		String valReligion[] = { "Hindu", "Muslim", "Sikh", "Christian", "Other" };
		religion = new JComboBox(valReligion);
		religion.setBounds(300, 140, 400, 30);
		religion.setBackground(Color.WHITE);
		add(religion);

		JLabel Fname = new JLabel("Category :");
		Fname.setFont(new Font("Raleway", Font.BOLD, 20));
		Fname.setBounds(100, 190, 200, 30);
		add(Fname);

		String valCategory[] = { "General", "OBC", "SC", "ST", "Other" };
		Category = new JComboBox(valCategory);
		Category.setBounds(300, 190, 400, 30);
		Category.setBackground(Color.WHITE);
		add(Category);

		JLabel DOB = new JLabel("Income :");
		DOB.setFont(new Font("Raleway", Font.BOLD, 20));
		DOB.setBounds(100, 240, 200, 30);
		add(DOB);

		String IncomeCategory[] = { "Null", "<150,000", "<2,50,000", "<5,00,000", "Upto 10,00,000" };
		Income = new JComboBox(IncomeCategory);
		Income.setBounds(300, 240, 400, 30);
		Income.setBackground(Color.WHITE);
		add(Income);

		JLabel gender = new JLabel("Educational ");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);

		JLabel email = new JLabel("Qualification :");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 315, 200, 30);
		add(email);

		String EducationValues[] = { "Non Graduation", "Graduate", "Post Graduate", "Doctrate", "Other" };
		Education = new JComboBox(EducationValues);
		Education.setBounds(300, 315, 400, 30);
		Education.setBackground(Color.WHITE);
		add(Education);

		JLabel marital = new JLabel("Occupation :");
		marital.setFont(new Font("Raleway", Font.BOLD, 20));
		marital.setBounds(100, 390, 200, 30);
		add(marital);

		String OccupationValues[] = { "Salaried", "Self Employed", "Bussiness", "Student", "Retired", "Other" };
		Occupation = new JComboBox(OccupationValues);
		Occupation.setBounds(300, 390, 400, 30);
		Occupation.setBackground(Color.WHITE);
		add(Occupation);

		JLabel address = new JLabel("Pan Number :");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 440, 200, 30);
		add(address);

		Pan = new JTextField();
		Pan.setFont(new Font("Raleway", Font.BOLD, 14));
		Pan.setBounds(300, 440, 400, 30);
		add(Pan);

		JLabel city = new JLabel("Aadhar Number :");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 490, 200, 30);
		add(city);

		Aadhar = new JTextField();
		Aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
		Aadhar.setBounds(300, 490, 400, 30);
		add(Aadhar);

		JLabel state = new JLabel("Senior citizen :");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 540, 200, 30);
		add(state);

		Syes = new JRadioButton("Yes");
		Syes.setBounds(300, 540, 70, 30);
		Syes.setBackground(Color.white);
		add(Syes);

		Sno = new JRadioButton("No");
		Sno.setBackground(Color.white);
		Sno.setBounds(450, 540, 100, 30);
		add(Sno);

		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(Syes);
		maritalgroup.add(Sno);

		JLabel pincode = new JLabel("Existing Account :");
		pincode.setFont(new Font("Raleway", Font.BOLD, 20));
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);

		Eyes = new JRadioButton("Yes");
		Eyes.setBounds(300, 590, 70, 30);
		Eyes.setBackground(Color.white);
		add(Eyes);

		Eno = new JRadioButton("No");
		Eno.setBackground(Color.white);
		Eno.setBounds(450, 590, 100, 30);
		add(Eno);

		ButtonGroup emaritalgroup = new ButtonGroup();
		emaritalgroup.add(Eyes);
		emaritalgroup.add(Eno);

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
		String sreligion = (String) religion.getSelectedItem();
		String sCategory = (String) Category.getSelectedItem();
		String sIncome = (String) Income.getSelectedItem();
		String sEducation = (String) Education.getSelectedItem();
		String sOccupation = (String) Occupation.getSelectedItem();
		String SeniorCitizen = null;
		if (Syes.isSelected()) {
			SeniorCitizen = "Yes";
		} else if (Sno.isSelected()) {
			SeniorCitizen = "No";
		}
		String ExistingAccount = null;
		if (Eyes.isSelected()) {
			ExistingAccount = "Yes";
		} else if (Eno.isSelected()) {
			ExistingAccount = "No";

		}
		String sPan = Pan.getText();
		String sAadhar = Aadhar.getText();

		try {

			Connect c = new Connect();
			String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + sCategory + "','"
					+ sIncome + "','" + sEducation + "','" + sOccupation + "','" + sPan + "','" + sAadhar + "','"
					+ SeniorCitizen + "','" + ExistingAccount + "')";

			c.s.executeUpdate(query);
//         SignupThree object
			setVisible(false);
			new SignupThree(formno).setVisible(true);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) {
		new SignupTwo("");

	}
}

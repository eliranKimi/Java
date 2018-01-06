import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoView extends JFrame implements IMemoView {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 400;
	private static final int HEIGHT = 200;
	private static final int STARTING_YEAR = 2018;

	private MemoModel m_model;

	// Components

	private JLabel titleLabel = new JLabel("Memo:");

	private JComboBox<String> daysCombo = new JComboBox<String>();
	private JComboBox<String> monthsCombo = new JComboBox<String>();
	private JComboBox<String> yearsCombo = new JComboBox<String>();

	private JButton saveBtn = new JButton("Save");
	private JButton getBtn = new JButton("Get record");

	private JTextArea memoText = new JTextArea();

	public MemoView(MemoModel model) {
		this.m_model = model;

		// Setting values to date fields
		setCombo(this.daysCombo, m_model.getDaysArray());
		setCombo(this.monthsCombo, m_model.getMonthsArray());
		setCombo(this.yearsCombo, m_model.getYearsArray(STARTING_YEAR));

		JPanel compPanel = new JPanel();

		JPanel titlePanel = new JPanel();
		titlePanel.add(titleLabel);

		compPanel.add(daysCombo);
		compPanel.add(monthsCombo);
		compPanel.add(yearsCombo);
		compPanel.add(saveBtn);
		compPanel.add(getBtn);

		JScrollPane textScroll = new JScrollPane(memoText);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		mainPanel.add(titlePanel);
		mainPanel.add(textScroll);
		mainPanel.add(compPanel);

		this.add(mainPanel);

		this.pack();
		this.setSize(WIDTH, HEIGHT);
		this.setTitle("Memo Application");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void setCombo(JComboBox<String> combo, ArrayList<Integer> array) {
		Iterator<Integer> it = array.iterator();
		while (it.hasNext()) {
			combo.addItem("" + it.next());
		}

	}

	public void addSaveListener(ActionListener saveListener) {
		saveBtn.addActionListener(saveListener);

	}

	public void addGetMemoListener(ActionListener getMemoListener) {
		getBtn.addActionListener(getMemoListener);

	}

	public void showError(String errMessage) {
		JOptionPane.showMessageDialog(this, errMessage);
	}

	public MemoDate getSelectedDate() {
		int day = Integer.parseInt((String) this.daysCombo.getSelectedItem());
		int month = Integer.parseInt((String) this.monthsCombo.getSelectedItem());
		int year = Integer.parseInt((String) this.yearsCombo.getSelectedItem());

		return new MemoDate(day, month, year);

	}

	public String getMemoText() {
		return this.memoText.getText();
	}

	public String getFileName() {
		String fileName = JOptionPane.showInputDialog("Enter file name:");
		return fileName;
	}

	public void setMemoText(String memo) {
		this.memoText.setText(memo);

	}

	public boolean dateIsLegal() {

		return this.getSelectedDate().isLegal();

	}

}

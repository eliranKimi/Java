import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class MemoView extends JFrame {

	private static final int MAX_LINES = 20;

	private MemoModel m_model;

	// Combobox

	private JComboBox<String> daysCombo = new JComboBox<String>();
	private JComboBox<String> monthsCombo = new JComboBox<String>();
	private JComboBox<String> yearsCombo = new JComboBox<String>();

	// Buttons
	private JButton saveBtn = new JButton("Save");
	private JButton getBtn = new JButton("Get record");
	private JButton openFileBtn = new JButton("Open file");

	private JTextArea memoText = new JTextArea();

	public MemoView(MemoModel model) {
		this.m_model = model;

		ArrayList<Integer> days = new ArrayList<Integer>();
		for (int i = 1; i <= 31; i++) {
			days.add(i);
		}

		ArrayList<Integer> months = new ArrayList<Integer>();
		for (int i = 1; i <= 12; i++) {
			months.add(i);
		}

		ArrayList<Integer> years = new ArrayList<Integer>();
		for (int i = 2018; i <= 2030; i++) {
			years.add(i);
		}

		setCombo(this.daysCombo, days);
		setCombo(this.monthsCombo, months);
		setCombo(this.yearsCombo, years);

		JPanel compPanel = new JPanel();

		compPanel.add(daysCombo);
		compPanel.add(monthsCombo);
		compPanel.add(yearsCombo);
		compPanel.add(saveBtn);
		compPanel.add(getBtn);
		compPanel.add(openFileBtn);

		JScrollPane textScroll = new JScrollPane(memoText);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		mainPanel.add(compPanel);
		mainPanel.add(textScroll);

		this.add(mainPanel);

		// this.setSize(WIDTH, HEIGHT);
		this.pack();
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

	public void addOpenFileListener(ActionListener openFileListener) {
		openFileBtn.addActionListener(openFileListener);

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

}

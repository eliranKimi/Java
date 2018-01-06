import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemoController implements IMemoController {

	private MemoModel m_model;
	private MemoView m_view;

	public MemoController(MemoModel m_model, MemoView m_view) {
		super();
		this.m_model = m_model;
		this.m_view = m_view;

		// Add listeners to buttons

		m_view.addSaveListener(new SaveMemoListener());
		m_view.addGetMemoListener(new GetMemoListener());

	}

	class SaveMemoListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (m_view.dateIsLegal() == true) {

				m_model.saveMemo(m_view.getSelectedDate(), m_view.getMemoText(), m_view.getFileName());

			} else {
				m_view.showError("Not a legal date!");
			}

		}
	}

	class GetMemoListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (m_view.dateIsLegal() == true) {

				m_view.setMemoText(m_model.getMemo(m_view.getSelectedDate(), m_view.getFileName()));
			} else {
				m_view.showError("Not a legal date!");

			}

		}
	}

}

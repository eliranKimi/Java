
public class MemoMVC {
	
	
	public static void main(String[] args) {

		MemoModel model = new MemoModel();
		MemoView view = new MemoView(model);
		MemoController controller = new MemoController(model, view);

	}


}

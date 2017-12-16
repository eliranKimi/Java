
public class TestMVC {

	public static void main(String[] args) {

		TestModel model = new TestModel();
		TestView view = new TestView(model);
		TestConroller controller = new TestConroller(model, view);

	}

}

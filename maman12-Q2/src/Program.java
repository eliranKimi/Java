import java.awt.Color;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Program {

	private static final SecureRandom randomNumbers = new SecureRandom();
	private static final int RANGE_OF_NUMBERS = 200;

	private ArrayList<MyShape> shapes;

	public Program() {

		this.shapes = new ArrayList<MyShape>();
		this.copiedShapes = new ArrayList<MyShape>();
		MyJFrame frame = new MyJFrame();

		this.generateShapes();
		this.addToFrame(shapes, frame);
		this.copyShapes();
		this.lowerShapesDownRight(this.copiedShapes);
		this.addToFrame(copiedShapes, frame);

	}

	private ArrayList<MyShape> copiedShapes;

	private void copyShapes() {
		if (this.shapes != null) {
			for (int i = 0; i < shapes.size(); i++) {
				this.copiedShapes.add((MyShape) shapes.get(i).clone());
			}
		}
	}

	private void generateShapes() {
		MyOval oval1 = new MyOval(randomNumbers.nextInt(RANGE_OF_NUMBERS), randomNumbers.nextInt(RANGE_OF_NUMBERS), 100,
				randomNumbers.nextInt(RANGE_OF_NUMBERS), Color.RED, true);
		MyOval oval2 = new MyOval(randomNumbers.nextInt(RANGE_OF_NUMBERS), randomNumbers.nextInt(RANGE_OF_NUMBERS), 100,
				randomNumbers.nextInt(RANGE_OF_NUMBERS), Color.RED, false);
		MyLine line1 = new MyLine(randomNumbers.nextInt(RANGE_OF_NUMBERS), randomNumbers.nextInt(RANGE_OF_NUMBERS), 100,
				randomNumbers.nextInt(RANGE_OF_NUMBERS), Color.BLACK);
		MyLine line2 = new MyLine(randomNumbers.nextInt(RANGE_OF_NUMBERS), randomNumbers.nextInt(RANGE_OF_NUMBERS), 100,
				randomNumbers.nextInt(RANGE_OF_NUMBERS), Color.BLACK);
		MyRectangle rect1 = new MyRectangle(randomNumbers.nextInt(RANGE_OF_NUMBERS),
				randomNumbers.nextInt(RANGE_OF_NUMBERS), 100, randomNumbers.nextInt(RANGE_OF_NUMBERS), Color.BLUE,
				true);
		MyRectangle rect2 = new MyRectangle(randomNumbers.nextInt(RANGE_OF_NUMBERS),
				randomNumbers.nextInt(RANGE_OF_NUMBERS), 100, randomNumbers.nextInt(RANGE_OF_NUMBERS), Color.BLUE,
				false);

		this.shapes.add(oval1);
		this.shapes.add(oval2);
		this.shapes.add(line1);
		this.shapes.add(line2);
		this.shapes.add(rect1);
		this.shapes.add(rect2);
	}

	private void addToFrame(ArrayList<MyShape> anArray, MyJFrame frame) {

		for (int i = 0; i < anArray.size(); i++) {
			frame.add(anArray.get(i));
			frame.setVisible(true);
		}

	}

	private void lowerShapesDownRight(ArrayList<MyShape> anArray) {
		for (int i = 0; i < anArray.size(); i++) {
			MyShape temp = anArray.get(i);
			temp.setX1(temp.getX1() + 10);
			temp.setY1(temp.getY1() + 10);

		}
	}
}

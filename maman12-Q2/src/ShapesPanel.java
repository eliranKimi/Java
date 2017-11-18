import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;
import java.util.ArrayList;
import javax.swing.JPanel;

//Contains most of the logic of the main program.
public class ShapesPanel extends JPanel {

	private static final SecureRandom randomNumbers = new SecureRandom();
	private static final int RANGE_OF_NUMBERS = 200;
	private static final int NUMBER_TO_LOWER = 10;
	private static final boolean FULL = true;
	private static final boolean NOT_FULL = false;

	private ArrayList<MyShape> shapes;
	private ArrayList<MyShape> copiedShapes;

	public ShapesPanel() {
		this.shapes = new ArrayList<MyShape>();
		this.copiedShapes = new ArrayList<MyShape>();

		this.generateShapes(this.shapes);
		this.copyShapes(this.shapes, this.copiedShapes);
		this.makeChangesToShapes(this.copiedShapes);
	}

	private void copyShapes(ArrayList<MyShape> sourceArray, ArrayList<MyShape> copyArray) {
		if (sourceArray != null && copyArray != null) {
			for (int i = 0; i < sourceArray.size(); i++) {
				copyArray.add((MyShape) sourceArray.get(i).clone());
			}
		}
	}

	private void generateShapes(ArrayList<MyShape> anArray) {
		MyOval oval1 = new MyOval(randomNumbers.nextInt(RANGE_OF_NUMBERS), randomNumbers.nextInt(RANGE_OF_NUMBERS),
				randomNumbers.nextInt(RANGE_OF_NUMBERS), randomNumbers.nextInt(RANGE_OF_NUMBERS), Color.RED, FULL);
		MyOval oval2 = new MyOval(randomNumbers.nextInt(RANGE_OF_NUMBERS), randomNumbers.nextInt(RANGE_OF_NUMBERS),
				randomNumbers.nextInt(RANGE_OF_NUMBERS), randomNumbers.nextInt(RANGE_OF_NUMBERS), Color.RED, NOT_FULL);
		MyLine line1 = new MyLine(randomNumbers.nextInt(RANGE_OF_NUMBERS), randomNumbers.nextInt(RANGE_OF_NUMBERS),
				randomNumbers.nextInt(RANGE_OF_NUMBERS), randomNumbers.nextInt(RANGE_OF_NUMBERS), Color.MAGENTA);
		MyLine line2 = new MyLine(randomNumbers.nextInt(RANGE_OF_NUMBERS), randomNumbers.nextInt(RANGE_OF_NUMBERS),
				randomNumbers.nextInt(RANGE_OF_NUMBERS), randomNumbers.nextInt(RANGE_OF_NUMBERS), Color.MAGENTA);
		MyRectangle rect1 = new MyRectangle(randomNumbers.nextInt(RANGE_OF_NUMBERS),
				randomNumbers.nextInt(RANGE_OF_NUMBERS), randomNumbers.nextInt(RANGE_OF_NUMBERS),
				randomNumbers.nextInt(RANGE_OF_NUMBERS), Color.BLUE, NOT_FULL);
		MyRectangle rect2 = new MyRectangle(randomNumbers.nextInt(RANGE_OF_NUMBERS),
				randomNumbers.nextInt(RANGE_OF_NUMBERS), randomNumbers.nextInt(RANGE_OF_NUMBERS),
				randomNumbers.nextInt(RANGE_OF_NUMBERS), Color.BLUE, NOT_FULL);

		anArray.add(oval1);
		anArray.add(oval2);
		anArray.add(line1);
		anArray.add(line2);
		anArray.add(rect1);
		anArray.add(rect2);
	}

	private void paintArray(ArrayList<MyShape> anArray, Graphics g) {
		for (int i = 0; i < anArray.size(); i++) {
			anArray.get(i).paint(g);
		}
	}

	private void makeChangesToShapes(ArrayList<MyShape> anArray) {
		// Lower down and right
		for (int i = 0; i < anArray.size(); i++) {
			MyShape temp = anArray.get(i);

			// X1&X2 are the coordinates of the top left corner of the shape (And not x1,y1
			// as described on the exercise)
			temp.setX1(temp.getX1() + NUMBER_TO_LOWER);
			temp.setX2(temp.getX2() + NUMBER_TO_LOWER);

			// Change to opposite of fill status
			if (temp instanceof MyBoundedShape) {
				MyBoundedShape x = (MyBoundedShape) temp;
				x.setFull(!x.getIsFull());
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.paintArray(shapes, g);
		this.paintArray(copiedShapes, g);
	}
}

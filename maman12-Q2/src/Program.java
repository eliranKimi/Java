import java.awt.Color;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Program {

	private static final SecureRandom randomNumbers = new SecureRandom();
	private static final int RANGE_OF_NUMBERS = 200;
	private static final int NUMBER_TO_LOWER = 10;
	private static final boolean FULL = true;
	private static final boolean NOT_FULL = false;

	private ArrayList<MyShape> shapes;

	public Program() {

		this.shapes = new ArrayList<MyShape>();
		this.copiedShapes = new ArrayList<MyShape>();
		MyJFrame frame = new MyJFrame();

		this.generateShapes(this.shapes);
		this.addToFrame(this.shapes, frame);
		this.copyShapes(this.shapes, this.copiedShapes);
		this.makeChangesToShapes(this.copiedShapes);
		this.addToFrame(this.copiedShapes, frame);

	}

	private ArrayList<MyShape> copiedShapes;

	private void copyShapes(ArrayList<MyShape> sourceArray, ArrayList<MyShape> copyArray) {
		if (sourceArray != null && copyArray != null) {
			for (int i = 0; i < sourceArray.size(); i++) {
				copyArray.add((MyShape) sourceArray.get(i).clone());
			}
		}
	}

	private void generateShapes(ArrayList<MyShape> anArray) {
		MyOval oval1 = new MyOval(randomNumbers.nextInt(RANGE_OF_NUMBERS), randomNumbers.nextInt(RANGE_OF_NUMBERS),
				randomNumbers.nextInt(RANGE_OF_NUMBERS), randomNumbers.nextInt(RANGE_OF_NUMBERS), Color.RED, NOT_FULL);
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

	private void addToFrame(ArrayList<MyShape> anArray, MyJFrame frame) {

		for (int i = 0; i < anArray.size(); i++) {
			frame.add(anArray.get(i));
			frame.setVisible(true);
		}

	}

	private void makeChangesToShapes(ArrayList<MyShape> anArray) {
		
		//Lower down and right
		for (int i = 0; i < anArray.size(); i++) {
			MyShape temp = anArray.get(i);
			
			// X1&X2 are the coordinates of the top left corner of the shape (And not x1,y1 as described on the exercise)
			temp.setX1(temp.getX1() + NUMBER_TO_LOWER);
			temp.setX2(temp.getX2() + NUMBER_TO_LOWER);
		
			//Change to opposite of full status
			if (temp instanceof MyBoundedShape) {
				MyBoundedShape x = (MyBoundedShape) temp;
				x.setFull(!x.getIsFull());

			}

		}
	}
}

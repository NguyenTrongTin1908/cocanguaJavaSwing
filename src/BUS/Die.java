package BUS;
import java.util.Random;

public class Die {
	/* Xúc xắc */
	private int steps = 0;

	/* Gieo xúc xắc */
	public void thrown() {
		Random random = new Random();
		steps = (random.nextInt(6) + 1);
	}

	/* Lấy gía trị xúc xắc gieo được */
	public int getSteps() {
		return steps;
	}
}
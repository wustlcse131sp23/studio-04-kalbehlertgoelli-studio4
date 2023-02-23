package studio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); // making Scanner with a File
		String Shape = in.next();
		StdDraw.setPenColor(in.nextInt(), in.nextInt(), in.nextInt());
		boolean fill = in.nextBoolean();
		if (Shape.equals("triangle")) {
			double x[] = new double[3];
			double y[] = new double[3];
			for (int i = 0; i < 3; i++) {
				x[i] = in.nextDouble();
				y[i] = in.nextDouble();
			}
			if (fill) {
				StdDraw.filledPolygon(x, y);
			} else {
				StdDraw.polygon(x, y);
			}
		} else if (Shape.equals("rectangle"))
			if (fill)
				StdDraw.filledRectangle(in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble());
			else
				StdDraw.rectangle(in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble());
		else if (Shape.equals("ellipse"))
			if (fill)
				StdDraw.filledEllipse(in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble());
			else
				StdDraw.ellipse(in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble());

	}
}

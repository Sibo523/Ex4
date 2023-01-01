package Exe.Ex4;
import java.awt.Color;
import java.awt.image.CropImageFilter;

import Exe.Ex4.geo.*;
import Exe.Ex4.gui.Ex4;
/**
 * A very simple main class for basic code for Ex4
 * 
 * t2: output:
 * GUIShape,0,true,1,Circle2D,3.0,4.0, 2.0
 * GUIShape,255,false,2,Circle2D,6.0,8.0, 4.0
 * 
 * @author boaz.ben-moshe
 *
 */
public class Ex4Main {

	public static void main(String[] args) {
		// t1();
		t2();
		// t3(); // won't work "out of the box" - requires editing the code (save, load..)
	}
	// Minimal empty frame (no shapes)
	public static void t1() {
		Ex4 ex4 = Ex4.getInstance();
		ex4.show();
	} 
	// Two simple circles
	public static void t2() {
		Ex4 ex4 = Ex4.getInstance();
		ShapeCollectionable shapes = ex4.getShape_Collection();
		// points
		Point2D p1 = new Point2D(3,4);
		Point2D p2 = new Point2D(6,8);
		Point2D p3 = new Point2D(0,0);
		// the shape
		Circle2D c1 = new Circle2D(p1,2);
		Circle2D c2 = new Circle2D(p2,4);
		Segment2D seg= new Segment2D(p1,p2);
		Rect2D rect = new Rect2D(p1,p2);
		Triangle2D tri = new Triangle2D(p1,p2,p3);
		//gui
		GUI_Shapeable gs1 = new GUIShape(c1, true, Color.black, 1);
		GUI_Shapeable gs2 = new GUIShape(c2, false, Color.blue, 2);
		GUI_Shapeable gs3 = new GUIShape(seg,true, Color.blue,2);
		GUI_Shapeable gs4 = new GUIShape(rect,true, Color.blue,2);
		GUI_Shapeable gs5 = new GUIShape(tri,true, Color.blue,2);
		//assertion
		shapes.add(gs4);
		shapes.add(gs1);
		shapes.add(gs2);
		shapes.add(gs3);
		shapes.add(gs5);


		//ex4.init(shapes);
		ex4.show();
		System.out.print(ex4.getInfo());
	}
	// Loads a file from file a0.txt (Circles only).
	public static void t3() {
		Ex4 ex4 = Ex4.getInstance();
		ShapeCollectionable shapes = ex4.getShape_Collection();
		String file = "a0.txt"; //make sure the file is your working directory.
		shapes.load(file);
		ex4.init(shapes);
		ex4.show();
	}

}

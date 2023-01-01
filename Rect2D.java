package Exe.Ex4.geo;

/**
 * This class represents a 2D rectangle (NOT necessarily axis parallel - this shape can be rotated!)
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect2D implements GeoShapeable {
	private Point2D Scorn;
	private Point2D Ecor;
	private Point2D _p3;
	private Point2D _p4;
	private double length;
	private double width;
	public Rect2D(Point2D p2, Point2D p1) {
		this.Scorn = p1;
		this.Ecor = p2;
		this._p3 = new Point2D(p1.x(),p2.y());
		this._p4 = new Point2D(p2.x(),p1.y());
		this.length = Scorn.distance(_p3);
		this.width = Ecor.distance(_p3);
	}

	@Override
	public boolean contains(Point2D ot) {
		double Area = area();
		double A1 = Area(Scorn, _p3 , ot);
		double A2 = Area(Scorn, _p4 , ot);
		double A3 = Area(Ecor , _p3 , ot);
		double A4 = Area(Ecor , _p4 , ot );
		return (A1+A2+A3+A4==Area);
	}
	/*
	this funtion computes a triangle Area using Shoelace theorom
	 */
	private double Area(Point2D p1, Point2D p2, Point2D ot) {
		return ((p1.x() * p2.y() + p2.x() * ot.y() + ot.x() * p1.y()) - (p1.y() * p2.x() + p2.y() * ot.x() + ot.y() * p1.x())) / 2;
	}


	@Override
	public double area() {
	return length*width;
	}

	@Override
	public double perimeter() {

		return length*width*2;
	}

	@Override
	public void move(Point2D vec) {
		Scorn.move(vec);
		Ecor.move(vec);
		copy();
	}

	@Override
	public GeoShapeable copy() {
		return new Rect2D(Ecor, Scorn);
	}

	@Override
	public void scale(Point2D center, double ratio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rotate(Point2D center, double angleDegrees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[4];
		ans[0] =new Point2D(Scorn);
		ans[1] = new Point2D(Ecor);
		ans[2] = new Point2D(Scorn.x(), Ecor.y());
		ans[3] = new Point2D(Ecor.x(), Scorn.y());
		return ans;
	}

}

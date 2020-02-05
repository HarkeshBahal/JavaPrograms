package corejavaassignment;

public class Rectangle {
	float widthRectangle;
	float heigthRectangle;
	Rectangle(float width, float height){
		widthRectangle = width;
		heigthRectangle = height;
	}
	
	public float areaOfRectangle() {
		return (widthRectangle*heigthRectangle);
	}
	public float getHeight() {
		return heigthRectangle;
	}
	
	public float getWidth() {
		return widthRectangle;
	}

}

/*
 * Class: CMSC203 CRN20931
 * Instructor: Khandan Monshi
 * Description: child of both property and management company classes, stores information of where each property is located, along with their sizes
 * Due: 11/11/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Kyran Heijkoop
*/

public class Plot {
	
	private int x;
	private int y;
	private int width;
	private int depth;
	
	public Plot() {
		this.width = 1;
		this.depth = 1;
	}
	
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public Plot(Plot otherPlot) {
		this.x = otherPlot.getX();
		this.y = otherPlot.getY();
		this.width = otherPlot.getWidth();
		this.depth = otherPlot.getDepth();
	}
	
	public boolean overlaps(Plot plot) {
		int xOverlap = 0;
		int yOverlap = 0;
		
		for (int i = this.x; i <= this.x + this.width; i++) {
			for (int k = plot.getX(); k <= plot.getX() + plot.getWidth(); k++) {
				if (i == k) {
					xOverlap++;
				}
			}
		}
		
		for (int j = this.y; j <= this.y + this.depth; j++) {
			for (int l = plot.getY(); l <= plot.getY() + plot.getDepth(); l++) {
				if (j == l) {
					yOverlap++;
				}
			}
		}
		
		return xOverlap >=2 && yOverlap >= 2;
	}
	
	public boolean encompasses(Plot plot) {
		int xOverlap = 0;
		int yOverlap = 0;
		
		for (int i = this.x; i <= this.x + this.width; i++) {
			for (int k = plot.getX(); k <= plot.getX() + plot.getWidth(); k++) {
				if (i == k) {
					xOverlap++;
				}
			}
		}
		
		for (int j = this.y; j <= this.y + this.depth; j++) {
			for (int l = plot.getY(); l <= plot.getY() + plot.getDepth(); l++) {
				if (j == l) {
					yOverlap++;
				}
			}
		}
		
		return xOverlap == plot.getWidth() + 1 && yOverlap == plot.getDepth() + 1 ? true : false;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public String toString() {
		return x + "," + y + "," + width + "," + depth;
	}
}

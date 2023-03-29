public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth;

	public Plot(){
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}

	public Plot(Plot p){
		this.x = p.x;
		this.y = p.x;
		this.width = p.width;
		this.depth = p.depth;
	}

	public Plot(int x, int y, int width, int depth){
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public boolean overlaps(Plot plot){
		
		if ((x < plot.getX()) && (plot.getX() < (x+width))){
			if (((y < plot.getY()) && (plot.getY() < (y+depth))) || ((y < (plot.getY()+plot.getDepth())) && ((plot.getY() + plot.getDepth()) < (y+depth)))) {
				return true;
			}
		}
		if ((x < (plot.getX() + plot.getWidth())) && ((plot.getX()+plot.getWidth()) < (x+width))){
			if (((y < plot.getY()) && (plot.getY() < (y+depth))) || ((y < (plot.getY()+plot.getDepth())) && ((plot.getY() + plot.getDepth()) < (y+depth)))) {
				return true;
			}
		}
		
		if ((plot.getX() < x) && (x < (plot.getX()+plot.getWidth()))){
			if (((plot.getY() < y) && (y < (plot.getY()+plot.getDepth()))) || ((plot.getY() < (y+depth)) && ((y+depth) < (plot.getY() + plot.getDepth())))) {
				return true;
			}
		}
		if ((plot.getX() < (x+width)) && ((x+width) < (plot.getX()+plot.getWidth()))){
			if (((plot.getY() < y) && (y < (plot.getY() + plot.getDepth()))) || ( (plot.getY() < (y+depth)) && ((y+depth) < (plot.getY() + plot.getDepth())))) {
				return true;
			}
		}
		
		if (encompasses(plot)) {
			return true;
		}
		
		return false;
		
	}
	
	public boolean encompasses(Plot plot){
		if ((x <= plot.getX()) && (plot.getX() <= (x+width))){
			if ((y <= plot.getY()) && (plot.getY() <= (y+depth))){
				if ((x <= (plot.getX()+plot.getWidth())) && ((plot.getX()+plot.getWidth()) <= (x+width))) {
					if ((y <= (plot.getY()+plot.getDepth())) && ((plot.getY()+plot.getDepth()) <= (y+depth))) {
						return true;
					}
				}
			}
			
		}
		
		return false;
}

	public void setX(int x){
		this.x = x;
	}
	
	public int getX() {
		return x;
	}

	public void setY(int y){
		this.y = y;
	}
	
	public int getY() {
		return y;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth() {
		return width;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getDepth() {
		return depth;
	}

	public String toString() {
		String str = "Upper left: (" + getX() + "," + getY() + "); Width: " + getWidth() + " Depth: " + getDepth();

		return str;
	}

}
package projects;

public class Ships {

	private char startX;
	private char startY;
	private char endX;
	private char endY;
	
	int cellCounts;
	int notHittedCells;
	
	public Ships(String shipLocation) {
		
		char[] arr= shipLocation.toCharArray();
		
		this.startX = arr[0];
		this.endX = arr[3];
		this.startY = arr[1];
		this.endY= arr[4];
		
		this.cellCounts = (endX - startX + 1) * (Character.getNumericValue(endY) - Character.getNumericValue(startY) + 1);
		this.notHittedCells = cellCounts;
	}
	
	public boolean targetSucess(String targetInfo) {
		char[] arr = targetInfo.toCharArray();
		return arr[0]>=this.startX && arr[0]<=this.endX && arr[1]>=this.startY && arr[1]<=this.endY;
	}
		
}

package projects;
public class TestShip {

	public static void main(String[] args) {
		
		String result = test("1A 2A,12A 12A", "12A");
		System.out.println(result);

	}

	public static String test(String shipLocationInfo, String targetsInfo) {
		
		int sunkShips = 0;
		//int NotHittedCell = 0;
		int perfectShip = 0;
		String[] locationArr = shipLocationInfo.split(",");
		Ships[] shipsArr = new Ships[locationArr.length];
		
		//create ships:
		
		for (int i = 0; i < shipsArr.length; i++) {
			Ships ship = new Ships(locationArr[i]);
			shipsArr[i] = ship;
		}
		
		String[] targetsArr = targetsInfo.split(" ");
		// see if targets touched ships
		for (int i = 0; i < shipsArr.length; i++) {
			for (int j = 0; j < targetsArr.length; j++) {
				if(shipsArr[i].targetSucess(targetsArr[j])) {
					shipsArr[i].notHittedCells--;
				}
			}
		}
		
		for (Ships ship : shipsArr) {
			if(ship.notHittedCells==0)
				sunkShips++;
			else if (ship.notHittedCells==ship.cellCounts)
				perfectShip++;
			else continue;
		}
		
		int hittedShips = shipsArr.length - perfectShip - sunkShips;
		return String.format("Sunk ships: %d , Hitted ships: %d", sunkShips, hittedShips );
	}
}

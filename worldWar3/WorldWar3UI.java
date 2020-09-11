package worldWar3;

import warOfPlaces.WarOfPlacesGame;
import edu.upb.lp.progra.adapterFiles.AndroidGameGUI;
import edu.upb.lp.progra.adapterFiles.UI;

public class WorldWar3UI implements UI{

	private AndroidGameGUI gui;
	private WorldWar3Game game = new WorldWar3Game(this);
	
	public WorldWar3UI(AndroidGameGUI gui) {

		this.gui = gui;

	}
	
	@Override
	public void onButtonPressed(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCellPressed(int vertical, int horizontal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialiseInterface() {
		// TODO Auto-generated method stub
		
	}

}

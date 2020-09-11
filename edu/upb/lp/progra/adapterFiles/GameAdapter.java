package edu.upb.lp.progra.adapterFiles;


import warOfPlaces.WarOfPlacesUI;
import worldWar3.WorldWar3UI;

//import edu.upb.lp.progra.BugWorld.BugWorldUI;
//import edu.upb.lp.progra.superJuegoMegaCoolMuyComplejo.SuperJuegoMegaCoolMuyComplejoUI;

/**
 * This class allows to select what UI will be used by the Android library.
 * 
 * @author Alexis Marechal
 * @author Alfredo Villalba
 */
public class GameAdapter {
	public static UI selectGame(AndroidGameGUI gui) {
		return new WorldWar3UI(gui);
	}	
}

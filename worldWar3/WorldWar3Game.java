package worldWar3;

import warOfPlaces.Bala;
import warOfPlaces.CreadorDeEnemigos;
import warOfPlaces.Enemigo;
import warOfPlaces.MovedorDeBala;
import warOfPlaces.MovedorDeEnemigo;
import warOfPlaces.Personaje;
import warOfPlaces.WarOfPlacesUI;

public class WorldWar3Game {

	private WorldWar3UI ui;
	private Personaje monigote = new Personaje(100, true, this);
	private Enemigo[] malotes = new Enemigo[5];
	private CreadorDeEnemigos creador = new CreadorDeEnemigos(this);
	private Bala bala = new Bala(this);

	private int score = 0;
	private int level = 1;
	
	public WorldWar3Game(WorldWar3UI ui) {

		this.ui = ui;

	}

	public int getLevel() {

		return level;

	}

	public int getHealth() {

		return monigote.getHealth();

	}

	public int getScore() {

		return score;

	}

	public void setLevel(int level) {

		this.level = level;

	}

	public void changeLevel(int level) {

		this.level += level;

	}

	public void gainScore() {

		score++;

	}

	public void setScore(int score) {

		this.score = score;

	}
	
	public void borrarImagen(int v, int h) {
		
		ui.borrarImagen(v, h);
		
	}

	public void moverMonigote(int v, int h, String direccion) {
		
		ui.moverImagen(v, h, direccion);
		
	}

	public void derecha() {

		monigote.moverDerecha();

	}

	public void izquierda() {

		monigote.moverIzquierda();

	}

	public void saltar() {

		monigote.saltar();

	}


	public void mirarArriba() {

		monigote.mirarArriba();

	}

	public void mirarDiagonalDerecha() {

		monigote.mirarDiagonalDerecha();

	}

	public void mirarDiagonalIzquierda() {

		monigote.mirarDiagonalIzquierda();

	}

	public void executeLater(Runnable r, int ms) {
		ui.executeLater(r, ms);
	}

	public void crearEnemigo() {

		if (monigote.getState()) {

			creador.start();

		}
	}

	public void generadorDeEnemigos() {

		for (int i = 0; i < malotes.length; i++) {
			if (malotes[i] == null) {
				malotes[i] = new Enemigo(100, this);
				malotes[i].crearMalote();
				i = malotes.length;
			}

		}

	}

	public void crearMalote(int v, int h, String direccion) {

		ui.crearImagenMalote(v, h, direccion);

	}

	public void moverMalote(int v, int h, String direccion) {

		ui.moverImagenMalote(v, h, direccion);

	}

	public void disparar() {

		if (monigote.getState()) {

			bala.disparar(monigote);

		}

	}

	public void crearBala(int v, int h, String direccion) {

		ui.crearImagenBala(v, h, direccion);

	}

	public void verificarCoordenadasBala(int v, int h, MovedorDeBala movedor) {
		for (int i = 0; i < malotes.length; i++) {
			if (malotes[i] != null && malotes[i].getHealth() > 0
					&& malotes[i].getCoordenadaV() == v
					&& malotes[i].getCoordenadaH() == h) {
				movedor.stop();
				malotes[i].recibirDaño(100);
				borrarImagen(v, h);

			}
		}

	}

	public void verificarCoordenadasMalote(int v, int h) {

		if (monigote.getHealth() > 0 && v == monigote.getCoordenadasV()
				&& h == monigote.getCoordenadasH()) {

			monigote.recibirDaño(25);
			ui.actualizar();

		}

	}

	public void verificarCoordenadasPersonaje(int v, int h) {

		for (int i = 0; i < malotes.length; i++) {

			if (malotes[i] != null && v == malotes[i].getCoordenadaV()
					&& h == malotes[i].getCoordenadaH()) {

				monigote.recibirDaño(25);
				ui.actualizar();

			}

		}

	}

	public void monigoteMuere(int v, int h) {

		borrarImagen(v, h);
		monigote.setState(false);
		ui.mostrarMensaje();

	}

	public void murioMalote(Enemigo m, int v, int h, MovedorDeEnemigo movedor) {

		for (int i = 0; i < malotes.length; i++) {
			if (malotes[i] == m) {
				movedor.stop();
				borrarImagen(v, h);
				gainScore();
				ui.actualizar();
				malotes[i] = null;
				i = malotes.length;
				verificarScore();
			}

		}

	}

	public void verificarScore() {

		if (score == 10 || score == 20 || score == 30 || score == 40
				|| score == 50 || score == 60) {

			cambiarNivel();
			score++;
			ui.actualizar();

		}

	}

	public void restart() {
		monigote.setState(true);
		monigote.setHealth(100);
		setLevel(1);
		setScore(0);
		monigote.setCoordenadas(9, 0);
		monigote.setDireccion("derecha");
		for (int i = 0; i < malotes.length; i++) {

			if (malotes[i] != null) {

				malotes[i].detenerMovedor();
				malotes[i].setHealth(100);
				malotes[i].crearMalote();

			}

		}
		ui.detenerMusica();

		ui.initialiseInterface();

	}

	public void cambiarNivel() {

		changeLevel(1);
		monigote.setCoordenadas(9, 0);
		monigote.setDireccion("derecha");

		for (int i = 0; i < malotes.length; i++) {

			if (malotes[i] != null) {

				malotes[i].detenerMovedor();
				malotes[i].setHealth(100);
				malotes[i].crearMalote();

			}
		}
		ui.detenerMusica();
		ui.initialiseInterface();

	}

}


}

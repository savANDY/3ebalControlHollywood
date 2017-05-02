package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Actor;
import modelo.ActorModelo;
import modelo.Film;
import modelo.FilmModelo;
import vista.ConsultorFilms;

public class FilmControlador {

	private ConsultorFilms consultorFilms;
	private FilmModelo filmModelo;
	private ActorModelo actorModelo;

	// Getters y Setters:
	public ConsultorFilms getConsultorFilms() {
		return consultorFilms;
	}

	public void setConsultorFilms(ConsultorFilms consultorFilms) {
		this.consultorFilms = consultorFilms;
	}

	public FilmModelo getFilmModelo() {
		return filmModelo;
	}

	public void setFilmModelo(FilmModelo filmModelo) {
		this.filmModelo = filmModelo;
	}

	public ActorModelo getActorModelo() {
		return actorModelo;
	}

	public void setActorModelo(ActorModelo actorModelo) {
		this.actorModelo = actorModelo;
	}

	// Metodos:
	public void abrirConsultorFilms() {

		ArrayList<Film> films = this.filmModelo.seleccionarTodos();

		this.consultorFilms.rellenarComboFilms(films);
		consultorFilms.setVisible(true);

	}

	public void rellenarConsultorFilms(int idFilm) {

		Film film = this.filmModelo.select(idFilm);
		this.rellenarTablaActores(idFilm);
		this.consultorFilms.rellenarCampos(film);

	}

	private void rellenarTablaActores(int idFilm) {
		
		ArrayList<Actor> actores;

		try {

			System.out.println(idFilm);
			actores = actorModelo.seleccionarPorFilm(idFilm);
			consultorFilms.rellenarTabla(actores);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR AL SELECCIONAR ACTORES");
			 e.printStackTrace();
			// e.getMessage();
		}
		
	}

//	public void rellenarActores(int idFilm) {
//
//		ArrayList<Actor> actores;
//
//		try {
//
//			System.out.println(idFilm);
//			actores = actorModelo.seleccionarPorFilm(idFilm);
//			consultorFilms.rellenarTabla(actores);
//
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "ERROR AL SELECCIONAR ACTORES");
//			 e.printStackTrace();
//			// e.getMessage();
//		}
//	}

}

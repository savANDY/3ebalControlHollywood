package main;

import controlador.ActorControlador;
import controlador.FilmControlador;
import vista.*;
import modelo.*;

public class Main {

	public static void main(String[] args) {

		ActorControlador actorControlador = new ActorControlador();
		FilmControlador filmControlador = new FilmControlador();

		FilmModelo filmModelo = new FilmModelo();
		ActorModelo actorModelo = new ActorModelo();

		Principal principal = new Principal();
		principal.setActorControlador(actorControlador);
		principal.setFilmControlador(filmControlador);

		// ACTOR
		FormularioActor formularioActor = new FormularioActor(principal, true);
		formularioActor.setActorControlador(actorControlador);

		actorControlador.setFormularioActor(formularioActor);
		actorControlador.setActorModelo(actorModelo);

		// FILMS
		ConsultorFilms consultorFilms = new ConsultorFilms(principal, true);
		consultorFilms.setFilmControlador(filmControlador);

		filmControlador.setConsultorFilms(consultorFilms);
		filmControlador.setFilmModelo(filmModelo);
		filmControlador.setActorModelo(actorModelo);
		
		// Abrir la ventana principal
		principal.setVisible(true);
	}

}

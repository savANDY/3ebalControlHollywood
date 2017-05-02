package modelo;

import java.util.ArrayList;

public class Actor {

	private int actorId;
	private String nombre;
	private String apellido;
	private int filmId;

	private ArrayList<Film> films;

	// Getters y Setters

	public String getNombre() {
		return nombre;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public ArrayList<Film> getFilms() {
		return films;
	}

	public void setFilms(ArrayList<Film> films) {
		this.films = films;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	// Constructores:
	public Actor(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Actor() {
		super();
	}

}

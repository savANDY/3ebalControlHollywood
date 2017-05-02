package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmModelo extends Conectar {

	public ArrayList<Film> seleccionarTodos(){
		PreparedStatement pst;
		Film film;

		try {
			pst = cn.prepareStatement("SELECT * FROM film");

			ResultSet rs = pst.executeQuery();// ejecuta

			// pasar de ResultSet a ArrayList

			ArrayList<Film> films = new ArrayList<Film>();
			while (rs.next()) {
				film = new Film();

				film.setFilmId(rs.getInt(1));
				film.setTitulo(rs.getString(2));
				film.setDescription(rs.getString(3));
				film.setReleaseYear(rs.getInt(4));
				film.setLanguageId(rs.getInt(5));
				//System.out.println(film.getTitulo());
				films.add(film);
			}
			return films;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Film select(int idFilm) {
		PreparedStatement ps;
		Film film;
		try {
			ps = cn.prepareStatement("select * from film where film_id = ?");
			ps.setInt(1, idFilm);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				film = new Film();
				film.setFilmId(rs.getInt("film_id"));
				film.setTitulo(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setLanguageId(rs.getInt("language_id"));
				return film;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}

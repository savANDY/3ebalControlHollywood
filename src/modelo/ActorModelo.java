package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ActorModelo extends Conectar {

	public int idMaximo() {
		int idMaximo = 0;

		PreparedStatement pst;
		try {
			pst = cn.prepareStatement("SELECT max(actor_id) as maxid FROM actor");

			ResultSet rs = pst.executeQuery();

			System.out.println(pst);

			if (rs.next()) {
				idMaximo = rs.getInt("maxid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idMaximo;

	}

	public void insertar(Actor actor) throws Exception {

		PreparedStatement pst;
		try {

			pst = cn.prepareStatement("INSERT INTO actor(first_name,last_name) VALUES (?,?)");

			pst.setString(1, actor.getNombre());
			pst.setString(2, actor.getApellido());

			// System.out.println(pst);

			pst.execute();

			System.out.println("Actor insertado correctamente");
		} catch (Exception e) {
			System.out.println("Error al insertar actor");
			// e.getMessage();
			// e.getStackTrace();
			throw e;
		}

	}

		public ArrayList<Actor> seleccionarPorFilm(int idFilm) {
			
			
			PreparedStatement pst;
			try {
				pst = cn.prepareStatement("SELECT A.* FROM actor A, film_actor FA "
						+ " WHERE A.actor_id=FA.actor_id AND"
						+ " FA.film_id = ?");
			
			
			pst.setInt(1, idFilm);
			//System.out.println(pst);
			ResultSet rs = pst.executeQuery();
			
			ArrayList<Actor>  actores =new ArrayList<Actor>();
			
			
			//recorrer los detalles de ese pedido
			
			while (rs.next()){
				
				Actor actor=new Actor();
				
				actor.setActorId(rs.getInt(1));
				actor.setNombre(rs.getString(2));
				actor.setApellido(rs.getString(3));
				
				
				actores.add(actor);
			}
			return(actores);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;

		}
		
//		
//		PreparedStatement ps;
//		Actor actor;
//		ArrayList<Actor> actores = new ArrayList<Actor>();
//		try {
//			ps = cn.prepareStatement("select * from film_actor where film_id = ?");
//			ps.setInt(1, idFilm);
//
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//				actor = new Actor();
//				actor.setActorId(rs.getInt("actor_id"));
//				actor.setFilmId(rs.getInt("film_id"));
//				actores.add(actor);
//			}
//
//			return actores;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//
//	}

	public String seleccionarPorId(int idActor) {
		PreparedStatement ps;
		Actor actor;
		try {
			ps = cn.prepareStatement("select * from film where actor_id = ?");
			ps.setInt(1, idActor);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				actor = new Actor();
				actor.setFilmId(rs.getInt("actor_id"));
				actor.setNombre(rs.getString("first_name"));
				actor.setApellido(rs.getString("last_name"));
				String nombreApellido = actor.getNombre() + " " + actor.getApellido();
				return nombreApellido;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public boolean comprobar(String nombre, String apellido) {
		
		PreparedStatement ps;
		Actor actor;
		try {
			ps = cn.prepareStatement("select * from actor where first_name = ? AND last_name = ?");
			ps.setString(1, nombre);
			ps.setString(2, apellido);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}

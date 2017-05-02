package controlador;

import javax.swing.JOptionPane;

import modelo.Actor;
import modelo.ActorModelo;
import vista.FormularioActor;
import vista.Principal;

public class ActorControlador {

	private FormularioActor formularioActor;
	private ActorModelo actorModelo;

	// Getters y Setters:
	public FormularioActor getFormularioActor() {
		return formularioActor;
	}

	public void setFormularioActor(FormularioActor formularioActor) {
		this.formularioActor = formularioActor;
	}

	public ActorModelo getActorModelo() {
		return actorModelo;
	}

	public void setActorModelo(ActorModelo actorModelo) {
		this.actorModelo = actorModelo;
	}

	// Metodos

	public void abrirFormularioActor() {

		formularioActor.seleccionarMaxId();
		formularioActor.setVisible(true);

	}

	public int idMaximo() {
		int idMaximo = actorModelo.idMaximo();
		return idMaximo;
	}

	public void insertarActor(String nombre, String apellido) {

		Actor actor = new Actor();

		actor.setNombre(nombre);
		actor.setApellido(apellido);


		System.out.println(actor.getNombre());
		System.out.println(actor.getApellido());

		try {
			actorModelo.insertar(actor);

			JOptionPane.showMessageDialog(null, "ACTOR " + actor.getNombre() + " " +  actor.getApellido() + " INSERTADO EN LA BD");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR ACTOR");
			e.getMessage();
			// e.printStackTrace();
		}

	}

	public Boolean comprobarActor(String Nombre, String Apellido) {
		
		if (actorModelo.comprobar(Nombre, Apellido)){
			return true;
		} else {
			return false;
		}
	}

}

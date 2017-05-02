package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ActorControlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioActor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JTextField textNombre;
	private JTextField textApellido;
	
	private ActorControlador actorControlador;
	private JTextField textId;
	
	// Getters y Setters
	
	public ActorControlador getActorControlador() {
		return actorControlador;
	}

	public void setActorControlador(ActorControlador actorControlador) {
		this.actorControlador = actorControlador;
	}

	/**
	 * Create the dialog.
	 */
	public FormularioActor(Principal parent, boolean modal) {

		super(parent, modal);
		setTitle("Formulario Actor");
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(22, 71, 46, 14);
			contentPanel.add(lblNombre);
		}
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(22, 108, 46, 14);
		contentPanel.add(lblApellido);
		
		textNombre = new JTextField();
		textNombre.setBounds(78, 68, 86, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(78, 105, 86, 20);
		contentPanel.add(textApellido);
		textApellido.setColumns(10);
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setEnabled(false);
		textId.setColumns(10);
		textId.setBounds(78, 35, 86, 20);
		contentPanel.add(textId);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(22, 38, 46, 14);
		contentPanel.add(lblId);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton gaurdarButton = new JButton("Guardar");
				gaurdarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						Boolean comprobar = actorControlador.comprobarActor(textNombre.getText(), textApellido.getText());
						
						if (!comprobar) {
						actorControlador.insertarActor(textNombre.getText(), textApellido.getText());
						} else {
							JOptionPane.showMessageDialog(null, "Ese autor ya existe!");
						}
						
					}
				});
				gaurdarButton.setActionCommand("Guardar");
				buttonPane.add(gaurdarButton);
				getRootPane().setDefaultButton(gaurdarButton);
			}
		}
	}

	public void seleccionarMaxId() {

		textId.setText(String.valueOf(actorControlador.idMaximo() + 1));
		
	}
}

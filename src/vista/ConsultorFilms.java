package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controlador.FilmControlador;
import modelo.Actor;
import modelo.Film;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultorFilms extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JTable tableActores;
	private JTextField textFieldAnioEstreno;
	private JTextField textFieldLengua;
	private JTextArea textAreaDescripcion;
	private JComboBox comboBoxFilms;

	private FilmControlador filmControlador;

	// Getters y Setters:
	public FilmControlador getFilmControlador() {
		return filmControlador;
	}

	public void setFilmControlador(FilmControlador filmControlador) {
		this.filmControlador = filmControlador;
	}

	/**
	 * Create the dialog.
	 */
	public ConsultorFilms(Principal parent, boolean modal) {

		super(parent, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		comboBoxFilms = new JComboBox();
		comboBoxFilms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nombreFilm = (String) comboBoxFilms.getSelectedItem();
				String nombreDefault = "Selecciona un film...";
				if ((nombreFilm != null) && (!nombreFilm.equals(nombreDefault))) {
					String[] partes = nombreFilm.split(":");
					// en la parte 0 esta el id del film

					filmControlador.rellenarConsultorFilms(Integer.parseInt(partes[0]));
				}
				
			}
		});
		comboBoxFilms.setModel(new DefaultComboBoxModel(new String[] {"Selecciona un film..."}));

		comboBoxFilms.setBounds(10, 31, 203, 20);
		contentPanel.add(comboBoxFilms);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(283, 48, 120, 139);
		contentPanel.add(scrollPane);

		tableActores = new JTable();
		scrollPane.setViewportView(tableActores);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(10, 83, 58, 14);
		contentPanel.add(lblDescripcion);

		JLabel lblAnioEstreno = new JLabel("A\u00F1o Estreno:");
		lblAnioEstreno.setBounds(10, 145, 70, 14);
		contentPanel.add(lblAnioEstreno);

		JLabel lblLengua = new JLabel("Lengua:");
		lblLengua.setBounds(10, 173, 46, 14);
		contentPanel.add(lblLengua);

		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBounds(78, 78, 135, 52);
		contentPanel.add(textAreaDescripcion);

		textFieldAnioEstreno = new JTextField();
		textFieldAnioEstreno.setBounds(78, 142, 135, 20);
		contentPanel.add(textFieldAnioEstreno);
		textFieldAnioEstreno.setColumns(10);

		textFieldLengua = new JTextField();
		textFieldLengua.setBounds(78, 170, 135, 20);
		contentPanel.add(textFieldLengua);
		textFieldLengua.setColumns(10);

		JLabel lblFimls = new JLabel("Fimls");
		lblFimls.setBounds(10, 11, 46, 14);
		contentPanel.add(lblFimls);

		JLabel lblActores = new JLabel("Actores");
		lblActores.setBounds(283, 23, 70, 14);
		contentPanel.add(lblActores);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

	public void rellenarComboFilms(ArrayList<Film> films) {

		Iterator<Film> iterator = films.iterator();
		while (iterator.hasNext()) {
			Film film = iterator.next();
			this.comboBoxFilms
					.addItem(film.getFilmId() + ": " + film.getTitulo());
		}

	}

	public void rellenarCampos(Film film) {

		this.textAreaDescripcion.setText(film.getDescription());
		this.textFieldAnioEstreno.setText(String.valueOf(film.getReleaseYear()));
		this.textFieldLengua.setText(String.valueOf(film.getLanguageId()));		
		
	}

	public void rellenarTabla(ArrayList<Actor> actores) {
		// cargar la tabla
		DefaultTableModel dtm = new DefaultTableModel();

		String[] encabezados = { "NOMBRE", "APELLIDO" };

		dtm.setColumnIdentifiers(encabezados);
		for (Actor actor : actores) {
			String[] fila = { actor.getNombre(), actor.getApellido() };
			dtm.addRow(fila);
		}
		tableActores.setModel(dtm);
		TableRowSorter<DefaultTableModel> modeloOrdenado = new TableRowSorter<DefaultTableModel>(dtm);
		tableActores.setRowSorter(modeloOrdenado);
	}

	public void rellenarTablaActores(int idFilm) {
		
		
		
	}

}

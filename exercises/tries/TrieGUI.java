import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrieGUI {
	private Trie trieStr;
	private JTextArea textArea;
	private String strText;
	private JTextField textSearch;
	private JTextField textReplace;

	public TrieGUI() {
		trieStr = new Trie();
	}

	public void showGUI() {
		JFrame frame = new JFrame("Buscar y Reemplazar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel(new BorderLayout());

		panel.add(createFormPanel(), BorderLayout.NORTH);
		panel.add(createButtonPanel(), BorderLayout.SOUTH);

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	public JPanel createFormPanel() {
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);

		JLabel textLabel = new JLabel("Texto:");
		panel.add(textLabel, constraints);

		constraints.gridx = 1;
		textArea = new JTextArea(5, 30);
		JScrollPane scrollPane = new JScrollPane(textArea);
		panel.add(scrollPane, constraints);


		constraints.gridy = 1;
		constraints.gridx = 0;
		JLabel searchLabel = new JLabel("Buscar:");
		panel.add(searchLabel, constraints);

		constraints.gridx = 1;
		textSearch = new JTextField(10);
		panel.add(textSearch, constraints);

		constraints.gridy = 2;
		constraints.gridx = 0;
		JLabel replaceLabel = new JLabel("Reemplazar por:");
		panel.add(replaceLabel, constraints);

		constraints.gridx = 1;
		textReplace = new JTextField(10);
		panel.add(textReplace, constraints);


		return panel;
	}

	public JPanel createButtonPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		JButton enterTextButton = new JButton("Ingresar Texto");
		enterTextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarTexto();
			}
		});
		panel.add(enterTextButton);

		JButton searchButton = new JButton("Buscar");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarTexto();
			}
		});
		panel.add(searchButton);

		JButton replaceButton = new JButton("Reemplazar");
		replaceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reemplazarTexto();
			}
		});
		panel.add(replaceButton);

		JButton cancelarButton = new JButton("Cancelar");
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelarOperacion();
			}
		});
		panel.add(cancelarButton);

		return panel;
	}

	private void ingresarTexto() {
		strText = textArea.getText();
		loadText();
	}

	private void buscarTexto() {

	}

	private void reemplazarTexto() {
		// Obtener strings
		strText = textArea.getText();
		String strSearch = textSearch.getText();
		String strReplace = textReplace.getText();

		strText = trieStr.replace(strText, strSearch, strReplace);
		
		loadText();
	}

	private void cancelarOperacion() {
		textArea.setText("");
		textSearch.setText("");
		textReplace.setText("");
	}

	private void loadText() {
		textArea.setText(strText);
	}

	public static void main(String[] args) {
		TrieGUI programa = new TrieGUI();
		programa.showGUI();
	}

}

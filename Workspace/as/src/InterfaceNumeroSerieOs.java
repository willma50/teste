import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterfaceNumeroSerieOs extends JFrame implements ActionListener {
	private Container tela = getContentPane();
	private JPanel painelNorte = new JPanel();
	private JPanel painelCentro = new JPanel();
	private JPanel painelSul = new JPanel();
	private JPanel painelRotulo = new JPanel();
	private JPanel painelTextField = new JPanel();
	private JLabel labelNumeroSerie = new JLabel("Nº de Série do Equipamento");
	private JLabel labelEspaco, labelEspaco2;
	private JTextField textNumero = new JTextField(25);
	private JButton btOk = new JButton("OK");
	private int opcao;

	public InterfaceNumeroSerieOs(int op) {
		super("Consulta Por Nº de Série");
		this.opcao = op;
		FlowLayout flow = new FlowLayout();
		flow.setAlignment(FlowLayout.LEFT);
		painelCentro.setLayout(new BoxLayout(painelCentro, BoxLayout.Y_AXIS));

		tela.add(painelCentro, BorderLayout.CENTER);
		tela.add(painelSul, BorderLayout.SOUTH);
		tela.add(painelNorte, BorderLayout.NORTH);
		// painelCentro.add(painelRotulo);
		painelCentro.add(painelTextField);
		painelTextField.setLayout(flow);
		painelTextField.add(painelRotulo);
		labelEspaco = new JLabel("    ");

		painelRotulo.setLayout(new GridLayout(3, 1));
		painelRotulo.add(labelNumeroSerie);
		painelRotulo.add(labelEspaco);
		painelRotulo.add(textNumero);
		textNumero.grabFocus();
		painelSul.add(btOk);
		btOk.addActionListener(this);
		setSize(400, 170);
		setVisible(true);
		setLocationRelativeTo(null);
		
	}

	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource() == btOk) {
			if (testando()==false) {
				OperacoesDoSistema o = new OperacoesDoSistema();
				if (opcao == 0) {
					o.tabelaRegistraDiagnosticoOs(textNumero.getText());
				} else if (opcao == 1) {
					o.tabelaRegistrarAutorizacao(textNumero.getText());
				} else if (opcao == 2) {
					o.tabelaRegistraConserto(textNumero.getText());
				}else if(opcao == 3){
					o.pagaroS(textNumero.getText());
				}

			}
		}

	}

	boolean testando() {
		boolean erro = false;
		String mErros = "";
		if (textNumero.getText().equals("")) {
			 mErros = "Este campo não pode ficar em branco!";
			 textNumero.grabFocus();
			erro = true;
		}
		if (erro == true) {
			JOptionPane.showMessageDialog(null, mErros, " Erro ",
					JOptionPane.ERROR_MESSAGE);
		}
		return erro;
	}
	
}

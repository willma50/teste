import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class InterfaceServico extends JFrame implements ActionListener {

	private Container tela = getContentPane();
	private JPanel painelNorte = new JPanel();
	private JPanel painelCentro = new JPanel();
	private JPanel painelSul = new JPanel();
	private JPanel painelRotulo = new JPanel();
	private JPanel painelTextField = new JPanel();
	private JLabel labelDesc = new JLabel("Descrição");
	private JLabel labelValor = new JLabel("Valor");
	private JLabel labelEspaco, labelEspaco2;
	private JTextField textDesc = new JTextField(25);
	private JTextField textValor = new JTextField(6);
	private JButton btOk = new JButton("OK");

	private OrdemServico os;

	public InterfaceServico(OrdemServico os1) {
		super("SERVIÇO");
		FlowLayout flow = new FlowLayout();
		flow.setAlignment(FlowLayout.LEFT);
		painelCentro.setLayout(new BoxLayout(painelCentro, BoxLayout.Y_AXIS));

		tela.add(painelCentro, BorderLayout.CENTER);
		tela.add(painelSul, BorderLayout.SOUTH);
		tela.add(painelNorte, BorderLayout.NORTH);
		painelCentro.add(painelRotulo);
		painelCentro.add(painelTextField);
		labelEspaco = new JLabel("                                     ");
		labelEspaco2 = new JLabel("      ");
		painelRotulo.setLayout(flow);
		painelRotulo.add(labelEspaco2);

		labelEspaco2 = new JLabel("                                        ");
		painelRotulo.add(labelDesc);
		labelEspaco = new JLabel("                                         ");
		painelRotulo.add(labelEspaco);
		painelRotulo.add(labelEspaco2);
		// painelRotulo.add(labelEspaco2);
		painelRotulo.add(labelValor);
		labelEspaco = new JLabel("          ");
		painelTextField.add(textDesc);
		painelTextField.add(labelEspaco);
		painelTextField.add(textValor);
		painelSul.add(btOk);
		this.os = os1;
		btOk.addActionListener(this);
		getRootPane().setDefaultButton(btOk);
		//setVisible(true);
		setSize(450, 170);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btOk) {
			if (testando() == false) {
				OrdemServico os = this.os;
				OperacoesDoSistema o = new OperacoesDoSistema();
				Double val = 0.0;
				String v = String.valueOf(textValor.getText());
				if (!v.equals("")) {
					val = Double.parseDouble(v);
				}
				Servico serv = new Servico(textDesc.getText(), val);
				int idServ = o.cadastraServico(serv);
				ItemOrdemServico item = new ItemOrdemServico(idServ, os
						.getId_ordemServico());
				o.casdrataItemOrdemServico(item);
			}
		}
	}

	public boolean testando() {
		boolean erro = false;
		String mErros = "";
		if (textDesc.equals("")) {
			mErros = "Não foi informado a Descrição do Serviço!";
			textDesc.grabFocus();
			erro = true;
		} else if (textValor.equals("")) {
			mErros = "Não foi informou o Valor do Serviço!";
			textValor.grabFocus();
			erro = true;
		}
		if (erro == true) {
			JOptionPane.showMessageDialog(null, mErros, " Erro ",
					JOptionPane.ERROR_MESSAGE);
		}
		return erro;
	}

}

import java.awt.BorderLayout;
import java.awt.Color;
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


public class InterfaceConsultaNome extends JFrame implements ActionListener{
	
	private Container tela = getContentPane();
	private JPanel painelNorte = new JPanel();
	private JPanel painelCentro = new JPanel();
	private JPanel painelSul = new JPanel();
	private JPanel painelRotulo = new JPanel();
	private JPanel painelTextField = new JPanel();
	
	private JLabel labelNome = new JLabel("Nome do Cliente");
	private JLabel labelEspaco, labelEspaco2;
	private JTextField textNome = new JTextField(40);
	private JButton btOk = new JButton("OK");
	private int opcao = 0;
	
	public InterfaceConsultaNome(int opcao) {
	super("Consulta Por Nome do Cliente");
	FlowLayout flow = new FlowLayout();
	flow.setAlignment(FlowLayout.LEFT);
	
	painelCentro.setLayout(new BoxLayout(painelCentro, BoxLayout.Y_AXIS));
	painelSul.setBackground( Color.blue);
	
	tela.add(painelCentro, BorderLayout.CENTER);
	tela.add(painelSul, BorderLayout.SOUTH);
	tela.add(painelNorte, BorderLayout.NORTH);

	painelCentro.add(painelTextField);
	painelTextField.add(painelRotulo);
	
	labelEspaco = new JLabel("    ");
	 this.opcao = opcao;
	painelRotulo.setLayout(new GridLayout(3,1));
	painelRotulo.add(labelNome);
	painelRotulo.add(labelEspaco);
	painelRotulo.add(textNome);
	textNome.grabFocus();
	painelSul.add(btOk);
	btOk.addActionListener(this);
	
	
	setSize(480,170);
	setVisible(true);
	setLocationRelativeTo(null);
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btOk){
			
			if(testando() == false){
				OperacoesDoSistema o = new OperacoesDoSistema();
				if(opcao == 0){
			 o.tabelaConsultaCliente(textNome.getText());	
				}else if(opcao == 1){
					o.tabelaAgendaCliente(textNome.getText());	
				}
		}
		}
	}
	boolean testando() {
		boolean erro = false;
		String mErros = "";
		if (textNome.getText().equals("")) {
			 mErros = "Este campo não pode ficar em branco!";
			 textNome.grabFocus();
			erro = true;
		}
		if (erro == true) {
			JOptionPane.showMessageDialog(null, mErros, " Erro ",
					JOptionPane.ERROR_MESSAGE);
		}
		return erro;
	}
	
}

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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

public class InterfacePeca extends JFrame implements ActionListener{
	private Container tela = getContentPane();
	private JPanel painelNorte = new JPanel();
	private JPanel painelCentro = new JPanel();
	private JPanel painelSul = new JPanel();
	private JPanel painel = new JPanel();
	private JPanel painelNome = new JPanel();
	private JPanel painelValor = new JPanel();
	private JLabel labelNome = new JLabel("Nome");
	private JLabel labelValor = new JLabel ("Valor");
	private JLabel labelQuantidade = new JLabel("Quantidade");
	private JTextField texQuantidade = new JTextField(2);
	//JLabel labelEspaco, labelEspaco2;
	private JTextField textNome = new JTextField(25);
	private JTextField textValor = new JTextField(6);
	private JButton btOk = new JButton("OK");
	
	private int idOrdemS, idItemOrdemS;

	public InterfacePeca(int idItemOs) {
	super("Inserir Peça");
	FlowLayout flow = new FlowLayout();
	flow.setAlignment(FlowLayout.LEFT);
	painelCentro.setLayout(new BoxLayout(painelCentro, BoxLayout.Y_AXIS));
	
	tela.add(painelCentro, BorderLayout.CENTER);
	tela.add(painelSul, BorderLayout.SOUTH);
	tela.add(painelNorte, BorderLayout.NORTH);
	
//	painelCentro.add(painelNorte);
	painelCentro.add(painel);
	painelSul.add(btOk);
	
	this.idItemOrdemS = idItemOs;
	painel.setLayout(flow);
	painel.add(painelNome);
	painel.add(painelValor);
	
	painelNome.setLayout(flow);
	painelNome.add(labelNome);
	painelNome.add(textNome);
	
	painelValor.setLayout(flow);
	painelValor.add(labelQuantidade);
	painelValor.add(texQuantidade);
	painelValor.add(labelValor);
	painelValor.add(textValor);
	
	btOk.addActionListener(this);
	setSize(400,270);
	setVisible(true);
	setLocationRelativeTo(null);
	
	}
	
	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getSource() == btOk){
			if(testando() == false){
			OperacoesDoSistema o = new OperacoesDoSistema();
			String q =String.valueOf(texQuantidade.getText());
			int quant = Integer.parseInt(q);
			String v =String.valueOf(textValor.getText());
			Double v1 = Double.parseDouble(v);
			Peca p = new Peca(textNome.getText(),v1 );
			int idP = o.cadastraPeca(p);
			ItemOrdemServicoPeca itemOsPeca = new ItemOrdemServicoPeca();
			itemOsPeca.setIdPeca(idP);
			itemOsPeca.setIdItemOs(idItemOrdemS);
			itemOsPeca.setQuantidade(quant);
			o.cadastraItemOsPeca(itemOsPeca);
			}
		}
	}
	
	public boolean testando(){
	boolean	erro = false;
	String mErros = "";
	if(textNome.equals("")){
		mErros = "Não foi informado o nome da Peça!";
		textNome.grabFocus();
		erro = true;
	}else if(texQuantidade.equals("")){
		mErros = "Não foi informado a quantidade de Peças!";
		texQuantidade.grabFocus();
		erro = true;
	}else if(textValor.equals("")){
		mErros = "Não informou o valor da Peça";
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

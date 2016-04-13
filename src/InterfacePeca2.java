import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterfacePeca2 extends JFrame implements ActionListener {
	private Container tela = getContentPane();
	private JPanel painelNorte = new JPanel();
	private JPanel painelCentro = new JPanel();
	private JPanel painelSul = new JPanel();
	private JPanel painel = new JPanel();
	// JPanel painel2 = new JPanel();
	// JPanel painel3 = new JPanel();
	private JPanel painelRotulo = new JPanel();
	private JPanel painelChecbox = new JPanel();
	private ArrayList<JCheckBox> checBoxs = new ArrayList<JCheckBox>();
	private JLabel labelNome, labelQuantidade = new JLabel("Quantidade"),
			labelVal = new JLabel("Valor");
	OperacoesDoSistema o = new OperacoesDoSistema();
	private JButton btOk = new JButton("OK"); 
	private int idItemOrdemS;

	public InterfacePeca2(int idItemOs) {

		FlowLayout flow = new FlowLayout();
		flow.setAlignment(FlowLayout.LEFT);
		painelCentro.setLayout(new BoxLayout(painelCentro, BoxLayout.Y_AXIS));
		painelChecbox.setLayout(new BoxLayout(painelChecbox, BoxLayout.Y_AXIS));
		
		tela.add(painelCentro, BorderLayout.CENTER);
		tela.add(painelSul, BorderLayout.SOUTH);
		
		painelSul.add(btOk);

	//	painelCentro.setLayout(flow);
		painelCentro.add(painelRotulo);
		labelNome = new JLabel("Nome");
		painelRotulo.add(labelNome);
		painelCentro.add(painelNorte);
	//	painelChecbox.setLayout(flow);
		painelNorte.setLayout(new GridLayout(1, 1));
		painelNorte.add(painelChecbox);

		painelCentro.add(painel);
		painel.setLayout(new GridLayout(1, 1));
		

		ArrayList<Peca> peca = new ArrayList<Peca>();
		peca = o.selecionaPeca();
		for (int i = 0; i < peca.size(); i++) {
			JCheckBox checbx = new JCheckBox(peca.get(i).getNomePeca());
			checbx.setMnemonic((int) peca.get(i).getIdPeca());
			JTextField texQuan = new JTextField(2);
			checBoxs.add(checbx);
		}

		for (int i = 0; i < checBoxs.size(); i++) {
			painelChecbox.add(checBoxs.get(i));
		}
		painelChecbox.setBorder(BorderFactory.createEtchedBorder());
		this.idItemOrdemS = idItemOs;

		btOk.addActionListener(this);
		setSize(400, 450);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btOk) {
				if(testando() == true){
			ArrayList<ItemOrdemServicoPeca> itemOsPeca = new ArrayList<ItemOrdemServicoPeca>();
			for (int i = 0; i < checBoxs.size(); i++) {
				if (checBoxs.get(i).isSelected()) {
				
					ItemOrdemServicoPeca item = new ItemOrdemServicoPeca();
					item.setIdPeca(checBoxs.get(i).getMnemonic());
					item.setIdItemOs(idItemOrdemS);
					item.setQuantidade(1);
					System.out.println(checBoxs.get(i).getMnemonic());
					itemOsPeca.add(item);
					checBoxs.get(i).setSelected(false);
				}
			}
			o.cadastraItemOsPeca(itemOsPeca);
		}
		}
	}
// TESTA SE FOI SELECIONADO ALGO
	public boolean testando(){
		boolean erro = false;
		String mErro = "";
		for (int i = 0; i < checBoxs.size(); i++) {
			if (checBoxs.get(i).isSelected()) {
				mErro = "Volte! Não selecionou a Peça!";
			erro = true;
			}
		}
		if (erro == false) {
			JOptionPane.showMessageDialog(null, mErro, " Erro ",
					JOptionPane.ERROR_MESSAGE);
		}
		return erro;
	}
	/*public String converter_data(String $data) {    
		// Recebemos a data no formato: dd/mm/aaaa     
		// Convertemos a data para o formato: aaaa-mm-dd     
		String $nova_data;
		$data = "02/12/2007";
		$nova_data = implode("-", array_reverse(explode("/", $data)));
		echo $nova_data1;
		}*/
}

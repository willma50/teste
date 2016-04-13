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

public class InterfaceServico2 extends JFrame implements ActionListener {
	private Container tela = getContentPane();
	private JPanel painelNorte = new JPanel();
	private JPanel painelCentro = new JPanel();
	private JPanel painelSul = new JPanel();
	private JPanel painelRotulo = new JPanel();
	private JPanel painelChecbox = new JPanel();
	private ArrayList<Servico> servico;
	private Vector<JCheckBox> checBoxs = new Vector<JCheckBox>();
	private JLabel labelDescricao, labelEspaco2;
	OperacoesDoSistema o = new OperacoesDoSistema();
	// JPanel painelSul = new JPanel();
	private JButton btOk = new JButton("OK");
	private OrdemServico os;
	
	
	public InterfaceServico2(OrdemServico ordemServ) {
		super();
		FlowLayout flow = new FlowLayout();
		flow.setAlignment(FlowLayout.LEFT);
		painelCentro.setLayout(new BoxLayout(painelCentro, BoxLayout.Y_AXIS));
		painelChecbox.setLayout(new BoxLayout(painelChecbox, BoxLayout.Y_AXIS));
		tela.add(painelCentro, BorderLayout.CENTER);
		tela.add(painelSul, BorderLayout.SOUTH);
		// tela.add(painelNorte, BorderLayout.NORTH);
		painelSul.add(btOk);
		
		servico = o.selecionaServico2();
		for (int i = 0; i < servico.size(); i++) {
			JCheckBox checbx = new JCheckBox(servico.get(i).getDescricao());
			checbx.setMnemonic((int) servico.get(i).getId_servico());
			checBoxs.add(checbx);
		}
		painelCentro.add(painelRotulo);
		painelNorte.setLayout(new GridLayout(1, 1));
		painelCentro.add(painelNorte);
		painelNorte.add(painelChecbox);
		// painelRotulo.setLayout(flow);
		//painelChecbox.setLayout(flow);
		labelDescricao = new JLabel("Descrição");
		painelRotulo.add(labelDescricao);

		for (int i = 0; i < checBoxs.size(); i++)
			painelChecbox.add(checBoxs.get(i));
		painelChecbox.setBorder(BorderFactory.createEtchedBorder());
        this.os = ordemServ;
		btOk.addActionListener(this);
		setSize(500, 550);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == btOk) {
			if(testando() == true){
			ArrayList<ItemOrdemServico> itemOs = new ArrayList<ItemOrdemServico>();
			for (int i = 0; i < checBoxs.size(); i++) {
				if (checBoxs.get(i).isSelected()) {
					ItemOrdemServico item = new ItemOrdemServico(checBoxs
							.get(i).getMnemonic(), os.getId_ordemServico());
					System.out.println(checBoxs.get(i).getMnemonic());
					itemOs.add(item);
					checBoxs.get(i).setSelected(false);
				}
			}
			os.setItemOs(itemOs);
			o.casdrataItemOrdemServico(itemOs);
			}
		}
	}
	// TESTA SE FOI SELECIONADO ALGO
	public boolean testando(){
		boolean erro = false;
		String mErro = "";
		for (int i = 0; i < checBoxs.size(); i++) {
			if (checBoxs.get(i).isSelected()) {
				mErro = "Volte! Não selecionou o Serviço!";
			erro = true;
			}
		}
		if (erro == false) {
			JOptionPane.showMessageDialog(null, mErro, " Erro ",
					JOptionPane.ERROR_MESSAGE);
		}
		return erro;
	}
}

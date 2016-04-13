import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

public class InterfaceTelefone extends JFrame implements ActionListener {

	private Container tela = getContentPane();
	private JPanel panelCenter = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel painel = new JPanel();
	private JPanel painelCima = new JPanel();
	private JPanel painelBaixo = new JPanel();
	private JPanel painelSul = new JPanel();
	private JButton bComfimar, bDeletar;
	private JFormattedTextField numeroTelefone;
	private MaskFormatter mascaratel;
	private JLabel rotuloTel;	
	private JPanel painelSul2 = new JPanel();
	private JPanel painelCentro = new JPanel();// /////
	private JPanel painelRotuloTel = new JPanel();

	Telefone telefone = null;
	// corrigir p trazer o objeto
	public InterfaceTelefone(Telefone tel) {

		super("Alterar Telefone");
		FlowLayout flow = new FlowLayout();
		flow.setAlignment(FlowLayout.LEFT);

		try {
			mascaratel = new MaskFormatter(" (##) #### - #### ");
			mascaratel.setPlaceholderCharacter('_');
		} catch (Exception e) {
		}
		rotuloTel = new JLabel("Telefone");
		numeroTelefone = new JFormattedTextField(mascaratel);
		this.telefone  = tel;
		numeroTelefone.setText(telefone.getNumero());
		
		bComfimar = new JButton("Confirmar");
		bDeletar = new JButton("Deletar");
		painelCentro.setLayout(new BoxLayout(painelCentro, BoxLayout.Y_AXIS));
		tela.add(painelCentro, BorderLayout.CENTER);
		tela.add(painelSul2, BorderLayout.SOUTH);
		painelBaixo.setLayout(new GridLayout(1, 2, 5, 5));
		painelSul2.add(painelBaixo);
		// painelRotuloTel.setLayout(flow);
		painelCentro.add(painelRotuloTel);

		painelRotuloTel.add(rotuloTel);
		painelRotuloTel.add(numeroTelefone);

		painelBaixo.add(bComfimar);
		painelBaixo.add(bDeletar);

		bComfimar.addActionListener(this);
		bDeletar.addActionListener(this);
		
		setSize(280, 170);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent evento) {
		if (testando() == false) {
			OperacoesDoSistema o = new OperacoesDoSistema();
			if (evento.getSource() == bComfimar) {

				Telefone telef = new Telefone(telefone.getIdtelefone(), numeroTelefone
						.getText());
				o.atualizaTelefone(telef);
			} else if (evento.getSource() == bDeletar) {
				o.excluiTelefone(telefone.getIdtelefone());
			}
		}
	}

	public boolean testando() {
		boolean erro = false;
		if (numeroTelefone.getText().equals(" (  ) ____ - ____ ")) {
			erro = true;
			JOptionPane
					.showMessageDialog(
							null,
							"O campo está em Branco!"," Erro ", JOptionPane.ERROR_MESSAGE);
			numeroTelefone.grabFocus();
		}
		return erro;
	}

}

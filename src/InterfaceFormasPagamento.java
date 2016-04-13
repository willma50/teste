import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterfaceFormasPagamento extends JFrame implements ActionListener {
	private Container tela = getContentPane();
	// Pagamento a vista
	
	private JPanel painelCentro = new JPanel();
	// private JPanel painelCentroAvista = new JPanel();
	private JPanel painelSul = new JPanel();
	
	private JPanel painelTotalDesc = new JPanel();
	private JPanel painelValRecTroc = new JPanel();
	OperacoesDoBanco o =new OperacoesDoBanco();
	// Pagamento a cart�o de cr�dito
	private JPanel painelBandeiraCred = new JPanel();
	private JPanel painelAcresTotal = new JPanel();
	private JPanel painelParc = new JPanel();
	// private JPanel painelSul3 = new JPanel();

	// pagamento cart�o de d�bito
	private JPanel painelBandeiraDebit = new JPanel();
	private JPanel painelAcresTotalDebit = new JPanel();

	// pagamento boleto
	private JPanel painelBanco = new JPanel();
	private JPanel painelAcrescTotalBoleto = new JPanel();

	private JTextField textValRec = new JTextField(6),textTotalAvista = new JTextField(6),
	textDesconto = new JTextField(6),textTroco = new JTextField(6),
	totalCred = new JTextField(6),crescCred = new JTextField(5),
	qtdParc = new JTextField(2),valParc = new JTextField(6),
	acrescCred = new JTextField(5),bandeiCred = new JTextField(10),
	totalDebit = new JTextField(6),	bandeiDebit = new JTextField(10),
	acrescDebit = new JTextField(6),bancoDebit = new JTextField(10),
	totalBoleto = new JTextField(6),bancoBolet = new JTextField(10),
	acrescBoleto = new JTextField(6);

	private JLabel labelDesconto = new JLabel("Desconto"),labelTroco = new JLabel("Troco"),
	labelTotalAvista = new JLabel("Valor Total"),	labelValoRec = new JLabel("Valor Recebido"),
	labelBandeiCred = new JLabel("Bandeira"),labelAcrescCred = new JLabel("Acr�scimo"),
	labelTotalCred = new JLabel("Total"),labelValParcel = new JLabel("Valor das parcelas"),
	labelQtdParcel = new JLabel("Quantidade de parcelas"),labelBandeiDebit = new JLabel("Bandeira"),
	labelBancoDebit = new JLabel("Banco"),labelAcrescDebit = new JLabel("Acr�scimo"),
	labelTotalDebit = new JLabel("Total"),labelBancoBoleto = new JLabel("Banco"),
	labelAcrescBolet = new JLabel("Acr�scimo"),labelTotalBolet = new JLabel("Total");
	
	private JButton btOkAvista, btOkCred, btOkDebit, btOkBoleto;

	private String desconto, valPagar, acrescimo, dataPagamento;
	private OrdemServico os = null;
	private int opcaot = 0;

	public InterfaceFormasPagamento(int op, String descAcresc, String valP,
			String dat, OrdemServico ordServ) {
		super("Formas de Pagamento");
		
		
		dataPagamento = dat;
		this.os = ordServ;
		
		FlowLayout flow = new FlowLayout();
		flow.setAlignment(FlowLayout.LEFT);
		painelCentro.setLayout(new BoxLayout(painelCentro, BoxLayout.Y_AXIS));
		tela.add(painelCentro, BorderLayout.CENTER);
		painelSul.setBackground( Color.blue);
		tela.add(painelSul, BorderLayout.SOUTH);
		btOkAvista = new JButton("OK");
		btOkCred = new JButton("OK");
		btOkDebit = new JButton("OK");
		btOkBoleto = new JButton("Imprimir");
		this.opcaot = op;
		if (opcaot == 1) {
			// Pagamento a vista
			setTitle("Pagamento a Vista");
			painelCentro.add(painelTotalDesc);
			painelCentro.add(painelValRecTroc);
			painelCentro.add(painelSul);

			textValRec.addActionListener(this);
			
			// setando os campos
			desconto = descAcresc;
			valPagar = valP;
			textDesconto.setText(desconto);
			textTotalAvista.setText(valPagar);

			painelTotalDesc.setLayout(flow);
			painelTotalDesc.add(labelDesconto);
			painelTotalDesc.add(textDesconto);
			painelTotalDesc.add(labelTotalAvista);
			painelTotalDesc.add(textTotalAvista);

			painelValRecTroc.setLayout(flow);
			painelValRecTroc.add(labelValoRec);
			painelValRecTroc.add(textValRec);
			painelValRecTroc.add(labelTroco);
			painelValRecTroc.add(textTroco);
			painelSul.add(btOkAvista);
		} else if (opcaot == 2) {
			// Pagamento a cart�o de cr�dito
			setTitle("Pagamento a Cart�o de Cr�dito");
			painelCentro.add(painelBandeiraCred);
			painelCentro.add(painelAcresTotal);
			painelCentro.add(painelParc);
			painelCentro.add(painelSul);

			qtdParc.addActionListener(this);
			
			acrescCred.setText(acrescimo);
			// setando os campos
			this.acrescimo = descAcresc;
			valPagar = valP;
			
			totalCred.setText(valPagar);

			painelBandeiraCred.add(labelBandeiCred);
			painelBandeiraCred.add(bandeiCred);

			painelAcresTotal.setLayout(flow);
			painelAcresTotal.add(labelAcrescCred);
			painelAcresTotal.add(acrescCred);
			painelAcresTotal.add(labelTotalCred);
			painelAcresTotal.add(totalCred);

			painelParc.setLayout(flow);
			painelParc.add(labelQtdParcel);
			painelParc.add(qtdParc);
			painelParc.add(labelValParcel);
			painelParc.add(valParc);
			painelSul.add(btOkCred);
		} else if (opcaot == 3) {
			// Pagamento a cart�o de d�bito
			setTitle("Pagamento Cart�o de D�bito");
			painelCentro
					.setLayout(new BoxLayout(painelCentro, BoxLayout.Y_AXIS));
			painelCentro.add(painelBandeiraDebit);
			painelCentro.add(painelAcresTotalDebit);
			painelCentro.add(painelSul);
	
			// setando os campos
			acrescimo = descAcresc;
			valPagar = valP;
			acrescDebit.setText(acrescimo);
			totalDebit.setText(valPagar);

			painelBandeiraDebit.setLayout(flow);
			painelBandeiraDebit.add(labelBandeiDebit);
			painelBandeiraDebit.add(bandeiDebit);
			painelBandeiraDebit.add(labelBancoDebit);
			painelBandeiraDebit.add(bancoDebit);

			painelAcresTotalDebit.setLayout(flow);
			painelAcresTotalDebit.add(labelAcrescDebit);
			painelAcresTotalDebit.add(acrescDebit);
			painelAcresTotalDebit.add(labelTotalDebit);
			painelAcresTotalDebit.add(totalDebit);
			painelSul.add(btOkDebit);
		} else if (opcaot == 4) {
			// Pagamento a boleto banc�rio
			setTitle("Pagamento a Boleto Banc�rio");
			painelCentro
					.setLayout(new BoxLayout(painelCentro, BoxLayout.Y_AXIS));
			painelCentro.add(painelBanco);
			painelCentro.add(painelAcrescTotalBoleto);
			painelCentro.add(painelSul);
	
			// setando os campos
			acrescimo = descAcresc;
			valPagar = valP;
			acrescBoleto.setText(acrescimo);
			totalBoleto.setText(valPagar);

			painelBanco.add(labelBancoBoleto);
			painelBanco.add(bancoBolet);

			painelAcrescTotalBoleto.add(labelAcrescBolet);
			painelAcrescTotalBoleto.add(acrescBoleto);
			painelAcrescTotalBoleto.add(labelTotalBolet);
			painelAcrescTotalBoleto.add(totalBoleto);
			painelSul.add(btOkBoleto);
		}
		btOkAvista.addActionListener(this);
		btOkCred.addActionListener(this);
		btOkDebit.addActionListener(this);
		btOkBoleto.addActionListener(this);
		
		setSize(460, 250);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent evento) {
		OperacoesDoSistema o = new OperacoesDoSistema();
		Pagamento p = null;
		Double vP = Double.parseDouble(valPagar);
		if (evento.getSource() == textValRec) {

			Double vR = (o.valido(textValRec.getText()));
			Double toco = vR - vP;
			toco = o.doTest(toco);
			String troc = String.valueOf(toco);
			textTroco.setText(troc);
		} else if (evento.getSource() == btOkAvista) {
			if (testando(opcaot) == false) {
				p = new Pagamento("A vista", vP, dataPagamento, os
						.getId_ordemServico());
				
				o.casdrataPagamento(p);
				os.setValor(vP);
				Cliente c = (Cliente) o.selectClienteid(os.getIdcliente());
				int opcao = 3;
				InterfaceOrdemServico inOs = new InterfaceOrdemServico(opcao,
						c, os);
			}
		} else if (evento.getSource() == qtdParc) {
			if (testando(opcaot) == false) {
				String parc = String.valueOf(qtdParc.getText());
				Double qtdParc = Double.parseDouble(parc);
				Double vParc = vP / qtdParc;
				String valorParc = String.valueOf(o.doTest(vParc));
				valParc.setText(valorParc);
			}
		} else if (evento.getSource() == btOkCred) {
			if (testando(opcaot) == false) {
				p = new Pagamento("Cart�o de Cr�dito", vP, dataPagamento, os
						.getId_ordemServico());
				
				o.casdrataPagamento(p);
				
				os.setValor(vP);
				Cliente c = (Cliente) o.selectClienteid(os.getIdcliente());
				int opcao = 3;
				InterfaceOrdemServico inOs = new InterfaceOrdemServico(opcao,
						c, os);
			}
		} else if (evento.getSource() == btOkDebit) {
			if (testando(opcaot) == false) {
				p = new Pagamento("Cart�o de D�bito", vP, dataPagamento, os
						.getId_ordemServico());
				
				o.casdrataPagamento(p);
				os.setValor(vP);
				Cliente c = (Cliente) o.selectClienteid(os.getIdcliente());
				int opcao = 3;
				InterfaceOrdemServico inOs = new InterfaceOrdemServico(opcao,
						c, os);
			}
		} else if (evento.getSource() == btOkBoleto) {
			if (testando(opcaot) == false) {
				p = new Pagamento("Boleto Banc�rio", vP, dataPagamento, os
						.getId_ordemServico());
				
				o.casdrataPagamento(p);
				os.setValor(vP);
				Cliente c = (Cliente) o.selectClienteid(os.getIdcliente());
				int opcao = 3;
				InterfaceOrdemServico inOs = new InterfaceOrdemServico(opcao,
						c, os);
			}
		}

	}

	public boolean testando(int opcao1) {
		boolean erro = false;
		String mErro = "";
		if (textDesconto.getText().equals("") && (opcao1 == 1)) {
			mErro = "Erro! Este campo n�o pode ficar em branco!";
			textDesconto.grabFocus();
			erro = true;
		} else if (textTotalAvista.getText().equals("") && (opcao1 == 1)) {
			mErro = "Erro! N�o informou a data do pagamento!";
			textTotalAvista.grabFocus();
			erro = true;
		} else if (textValRec.getText().equals("") && (opcao1 == 1)) {
			mErro = " N�o informou o valor Recebido!";
			textValRec.grabFocus();
			erro = true;
		} else if (textTroco.getText().equals("") && (opcao1 == 1)) {
			mErro = " N�o gerou o Troco! Para gerar o troco deve apertar ENTER";
			textTroco.grabFocus();
			erro = true;
		}else if(acrescCred.getText().equals("")&&(opcao1 == 2)){
			mErro = " N�o gerou o Acr�scimo! ";
			acrescCred.grabFocus();
			erro = true;
			
		}else if(totalCred.getText().equals("")&&(opcao1 == 2)){
			mErro = " N�o gerou o Total! ";
			totalCred.grabFocus();
			erro = true;
		}else if(qtdParc.getText().equals("") &&(opcao1 == 2)){
			mErro = " N�o informou a quantidade da parcela!";
			qtdParc.grabFocus();
			erro = true;
		}else if(valParc.getText().equals("")&&(opcao1 == 2)){
			mErro = " N�o gerou o Troco! Para gerar o valor da parcela deve apertar ENTER";
			valParc.grabFocus();
			erro = true;
		}else if(bandeiCred.getText().equals("")&&(opcao1 == 2)){
			mErro = " N�o informou a Bandeira do Cart�o!";
			bandeiCred.grabFocus();
			erro = true;
		}else if(bancoDebit.getText().equals("")&&(opcao1 == 3)){
			mErro = " N�o informou o Banco !";
			bancoDebit.grabFocus();
			erro = true;
		}else if(bandeiDebit.getText().equals("")&&(opcao1 == 3)){
			mErro = " N�o informou a Bandeira do Cart�o!";
			bancoDebit.grabFocus();
			erro = true;
		}else if(bancoBolet.getText().equals("")&&(opcao1 == 4)){
			mErro = " N�o informou o Banco!";
			bancoBolet.grabFocus();
			erro = true;
		}
		if (erro == true) {
			JOptionPane.showMessageDialog(null, mErro, " Erro ",
					JOptionPane.ERROR_MESSAGE);
		}
		return erro;
	}
}

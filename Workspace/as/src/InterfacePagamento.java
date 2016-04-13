import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.RoundingMode;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class InterfacePagamento extends JFrame implements ActionListener {
	private Container tela = getContentPane();
	private JMenuBar barraMenu = new JMenuBar();
	private JMenu pagamento = new JMenu("Formas de Pagamento");
	private JMenuItem pagamentoAvista = new JMenuItem("Pagamento a Vista");
	private JMenuItem pagamentoCartCredito = new JMenuItem("Cartão de Crédito");
	private JMenuItem pagamentoCartDebito = new JMenuItem("Cartão de Débito");
	private JMenuItem pagamentoBoleto = new JMenuItem("Boleto Bancário");
	private JMenuItem sair = new JMenuItem("Sair");
	OperacoesDoSistema o = new OperacoesDoSistema();
	// Pagamento
	private JPanel painelCentro = new JPanel();
	private JPanel painelValOs = new JPanel();
	private JPanel painelData = new JPanel();
	private JPanel painelCima = new JPanel();
	private JLabel labelValOs, labelDatPag;
	private JTextField valOs;
	private JFormattedTextField datPag;
	private MaskFormatter mascaraDatPag;
	private JButton btOkPag;
	
	private OrdemServico os = null;
	private final int opcao1 = 1,opcao2 = 2,opcao3 = 3,opcao4=4; 

	public InterfacePagamento(OrdemServico ordSrv) {
		super("Pagamento");
		FlowLayout flow = new FlowLayout();
		flow.setAlignment(FlowLayout.LEFT);
		

		// barraMenu.add(pagamento);
		barraMenu.add(pagamentoAvista);
		barraMenu.add(pagamentoCartCredito);
		barraMenu.add(pagamentoCartDebito);
		barraMenu.add(pagamentoBoleto);
		// barraMenu.add(sair);
		tela.add(barraMenu, BorderLayout.NORTH);
		tela.add(painelCentro, BorderLayout.CENTER);
		painelCentro.add(painelValOs);
		painelCentro.add(painelData);
		// Pagamento
		labelValOs = new JLabel("Valor da Ordem de Serviço");
		valOs = new JTextField(6);

		this.os = ordSrv;
		
		
		valOs.setText(String.valueOf(os.getValor()));

		try {
			mascaraDatPag = new MaskFormatter(" ####-##-## ");
			mascaraDatPag.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		labelDatPag = new JLabel("Data do Pagamento");
		datPag = new JFormattedTextField(mascaraDatPag);
		datPag.grabFocus();

		painelValOs.add(labelValOs);
		painelValOs.add(valOs);

		painelData.add(labelDatPag);
		painelData.add(datPag);

		pagamentoAvista.addActionListener(this);
		pagamentoCartCredito.addActionListener(this);
		pagamentoBoleto.addActionListener(this);
		pagamentoCartDebito.addActionListener(this);

		setSize(460, 250);
		setLocation(300, 200);
		setVisible(true);
	}

	// s String vos;
	public void actionPerformed(ActionEvent evento) {
		OperacoesDoSistema o = new OperacoesDoSistema();
		InterfaceFormasPagamento pag;
		
		Double valorOs = 0.0;
		String descontoAcrescimo;
		String valorCalculado;
		String val = String.valueOf(valOs.getText());
		if (!val.equals("")) {
			valorOs = o.doTest(Double.parseDouble(val));
		}
		
		if (evento.getSource() == pagamentoAvista) {
			if (testando() == false) {
				PagamentoAvista pVista;
				pVista = new PagamentoAvista(datPag.getText(), valorOs);
				pVista.calculoDescontoTotal();
				pVista.calculoTotal();
				
				descontoAcrescimo = String.valueOf(pVista.getDesconto());
				valorCalculado = String.valueOf(o.doTest(pVista
						.getTotalAvista()));
				pag = new InterfaceFormasPagamento(opcao1, descontoAcrescimo,
						valorCalculado, pVista.getDataPagamento(), os);
			}
		} else if (evento.getSource() == pagamentoCartCredito) {
			if (testando() == false) {
		
			PagamentoCartaoCredito pCredito;
			pCredito = new PagamentoCartaoCredito(datPag.getText(), valorOs);
			pCredito.calculoAcrescimo();
			pCredito.calculoTotal();

			descontoAcrescimo = String.valueOf(o
					.doTest(pCredito.getAcrescimo()));
			
			valorCalculado = String.valueOf(o.doTest(pCredito.getTotalCred()));
			pag = new InterfaceFormasPagamento(opcao2, descontoAcrescimo,
					valorCalculado, pCredito.getDataPagamento(), os);
			}
		} else if (evento.getSource() == pagamentoCartDebito) {
			if (testando() == false) {
			
			PagamentoCartaoDeDebito pDebito = new PagamentoCartaoDeDebito(
					datPag.getText(), valorOs);
			pDebito.calculoAcrescimo();
			pDebito.calculoTotal();
			descontoAcrescimo = String
					.valueOf(o.doTest(pDebito.getAcrescimo()));
			valorCalculado = String.valueOf(o.doTest(pDebito.getTotalDebito()));
			pag = new InterfaceFormasPagamento(opcao3, descontoAcrescimo,
					valorCalculado, pDebito.getDataPagamento(), os);
			}
		} else if (evento.getSource() == pagamentoBoleto) {
			if (testando() == false) {
			
			PagamnetoBoletoBancario pBancario = new PagamnetoBoletoBancario(
					datPag.getText(), valorOs);
			pBancario.calculoAcrescimo();
			pBancario.calculoTotal();
			descontoAcrescimo = String.valueOf(o.doTest(pBancario
					.getAcrescimo()));
			valorCalculado = String.valueOf(o
					.doTest(pBancario.getTotalBoleto()));
			pag = new InterfaceFormasPagamento(opcao4, descontoAcrescimo,
					valorCalculado, pBancario.getDataPagamento(), os);
		}
		}
	}

	public boolean testando() {
		boolean erro = false;
		String mErro = "";
		if (valOs.getText().equals("")) {
			mErro = "Erro! Este campo não pode ficar em branco!";
			valOs.grabFocus();
			erro = true;
		} else if (datPag.getText().equals("")) {
			mErro = "Erro! Não informou a data do pagamento!";
			datPag.grabFocus();
			erro = true;
		}
		if (erro == true) {
			JOptionPane.showMessageDialog(null, mErro, " Erro ",
					JOptionPane.ERROR_MESSAGE);
		}
		
		return erro;

	}
}

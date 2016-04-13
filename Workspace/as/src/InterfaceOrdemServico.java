import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class InterfaceOrdemServico extends JFrame implements ActionListener {
	private Container tela = getContentPane();
	private JPanel painelSul = new JPanel();
	private JPanel painelCentro = new JPanel();// /////
	private JPanel painelCentroNome = new JPanel();
	private JPanel painelCentroNumSerie = new JPanel();
	private JPanel painelCentroDataStatus = new JPanel();
	private JPanel painelDosChecks = new JPanel();// /////////
	private JPanel painelDosChecks2 = new JPanel();
	private JPanel painelCentroConfDefeito = new JPanel();
	private JPanel painelDefeito = new JPanel();
	private JPanel painelConfiguraco = new JPanel();
	private JPanel painelBaixoDiagnostico = new JPanel();
	private JPanel painelBaixoDatPrevConclu = new JPanel();
	private JPanel painelBaixoDatPrev = new JPanel();
	private JPanel painelBaixoDatConclu = new JPanel();
	private JPanel painelBaixoDataFecham = new JPanel();

	private JTextArea textoConfig, textoDefeito, textoDiag;
	private ButtonGroup grup;
	private JScrollPane painelRolgem, painelRolgem2, painelRolgem3;
	private JRadioButton status1, status2, status3, status4, status5, status6;
	private JLabel rotuloNome, rotuloIdCli, rotuloCpf, rotuloDataAbert,
			rotuloStatus, rotuloDefeito, rotuloConfiguracao, rotuloEspaco,
			rotuloDiagnostico, rotuloDatPrevisao, rotuloDatConclusao,
			rotuloDatFechamento, rotuloValor, rotuloNumeroSerie;
	private JTextField nomeCli, idCli, valor, textNumeroSerie;
	private JFormattedTextField cpf, dataAbertura, dataPrevisao, dataConclusao,
			dataFechamento;
	private MaskFormatter mascaracpf, mascaraDataAbert, mascaraDataPrev,
			mascaraDataConclu, mascaraDataFecham;
	private JButton btConfirma, btCancela, btAtualizar1, btAtualizar2,
			inserirServico, inserirServico1;// ,
	// btOk
	private CheckboxGroup grupoCheck;
	private int idCliente = 0;
	// private int idOrdemServ = 0;
	OrdemServico orS = null;
	OperacoesDoSistema o = new OperacoesDoSistema();

	public InterfaceOrdemServico(Cliente c, OrdemServico ordServ, int opcao) {
		super("ABRIR ORDEM DE SERVICO");
		// rotulos
		rotuloNome = new JLabel("NOME :");
		rotuloIdCli = new JLabel("Identificador do Cliente:");
		rotuloCpf = new JLabel("CPF :");
		nomeCli = new JTextField(40);
		idCli = new JTextField(4);
		valor = new JTextField(5);
		rotuloDataAbert = new JLabel("Data da Abertura :");
		rotuloStatus = new JLabel("Status");
		rotuloConfiguracao = new JLabel("Configuração");
		rotuloDefeito = new JLabel("Defeito");
		rotuloDiagnostico = new JLabel("Diagnóstico");
		rotuloDatConclusao = new JLabel("Data da Conclusão");
		rotuloDatPrevisao = new JLabel("Data da Previsão");
		rotuloDatFechamento = new JLabel("Data do Fechamento");
		rotuloNumeroSerie = new JLabel("Nº de Série:");
		rotuloValor = new JLabel("Valor");
		grupoCheck = new CheckboxGroup();
		status1 = new JRadioButton("Aberta");
		status2 = new JRadioButton("Diagnosticada");
		status3 = new JRadioButton("Aprovada");
		status4 = new JRadioButton("Reprovada");
		status5 = new JRadioButton("Liberada");
		status6 = new JRadioButton("Fechada");

		btCancela = new JButton("CANCELAR");
		btConfirma = new JButton("CONFIRMAR");
		btAtualizar1 = new JButton("ATUALIZAR");
		btAtualizar2 = new JButton("ATUALIZAR");
		inserirServico = new JButton("Inserir novo Serviço");
		inserirServico1 = new JButton("Inserir Serviço");

		FlowLayout flow = new FlowLayout();
		flow.setAlignment(FlowLayout.LEFT);
		painelCentro.setLayout(new BoxLayout(painelCentro, BoxLayout.Y_AXIS));
		painelDefeito.setLayout(new BoxLayout(painelDefeito, BoxLayout.Y_AXIS));
		painelConfiguraco.setLayout(new BoxLayout(painelConfiguraco,
				BoxLayout.Y_AXIS));
		painelDosChecks.setLayout(new BoxLayout(painelDosChecks,
				BoxLayout.Y_AXIS));
		painelDosChecks2.setLayout(new BoxLayout(painelDosChecks2,
				BoxLayout.Y_AXIS));
		painelBaixoDatPrev.setLayout(new BoxLayout(painelBaixoDatPrev,
				BoxLayout.Y_AXIS));
		painelBaixoDatConclu.setLayout(new BoxLayout(painelBaixoDatConclu,
				BoxLayout.Y_AXIS));

		tela.add(painelCentro, BorderLayout.CENTER);

		tela.add(painelSul, BorderLayout.SOUTH);

		painelCentro.add(painelCentroNome);
		painelCentro.add(painelCentroNumSerie);
		painelCentro.add(painelCentroDataStatus);
		painelCentro.add(painelCentroConfDefeito);

		painelCentro.add(painelBaixoDiagnostico);
		painelCentro.add(painelBaixoDatPrevConclu);
		painelCentro.add(painelBaixoDataFecham);

		painelCentroNome.setLayout(flow);
		painelCentroNome.add(rotuloNome);
		painelCentroNome.add(nomeCli);
		nomeCli.setText(c.getNome());
		idCliente = c.getIdCliente();

		try {
			mascaracpf = new MaskFormatter(" ######### - ##");
			mascaraDataAbert = new MaskFormatter("####-##-##");
			mascaraDataPrev = new MaskFormatter("####-##-##");
			mascaraDataConclu = new MaskFormatter("####-##-##");
			mascaraDataFecham = new MaskFormatter("####-##-##");

			mascaracpf.setPlaceholderCharacter('_');
			mascaraDataAbert.setPlaceholderCharacter('_');
			mascaraDataConclu.setPlaceholderCharacter('_');
			mascaraDataFecham.setPlaceholderCharacter('_');
			mascaraDataPrev.setPlaceholderCharacter('_');

		} catch (ParseException e) {

			e.getMessage();
		}
		cpf = new JFormattedTextField(mascaracpf);
		dataAbertura = new JFormattedTextField(mascaraDataAbert);
		dataPrevisao = new JFormattedTextField(mascaraDataPrev);
		dataConclusao = new JFormattedTextField(mascaraDataConclu);
		dataFechamento = new JFormattedTextField(mascaraDataFecham);

		cpf.setText(c.getCPF());
		textNumeroSerie = new JTextField(20);

		// painelCentroNumSerie.setLayout(flow);
		painelCentroNumSerie.add(rotuloCpf);
		painelCentroNumSerie.add(cpf);
		painelCentroNumSerie.add(rotuloNumeroSerie);
		painelCentroNumSerie.add(textNumeroSerie);

		painelCentroDataStatus.setLayout(flow);
		painelCentroDataStatus.add(rotuloDataAbert);
		painelCentroDataStatus.add(dataAbertura);

		rotuloEspaco = new JLabel("        ");
		painelCentroDataStatus.add(rotuloEspaco);
		painelCentroDataStatus.add(rotuloStatus);
		painelCentroDataStatus.add(painelDosChecks);
		grup = new ButtonGroup();
		grup.add(status1);
		grup.add(status2);
		grup.add(status3);
		grup.add(status4);
		grup.add(status5);
		grup.add(status6);
		painelDosChecks.add(status1);
		painelDosChecks.add(status2);
		painelDosChecks.add(status3);
		rotuloEspaco = new JLabel("           ");
		painelCentroDataStatus.add(rotuloEspaco);
		painelDosChecks.setBorder(BorderFactory.createEtchedBorder());
		painelCentroDataStatus.add(painelDosChecks2);
		painelDosChecks2.add(status4);
		painelDosChecks2.add(status5);
		painelDosChecks2.add(status6);
		painelDosChecks2.setBorder(BorderFactory.createEtchedBorder());

		painelCentroConfDefeito.setLayout(flow);
		painelCentroConfDefeito.add(rotuloDefeito);
		painelCentroConfDefeito.add(painelDefeito);
		textoDefeito = new JTextArea(5, 15);
		painelDefeito.add(textoDefeito);
		painelRolgem2 = new JScrollPane(textoDefeito);
		painelRolgem2
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		painelRolgem2
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		painelDefeito.add(painelRolgem2);

		painelCentroConfDefeito.add(rotuloConfiguracao);
		painelCentroConfDefeito.add(painelConfiguraco);
		textoConfig = new JTextArea(5, 20);
		painelConfiguraco.add(textoConfig);

		painelRolgem = new JScrollPane(textoConfig);
		painelRolgem
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		painelRolgem
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		painelConfiguraco.add(painelRolgem);

		painelBaixoDiagnostico.setLayout(flow);
		painelBaixoDiagnostico.add(rotuloDiagnostico);
		textoDiag = new JTextArea(3, 41);
		painelBaixoDiagnostico.add(textoDiag);
		painelRolgem3 = new JScrollPane(textoDiag);
		painelRolgem3
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		painelRolgem3
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		painelBaixoDiagnostico.add(painelRolgem3);

		FlowLayout flo = new FlowLayout();
		flo.setAlignment(FlowLayout.CENTER);
		painelBaixoDatPrevConclu.setLayout(flo);
		painelBaixoDatPrevConclu.add(rotuloDatPrevisao);
		rotuloEspaco = new JLabel("       ");
		painelBaixoDatPrevConclu.add(painelBaixoDatPrev);
		painelBaixoDatPrev.add(dataPrevisao);
		painelBaixoDatPrevConclu.add(rotuloEspaco);

		painelBaixoDatPrevConclu.add(rotuloDatConclusao);
		painelBaixoDatPrevConclu.add(painelBaixoDatConclu);
		painelBaixoDatConclu.add(dataConclusao);

		painelBaixoDataFecham.setLayout(flo);
		painelBaixoDataFecham.add(rotuloDatFechamento);
		painelBaixoDataFecham.add(dataFechamento);
		rotuloEspaco = new JLabel("       ");
		painelBaixoDataFecham.add(rotuloEspaco);

		painelBaixoDataFecham.add(rotuloValor);
		painelBaixoDataFecham.add(valor);
		painelSul.setBackground(Color.blue);
		if (opcao == 1) {
			painelSul.add(btConfirma);
			painelSul.add(btCancela);
		} else if (opcao == 2) {
			setTitle("Atualizar Ordem de Serviço");

			this.orS = ordServ;
			painelSul.add(btAtualizar1);
			painelSul.add(inserirServico);
			painelSul.add(inserirServico1);
			painelSul.add(btCancela);
			valor.setText(String.valueOf(ordServ.getValor()));
		} else if (opcao == 3) {
			// idOrdemServ = ordServ.getId_ordemServico();
			this.orS = ordServ;
			painelSul.add(btAtualizar2);
			painelSul.add(btCancela);
		}

		inserirServico.addActionListener(this);
		inserirServico1.addActionListener(this);
		btAtualizar2.addActionListener(this);
		btConfirma.addActionListener(this);
		btCancela.addActionListener(this);
		btAtualizar1.addActionListener(this);
		setResizable(false);
		setSize(550, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	boolean le1 = false;

	public void actionPerformed(ActionEvent evento) {

		if (evento.getSource() == btConfirma) {
			int i = 1;
			boolean test = testandoOs(i);
			if (test == false) {
				OperacoesDoSistema o = new OperacoesDoSistema();
				String status = metodoDoCrec();
				OrdemServico os = new OrdemServico(dataAbertura.getText(),
						nomeCli.getText(), cpf.getText(),
						textoConfig.getText(), textoDefeito.getText(), status,
						idCliente, textNumeroSerie.getText());

				o.abrirOS(os);
				limpar();

			}
		} else if (evento.getSource() == btCancela) {
			System.exit(0);
		} else if (evento.getSource() == btAtualizar1) {
			int i = 2;
			boolean test = testandoOs(i);
			teste2();
			if ((test == false) && (le1 == false)) {
				OperacoesDoSistema o = new OperacoesDoSistema();
				String status = metodoDoCrec();

				if (status != "Reprovada") {

					OrdemServico os = new OrdemServico(this.orS
							.getId_ordemServico(), dataAbertura.getText(),
							nomeCli.getText(), cpf.getText(), textoConfig
									.getText(), textoDefeito.getText(), status,
							textoDiag.getText(), dataPrevisao.getText(),
							dataConclusao.getText(), textNumeroSerie.getText());
					o.atualizaOS(os);

				} else {
					Object[] options = { "Confirmar", "Cancelar" };
					int m = JOptionPane
							.showOptionDialog(
									null,
									"Deseja realizar o Pagamento da Ordem de Serviço agora?",
									"Informação", JOptionPane.DEFAULT_OPTION,
									JOptionPane.WARNING_MESSAGE, null, options,
									options[0]);
					if (m == 0) {
						orS.setValor(25.0);
						InterfacePagamento inP = new InterfacePagamento(orS);

					} else {

					}
				}
			}
			// limpar();
		} else if (evento.getSource() == btAtualizar2) {
			int i = 3;
			boolean test = testandoOs(i);
			if (test == false) {
				OperacoesDoSistema o = new OperacoesDoSistema();
				String status = metodoDoCrec();
				Double valOs = 0.0;
				String v = String.valueOf(valor.getText());
				System.out.println(v);
				if (!v.equals("")) {
					valOs = Double.parseDouble(v);
				}

				OrdemServico os = new OrdemServico(orS.getId_ordemServico(),
						dataAbertura.getText(), nomeCli.getText(), cpf
								.getText(), textoConfig.getText(), textoDefeito
								.getText(), status, textoDiag.getText(),
						dataPrevisao.getText(), dataConclusao.getText(),
						dataFechamento.getText(), valOs, textNumeroSerie
								.getText());
				o.atualizaOS2(os);

			}

		} else if (evento.getSource() == inserirServico) {
			le1 = true;

			o.seleselecionaOSid(o.selecionaOSid(orS.getId_ordemServico()));
		
		} else if (evento.getSource() == inserirServico1) {
			le1 = true;
			InterfaceServico2 in = new InterfaceServico2(orS);
		}
	}

	public boolean teste2() {
		boolean le = false;
		if (le1 == false && status2.isSelected() == true) {
			String b = "faltou inserir Servico";
			JOptionPane.showMessageDialog(null, b, " Erro ",
					JOptionPane.ERROR_MESSAGE);
			le = true;
		}

		return le;
	}

	// Atualiza ordem de serviço
	InterfaceOrdemServico(OrdemServico os, Cliente c, int opcao) {
		this(c, os, opcao);
		OperacoesDoSistema o = new OperacoesDoSistema();
		nomeCli.setText(c.getNome());
		dataAbertura.setText(os.getData_abertura());
		System.out.println("diagnostico " + os.getDiagnostico());
		if (os.getStatus() == "aberta") {
			status1.setSelected(true);
		} else if (os.getStatus() == "Diagnosticada") {
			status2.setSelected(true);
		} else if (os.getStatus() == "Aprovada") {
			status3.setSelected(true);
		} else if (os.getStatus() == "Reprovada") {
			status4.setSelected(true);
		} else if (os.getStatus() == "Liberada") {
			status5.setSelected(true);
		} else if (os.getStatus() == "Fechada") {
			status6.setSelected(true);
		}
		textNumeroSerie.setText(os.getNumeroSerie());
		textoDefeito.setText(os.getDefeito());
		textoConfig.setText(os.getConfiguracao());
		cpf.setText(c.getCPF());
	}

	public InterfaceOrdemServico(int opcao, Cliente c, OrdemServico os) {
		this(os, c, opcao);
		textoDiag.setText(os.getDiagnostico());
		System.out.println("previsao " + os.getData_previsao());
		dataPrevisao.setText(os.getData_previsao());
		dataConclusao.setText(os.getData_conclusao());
		if (os.getValor() != null) {
			valor.setText(String.valueOf(os.getValor()));
		}

	}

	public String metodoDoCrec() {
		String status = "";
		if (status1.isSelected() == true) {
			status = "aberta";
		}
		if (status2.isSelected() == true) {
			status = "Diagnosticada";
			le1 = true;
		}
		if (status3.isSelected() == true) {
			status = "Aprovada";
			le1 = true;
		}
		if (status4.isSelected() == true) {
			status = "Reprovada";

		}
		if (status5.isSelected() == true) {
			status = "Liberada";
			le1 = true;
		}
		if (status6.isSelected() == true) {
			status = "Fechada";

		}
		return status;
	}

	public void limpar() {
		nomeCli.setText(null);
		cpf.setText(null);
		dataAbertura.setText(null);
		idCli.setText(null);
		textoConfig.setText("");
		textoDefeito.setText("");
		status1.setSelected(false);
		status2.setSelected(false);
		status3.setSelected(false);
		status4.setSelected(false);
		status5.setSelected(false);
		status6.setSelected(false);
		dataConclusao.setText(null);
		dataFechamento.setText(null);
		dataPrevisao.setText(null);
		textoDiag.setText("");
		valor.setText("");
		textNumeroSerie.setText("");
	}

	boolean testandoOs(int i) {
		boolean erro = false;
		String mErros = "";
		if (dataAbertura.getText().equals("____-__-__") & (i == 1)) {
			mErros = " Não forneceu a data de data Abertura ! ";
			dataAbertura.grabFocus();
			erro = true;
		} else if (textNumeroSerie.getText().equals("") & (i == 1)) {
			mErros = " Não forneceu o Nº de Série do Equipamento ! ";
			textNumeroSerie.grabFocus();
		} else if (textoDefeito.getText().equals("") & (i == 1)) {
			mErros = " Não forneceu o Defeito do Equipamento";
			textoDefeito.grabFocus();
			erro = true;
		} else if (textoConfig.getText().equals("") & (i == 1)) {
			mErros = " Não forneceu a Configuração do Equipamento";
			textoConfig.grabFocus();
			erro = true;
		} else if ((status1.isSelected() == false)
				&& (status2.isSelected() == false)
				&& (status3.isSelected() == false)
				&& (status4.isSelected() == false)
				&& (status5.isSelected() == false)
				&& (status6.isSelected() == false)) {
			mErros = "Selecione o status da Ordem de Serviço";
			erro = true;

		} else if (dataConclusao.getText().equals("____-__-__") & (i == 2)) {
			mErros = " Não forneceu a data de conclusão! ";
			dataConclusao.grabFocus();
			erro = true;
		} else if (dataPrevisao.getText().equals("____-__-__") & (i == 2)) {////
			mErros = " Não forneceu a data de Previsão ! ";
			dataPrevisao.grabFocus();
			erro = true;
		} else if (dataFechamento.getText().equals("____-__-__") && (i == 3)) {
			mErros = "Não forneceu a data do fechamento";
			dataFechamento.grabFocus();
			erro = true;
		}
		if (erro == true) {
			JOptionPane.showMessageDialog(null, mErros, " Erro ",
					JOptionPane.ERROR_MESSAGE);
		}
		return erro;
	}

}

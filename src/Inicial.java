import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit.AlignmentAction;

public class Inicial extends JFrame implements ActionListener {

	private JPanel painelCentro = new JPanel();
	private JPanel painelsul = new JPanel();
	private JMenuBar barraMenu = new JMenuBar();

	private JMenu cliente = new JMenu("  Cliente  "); // 1
	private JMenuItem cadasCliente = new JMenuItem("Cadastro");
	private JMenu consultaCli = new JMenu("Consulta"); //2
	private JMenuItem consultaNo = new JMenuItem("Nome"); //2.1
	private JMenuItem consultaPadraoCli = new JMenuItem("Padrão"); //2.2
	private JMenuItem agendaTelefônica = new JMenuItem("Agenda Telefônica");
	private JMenuItem sair1 = new JMenuItem("sair");

	private JMenu ordemServ = new JMenu("Ordem de Serviço");
	private JMenu consultaOS2 = new JMenu("Consulta");
	private JMenu consultaPadraoOs = new JMenu("Padrão");
	private JMenuItem registraDiagnosticoOs = new JMenuItem("Diagnosticar");
	private JMenuItem registraAutorizacaoOs = new JMenuItem("Autorizar");
	private JMenuItem registraConsertoOs = new JMenuItem("Registrar Conserto");
	private JMenuItem pagarOS = new JMenuItem("Pagar Ordem de Serviço ");
	private JMenu consultaNumSerie = new JMenu("Nº de Série");
	private JMenuItem registraDiagnosticoOsNumero = new JMenuItem(
			"Diagnosticar");
	private JMenuItem registraAutorizacaoOSsNumero = new JMenuItem("Autorizar");
	private JMenuItem registraConsertoOsNumero = new JMenuItem(
			"Registrar Conserto");
	private JMenuItem pagarOsNumero = new JMenuItem("Pagar Ordem de Serviço ");
	private JMenuItem abrirOS = new JMenuItem(" Abertura  ");
	private JMenuItem consultaOS = new JMenuItem(" Consulta  ");
	
	private JMenuItem insServicoOs = new JMenuItem("Inserir Serviço");

	private JMenuItem inserePeca = new JMenuItem("Inserir Peça");
	private JMenuItem sair2 = new JMenuItem("sair");

	private JMenu agendamento = new JMenu("Agendamento");
	private JMenu agendVisita = new JMenu("Agendar Visita");
	private JMenuItem agendVisitaNome = new JMenuItem("Nome");
	private JMenuItem agendVisitaPadrao = new JMenuItem("Padrão");
	private JMenuItem sair3 = new JMenuItem("sair");


	private JMenu relatorio = new JMenu(" Relatório ");
	
	private JMenu relatorioOs = new JMenu("Relatório da Ordem de Serviço");
	
	private JMenu relatorioOsStatos = new JMenu("Exibir por Status");
	private JMenuItem statusAberta = new JMenuItem("Aberta");
	private JMenuItem statusDiagnosticada = new JMenuItem("Diagnosticada");
	private JMenuItem statusAprovada = new JMenuItem("Aprovada");
	private JMenuItem statusReprovada = new JMenuItem("Reprovada");
	private JMenuItem statusFechada = new JMenuItem("Fechada");
	private JMenuItem statusLiberada = new JMenuItem("Liberada");
	private JMenuItem exibeOsData = new JMenuItem("Exibir por Data");
	private JMenuItem clienteAgendados = new JMenuItem("Clientes Agendados");
	
	private JMenuItem servDiario = new JMenuItem("Serviços Diários");
	private JMenuItem sair4 = new JMenuItem("sair");
	private JLabel imagem;
	private final int opcao0 = 0, opcao1 = 1, opcao2 = 2, opcao3 = 3,
			opcao4 = 4;

	public Inicial() {

		super("Controle e Acompanhamento de Microcomputadores.");
		Container c = getContentPane();
		
		ImageIcon icone = new ImageIcon("imagem1.jpg");
		imagem = new JLabel(icone);

		ImageIcon icone2 = new ImageIcon("logo.jpg");
		JLabel imagem1 = new JLabel(icone2);
		
		ImageIcon icone1 = new ImageIcon("logo.jpg");
		setIconImage(icone1.getImage());
		
		barraMenu.add(cliente);
		cliente.add(cadasCliente);
		cliente.add(consultaCli);
		cliente.add(agendaTelefônica);
		cliente.addSeparator();
		cliente.add(sair1);
		consultaCli.add(consultaNo);
		consultaCli.add(consultaPadraoCli);

		barraMenu.add(ordemServ);
		ordemServ.add(abrirOS);
		//
		ordemServ.add(consultaOS2);

		ordemServ.add(consultaOS);
		ordemServ.add(insServicoOs);
		ordemServ.addSeparator();
		ordemServ.add(sair2);

		consultaOS2.add(consultaPadraoOs);
		consultaOS2.add(consultaNumSerie);
		consultaPadraoOs.add(registraDiagnosticoOs);
		consultaPadraoOs.add(registraAutorizacaoOs);
		consultaPadraoOs.add(registraConsertoOs);
		consultaPadraoOs.add(inserePeca);
		consultaPadraoOs.add(pagarOS);
	
		consultaNumSerie.add(registraDiagnosticoOsNumero);
		consultaNumSerie.add(registraAutorizacaoOSsNumero);
		consultaNumSerie.add(registraConsertoOsNumero);
		consultaNumSerie.add(pagarOsNumero);

		barraMenu.add(agendamento);

		agendamento.add(agendVisita);
		agendamento.addSeparator();
		agendamento.add(sair3);
        agendVisita.add(agendVisitaPadrao);
        agendVisita.add(agendVisitaNome);
        
		barraMenu.add(relatorio);
		relatorio.add(relatorioOs);
		relatorio.add(servDiario);
		relatorio.add(clienteAgendados);
		relatorio.addSeparator();
		relatorio.add(sair4);
		
		relatorioOs.add(relatorioOsStatos);
		relatorioOs.add(exibeOsData);
		
		relatorioOsStatos.add(statusAberta);
		relatorioOsStatos.add(statusDiagnosticada);
		relatorioOsStatos.add(statusAprovada);
		relatorioOsStatos.add(statusReprovada);
		relatorioOsStatos.add(statusLiberada);
		relatorioOsStatos.add(statusFechada);
		
		c.add(barraMenu, BorderLayout.NORTH); // ou esse
		c.add(painelCentro, BorderLayout.CENTER);
		c.add(painelsul, BorderLayout.SOUTH);
		painelCentro.add(imagem1);
		painelsul.add(imagem);
		// painelCentro.setBackground(new Color(110, 210, 90));

		// EVENTOS
		cadasCliente.addActionListener(this);
		abrirOS.addActionListener(this);
		sair1.addActionListener(this);
		exibeOsData.addActionListener(this);
		consultaNo.addActionListener(this);
		consultaPadraoCli.addActionListener(this);
		consultaOS.addActionListener(this);
		registraDiagnosticoOs.addActionListener(this);
		registraAutorizacaoOs.addActionListener(this);
		registraConsertoOs.addActionListener(this);
		sair2.addActionListener(this);
		servDiario.addActionListener(this);
		agendaTelefônica.addActionListener(this);
		sair4.addActionListener(this);
		agendVisitaPadrao.addActionListener(this);
		agendVisitaNome.addActionListener(this);
		insServicoOs.addActionListener(this);
		inserePeca.addActionListener(this);
		pagarOS.addActionListener(this);
		registraConsertoOsNumero.addActionListener(this);
		registraAutorizacaoOSsNumero.addActionListener(this);
		registraDiagnosticoOsNumero.addActionListener(this);
		pagarOsNumero.addActionListener(this);
		statusAberta.addActionListener(this);
		statusDiagnosticada.addActionListener(this);
		statusAprovada.addActionListener(this);
		statusReprovada.addActionListener(this);
		statusLiberada.addActionListener(this);
		statusFechada.addActionListener(this);
		clienteAgendados.addActionListener(this);
		consultaOS.addActionListener(this);
		// setExtendedState(MAXIMIZED_BOTH);

		setResizable(false);
		setSize(550, 705);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent evento) {
		OperacoesDoSistema o = new OperacoesDoSistema();
		if (evento.getSource() == cadasCliente) {

		Cliente cli = null;
			InterfaceCadastro in = new InterfaceCadastro(cli);

		} else if (evento.getSource() == consultaNo) {

			InterfaceConsultaNome iNome = new InterfaceConsultaNome(opcao0);

		} else if (evento.getSource() == consultaPadraoCli) {

			o.tabelaConsultaCliente();

		} else if (evento.getSource() == abrirOS) {

			o.tabelaAbrirOs();

		} else if (evento.getSource() == consultaOS) {
			o.tabelaConsultaOs();
		} else if (evento.getSource() == registraDiagnosticoOs) {

			o.tabelaRegistraDiagnosticoOs();
		} else if (evento.getSource() == registraAutorizacaoOs) {

			o.tabelaRegistrarAutorizacao();

		} else if (evento.getSource() == registraConsertoOs) {

			o.tabelaRegistraConserto();

		} else if (evento.getSource() == registraDiagnosticoOsNumero) {

			InterfaceNumeroSerieOs numOs = new InterfaceNumeroSerieOs(opcao0);

		} else if (evento.getSource() == registraAutorizacaoOSsNumero) {

			InterfaceNumeroSerieOs numOs = new InterfaceNumeroSerieOs(opcao1);

		} else if (evento.getSource() == registraConsertoOsNumero) {

			InterfaceNumeroSerieOs numOs = new InterfaceNumeroSerieOs(opcao2);

		} else if (evento.getSource() == pagarOsNumero) {

			InterfaceNumeroSerieOs numOs = new InterfaceNumeroSerieOs(opcao3);

		} else if (evento.getSource() == insServicoOs) {

			o.tabelConsultaServ();
		} else if (evento.getSource() == servDiario) {

			InterfaceServicosDiarios i = new InterfaceServicosDiarios();
		} else if (evento.getSource() == agendVisitaPadrao) {

			o.tabelaAgendaCliente();
		} else if(evento.getSource() == agendVisitaNome){
			InterfaceConsultaNome inNome = new InterfaceConsultaNome(opcao1);
		}else if (evento.getSource() == agendaTelefônica) {

			o.agendaTelefonica();
		} else if (evento.getSource() == inserePeca) {

			o.tabelInserePeca();
		} else if (evento.getSource() == pagarOS) { // wwwwwwwwwwwwwwww
			o.pagaroS();
		}else if(evento.getSource() == exibeOsData){
			
		}else if(evento.getSource() == statusAberta){
			o.relatorioStatusAberta();
		}else if(evento.getSource() == statusDiagnosticada){
			o.relatorioStatusDiagnosticada();
		}else if(evento.getSource() == statusAprovada){
			o.relatorioStatusAprovada();
		}else if(evento.getSource() == statusReprovada){
			o.relatorioStatusReprovada();
		}else if(evento.getSource() ==statusLiberada){
			o.relatorioStatusLiberada();
		}else if(evento.getSource() ==statusFechada){
			o.relatorioStatusFechada();
		}else if(evento.getSource() ==clienteAgendados){
			o.relatorioAgendaVisita();
		}
	}

	public static void main(String[] args) {
		Inicial i = new Inicial();
		i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class OperacoesDoSistema {

	OperacoesDoBanco ob = new OperacoesDoBanco();

	//   Cliente
	public boolean casdrataCliente(Cliente c) {
		boolean cadcliente = ob.cadastraCliente(c);

		return cadcliente;
	}

	public boolean atualizaCliente(Cliente c) {
		boolean atuacliente = ob.atualizaCliente(c);

		return atuacliente;
	}

	public void excluiCliente(int idCliente) {
		ob.deletaCliente(idCliente);
	}

	public Cliente selectClienteid(int id) {
		Cliente c = ob.selectClienteid(id);

		return c;
	}

	public ResultSet selecionaCliente() {
		ResultSet rs = ob.selectCliente();
		return rs;
	}

	// Pega o ultimo id do cliente e acrescenta mais um P CADASTRA O TELEFONE
	public int pegaUltimoIdClienteMais1() {
		OperacoesDoSistema o = new OperacoesDoSistema();
		ResultSet rs = o.selecionaCliente();
		boolean y = false;
		int x = 0;
		Cliente c = null;
		try {
			while (rs.next()) {
				c = new Cliente(rs.getInt("idcliente"), rs.getString("nome"));
				y = true;
			}
		} catch (Exception e) {
		}

		if (y == true) {
			x = c.getIdCliente() + 1;
		} else {
			x = 1;
		}
		return x;
	}

	// CIDADE
	public ArrayList<Cidade> listCidades() {
		ArrayList<Cidade> listCidade = new ArrayList<Cidade>();
		listCidade = ob.listCidades();

		return listCidade;
	}

	// Ordem Servico
	public boolean abrirOS(OrdemServico os) {
		boolean abOS = ob.abrirOS(os);

		return abOS;
	}

	public void atualizaOS(OrdemServico os) {
			ob.atualizaOS(os);		
	}
	public void atualizaOS2(OrdemServico os) {

		ob.atualizaOS2(os);	
	}
	
	public void excluiOS(int id_ordemServico) {
		ob.deletaOrdemServico(id_ordemServico);
	}

	public ResultSet selecionaOS() {
		ResultSet rs = ob.selectOrdemServico();
		return rs;
	}

	public OrdemServico selecionaOSid(int idOs) {
		OrdemServico os = ob.selectOSeid(idOs);

		return os;
	}
	public Double seleselecionaOSid(OrdemServico selecionaOSid) {
		
		InterfaceServico in = new InterfaceServico(selecionaOSid);
		return pegarvalorOS(selecionaOSid.getId_ordemServico());
		
	}
	// tabela os
	// wwwwwwwwwwwwwwww
	public void tabelaRegistraDiagnosticoOs() {
		ob.tabelaRegistraDiagnosticoOs();
	}
	//seleciona pelo numero de serie
	public void tabelaRegistraDiagnosticoOs(String numSerie) {
		ob.tabelaRegistraDiagnosticoOs(numSerie);
	}

	public void tabelaRegistrarAutorizacao() {
		ob.tabelaRegistrarAutorizacao();
	}
	//seleciona pelo numero de serie
	public void tabelaRegistrarAutorizacao(String numSerie) {
		ob.tabelaRegistrarAutorizacao(numSerie);
	}
	public void tabelaRegistraConserto() {
		ob.tabelaRegistraConserto();
	}
	//seleciona pelo numero de serie
	public void tabelaRegistraConserto(String numSerie) {
		ob.tabelaRegistraConserto(numSerie);
	}

	public void tabelaAbrirOs() {
		ob.tabelaAbreOs();
	}

	public void tabelaConsultaOs() {
		ob.tabelaConsultOs();
	}

	public void tabelaConsultaCliente() {
		ob.tabelaConsultCliente();
	}
	
	//consulta por nome o cliente
	public void tabelaConsultaCliente(String nomeCliente) {
		ob.tabelaConsultCliente(nomeCliente);
	}
	// Agenda visita padrao
	public void tabelaAgendaCliente() {
		ob.tabelaAgendaCliente();
	}
	// Agenda visita por nome
	public void tabelaAgendaCliente(String nomeCliente) {
		ob.tabelaAgendaCliente(nomeCliente);
	}
	public boolean agendaVisita(AgendamentoVisita agenVisita) {
		boolean agendVisita = ob.agendamentoVisita(agenVisita);
		return agendVisita;
	}

	public ResultSet selectAgendaVisita() {
		ResultSet rs = ob.selectAgendaVisita();
		return rs;
	}

	// Servico ///////////mudei
	public int cadastraServico(Servico s) {
		int cadServico = ob.cadastraServico(s);
		return cadServico;
	}

	public void atualizaServico(Servico s) {
		ob.atualizaServico(s);
	}

	public void excluiServico(int id_servico) {
		ob.deletaServico(id_servico);
	}

	public ResultSet selecionaServico() {
		ResultSet rs = ob.selectServico();
		return rs;

	}

	public ArrayList<Servico> selecionaServico2() {
		ArrayList<Servico> listServico = new ArrayList<Servico>();
		listServico = ob.selecionaServico2();

		return listServico;

	}

	public void tabelConsultaServ() {
		ob.tabelaConsultaServ();
	}

	// ITEM sERVIÇO
	public boolean casdrataItemOrdemServico(ArrayList<ItemOrdemServico> item) {
		boolean cadItem = ob.cadastraItemOrdemServico(item);

		return cadItem;
	}

	public boolean casdrataItemOrdemServico(ItemOrdemServico item2) {
		boolean cadItem = ob.cadastraItemOrdemServico2(item2);
		return cadItem;
	}

	public ResultSet selecionaItemOs() {
		ResultSet rs = ob.selectItemOs();
		return rs;

	}


	public int cadastraPeca(Peca p) {
		int cadPeca = ob.cadastraPeca(p);
		return cadPeca;
	}

	public ArrayList<Peca> selecionaPeca() {
		ArrayList<Peca> listPeca = new ArrayList<Peca>();
		listPeca = ob.selecionaPeca();

		return listPeca;

	}

	// PEÇA
	public void tabelInserePeca() {
		ob.tabelaInserePeca();
	}

	public boolean cadastraItemOsPeca(ArrayList<ItemOrdemServicoPeca> itemOsPeca) {
		boolean cadItemOsPeca = ob.cadastraItemOrdemServicoPeca(itemOsPeca);

		return cadItemOsPeca;

	}
	public boolean cadastraItemOsPeca(ItemOrdemServicoPeca itemOsPeca) {
		boolean cadItemOsPeca = ob.cadastraItemOrdemServicoPeca(itemOsPeca);
		return cadItemOsPeca;
	}
	// Telefone
	public boolean casdrataTelefone(ArrayList<Telefone> t) {
		boolean cadTelefone = ob.cadastraTelefone(t);

		return cadTelefone;
	}

	public void atualizaTelefone(Telefone t) {
		ob.atualizaTelefone(t);
	}

	public void excluiTelefone(int id_telefone) {
		ob.deletaTelefone(id_telefone);
	}

	public ResultSet selecionaTelefone() {
		ResultSet rs = ob.selectTelefone();
		return rs;

	}

	public ArrayList<Telefone> selecionaTelefone1(int idCliente) {
		ArrayList<Telefone> listTel = new ArrayList<Telefone>();
		listTel = ob.selectTelefone1(idCliente);

		return listTel;

	}

	public Telefone selecionaTelefone2(int idTel) {

		Telefone tel = ob.selectTelefone2(idTel);

		return tel;

	}

	// Pagamento
	public boolean casdrataPagamento(Pagamento p) {
		boolean cadPagamento = ob.cadastraPagamento(p);

		return cadPagamento;
	}

	public void atualizaPagamento(Pagamento p) {
		ob.atualizaPagamento(p);
	}

	public void excluiPagamento(int id_pagamento) {
		ob.deletaPagamento(id_pagamento);
	}

	public ResultSet selecionaPagamento() {
		ResultSet rs = ob.selectPagamento();
		return rs;

	}

	public Double doTest(double num) {

		int decimalPlace = 2;
		BigDecimal bd = new BigDecimal(num);
		bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
		num = bd.doubleValue();
		return num;
	}

	// calculo pagamento



	public void agendaTelefonica() {
		ob.agendaTelefonica();
	}

	public double pegarvalorOS(int idOS) {
		double v = 0.0;
		v = ob.pegarvalorOS(idOS);
		return v;

	}

	public void pagaroS() {
		ob.pagaroS();

	}
	// pelo número de série
	public void pagaroS(String numSerie) {
		ob.pagaroS(numSerie);

	}
	public ResultSet getTable(String sql) {
		
		ResultSet rs=ob.getTable(sql);
		return rs;
		
	}
	// relatorios
	public void relatorioDeServiosDiarios(String data) {
		ob.relatorioDeServiosDiarios(data);

	}
	// Status
	public void relatorioStatusAberta(){
		ob.relatorioStatusAberta();
	}
	public void relatorioStatusDiagnosticada(){
		ob.relatorioStatusDiagnosticada();
	}
	public void relatorioStatusAprovada(){
		ob.relatorioStatusAprovada();
	}
	public void relatorioStatusReprovada(){
		ob.relatorioStatusReprovada();
	}
	public void relatorioStatusLiberada(){
		ob.relatorioStatusLiberada();
	}
	public void relatorioStatusFechada(){
		ob.relatorioStatusFechada();
	}
	public void relatorioAgendaVisita(){
		ob.relatorioAgendaVisita();
	}
	public Double valido(String o) {
	
		double d = 0;
		boolean a = false;
		try {
			d= Double.parseDouble(o);

		} catch (java.lang.NumberFormatException e) {
			
			
		}

		return d;

	}

}
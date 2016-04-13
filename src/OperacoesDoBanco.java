import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;

public class OperacoesDoBanco {
	static BDMySql b = new BDMySql();
	static JTable table;

	// insere o cliente no banco
	public boolean cadastraCliente(Cliente c) {


		String sql = "insert into cliente(nome,sexo,cpf,dtnascimento,idcidade,cep,endereco) values ('"
				+ c.getNome()
				+ "','"
				+ c.getSexo()
				+ "','"
				+ c.getCPF()
				+ "','"
				+ c.getData_nascimento()
				+ "','"
				+ c.getCidade().getIdCidade()
				+ "','"
				+ c.getCep()
				+ "','"
				+ c.getEndereco() + "')";
		System.out.println(sql);
		b.executarSQL(sql);

		return true;
	}

	public boolean atualizaCliente(Cliente c) {
		String sql = "update cliente set nome = '" + c.getNome() + "',"
				+ " sexo = '" + c.getSexo() + "'," + " cpf = '" + c.getCPF()
				+ "'," + " dtnascimento ='" + c.getData_nascimento() + "',"
				+ " idcidade = '" + c.getCidade().getIdCidade() + "',"
				+ " cep='" + c.getCep() + "'" + " where idcliente = "
				+ c.getIdCliente();

		
		b.executarSQL(sql);
		return true;
	}

	public void deletaCliente(int idCliente) {
		String sql = "delete from cliente where idcliente =" + idCliente;
		b.executarSQL(sql);
	}

	// seleciona o cliente pelo id
	public Cliente selectClienteid(int id) {
		Cliente c = null;

		String sql = "select c.idcliente as idcliente, c.nome as cNome, c.sexo as sexo, c.cpf as cpf,c.dtnascimento as data, "
				+ "c.cep as cep, c.endereco as endereco, cid.idcidade as idcidade, cid.nome as nomeCidade from cliente c,"
				+ "cidade cid where c.idcidade = cid.idcidade and c.idcliente = "
				+ id;
		ResultSet rs = b.executarBuscaSQL(sql);

		try {
			if (rs.next()) {
				String data = String.valueOf(rs.getDate("data"));
				
				char sexo = rs.getString("sexo").toCharArray()[0];
				c = new Cliente(id, rs.getString("cNome"), sexo, rs
						.getString("cpf"), data, rs.getString("cep"), rs
						.getString("endereco"));
				
				
				Cidade cid = new Cidade(rs.getInt("idcidade"), rs.getString("nomecidade"));
				c.setCidade(cid);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return c;
	}

	public ResultSet selectCliente() {
		String sql = "select * from cliente";
		ResultSet rs = b.executarBuscaSQL(sql);
		return rs;

	}

	// CIDADE
	public ArrayList<Cidade> listCidades() {
		ResultSet rs;
		Cidade cidade;
		ArrayList<Cidade> cidades = new ArrayList<Cidade>();

		rs = b.executarBuscaSQL("select * from cidade");

		try {
			while (rs.next()) {
				cidade = new Cidade(rs.getInt("idCidade"), rs.getString("nome"));
				cidades.add(cidade);
			}
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
		}
		return cidades;
	}

	// Agenda Visita padrão

	public void tabelaAgendaCliente() {
		String sql = "select * from cliente";
		int d = 4;
		Tabela tab = new Tabela(sql, d);
	}
	// Agenda Visita por nome
	public void tabelaAgendaCliente(String nomeCliente) {
		String sql = "select * from cliente c where c.nome like " + "'" + nomeCliente + "%"+"'";
		int d = 4;
		Tabela tab = new Tabela(sql, d);
	}
	public boolean agendamentoVisita(AgendamentoVisita agenVis) {
		String sql = "insert into agendavisita(dataVisita,horario,endereco, idCliente) values ('"
				+ agenVis.getDataVisita()
				+ "','"
				+ agenVis.getHoraVisita()
				+ "','"
				+ agenVis.getEnderecoVisita()
				+ "','"
				+ agenVis.getIdCliente() + "')";
		
		b.executarSQL(sql);
		return true;
	}

	public ResultSet selectAgendaVisita() {
		String sql = "select * from agendavisita";
		ResultSet rs = b.executarBuscaSQL(sql);
		return rs;
	}

	// tabela
	// wwwwwwwwwwwwwwwwwwwwwwww
	public void tabelaRegistraDiagnosticoOs() {
		String sql = "SELECT c.idcliente, c.nome nome,o.id_ordenservico,o.status,o.defeito," +
				"o.configuracao,o.data_abertura data  FROM ordemservico o inner join cliente c" +
				" on c.idcliente = o.idcliente where o.status = 'aberta'";
		int d = 16;
		Tabela table = new Tabela(sql, d);
	}

	public void tabelaRegistraDiagnosticoOs(String numSerie) {
		String sql = "SELECT c.idcliente, c.nome nome,o.id_ordenservico,o.status,o.defeito," +
				"o.configuracao,o.data_abertura data  FROM ordemservico o inner join cliente c on c.idcliente = o.idcliente where o.status = 'aberta' and o.nserie="
				+ "'" + numSerie + "' ";
		int d = 16;
		
		Tabela table = new Tabela(sql, d);
	}

	// wwwwwwwwwwwwwwwwwwwwww
	public void tabelaRegistrarAutorizacao() {
		String sql = "SELECT c.idcliente, c.nome nomeCliente,o.id_ordenservico idOS,o.status," +
				"o.defeito,o.configuracao,o.data_abertura data ,o.valor, o.data_previsao dataPrevisão, o.data_conclusao dataConclusão FROM ordemservico o inner join cliente c on c.idcliente = o.idcliente where o.status = 'Diagnosticada'";
		int d = 17;
		Tabela table = new Tabela(sql, d);

	}

	public void tabelaRegistrarAutorizacao(String numSerie) {
		String sql = "SELECT c.idcliente, c.nome nomeCliente,o.id_ordenservico idOS,o.status," +
				"o.defeito,o.configuracao,o.data_abertura data ,o.valor, o.data_previsao dataPrevisão, o.data_conclusao dataConclusão FROM ordemservico o inner join cliente c on c.idcliente = o.idcliente where o.status = 'Diagnosticada' and o.nserie="
				+ "'" + numSerie + "' ";
		int d = 17;
		
		Tabela table = new Tabela(sql, d);

	}

	
	public void tabelaRegistraConserto() {
		String sql = "SELECT c.idcliente, c.nome nomeCliente,o.id_ordenservico idOS,"
				+ "o.status,o.defeito,o.configuracao,o.data_abertura data ,o.valor, " +
						"o.data_previsao dataPrevisão,"
				+ " o.data_conclusao dataConclusão FROM ordemservico o inner join cliente c " +
						"on c.idcliente = o.idcliente where o.status = 'Aprovada'";
		int d = 18;
		Tabela table = new Tabela(sql, d);
	}

	
	public void tabelaRegistraConserto(String numSerie) {
		String sql = "SELECT c.idcliente, c.nome nomeCliente,o.id_ordenservico idOS,"
				+ "o.status,o.defeito,o.configuracao,o.data_abertura data ,o.valor, o.data_previsao dataPrevisão,"
				+ " o.data_conclusao dataConclusão FROM ordemservico o inner join cliente c on c.idcliente = o.idcliente where o.status = 'Aprovada' and o.nserie="
				+ "'" + numSerie + "' ";
		int d = 18;
		
		Tabela table = new Tabela(sql, d);
	}

	public void tabelaAbreOs() {
		String sql = "select * from cliente";
		int d = 1;
		Tabela table = new Tabela(sql, d);
	}
////////////////////////////////////////
	  public boolean tabelaConsultOs() {
	  String sql = "select c.idcliente, c.nome nomeCliente,o.id_ordenservico idOS,"
				+ "o.status,o.defeito,o.configuracao,o.data_abertura data ,o.valor, o.data_previsao dataPrevisão,"
				+ " o.data_conclusao dataConclusão from cliente c inner join ordemservico o on c.idcliente = o.idcliente "; 
	  int d = 3; Tabela table = new
	  Tabela(sql, d);
	  return true; }
	 

	public void tabelaConsultCliente() {
		String sql = "select * from cliente";
		int d = 0;
		Tabela table = new Tabela(sql, d);
	}
	
	//consulta por nome o cliente

	public void tabelaConsultCliente(String nomeCliente) {//"'" + data + "' ";
		String sql = "select * from cliente c where c.nome like " + "'" + nomeCliente + "%"+"'";
		int d = 0;
		
		Tabela table = new Tabela(sql, d);
	}
	public void tabelaConsultaServ() {
		String sql = "select * from cliente";
		int op = 5;
		Tabela tab = new Tabela(sql, op);
	}

	// Ordem Servico
	public boolean abrirOS(OrdemServico os) {
		String sql = "insert into ordemservico(data_abertura,configuracao,defeito,status,idCliente,nserie) values ('"
				+ os.getData_abertura()
				+ "','"
				+ os.getConfiguracao()
				+ "','"
				+ os.getDefeito()
				+ "','"
				+ os.getStatus()
				+ "','"
				+ os.getIdcliente() + "','" + os.getNumeroSerie() + "')";
		
		b.executarSQL(sql);
		return true;
	}

	public void atualizaOS2(OrdemServico os) {
		String sql = "update ordemservico set data_abertura = '"
				+ os.getData_abertura() + "'," + "configuracao = '"
				+ os.getConfiguracao() + "'," + "defeito = '" + os.getDefeito()
				+ "'," + "diagnostico = '" + os.getDiagnostico() + "',"
				+ "valor = '" + os.getValor() + "'," + "data_previsao ='"
				+ os.getData_previsao() + "'," + "data_conclusao = '"

				+ os.getData_conclusao() + "'," + "status='" + os.getStatus()
				+ "'," + "data_fechamento = '" + os.getData_fechamento() + "',"
				+ "nserie ='" + os.getNumeroSerie() + "'"
				+ "where id_ordenServico = " + os.getId_ordemServico();
		
		b.executarSQL(sql);
	}

	public void atualizaOS(OrdemServico os) {
	
		String sql = "update ordemservico set data_abertura = '"
				+ os.getData_abertura() + "'," + "configuracao = '"
				+ os.getConfiguracao() + "'," + "defeito = '" + os.getDefeito()
				+ "'," + "diagnostico = '" + os.getDiagnostico() + "',"
				+ "data_previsao ='" + os.getData_previsao() + "',"
				+ "data_conclusao = '" + os.getData_conclusao() + "',"
				+ "status='" + os.getStatus() + "'," + "nserie ='"
				+ os.getNumeroSerie() + "'" + "where id_ordenServico = "
				+ os.getId_ordemServico();
		
		b.executarSQL(sql);
	}

	public void deletaOrdemServico(int id_ordemServico) {
		String sql = "delete from ordemServico where id_ordenServico ="
				+ id_ordemServico;

		b.executarSQL(sql);
	}

	public ResultSet selectOrdemServico() {
		String sql = "select * from OrdemServico";
		ResultSet rs = b.executarBuscaSQL(sql);
		return rs;

	}

	public OrdemServico selectOSeid(int idOS) {
		String sql = "select * from OrdemServico " + "where id_ordenServico = "
				+ idOS;
		ResultSet rs = b.executarBuscaSQL(sql);
		OrdemServico os = null;
		try {
			if (rs.next()) {
				os = new OrdemServico(idOS, rs.getString("data_abertura"), rs
						.getString("configuracao"), rs.getString("defeito"), rs
						.getString("status"), rs.getString("diagnostico"), rs
						.getString("data_previsao"), rs
						.getString("data_conclusao"), rs.getDouble("valor"), rs
						.getInt("idCliente"), rs.getString("nserie"));
				
				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return os;
	}

	// ITRM sERVIÇO
	public boolean cadastraItemOrdemServico(
			ArrayList<ItemOrdemServico> listaItem) {
		for (int i = 0; i < listaItem.size(); i++) {
			ItemOrdemServico item = listaItem.get(i);
			String sql = "insert into itemordemservico (idServico,idOs) values ('"
					+ item.getIdServico() + "','" + item.getIdOs() + "')";
			
			b.executarSQL(sql);

		}
		return false;
	}

	public boolean cadastraItemOrdemServico2(ItemOrdemServico item2) {
		String sql = "insert into itemordemservico (idServico,idOs) values ('"
				+ item2.getIdServico() + "','" + item2.getIdOs() + "')";
		
		b.executarSQL(sql);
		return false;
	}

	public ResultSet selectItemOs() {
		String sql = "select * from itemordemservico ";
		ResultSet rs = b.executarBuscaSQL(sql);
		return rs;
	}

	
	
	public int cadastraServico(Servico s) {
		int idservico = 0;
		String sql = "insert into Servico(descricao,valor) values ('"
				+ s.getDescricao() + "','" + s.getValor() + "')";

		b.executarSQL(sql);
		ResultSet rs;
		rs = b
				.executarBuscaSQL("select max(id_servico) as idservico from servico");

		try {
			if (rs.next())
				idservico = rs.getInt("idservico");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idservico;
	}

	public void atualizaServico(Servico s) {
		String sql = "update Servico set descricao = '" + s.getDescricao()
				+ "'," + " valor = '" + s.getValor() + "',"
				+ " where id_Servico = " + s.getId_servico();

		b.executarSQL(sql);
	}

	public void deletaServico(int id_servico) {
		String sql = "delete from Servico where id_servico =" + id_servico;

		b.executarSQL(sql);
	}

	public ResultSet selectServico() {
		String sql = "select * from Servico";
		ResultSet rs = b.executarBuscaSQL(sql);
		return rs;

	}

	public ArrayList<Servico> selecionaServico2() {
		String sql = "select * from servico";
		ResultSet rs = b.executarBuscaSQL(sql);
		ArrayList<Servico> listServico = new ArrayList<Servico>();
		try {
			while (rs.next()) {
				Servico ser = new Servico(rs.getInt("id_servico"), rs
						.getString("descricao"), rs.getDouble("valor"));
				listServico.add(ser);
			}
		} catch (SQLException e) {
		//	System.out.println(e.getMessage());
		}
		return listServico;
	}

	// Telefone
	public boolean cadastraTelefone(ArrayList<Telefone> ListaTelefones) {
		
		for (int i = 0; i < ListaTelefones.size(); i++) {
			Telefone t = ListaTelefones.get(i);
			String sql = "insert into Telefone(tipo,numero,idcliente) values ('"
					+ t.getTipo()
					+ "','"
					+ t.getNumero()
					+ "','"
					+ t.getIdcliente() + "')";
			b.executarSQL(sql);
		}
		return true;
	}

	public void atualizaTelefone1(Telefone t) {
		String sql = "update Telefone set tipo = '" + t.getTipo() + "',"
				+ " numero = '" + t.getNumero() + "','" + t.getIdcliente()
				+ "','" + t.getIdCpfCliente() + "'," + " where id_Telefone = "
				+ t.getIdtelefone();

		b.executarSQL(sql);
	}

	public void atualizaTelefone(Telefone t) {
		String sql = "update Telefone set numero = '" + t.getNumero() + "'"
				+ " where id_Telefone = " + t.getIdtelefone();
		b.executarSQL(sql);
	}

	public void deletaTelefone(int id_Telefone) {
		String sql = "delete from Telefone where id_Telefone=" + id_Telefone;
		b.executarSQL(sql);
	}

	public ResultSet selectTelefone() {
		String sql = "select * from Telefone";
		ResultSet rs = b.executarBuscaSQL(sql);
		return rs;

	}

	public ArrayList<Telefone> selectTelefone1(int idCliente) {
		String sql = "select * from Telefone where idCliente =" + idCliente;
		ResultSet rs = b.executarBuscaSQL(sql);
		ArrayList<Telefone> listTelef = new ArrayList<Telefone>();
		try {
			while (rs.next()) {
				Telefone tel = new Telefone(rs.getInt("id_telefone"), rs
						.getString("tipo"), rs.getString("numero"), rs
						.getInt("idcliente"));
				listTelef.add(tel);
			}
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
		}
		return listTelef;
	}

	public Telefone selectTelefone2(int idTel) {
		int op = 5;
		String sql = "select * from telefone where id_telefone =" + idTel;
		ResultSet rs = b.executarBuscaSQL(sql);
		Telefone te = null;
		try {
			if (rs.next())
				te = new Telefone(rs.getInt("id_telefone"), rs.getString("numero"));
		te.setTipo(rs.getString("tipo"));
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return te;
	}

	// PEÇA
	public void tabelaInserePeca() {
		String sql = "SELECT c.idcliente, c.nome nomeCliente,o.id_ordenservico idOS,o.status,o.defeito,o.configuracao,o.data_abertura data ,o.valor, o.data_previsao dataPrevisão, o.data_conclusao dataConclusão FROM ordemservico o inner join cliente c on c.idcliente = o.idcliente where o.status = 'Diagnosticada' or o.status = 'Aprovada'";
		int op = 11;
		
		Tabela tab = new Tabela(sql, op);
	}

	public int cadastraPeca(Peca p) {
		int idPeca = 0;
		String sql = "insert into peca (nome,valor) values ('"
				+ p.getNomePeca() + "','" + p.getValorPeca() + "')";
		b.executarSQL(sql);
		ResultSet rs;
		rs = b.executarBuscaSQL("select max(idpeca) as idpeca from peca");
		try {
			if (rs.next())
				idPeca = rs.getInt("idpeca");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idPeca;
	}

	public ArrayList<Peca> selecionaPeca() {
		String sql = "select * from peca";
		ResultSet rs = b.executarBuscaSQL(sql);
		ArrayList<Peca> listPeca = new ArrayList<Peca>();
		try {
			while (rs.next()) {
				Peca p = new Peca(rs.getString("nome"), rs.getDouble("valor"));
				p.setIdPeca(rs.getInt("idPeca"));
				listPeca.add(p);
			}
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
		}
		return listPeca;
	}

	public boolean cadastraItemOrdemServicoPeca(
			ArrayList<ItemOrdemServicoPeca> listItemOsPeca) {
		for (int i = 0; i < listItemOsPeca.size(); i++) {
			ItemOrdemServicoPeca itemOsP = listItemOsPeca.get(i);
			String sql = "insert into itemordemservicopeca (idPeca,iditemos,quantidade) values ('"
					+ itemOsP.getIdPeca()
					+ "','"
					+ itemOsP.getIdItemOs()
					+ "','" + itemOsP.getQuantidade() + "')";
			
			b.executarSQL(sql);
		}
		return true;
	}

	public boolean cadastraItemOrdemServicoPeca(ItemOrdemServicoPeca itemOsPeca) {
		String sql = "insert into itemordemservicopeca (idPeca,iditemos,quantidade) values ('"
				+ itemOsPeca.getIdPeca()
				+ "','"
				+ itemOsPeca.getIdItemOs()
				+ "','" + itemOsPeca.getQuantidade() + "')";
	
		b.executarSQL(sql);

		return true;
	}

	// Pagamento
	public boolean cadastraPagamento(Pagamento p) {
		String sql = "insert into Pagamento(tipoPagamento,totalValor, dataPagamento, idOs) values ('"
				+ p.getTipoPagamento()
				+ "','"
				+ p.getTotal_valor()
				+ "','"
				+ p.getDataPagamento() + "','" + p.getIdOs() + "')";
		
		b.executarSQL(sql);
		return true;
	}

	public void atualizaPagamento(Pagamento p) {
		String sql = "update Pagamento set tipoPagamento = '"
				+ p.getTipoPagamento() + "'," + " total_valor = '"
				+ p.getTotal_valor() + "'" + " where id_pagamento = "
				+ p.getId_pagamento();

		b.executarSQL(sql);
	}

	public void deletaPagamento(int id_pagamento) {
		String sql = "delete from Pagamento where id_Pagamento ="
				+ id_pagamento;

		b.executarSQL(sql);
	}

	public ResultSet selectPagamento() {
		String sql = "select * from Pagamento";
		ResultSet rs = b.executarBuscaSQL(sql);
		return rs;
	}

	
	public double pegarvalorOS(int idOS) {
		double valorTOT = 0.0;
		double valorServico = 0.0;
		double valorPeca = 0.0;
		String sql1 = "SELECT  sum(s.valor) as valorOS FROM servico s "
				+ "inner join itemordemservico i on s.id_servico = i.idservico "
				+ "inner join ordemservico o on i.idOs = o.id_ordenservico where  i.idOs = '"
				+ idOS + "'group by i.idOs";
		
		String sql2 = "SELECT sum(p.valor) as valorPeca  FROM peca p right"
				+ " join itemordemservicopeca it on it.idpeca = p.idpeca "
				+ "left join itemordemservico i on i.idItemOs = it.idItemOs where i.idOs ='"
				+ idOS + "' group by i.idOs";
		
		ResultSet rs2 = b.executarBuscaSQL(sql2);
		ResultSet rs1 = b.executarBuscaSQL(sql1);

		try {
			if (rs1.next())
				valorServico = rs1.getDouble("valorOS");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs2.next())
				valorPeca = rs2.getDouble("valorPeca");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return valorTOT = valorServico + valorPeca;

	}

	public void pagaroS() {
		int d = 13;
		String sql = "SELECT c.idcliente, c.nome nomeCliente,o.id_ordenservico idOS,o.status,"
				+ "o.defeito,o.configuracao,o.data_abertura data ,o.valor, o.data_previsao dataPrevisão, "
				+ "o.data_conclusao dataConclusão FROM ordemservico o inner join cliente c on "
				+ "c.idcliente = o.idcliente where o.status = 'Liberada' or o.status = 'Reprovada' ";
		Tabela table = new Tabela(sql, d);
	}
// pelo n de serie
	public void pagaroS(String numSerie) { // colocar tambem o reprovada
		int d = 13;
		String sql = "SELECT c.idcliente, c.nome nomeCliente,o.id_ordenservico idOS,o.status,"
				+ "o.defeito,o.configuracao,o.data_abertura data ,o.valor, o.data_previsao dataPrevisão, "
				+ "o.data_conclusao dataConclusão FROM ordemservico o inner join cliente c on "
				+ "c.idcliente = o.idcliente where o.status = 'Liberada'  or o.status = 'Reprovada' and o.nserie="
				+ "'" + numSerie + "' ";
		
		Tabela table = new Tabela(sql, d);
	}
	public ResultSet getTable(String sql) {
		ResultSet rs = b.executarBuscaSQL(sql);
		return rs;
	}

	// RELATORIOS
	public void agendaTelefonica() {
		int d = 6;
		String sql = "SELECT c.nome ,t.tipo,t.numero FROM  telefone t,cliente c where c.idcliente=t.idcliente ";
		Tabela t = new Tabela(sql, d);
	}

	public void relatorioDeServiosDiarios(String data) {
		int d = 7;
		String sql = "select *from visao v " +
				" where v.data_abertura='"+data +"'";
		
		
		Tabela table = new Tabela(sql, d);
	}

	public void relatorioStatusAberta() {
		int d = 6;
		String sql = "select count(*) Total , o.status from ordemservico o where o.status = 'aberta' group by  o.status";
		Tabela t = new Tabela(sql, d);
	}

	public void relatorioStatusDiagnosticada() {
		int d = 6;
		String sql = "select count(*) Total , o.status from ordemservico o where o.status = 'Diagnosticada' group by  o.status";
		Tabela table = new Tabela(sql, d);
		
	}

	public void relatorioStatusAprovada() {
		int d = 6;
		String sql = "select count(*) Total , o.status from ordemservico o where o.status = 'Aprovada' group by  o.status";
		Tabela table = new Tabela(sql, d);
		
	}

	public void relatorioStatusReprovada() {
		int d = 6;
		String sql = "select count(*) Total , o.status from ordemservico o where o.status = 'Reprovada' group by  o.status";
		Tabela table = new Tabela(sql, d);
		
	}

	public void relatorioStatusLiberada() {
		int d = 6;
		String sql = "select count(*) Total , o.status from ordemservico o " +
				"where o.status = 'Liberada' group by  o.status" ;
		Tabela table = new Tabela(sql, d);	
	}

	public void relatorioStatusFechada() {
		int d = 6;
		String sql ="select count(*) Total , o.status from ordemservico o where o.status = 'Fechada' group by  o.status";
		Tabela table = new Tabela(sql, d);	
	}

	public void relatorioAgendaVisita() {
		int d = 6;
		String sql ="SELECT c.idcliente, c.nome, a.dataVisita,a.horario Horário ," +
				"t.numero FROM cliente c inner join agendavisita a on c.idcliente = a.idcliente" +
				" inner join telefone t on t.idcliente = c.idcliente group by t.numero"; 
		Tabela table = new Tabela(sql, d);	
		
	}

}

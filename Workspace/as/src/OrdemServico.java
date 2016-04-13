import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;

public class OrdemServico {
	private int idcliente;
	private int id_ordemServico;
	private String data_abertura;
	private String nome;
	private String cpf;

	private String configuracao;
	private String defeito;
	private String diagnostico;
	private Double valor;
	private String data_previsao;
	private String data_conclusao;
	private String status;
	private String data_fechamento;
	private String numeroSerie;
	private ArrayList<ItemOrdemServico> itemOs = new ArrayList<ItemOrdemServico>();

	// CADASTRO
	public OrdemServico(String data_abertura, String nome, String cpf,
			String configuracao, String defeito, String status, int idcliente,String numSerie) {

		this.data_abertura = data_abertura;
		this.nome = nome;
		this.cpf = cpf;
		this.idcliente = idcliente;
		this.configuracao = configuracao;
		this.defeito = defeito;
		this.status = status;
		this.numeroSerie = numSerie;
	}


	// Atualiza
	public OrdemServico(int id_ordemServico, String data_abertura, String nome,
			String cpf, String configuracao, String defeito, String status,
			String diagnost, String dataPrevisao, String conclusao,
			String fechamento, Double valor,String numSerie) {

		this.id_ordemServico = id_ordemServico;
		this.data_abertura = data_abertura;
		this.nome = nome;
		this.cpf = cpf;
		this.status = status;
		this.configuracao = configuracao;
		this.defeito = defeito;
		this.data_conclusao = conclusao;
		this.data_previsao = dataPrevisao;
		this.valor = valor;
		this.diagnostico = diagnost;
		this.data_fechamento = fechamento;
		this.numeroSerie = numSerie;
	}

	public OrdemServico(int id_ordemServico, String data_abertura, String nome,
			String cpf, String configuracao, String defeito, String status,
			String diagnost, String previsao, String conclusao,String numSerie) {

		this.id_ordemServico = id_ordemServico;
		this.data_abertura = data_abertura;
		this.nome = nome;
		this.cpf = cpf;
		this.status = status;
		this.configuracao = configuracao;
		this.defeito = defeito;
		this.data_conclusao = conclusao;
		this.data_previsao = previsao;
		this.diagnostico = diagnost;
		this.numeroSerie = numSerie;
	}

	// 1

	// vem do banco
	public OrdemServico(int id_ordemServico, String data_abertura,
			String configuracao, String defeito, String status, String diag,
			String datPrev, String datConclu, Double val, int idcliente,String numSerie) {
		
		this.id_ordemServico = id_ordemServico;
		this.data_abertura = data_abertura;
		this.status = status;
		this.configuracao = configuracao;
		this.defeito = defeito;
		this.idcliente = idcliente;
		this.data_previsao = datPrev;
		this.data_conclusao = datConclu;
		this.diagnostico = diag;
		this.valor = val;
		this.numeroSerie = numSerie;
	}

	public void setOrdemServico(String data_abertura, String nome, String cpf,
			String equipamento, String configuracao, String defeito,
			String diagnostico, Double valor, String data_previsao,
			String data_conclusao, String status, String data_fechamento) {
		this.data_abertura = data_abertura;
		this.nome = nome;
		this.cpf = cpf;

		this.configuracao = configuracao;
		this.defeito = defeito;
		this.data_conclusao = data_conclusao;
		this.data_previsao = data_previsao;
		this.diagnostico = diagnostico;
		this.status = status;
		this.data_fechamento = data_fechamento;
		this.valor = valor;

	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public void setData_previsao(String data_previsao) {
		this.data_previsao = data_previsao;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setData_conclusao(String data_conclusao) {
		this.data_conclusao = data_conclusao;

	}

	// /////////////////////////////
	public void setItemOs(ArrayList<ItemOrdemServico> itemOs2) {
		this.itemOs = itemOs2;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setData_fechamento(String data_fechamento) {
		this.data_fechamento = data_fechamento;
	}

	public int getId_ordemServico() {
		return id_ordemServico;
	}

	public String getData_abertura() {
		return data_abertura;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getConfiguracao() {
		return configuracao;
	}

	public String getDefeito() {
		return defeito;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public String getData_previsao() {
		return data_previsao;
	}

	public Double getValor() {
		return valor;
	}

	public String getData_conclusao() {
		return data_conclusao;
	}

	public String getStatus() {
		return status;
	}

	public String getData_fechamento() {
		return data_fechamento;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public ArrayList<ItemOrdemServico> getItemServ() {
		return itemOs;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
}

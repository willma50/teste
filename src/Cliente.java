import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String CPF;
	private String endereco;
	private char sexo;
	private Cidade cidade;
	private String data_nascimento;
	private String cep;
	private int idCliente;

	public ArrayList<Telefone> listaTelefone;

	// Construtor completo
	public Cliente(String nome, char sexo, String CPF, String data_nascimento,
			 String cep, String endereco) {

		this.nome = nome;
		this.CPF = CPF;
		this.endereco = endereco;
	     this.sexo = sexo;
		//this.cidade = cidade;
		this.cep = cep;
		this.data_nascimento = data_nascimento;

	}

	public Cliente(int idCliente, String nome, char sexo, String CPF,
			String data_nascimento, String cep, String endereco) {
		
		this.idCliente = idCliente;
		this.nome = nome;
		this.CPF = CPF;
		this.endereco = endereco;
		this.sexo = sexo;
		//this.cidade = cidade;
		this.cep = cep;
		this.data_nascimento = data_nascimento;

	}

	// Construtor
	public Cliente(String nome, String CPF) {
		this.nome = nome;
		this.CPF = CPF;
	}

	public Cliente(int id, String CPF) {
		this.idCliente = id;
		this.CPF = CPF;
	}

	/*
	 * public Cliente(String text, char c, String text2, String text3, String
	 * text4, String text5) {this.sexo=c; }
	 */

	public Cliente(int idCliente, String nome, String cpf) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.CPF = cpf;
	}

	public Cliente() {
		
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public void setTelefone(ArrayList<Telefone> te) {
		this.listaTelefone = te;
	}
public ArrayList<Telefone> getListaTelefone() {
	return listaTelefone;
}
	public String getNome() {
		return nome;
	}

	public String getCPF() {
		return CPF;
	}

	public String getEndereco() {
		return endereco;
	}

	public char getSexo() {
		return sexo;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public String getCep() {
		return cep;
	}
}

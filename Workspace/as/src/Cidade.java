public class Cidade {
	
	private int idCidade;
	private String nome;
	//private String cep;

	public Cidade(int idcidade, String nome) {
		this.idCidade = idcidade;
		this.nome = nome;
	}

	public Cidade(int idcidade) {
		this.idCidade = idcidade;
	}

/*	public void setCep(String cep) {
		this.cep = cep;
	}*/

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdCidade() {
		return idCidade;
	}

/*	public String getCep() {
		return cep;
	}*/

	public void setIdCidade(int cidade_id) {
		this.idCidade = cidade_id;
	}

	public String toString() {
		return this.nome;
	}
}

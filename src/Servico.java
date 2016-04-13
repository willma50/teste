public class Servico {

	private int id_servico;
	private String descricao;
	private Double valor;
	private int idItemOs;

	public Servico(int id_servico, String descricao, Double valor) {

		this.id_servico = id_servico;
		this.descricao = descricao;
		this.valor = valor;
	}
	public Servico(String descricao, Double valor ) {

		this.descricao = descricao;
		this.valor = valor;
	}
	
	public int getId_servico() {
		return id_servico;
	}

	public String getDescricao() {
		return descricao;
	}
	public int getIdItemOs() {
		return idItemOs;
	}

	public Double getValor() {
		return valor;
	}
	
}

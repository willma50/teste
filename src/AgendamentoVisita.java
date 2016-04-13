public class AgendamentoVisita {

	private int idVisita;
	private String dataVisita;
	private String horaVisita;
	private String enderecoVisita;
	private String nome;
	private int idCliente;

	public AgendamentoVisita( int idVisita, String nome, String enderecoVisita, String dataVisita,
			String horaVisita, int idcliente) {

		this.idCliente = idcliente;
		this.dataVisita = dataVisita;
		this.enderecoVisita = enderecoVisita;
		this.horaVisita = horaVisita;
		this.idVisita = idVisita;
		this.nome = nome;
	}

	public AgendamentoVisita(  String nome, String enderecoVisita, String dataVisita,
			String horaVisita, int idcliente) {

	    this.idCliente = idcliente;
		this.dataVisita = dataVisita;
		this.enderecoVisita = enderecoVisita;
		this.horaVisita = horaVisita;
		this.nome = nome;
	}

	public String getDataVisita() {
		return dataVisita;
	}

	public String getEnderecoVisita() {
		return enderecoVisita;
	}

	public String getHoraVisita() {
		return horaVisita;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public int getIdVisita() {
		return idVisita;
	}

	public String getNome() {
		return nome;
	}

}

public class Peca {

	private int idPeca;
	private String nomePeca;
	private Double valorPeca;

	public Peca(String nomeP, Double valorP) {
		this.nomePeca = nomeP;
		this.valorPeca = valorP;
	}

	public void setIdPeca(int idP) {
		this.idPeca = idP;
	}

	public int getIdPeca() {
		return idPeca;
	}

	public String getNomePeca() {
		return nomePeca;
	}

	public Double getValorPeca() {
		return valorPeca;
	}

}

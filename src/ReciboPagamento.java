public class ReciboPagamento {

	private int id_recibo;
	private Double total;
	private Double valor_recebido;
	private Double troco;

	public ReciboPagamento(int id_recibo, Double total, Double valor_recebido,
			Double troco) {
		this.id_recibo = id_recibo;
		this.total = total;
		this.valor_recebido = valor_recebido;
		this.troco = troco;
	}

	public int getId_recibo() {
		return id_recibo;
	}

	public Double getTotal() {
		return total;
	}

	public Double getValor_recebido() {
		return valor_recebido;
	}

	public Double getTroco() {
		return troco;
	}

}

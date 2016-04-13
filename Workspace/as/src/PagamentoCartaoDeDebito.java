public class PagamentoCartaoDeDebito extends Pagamento {
	
	private String banco;
	private String bandeira;
	private Double totalDebito;
	private Double acrescimo;
	private Double acrescimoCartDebito = 0.05;

	public PagamentoCartaoDeDebito(String data, Double valorOs) {
		super(data, valorOs);
	}

	public void calculoAcrescimo() {
		this.acrescimo = total_valor * this.acrescimoCartDebito;
		
	}

	public void calculoTotal() {
		this.totalDebito = total_valor + this.getAcrescimo();
	}

	public Double getAcrescimo() {
		return acrescimo;
	}

	public String getBanco() {
		return banco;
	}

	public Double getTotalDebito() {
		return totalDebito;
	}
}

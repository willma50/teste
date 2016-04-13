public class PagamentoCartaoCredito extends Pagamento {

	Double qtd_parcela;
	Double valo_parcela;
	String bandeira;
	Double acrescimo = 0.0;
	Double acrescimoCartCredito = 0.07;
	Double totalCred;

	public PagamentoCartaoCredito(String data, Double valorOs) {
		super(data, valorOs);
	}

	public void calculoAcrescimo() {
		this.acrescimo = total_valor * this.acrescimoCartCredito;

	}

	public void calculoTotal() {
		this.totalCred = total_valor + this.getAcrescimo();
	}

	public void calculoValorParcela() {
		this.valo_parcela = totalCred;
	}

	public void setBandeira(String band) {
		this.bandeira = band;
	}

	public void setQuantidParcela(Double qtd) {
		this.qtd_parcela = qtd;
	}

	public Double getTotalCred() {
		return totalCred;
	}

	public Double getAcrescimo() {
		return acrescimo;
	}

	public String getBandeira() {
		return bandeira;
	}

	public Double getQtd_parcela() {
		return qtd_parcela;
	}

	public Double getValo_parcela() {
		return valo_parcela;
	}
}

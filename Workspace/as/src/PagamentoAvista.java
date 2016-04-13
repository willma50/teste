public class PagamentoAvista extends Pagamento {
	
	
	Double valorRecebido;
	Double troco;
	Double desconto;
	Double descontoAvista = 0.02;
	Double totalAvista = 0.0;

	public PagamentoAvista() {
		// super();
	}

	public PagamentoAvista(String data, Double totalValor) {
		super(data, totalValor);
		System.out.println(totalValor);
	}

	public void calculoDescontoTotal() {
		
		this.desconto = total_valor * this.descontoAvista;
		
	}

	public void calculoTotal() {
		this.totalAvista = total_valor - this.getDesconto();
		String vt = String.valueOf(totalAvista);//
	
	}

	public Double getDesconto() {
		return desconto;
	}

	public Double getValorRecebido() {
		return valorRecebido;
	}

	public Double getTroco() {
		return troco;
	}

	public Double getTotalAvista() {
		return totalAvista;
	}
}
// calculo pagamento


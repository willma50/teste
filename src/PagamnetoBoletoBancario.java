public class PagamnetoBoletoBancario extends Pagamento {

	String banco;
	Double acrescimo;
	Double acrescimoBoletoBancario = 0.08;
	Double totalBoleto;

	public PagamnetoBoletoBancario(String data, Double valorOs) {
		super(data, valorOs);
	}

	public void calculoAcrescimo() {
		this.acrescimo = total_valor * this.acrescimoBoletoBancario;
		
	}

	public void calculoTotal() {
		this.totalBoleto = total_valor + this.acrescimo;
	}

	public Double getAcrescimo() {
		return acrescimo;
	}

	public String getBanco() {
		return banco;
	}

	public Double getTotalBoleto() {
		return totalBoleto;
	}
}


public class Pagamento {
	
	protected int id_pagamento;
	protected String tipoPagamento;
	protected Double total_valor;
	protected int idOs;
	protected String dataPagamento;
	
	
	public Pagamento() {
		
	}
	public Pagamento(int id_pagamento,String tipoPagamento,Double total_valor) {
		this.id_pagamento = id_pagamento;
		
		this.tipoPagamento = tipoPagamento;
		this.total_valor = total_valor;
	}
	
	public int getId_pagamento() {
		return id_pagamento;
	}
	
	public Pagamento(String tipoPagamento,Double total_valor, String dataPag, int idos) {
	this.dataPagamento = dataPag;
		this.tipoPagamento = tipoPagamento;
		this.total_valor = total_valor;
		this.idOs =idos;
	}
	public Pagamento( String dataPag,Double total_valor) {
		this.dataPagamento = dataPag;
			this.total_valor = total_valor;
		}
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	
	public double getTotal_valor() {
		return total_valor;
	}
	public String getDataPagamento() {
		return dataPagamento;
	}
	public int getIdOs() {
		return idOs;
	}

}

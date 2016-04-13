public class ItemOrdemServicoPeca {

	private int idItemOrdemServicoPeca;
	private int idItemOs;
	private int idPeca;
	private int quantidade;

	public ItemOrdemServicoPeca() {
		// TODO Auto-generated constructor stub
	}
/*	public ItemOrdemServicoPeca(int idItemOs, int idPeca, int qtd) {

		this.idItemOs = idItemOs;
		this.idPeca = idPeca;
		this.quantidade = qtd;
	}*/

	/*public ItemOrdemServicoPeca(int idPeca, int idItemOs) {

		this.idItemOs = idItemOs;
		this.idPeca = idPeca;

	}*/
	public void setIdPeca(int idP) {
		this.idPeca = idP;
	}
	
	public void setQuantidade(int qtd) {
		this.quantidade = qtd;
	}
	
	public void setIdItemOrdemServicoPeca(int id) {
		this.idItemOrdemServicoPeca = id;
	}
	public void setIdItemOs(int idItemos) {
		this.idItemOs = idItemos;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public int getIdItemOrdemServicoPeca() {
		return idItemOrdemServicoPeca;
	}

	public int getIdItemOs() {
		return idItemOs;
	}

	public int getIdPeca() {
		return idPeca;
	}

}

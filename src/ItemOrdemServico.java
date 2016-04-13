public class ItemOrdemServico {

	private int idItemOS;
	private int idServico;
	private int idOs;

	public ItemOrdemServico() {

	}

	public ItemOrdemServico(int idServico, int idOs) {
		this.idServico = idServico;
		this.idOs = idOs;
	}

	public ItemOrdemServico(int idItemOs, int idServico, int idOs) {
		this.idItemOS = idItemOs;
		this.idServico = idServico;
		this.idOs = idOs;
	}

	public ItemOrdemServico(int idItemOs) {
		this.idItemOS = idItemOs;
	}

	public void setIdOs(int idOs) {
		this.idOs = idOs;
	}

	public int getIdItemOS() {
		return idItemOS;
	}

	public int getIdOs() {
		return idOs;
	}

	public int getIdServico() {
		return idServico;
	}
}

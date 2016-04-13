import java.util.ArrayList;

public class Telefone {
	private int idtelefone;
	private String tipo;
	private String numero;
	private int idcliente;
	private String idCpfCliente;

	public Telefone(String tipo, String numero, String idCpfCliente) {
		this.tipo = tipo;
		this.numero = numero;
		this.idCpfCliente = idCpfCliente;
	}

	public Telefone(String tipo, String numero, int idcliente) {
		this.tipo = tipo;
		this.numero = numero;
		this.idcliente = idcliente;
	}

	public Telefone(int idtel, String tipo, String numero, int idcliente) {
		this.tipo = tipo;
		this.numero = numero;
		this.idcliente = idcliente;
		this.idtelefone = idtel;
	}

	public Telefone(int idTelefone, String numero) {
		this.idtelefone = idTelefone;
		this.numero = numero;
	}

	public Telefone() {
	}

	public void setTelefone2(int idTel, String tipo, String numero) {
		this.idtelefone = idTel;
		this.tipo = tipo;
		this.numero = numero;
	}
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	public void setTelefone(String tipo, String numero) {
		this.numero = numero;
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public String getNumero() {
		return numero;
	}

	public int getIdtelefone() {
		return idtelefone;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public String getIdCpfCliente() {
		return idCpfCliente;
	}

}

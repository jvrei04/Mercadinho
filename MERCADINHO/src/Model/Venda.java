package Model;

public class Venda {
	private String id;
	private String idCliente;
	private String idFuncionario;
	private String formaPagamento;
	private String desconto;
	private String dataVenda;
	private String precoTotal;
	
	
	
	
	public Venda() {
		super();
	}
	public Venda(String id, String idCliente, String idFuncionario, String formaPagamento, String desconto,
			String dataVenda, String precoTotal) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.idFuncionario = idFuncionario;
		this.formaPagamento = formaPagamento;
		this.desconto = desconto;
		this.dataVenda = dataVenda;
		this.precoTotal = precoTotal;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(String idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public String getDesconto() {
		return desconto;
	}
	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}
	public String getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}
	public String getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(String precoTotal) {
		this.precoTotal = precoTotal;
	}
	
	
}

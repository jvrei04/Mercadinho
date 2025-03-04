package Model;

public class Produto {
	private String idProduto;
	private String idFornecedor;
	private String nome;
	private String codBarra;
	private String lote;
	private String dataFab;
	private String dataVal;
	private String marca;
	private String categoria;
	private String unidadeMedida;
	private String precoUn;
	private String estoque;
	
	
	
	public Produto() {
		super();
	}
	public Produto(String idProduto, String idFornecedor, String nome, String codBarra, String lote, String dataFab,
			String dataVal, String marca, String categoria, String unidadeMedida, String precoUn, String estoque) {
		super();
		this.idProduto = idProduto;
		this.idFornecedor = idFornecedor;
		this.nome = nome;
		this.codBarra = codBarra;
		this.lote = lote;
		this.dataFab = dataFab;
		this.dataVal = dataVal;
		this.marca = marca;
		this.categoria = categoria;
		this.unidadeMedida = unidadeMedida;
		this.precoUn = precoUn;
		this.estoque = estoque;
	}
	public String getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}
	public String getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(String idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodBarra() {
		return codBarra;
	}
	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public String getDataFab() {
		return dataFab;
	}
	public void setDataFab(String dataFab) {
		this.dataFab = dataFab;
	}
	public String getDataVal() {
		return dataVal;
	}
	public void setDataVal(String dataVal) {
		this.dataVal = dataVal;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	public String getPrecoUn() {
		return precoUn;
	}
	public void setPrecoUn(String precoUn) {
		this.precoUn = precoUn;
	}
	public String getEstoque() {
		return estoque;
	}
	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}
	
	
	
}
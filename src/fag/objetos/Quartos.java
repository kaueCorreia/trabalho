package fag.objetos;

public class Quartos {
	
	public Integer numeroQuarto;
	public String tipoQuarto;
	public Double preco;
	public Boolean Disponibilidade;
	
	public Quartos(Integer numeroQuarto, String tipoQuarto, Double preco, Boolean disponibilidade) {
		this.numeroQuarto = numeroQuarto;
		this.tipoQuarto = tipoQuarto;
		this.preco = preco;
		this.Disponibilidade = disponibilidade ;
	}

	@Override
	public String toString() {
		return "hospedes [quartos=" +  ", numeroQuarto=" + numeroQuarto + ", tipoQuarto=" + tipoQuarto
				+ ", preco=" + preco + ", Disponibilidade=" + Disponibilidade + "]";
	}
	
	
	
}

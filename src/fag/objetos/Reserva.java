package fag.objetos;

public class Reserva {
	
	public String nomeHospede;
	public String checkin;
	public String checkout;
	public String tipoQuarto;
	public Integer numeroQuarto;
	public Reserva(String nomeHospede, String checkin, String checkout, String tipoQuarto, Integer numeroQuarto) {
		super();
		this.nomeHospede = nomeHospede;
		this.checkin = checkin;
		this.checkout = checkout;
		this.tipoQuarto = tipoQuarto;
		this.numeroQuarto = numeroQuarto;
	}
	@Override
	public String toString() {
		return "Reserva [nomeHospede=" + nomeHospede + ", checkin=" + checkin + ", checkout=" + checkout
				+ ", tipoQuarto=" + tipoQuarto + ", numeroQuarto=" + numeroQuarto + "]";
	}
	
	
	
	
}

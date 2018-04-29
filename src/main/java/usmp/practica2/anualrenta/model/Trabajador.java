package usmp.practica2.anualrenta.model;
import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Trabajador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotNull
	@Size(max=8,message="mi mensaje")
	private String dni;
	@NotNull
	@Size(min=2, max=30,message="mi mensaje")
	private String name;
	
	private Double sueldoMensual;
	@NotNull
	@Size(min=2, max=30,message="mi mensaje")
	private String modalidadTrabajo;
	private Double rentaneta;
	private Double rentamensual;
	private Double imptotalbruto;
	private Double impUITdes;
	private Double impUIT;
	private Double impRentaPagar;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getSueldoMensual() {
		return sueldoMensual;
	}
	public void setSueldoMensual(Double sueldoMensual) {
		this.sueldoMensual = sueldoMensual;
	}
	public Double getRentaneta() {
		return rentaneta;
	}
	public void setRentaneta(Double rentaneta) {
		this.rentaneta = rentaneta;
	}
	public Double getRentamensual() {
		return rentamensual;
	}
	public void setRentamensual(Double rentamensual) {
		this.rentamensual = rentamensual;
	}
	public Double getImptotalbruto() {
		return imptotalbruto;
	}
	public void setImptotalbruto(Double imptotalbruto) {
		this.imptotalbruto = imptotalbruto;
	}
	public Double getImpUITdes() {
		return impUITdes;
	}
	public void setImpUITdes(Double impUITdes) {
		this.impUITdes = impUITdes;
	}
	public Double getImpUIT() {
		return impUIT;
	}
	public void setImpUIT(Double impUIT) {
		this.impUIT = impUIT;
	}
	public Double getImpRentaPagar() {
		return impRentaPagar;
	}
	public void setImpRentaPagar(Double impRentaPagar) {
		this.impRentaPagar = impRentaPagar;
	}
	
}

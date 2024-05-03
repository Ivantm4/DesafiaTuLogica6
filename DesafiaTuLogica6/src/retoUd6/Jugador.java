package retoUd6;

import java.util.*;

public class Jugador {
	
	private String nombre,arma,habitaciones;
	private Date horaPartida;
	
	public Jugador(String nombre, String arma, String habitaciones, Date horaPartida) {
		
		this.nombre = nombre;
		this.arma = arma;
		this.habitaciones = habitaciones;
		this.horaPartida = horaPartida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getArma() {
		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}

	public String getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(String habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Date getHoraPartida() {
		return horaPartida;
	}

	public void setHoraPartida(Date horaPartida) {
		this.horaPartida = horaPartida;
	}
	
	public String toString() {
		return "Jugador [nombre=" + nombre + ", arma=" + arma + ", habitaciones=" + habitaciones + ", horaPartida="
				+ horaPartida + "]";
	}
}

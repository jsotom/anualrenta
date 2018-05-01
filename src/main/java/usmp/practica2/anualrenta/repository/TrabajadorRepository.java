package usmp.practica2.anualrenta.repository;
import java.util.List;

import org.hibernate.sql.Delete;
import org.springframework.data.repository.Repository;

import usmp.practica2.anualrenta.model.Trabajador;
import java.lang.Integer;

public interface TrabajadorRepository 
extends Repository<Trabajador,Integer>
{
void save(Trabajador trabajador);
	
	List<Trabajador> findAll();
	
	Trabajador findById(int id);
	
	void delete(Trabajador trabajador);
}

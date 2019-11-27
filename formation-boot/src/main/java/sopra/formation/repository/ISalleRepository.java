package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Salle;
import sopra.formation.model.SalleId;

public interface ISalleRepository extends JpaRepository<Salle, SalleId> {
	
	
	@Query("from Salle s left outer join s.modules m where s.nom= :nom and s.capacite= :capacite")
	Salle findwithModule(@Param("nom") String nom,@Param("capacite") String capacite);
}



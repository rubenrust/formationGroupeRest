package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Filiere;

public interface IFiliereRepository extends JpaRepository<Filiere, Long> {

	@Query("select distinct f from Filiere f left join fetch f.referent r where f.id = :id")
	Filiere findWithFormateur(@Param("id") Long id);

}

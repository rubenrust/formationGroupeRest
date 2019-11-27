package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Module;

public interface IModuleRepository extends JpaRepository<Module, Integer> {
	
	@Query("select distinct m from Module m join fetch m.filiere f join fetch m.formateur f join fetch m.matiere mm join fetch m.salle s where m.code = :code")
	Module findWithAll(@Param("code") Integer code);
}

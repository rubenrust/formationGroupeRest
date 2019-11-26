package sopra.formation.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Salle;
import sopra.formation.model.SalleId;
import sopra.formation.model.Views;
import sopra.formation.repository.ISalleRepository;

@RestController
@RequestMapping("/salle")
public class SalleController {
	@Autowired
	private ISalleRepository salleRepo;

	@GetMapping("")
	@JsonView(Views.ViewSalle.class)
	public List<Salle> list() {
		List<Salle> salles = salleRepo.findAll();

		return salles;
	}

	@GetMapping("/{nom}:{capacite}")
	@JsonView(Views.ViewSalleDetail.class)
	public Salle find(@PathVariable String nom, @PathVariable Integer capacite) {
		SalleId idSalle = new SalleId(nom, capacite);
		Salle salle = salleRepo.findById(idSalle).get();

		return salle;
	}

	@PostMapping("")
	public Salle create(@RequestBody Salle salle) {
		return salleRepo.save(salle);
	}

	@PutMapping("/{nom}:{capacite}")
	public Salle update(@RequestBody Salle salle, @PathVariable String nom, @PathVariable Integer capacite) {
		return salleRepo.save(salle);
	}

	@DeleteMapping("/{nom}:{capacite}")
	public void delete(@PathVariable String nom, @PathVariable Integer capacite) {
		SalleId idSalle = new SalleId(nom, capacite);
		salleRepo.deleteById(idSalle);
	}
}

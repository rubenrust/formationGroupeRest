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

import sopra.formation.model.Stagiaire;
import sopra.formation.model.Views;
import sopra.formation.repository.IPersonneRepository;

@RestController
@RequestMapping("/stagiaire")
public class StagiaireController {
	@Autowired
	private IPersonneRepository personneRepo;

	@GetMapping("")
	@JsonView(Views.ViewStagiaire.class)
	public List<Stagiaire> list() {
		List<Stagiaire> stagiaires = personneRepo.findAllStagiaire();
		return stagiaires;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewStagiaire.class)
	public Stagiaire find(@PathVariable Long id) {
		Stagiaire stagiaire = (Stagiaire) personneRepo.findById(id).get();

		return stagiaire;
	}
	
	@GetMapping("/{id}/detail")
	@JsonView(Views.ViewStagiaireDetail.class)
	public Stagiaire findDetail(@PathVariable Long id) {
		Stagiaire stagiaire = (Stagiaire) personneRepo.findWithFiliere(id);

		return stagiaire;
	}

	@PostMapping("")
	@JsonView(Views.ViewStagiaire.class)
	public Stagiaire create(@RequestBody Stagiaire stagiaire) {
		return personneRepo.save(stagiaire);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewStagiaire.class)
	public Stagiaire update(@RequestBody Stagiaire stagiaire, @PathVariable Long id) {
		return personneRepo.save(stagiaire);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		personneRepo.deleteById(id);
	}
}

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

import sopra.formation.model.Evaluation;
import sopra.formation.model.Views;
import sopra.formation.repository.IEvaluationRepository;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {
	@Autowired
	private IEvaluationRepository evaluationRepo;

	@GetMapping("")
	@JsonView(Views.ViewEvaluation.class)
	public List<Evaluation> list() {
		List<Evaluation> evaluations = evaluationRepo.findAll();

		return evaluations;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewEvaluationDetail.class)
	public Evaluation find(@PathVariable Long id) {
		Evaluation evaluation = evaluationRepo.findWithStagiaire(id); 

		return evaluation;
	}

	@PostMapping("")
	public Evaluation create(@RequestBody Evaluation evaluation) {
		return evaluationRepo.save(evaluation);
	}

	@PutMapping("/{id}")
	public Evaluation update(@RequestBody Evaluation evaluation, @PathVariable Long id) {
		return evaluationRepo.save(evaluation);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		evaluationRepo.deleteById(id);
	}
}

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

import sopra.formation.model.Module;
import sopra.formation.model.Views;
import sopra.formation.repository.IModuleRepository;

@RestController
@RequestMapping("/module")
public class ModuleController {
	@Autowired
	private IModuleRepository moduleRepo;

	@GetMapping("")
	@JsonView(Views.ViewModule.class)
	public List<Module> list() {
		List<Module> modules = moduleRepo.findAll();

		return modules;
	}

	@GetMapping("/{code}")
	@JsonView(Views.ViewModuleDetail.class)
	public Module find(@PathVariable Integer code) {
		Module module = moduleRepo.findWithAll(code);

		return module;
	}

	@PostMapping("")
	public Module create(@RequestBody Module module) {
		return moduleRepo.save(module);
	}

	@PutMapping("/{code}")
	public Module update(@RequestBody Module module, @PathVariable Integer code) {
		return moduleRepo.save(module);
	}

	@DeleteMapping("/{code}")
	public void delete(@PathVariable Integer code) {
		moduleRepo.deleteById(code);
	}
}

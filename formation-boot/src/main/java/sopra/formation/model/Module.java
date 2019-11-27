package sopra.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "module")
public class Module {
	@Id
	@JsonView(Views.ViewCommon.class)
	private Integer code;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(name = "duration")
	@JsonView(Views.ViewCommon.class)
	private Integer duree;
	@Column(name = "position")
	@JsonView(Views.ViewCommon.class)
	private Integer ordre;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "training_id")
	@JsonView(Views.ViewModuleDetail.class)
	private Filiere filiere;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "trainer_id")
	@JsonView(Views.ViewModuleDetail.class)
	private Formateur formateur;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "subject_name", referencedColumnName = "name"),
			@JoinColumn(name = "subject_level", referencedColumnName = "level") })
	@JsonView(Views.ViewModuleDetail.class)
	private Matiere matiere;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "classroom_name", referencedColumnName = "name"),
			@JoinColumn(name = "classroom_capacity", referencedColumnName = "capacity") })
	@JsonView(Views.ViewModuleDetail.class)
	private Salle salle;

	public Module() {
		super();
	}

	public Module(Integer code) {
		super();
		this.code = code;
	}

	public Module(Integer code, Integer duree, Integer ordre, Filiere filiere, Formateur formateur, Matiere matiere,
			Salle salle) {
		super();
		this.code = code;
		this.duree = duree;
		this.ordre = ordre;
		this.filiere = filiere;
		this.formateur = formateur;
		this.matiere = matiere;
		this.salle = salle;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public Integer getOrdre() {
		return ordre;
	}

	public void setOrdre(Integer ordre) {
		this.ordre = ordre;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

}

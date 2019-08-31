package cr.ac.una.beans;

import cr.ac.una.entities.Persona;
import cr.ac.una.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import java.util.List;


@Component
public class PersonaBean {

    @Autowired
    PersonaService personaService;
    private Persona persona = new Persona();


    private List<Persona> personas;

    @PostConstruct
    public void init() {
        personas = personaService.getAllPersonas();

    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public void create() {
        personaService.createPersona(persona);
        personas = personaService.getAllPersonas();
    }
}

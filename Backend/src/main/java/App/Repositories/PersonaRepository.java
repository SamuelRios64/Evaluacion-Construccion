package App.Repositories;

import App.Entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repositorio de Persona
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}

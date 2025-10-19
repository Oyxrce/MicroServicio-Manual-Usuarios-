package com.example.manual_usuarios_service.repository;

import com.example.manual_usuarios_service.model.ManualUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ManualUsuariosRepository extends JpaRepository<ManualUsuarios, Long> {
    List<ManualUsuarios> findByUsuarioId(Long usuarioId);
    List<ManualUsuarios> findByManualId(Long manualId);
    Optional<ManualUsuarios> findByUsuarioIdAndManualId(Long usuarioId, Long manualId);
    List<ManualUsuarios> findByUsuarioIdAndPuedeAcceder(Long usuarioId, Boolean puedeAcceder);
    boolean existsByUsuarioIdAndManualId(Long usuarioId, Long manualId);
}
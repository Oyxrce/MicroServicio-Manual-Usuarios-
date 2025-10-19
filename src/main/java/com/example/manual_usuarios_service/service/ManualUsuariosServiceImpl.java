package com.example.manual_usuarios_service.service;

import com.example.manual_usuarios_service.model.ManualUsuarios;
import com.example.manual_usuarios_service.repository.ManualUsuariosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ManualUsuariosServiceImpl implements ManualUsuariosService {
    
    private final ManualUsuariosRepository repository;
    
    @Override
    @Transactional
    public ManualUsuarios crear(ManualUsuarios manualUsuarios) {
        if (repository.existsByUsuarioIdAndManualId(
                manualUsuarios.getUsuarioId(), manualUsuarios.getManualId())) {
            throw new RuntimeException("El acceso ya existe");
        }
        return repository.save(manualUsuarios);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<ManualUsuarios> obtenerTodos() {
        return repository.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public ManualUsuarios obtenerPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Acceso no encontrado: " + id));
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<ManualUsuarios> obtenerPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<ManualUsuarios> obtenerPorManual(Long manualId) {
        return repository.findByManualId(manualId);
    }
    
    @Override
    @Transactional
    public ManualUsuarios actualizar(Long id, ManualUsuarios manualUsuarios) {
        ManualUsuarios existe = obtenerPorId(id);
        existe.setPuedeAcceder(manualUsuarios.getPuedeAcceder());
        existe.setFechaAcceso(manualUsuarios.getFechaAcceso());
        return repository.save(existe);
    }
    
    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Acceso no encontrado: " + id);
        }
        repository.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public boolean puedeAcceder(Long usuarioId, Long manualId) {
        return repository.findByUsuarioIdAndManualId(usuarioId, manualId)
            .map(ManualUsuarios::getPuedeAcceder)
            .orElse(false);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<ManualUsuarios> obtenerAccesosUsuario(Long usuarioId) {
        return repository.findByUsuarioIdAndPuedeAcceder(usuarioId, true);
    }
}
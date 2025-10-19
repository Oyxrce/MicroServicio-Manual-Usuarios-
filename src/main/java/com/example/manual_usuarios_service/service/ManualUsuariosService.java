package com.example.manual_usuarios_service.service;

import com.example.manual_usuarios_service.model.ManualUsuarios;
import java.util.List;

public interface ManualUsuariosService {
    ManualUsuarios crear(ManualUsuarios manualUsuarios);
    List<ManualUsuarios> obtenerTodos();
    ManualUsuarios obtenerPorId(Long id);
    List<ManualUsuarios> obtenerPorUsuario(Long usuarioId);
    List<ManualUsuarios> obtenerPorManual(Long manualId);
    ManualUsuarios actualizar(Long id, ManualUsuarios manualUsuarios);
    void eliminar(Long id);
    boolean puedeAcceder(Long usuarioId, Long manualId);
    List<ManualUsuarios> obtenerAccesosUsuario(Long usuarioId);
}
package com.example.manual_usuarios_service.controller;

import com.example.manual_usuarios_service.model.ManualUsuarios;
import com.example.manual_usuarios_service.service.ManualUsuariosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/manual-usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ManualUsuariosController {
    
    private final ManualUsuariosService service;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ManualUsuarios crear(@Valid @RequestBody ManualUsuarios manualUsuarios) {
        return service.crear(manualUsuarios);
    }
    
    @GetMapping
    public List<ManualUsuarios> obtenerTodos() {
        return service.obtenerTodos();
    }
    
    @GetMapping("/{id}")
    public ManualUsuarios obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }
    
    @GetMapping("/usuario/{usuarioId}")
    public List<ManualUsuarios> obtenerPorUsuario(@PathVariable Long usuarioId) {
        return service.obtenerPorUsuario(usuarioId);
    }
    
    @GetMapping("/manual/{manualId}")
    public List<ManualUsuarios> obtenerPorManual(@PathVariable Long manualId) {
        return service.obtenerPorManual(manualId);
    }
    
    @GetMapping("/usuario/{usuarioId}/accesos")
    public List<ManualUsuarios> obtenerAccesosUsuario(@PathVariable Long usuarioId) {
        return service.obtenerAccesosUsuario(usuarioId);
    }
    
    @GetMapping("/verificar/{usuarioId}/{manualId}")
    public boolean puedeAcceder(
            @PathVariable Long usuarioId, 
            @PathVariable Long manualId) {
        return service.puedeAcceder(usuarioId, manualId);
    }
    
    @PutMapping("/{id}")
    public ManualUsuarios actualizar(
            @PathVariable Long id, 
            @Valid @RequestBody ManualUsuarios manualUsuarios) {
        return service.actualizar(id, manualUsuarios);
    }
    
    @PatchMapping("/{id}")
    public ManualUsuarios actualizarParcial(
            @PathVariable Long id, 
            @RequestBody ManualUsuarios manualUsuarios) {
        return service.actualizar(id, manualUsuarios);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
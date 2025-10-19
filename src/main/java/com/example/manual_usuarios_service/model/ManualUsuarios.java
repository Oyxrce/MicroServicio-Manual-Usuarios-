package com.example.manual_usuarios_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "manual_usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManualUsuarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "El usuario es obligatorio")
    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;
    
    @NotNull(message = "El manual es obligatorio")
    @Column(name = "manual_id", nullable = false)
    private Long manualId;
    
    @Column(name = "fecha_acceso")
    private LocalDate fechaAcceso;
    
    @NotNull
    @Column(name = "puede_acceder", nullable = false)
    private Boolean puedeAcceder;
    
    @PrePersist
    protected void onCreate() {
        if (fechaAcceso == null) {
            fechaAcceso = LocalDate.now();
        }
        if (puedeAcceder == null) {
            puedeAcceder = true;
        }
    }
}
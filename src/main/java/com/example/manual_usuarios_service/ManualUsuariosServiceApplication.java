package com.example.manual_usuarios_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManualUsuariosServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ManualUsuariosServiceApplication.class, args);
        System.out.println("\n" + "=".repeat(50));
        System.out.println(" MicroServicio Manual-Usuarios Operativo  - Puerto 8086");
        System.out.println(" http://localhost:8086/api/manual-usuarios");
        System.out.println("=".repeat(50) + "\n");
    }
}
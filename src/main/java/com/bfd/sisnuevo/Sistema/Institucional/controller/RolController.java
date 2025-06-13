package com.bfd.sisnuevo.Sistema.Institucional.controller;


import com.bfd.sisnuevo.Sistema.Institucional.model.authotization.Permisos;
import com.bfd.sisnuevo.Sistema.Institucional.model.authotization.Rol;
import com.bfd.sisnuevo.Sistema.Institucional.service.PermisoService;
import com.bfd.sisnuevo.Sistema.Institucional.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @Autowired
    private PermisoService permisoService;

    @GetMapping
    public ResponseEntity<List> getAllRoles() {
        List roles = rolService.findAll();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity getRoleById(@PathVariable Long id) {
        Optional role = rolService.findById(id);
        return (ResponseEntity) role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity createRole(@RequestBody Rol rol) {
        Set<Permisos> permissionList = new HashSet<>();
        Permisos readPermission;

        // Recuperar la Permission/s por su ID
        for (Permisos per : rol.getPermisosSet()) {
            readPermission = (Permisos) permisoService.findById(per.getId()).orElse(null);
            if (readPermission != null) {
                //si encuentro, guardo en la lista
                permissionList.add(readPermission);
            }
        }

        rol.setPermisosSet(permissionList);
        Rol newRole = rolService.save(rol);
        return ResponseEntity.ok(newRole);
    }
}

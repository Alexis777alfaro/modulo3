package com.moduloIII.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.moduloIII.collections.Computers;
import com.moduloIII.service.ComputersService;

@RestController
@RequestMapping("/mongo/pc")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ComputersController {

    @Autowired
    private ComputersService computersService;

    @GetMapping
    public List<Computers> getAllComputers() {
        return computersService.getAll();
    }

    @GetMapping("/{id}")
    public Computers getComputerById(@PathVariable("id") String id) {
        return computersService.getById(id);
    }

    @PutMapping("/{id}")
    public Computers updateComputer(@PathVariable("id") String id, @RequestBody Computers updatedComputer) {
        Computers computer = computersService.getById(id);
        if (computer != null) {
            computer.setFechaIngreso(updatedComputer.getFechaIngreso());
            computer.setNombrePropietario(updatedComputer.getNombrePropietario());
            computer.setMarca(updatedComputer.getMarca());
            computer.setModelo(updatedComputer.getModelo());
            computer.setTipo(updatedComputer.getTipo());
            computer.setSerie(updatedComputer.getSerie());
            return computersService.update(computer);
        }
        return null;
    }

    @PostMapping
    public Computers addComputer(@RequestBody Computers computer) {
        return computersService.create(computer);
    }

    @DeleteMapping("/{id}")
    public void deleteComputer(@PathVariable("id") String id) {
        computersService.delete(id);
    }
}

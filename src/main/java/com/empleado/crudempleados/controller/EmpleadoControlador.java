package com.empleado.crudempleados.controller;

import com.empleado.crudempleados.model.Empleado;
import com.empleado.crudempleados.service.EmpleadoService;
import com.empleado.crudempleados.service.EmpleadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpleadoControlador {

@Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/")
    public String inicio(Model model){
        model.addAttribute("listaEmpleados", empleadoService.obtenerEmpleados());
        return "index";
    }
    @GetMapping("/nuevoEmpleado")
    public String nuevoEmpleado(Model model){
        Empleado empleado = new Empleado();
        model.addAttribute("empleado" ,empleado);
        return "nuevo_empleado";
    }
    @PostMapping("/guardarEmpleado")
    public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleado){
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/";
    }
    @GetMapping("/actualizarEmpleado/{id}")
    public String actualizarEmpleado(@PathVariable (value="id") long id, Model model){
        Empleado empleado= empleadoService.obtenerEmpleadoById(id);
        model.addAttribute("empleado",empleado);
        return "actualizar_empleado";
    }
}

package com.empleado.crudempleados.service;

import com.empleado.crudempleados.model.Empleado;
import com.empleado.crudempleados.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> obtenerEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public void guardarEmpleado(Empleado empleado) {
        this.empleadoRepository.save(empleado);
    }

    @Override
    public Empleado obtenerEmpleadoById(long id) {
        Optional<Empleado> optional=empleadoRepository.findById(id);
        Empleado empleado=null;
        if(optional.isPresent()){
            empleado= optional.get();
        }else{
            throw new RuntimeException("No se encontró el empleado con id: "+id);
        }
        return empleado;

    }
}

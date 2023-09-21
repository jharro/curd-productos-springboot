package com.empleado.crudempleados.service;

import com.empleado.crudempleados.model.Empleado;

import java.util.List;

public interface EmpleadoService {

    List<Empleado> obtenerEmpleados();
    void guardarEmpleado(Empleado empleado);
    Empleado obtenerEmpleadoById(long id);
}

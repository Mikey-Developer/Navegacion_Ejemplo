package com.daa_lm.app_consultorio.data;

public class Cita {

    String nombreDoctor, hospital, especialidad, fecha, horario;

    public Cita(String nombreDoctor, String hospital, String especialidad, String fecha, String horario) {
        this.nombreDoctor = nombreDoctor;
        this.hospital = hospital;
        this.especialidad = especialidad;
        this.fecha = fecha;
        this.horario = horario;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}

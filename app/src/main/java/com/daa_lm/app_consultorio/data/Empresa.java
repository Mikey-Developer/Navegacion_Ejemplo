package com.daa_lm.app_consultorio.data;

import java.util.UUID;

public class Empresa  {
    UUID id_Empresa;
    String nombre, descripcion, tel, direccion;
    //String codigoPostal, colonia, estado, ciudad;

    public Empresa(UUID ID, String nombre, String descripcion, String tel, String direccion) {
        this.id_Empresa = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tel = tel;
        this.direccion = direccion;
    }

    public UUID getId_Empresa() {
        return id_Empresa;
    }

    public void setId_Empresa(UUID id_Empresa) {
        this.id_Empresa = id_Empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

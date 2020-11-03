package com.daa_lm.app_consultorio.Vmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.daa_lm.app_consultorio.data.Empresa;

import java.util.UUID;

public class EmpresaViewModel extends ViewModel {
    Empresa empresa;

    private MutableLiveData<Empresa> datosEmpresa;

    private static final String TAG = EmpresaViewModel.class.getSimpleName();

    public EmpresaViewModel(){
        datosEmpresa = new MutableLiveData<>();
    }

    public LiveData<Empresa> getDatosEmpresa(){
        return datosEmpresa;
    }

    public void crearEmpresa(UUID id, String nombre, String description, String tel, String direccion){

        Log.i(TAG, "*** EmpresaViewModel.crearEmpresa() : CREANDO EMPRESA");

        empresa = new Empresa(id, nombre, description, tel, direccion);

        Log.i(TAG, "*** EmpresaViewModel.crearEmpresa() : EMPRESA CREADA");

        datosEmpresa.setValue(empresa);

        Log.i(TAG, "*** EmpresaViewModel.crearEmpresa() : EMPRESA ASIGNADA");
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}

package com.daa_lm.app_consultorio.Vmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.daa_lm.app_consultorio.data.Cita;

public class CitaViewModel extends ViewModel {
    Cita cita;

    private MutableLiveData<Cita> datosCita;

    private static final String TAG = CitaViewModel.class.getSimpleName();


    public CitaViewModel() {
        datosCita = new MutableLiveData<>();
    }

    public LiveData<Cita> getDatosCita(){
        return datosCita;
    }

    public void crearCita(String nombreDoctor, String hospital, String especialidad,
                          String fecha, String horario){

        Log.i(TAG,"*** CitaViewModel.crearCita() : CREANDO CITA");

        cita = new Cita(nombreDoctor, hospital, especialidad, fecha, horario);

        Log.i(TAG,"*** CitaViewModel.crearCita() : CITA CREADA");

        datosCita.setValue(cita);

        Log.i(TAG,"*** CitaViewModel.datosCita : CITA ASIGNADA");
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
}

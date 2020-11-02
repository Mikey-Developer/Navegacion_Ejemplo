package com.daa_lm.app_consultorio.fragments;


import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import com.daa_lm.app_consultorio.R;
import com.daa_lm.app_consultorio.Vmodel.CitaViewModel;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentoCita#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentoCita extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText nombre_doctor, hospital, especialidad, dia, horario;
    private Button siguiente;

    private CitaViewModel citaViewModel;

    private static final String TAG = fragmentoCita.class.getSimpleName();

    private TextWatcher revisar_campos = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
             boolean camposVerificados = revisarCampos(nombre_doctor.getText().toString(), hospital.getText().toString(), dia.getText().toString());

             if(!camposVerificados)
                siguiente.setEnabled(true);
             else
                 siguiente.setEnabled(false);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public fragmentoCita() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Citas.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentoCita newInstance(String param1, String param2) {
        fragmentoCita fragment = new fragmentoCita();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_citas, container, false);

        citaViewModel = new ViewModelProvider(requireActivity()).get(CitaViewModel.class);


        nombre_doctor = v.findViewById(R.id.edit_nombre_doctor);
        hospital = v.findViewById(R.id.edit_hospital);
        especialidad = v.findViewById(R.id.edit_especialidad);
        dia = v.findViewById(R.id.edit_dia);
        horario = v.findViewById(R.id.edit_horario);

        nombre_doctor.addTextChangedListener(revisar_campos);
        hospital.addTextChangedListener(revisar_campos);
        dia.addTextChangedListener(revisar_campos);

        siguiente = v.findViewById(R.id.boton_siguiente);

        siguiente.setEnabled(false);

        horario.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                DialogFragment timePicker = new fragmentoTimePicker(horario);
                timePicker.show(getActivity().getSupportFragmentManager(), "TimePicker");
            }
        });



        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /*ir_aDestino(view, nombre_doctor.getText().toString(),
                        hospital.getText().toString(),
                        especialidad.getText().toString(),
                        dia.getText().toString(),
                        horario.getText().toString());*/

                Log.i(TAG, "*** siguiente: SETONCLICKLISTENER() ***");
                Log.i(TAG, "*** siguiente: SETONCLICKLISTENER() : citaViewModel.crearCita ***");
                citaViewModel.crearCita(nombre_doctor.getText().toString(),
                        hospital.getText().toString(),
                        especialidad.getText().toString(),
                        dia.getText().toString(),
                        horario.getText().toString());

                Log.i(TAG, "*** siguiente: SETONCLICKLISTENER() : FIN ***");
                Navigation.findNavController(view).navigate(R.id.action_confirmar);
            }
        });

        return v;
    }

    public void ir_aDestino(View view, String nombreDoctor, String hospital, String especialidad, String dia, String horario){

       fragmentoCitaDirections.ActionConfirmar confirmar = fragmentoCitaDirections.actionConfirmar(nombreDoctor, hospital, dia);

       if(!especialidad.isEmpty())
           confirmar.setEspecialidad(especialidad);
       if(!horario.isEmpty())
           confirmar.setHorario(horario);

        Navigation.findNavController(view).navigate(confirmar);

    }

    public boolean revisarCampos(String nombreDoctor, String hospital, String dia){
        return (nombreDoctor.trim().isEmpty() || hospital.trim().isEmpty() || (dia.trim().isEmpty() || Integer.parseInt(dia) > 31));
    }

}
package com.daa_lm.app_consultorio.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.daa_lm.app_consultorio.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentoCita#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentoCita extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText nombre_doctor, hospital, especialidad, dia, horario;
    private Button siguiente;

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

        nombre_doctor = v.findViewById(R.id.edit_nombre_doctor);
        hospital = v.findViewById(R.id.edit_hospital);
        especialidad = v.findViewById(R.id.edit_especialidad);
        dia = v.findViewById(R.id.edit_dia);
        horario = v.findViewById(R.id.edit_horario);

        siguiente = v.findViewById(R.id.boton_siguiente);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ir_aDestino(view, nombre_doctor.getText().toString(),
                        hospital.getText().toString(),
                        especialidad.getText().toString(),
                        dia.getText().toString(),
                        horario.getText().toString());
            }
        });

        return v;
    }

    public void ir_aDestino(View view, String nombreDoctor, String hospital, String especialidad, String dia, String horario){

       fragmentoCitaDirections.ActionConfirmar confirmar = fragmentoCitaDirections.actionConfirmar(nombreDoctor, hospital, dia);

        Navigation.findNavController(view).navigate(confirmar);

    }
}
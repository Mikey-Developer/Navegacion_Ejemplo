package com.daa_lm.app_consultorio.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daa_lm.app_consultorio.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentoConfirmar_Cita#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentoConfirmar_Cita extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_DOCTOR = "Doctor";
    private static final String ARG_HOSPITAL = "Hospital";
    private static final String ARG_ESPECIALIDAD = "Especialidad";
    private static final String ARG_DIA = "Dia";
    private static final String ARG_HORARIO = "Horario";

    // TODO: Rename and change types of parameters
    // private String argDoctor, argHopsital, argEspecialidad, argDia, argHorario;

    private TextView resultado_doctor, resultado_hospital, resultado_especialidad, resultado_dia, resultado_horario;
    private Button confirmar;

    private static final String TAG = "Fragmento Confirmar: ";

    public fragmentoConfirmar_Cita() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param nombreDoctor Parameter 1.
     * @param hospital Parameter 2.
     * @param especialidad Parameter 3.
     * @param dia Parameter 4.
     * @param horario Parameter 5.
     * @return A new instance of fragment confirmarCita.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentoConfirmar_Cita newInstance(String nombreDoctor, String hospital, String especialidad, String dia, String horario) {
        fragmentoConfirmar_Cita fragment = new fragmentoConfirmar_Cita();
        Bundle args = new Bundle();
        args.putString(ARG_DOCTOR, nombreDoctor);
        args.putString(ARG_HOSPITAL, hospital);
        args.putString(ARG_ESPECIALIDAD, especialidad);
        args.putString(ARG_DIA, dia);
        args.putString(ARG_HORARIO, horario);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_confirmar_cita, container, false);

        resultado_doctor  = v.findViewById(R.id.result_nombre_doctor);
        resultado_hospital  = v.findViewById(R.id.result_hospital);
        resultado_especialidad = v.findViewById(R.id.result_especialidad);
        resultado_dia = v.findViewById(R.id.result_dia);
        resultado_horario = v.findViewById(R.id.result_horario);

        fragmentoConfirmar_CitaArgs args = fragmentoConfirmar_CitaArgs.fromBundle(getArguments());

        resultado_doctor.setText(args.getDoctor());
        resultado_hospital.setText(args.getHospital());
        resultado_especialidad.setText(args.getEspecialidad());
        resultado_dia.setText(args.getDia());
        resultado_horario.setText(args.getHorario());

        confirmar = v.findViewById(R.id.boton_confirmar);

        confirmar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Cita confirmada!", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.action_regresar_inicio);
            }
        });

        return v;
    }
}
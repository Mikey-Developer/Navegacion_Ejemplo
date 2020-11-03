package com.daa_lm.app_consultorio.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.daa_lm.app_consultorio.R;
import com.daa_lm.app_consultorio.Vmodel.EmpresaViewModel;
import com.daa_lm.app_consultorio.data.Empresa;

import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentoEmpresa#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentoEmpresa extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private EditText editId, editNombre, editDesc, editTel, editDireccion, testText;
    private Button enviar;
    private EmpresaViewModel empresaViewModel;

    private static final String TAG = fragmentoEmpresa.class.getSimpleName();

    public fragmentoEmpresa() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentoEmpresa.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentoEmpresa newInstance(String param1, String param2) {
        fragmentoEmpresa fragment = new fragmentoEmpresa();
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
        View v = inflater.inflate(R.layout.fragment_empresa, container, false);

        editId = v.findViewById(R.id.editId);
        editNombre = v.findViewById(R.id.editNombre_Empresa);
        editDesc = v.findViewById(R.id.editDesc_Empresa);
        editTel = v.findViewById(R.id.editTel_Empresa);
        editDireccion = v.findViewById(R.id.editDireccion_Empresa);
        testText = v.findViewById(R.id.testVM);

        enviar = v.findViewById(R.id.finalizarEmpresa);


        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try {

            empresaViewModel = new ViewModelProvider(requireActivity()).get(EmpresaViewModel.class);

            final Observer<Empresa> observarEmpresa = new Observer<Empresa>() {
                @Override
                public void onChanged(Empresa resultado) {
                    Log.i(TAG, "getDatosEmpresa().observe(observarEmpresa) : OnChanged() : CAMBIOS ACTUALIZADOS. GENERANDO DATOS.");
                    editId.setText(resultado.getId_Empresa().toString());
                    testText.setText(
                            "Nombre: " + resultado.getNombre() +
                                    "\nDescripcion: " + resultado.getDescripcion() +
                                    "\nTelefono: " + resultado.getTel() +
                                    "\nDireccion: " + resultado.getDireccion()
                    );

                    Log.i(TAG, "getDatosEmpresa().observe(observarEmpresa) : OnChanged() : DATOS GENERADOS");
                }
            };

            empresaViewModel.getDatosEmpresa().observe(getViewLifecycleOwner(), observarEmpresa);

            enviar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i(TAG, "enviar.setOnClickListener() : onClick() : empresaViewModel.crearEmpresa()");
                    empresaViewModel.crearEmpresa(UUID.randomUUID(), editNombre.getText().toString(),
                            editDesc.getText().toString(), editTel.getText().toString(), editDireccion.getText().toString());
                    Log.i(TAG, "enviar.setOnClickListener() : onClick() : FIN");
                }
            });
        } catch (Exception e){
            Log.e(TAG, "ERROR: " + e.getMessage());
        }
    }
}
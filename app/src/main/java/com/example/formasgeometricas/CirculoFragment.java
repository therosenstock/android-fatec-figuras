package com.example.formasgeometricas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.formasgeometricas.controller.CirculoController;
import com.example.formasgeometricas.controller.IGeometriaController;
import com.example.formasgeometricas.model.Circulo;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CirculoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CirculoFragment extends Fragment {

    View view;
    EditText txtRaio;
    Button btnPerimetro, btnArea;
    TextView txtResultado;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CirculoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CirculoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CirculoFragment newInstance(String param1, String param2) {
        CirculoFragment fragment = new CirculoFragment();
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
        view = inflater.inflate(R.layout.fragment_circulo, container, false);

        txtResultado = view.findViewById(R.id.txtResultado);
        txtRaio = view.findViewById(R.id.txtRaio);
        btnArea = view.findViewById(R.id.btnArea);
        btnPerimetro = view.findViewById(R.id.btnPerimetro);

        btnArea.setOnClickListener(op -> calcularArea());
        btnPerimetro.setOnClickListener(op -> calcularPerimetro());

        return view;
    }

    private void calcularArea() {
        float raio = Float.parseFloat(txtRaio.getText().toString());
        Circulo circulo = new Circulo();
        circulo.setRaio(raio);
        IGeometriaController geo =  new CirculoController();
        float area = geo.calcularArea(circulo);
        txtResultado.setText("Área do Círculo: " + area);
        limparCampos();
    }

    private void limparCampos() {
        txtRaio.setText("");
    }

    private void calcularPerimetro() {
        float raio = Float.parseFloat(txtRaio.getText().toString());
        Circulo circulo = new Circulo();
        circulo.setRaio(raio);
        IGeometriaController geo =  new CirculoController();
        float area = geo.calcularPerimetro(circulo);
        txtResultado.setText("Perímetro do Círculo: " + area);
        limparCampos();
    }


}
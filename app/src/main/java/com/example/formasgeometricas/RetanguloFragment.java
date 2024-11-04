package com.example.formasgeometricas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.formasgeometricas.controller.IGeometriaController;
import com.example.formasgeometricas.controller.RetanguloController;
import com.example.formasgeometricas.model.Retangulo;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link com.example.formasgeometricas.RetanguloFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RetanguloFragment extends Fragment {

        View view;
        EditText txtBase, txtAltura;
        Button btnPerimetro, btnArea;
        TextView txtResultado;

        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";

        // TODO: Rename and change types of parameters
        private String mParam1;
        private String mParam2;

        public RetanguloFragment() {
            // Required empty public constructor
        }

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RetanguloFragment.
         */
        // TODO: Rename and change types and number of parameters
        public static RetanguloFragment newInstance(String param1, String param2) {
            RetanguloFragment fragment = new RetanguloFragment();
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
            view = inflater.inflate(R.layout.fragment_retangulo, container, false);

            txtResultado = view.findViewById(R.id.txtResultado);
            txtAltura = view.findViewById(R.id.txtAltura);
            txtBase = view.findViewById(R.id.txtBase);
            btnArea = view.findViewById(R.id.btnArea);
            btnPerimetro = view.findViewById(R.id.btnPerimetro);

            btnArea.setOnClickListener(op -> calcularArea());
            btnPerimetro.setOnClickListener(op -> calcularPerimetro());

            return view;
        }

        private void calcularPerimetro() {
            float base = Float.parseFloat(txtBase.getText().toString());
            float altura = Float.parseFloat(txtAltura.getText().toString());
            Retangulo retangulo = new Retangulo();
            retangulo.setAltura(altura);
            retangulo.setBase(base);

            IGeometriaController geo = new RetanguloController();

            float perimetro = geo.calcularPerimetro(retangulo);
            txtResultado.setText("Perímetro do Retângulo: " + perimetro);
            limparCampos();
        }

        private void calcularArea() {
            float base = Float.parseFloat(txtBase.getText().toString());
            float altura = Float.parseFloat(txtAltura.getText().toString());
            Retangulo retangulo = new Retangulo();
            retangulo.setAltura(altura);
            retangulo.setBase(base);

            IGeometriaController geo = new RetanguloController();

            float area = geo.calcularArea(retangulo);
            txtResultado.setText("Área do Retângulo: " + area);
            limparCampos();
        }

        private void limparCampos() {
            txtAltura.setText("");
            txtBase.setText("");
        }

}
package com.devtorreshs.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder nViewHolder = new

    ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nViewHolder.editValor = findViewById(R.id.edit_Valor);
        this.nViewHolder.textDolar = findViewById(R.id.text_Dolar);
        this.nViewHolder.textEuro = findViewById(R.id.text_Euro);
        this.nViewHolder.buttonCalculate = findViewById(R.id.buttonCalculate);

        this.nViewHolder.buttonCalculate.setOnClickListener(this);

        this.ClearValor();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonCalculate) {
            String valor = this.nViewHolder.editValor.getText().toString();
            if ("".equals(valor)) {
                // Mostra msg de validação
                Toast.makeText(this,this.getString(R.string.informe_valor), Toast.LENGTH_LONG).show();
            } else {
                Double real = Double.valueOf(valor);
                this.nViewHolder.textDolar.setText((String.format("%.2f", (real / 4))));
                this.nViewHolder.textEuro.setText((String.format("%.2f", (real / 5))));

            }
        }
    }

    private void ClearValor() {
        this.nViewHolder.textDolar.setText("");
        this.nViewHolder.textEuro.setText("");
    }

    private static class ViewHolder {
        EditText editValor;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculate;
    }
}

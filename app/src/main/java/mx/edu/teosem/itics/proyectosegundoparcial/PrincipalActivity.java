package mx.edu.teosem.itics.proyectosegundoparcial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity implements View.OnClickListener {

    Button bregistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        bregistrar = (Button) findViewById(R.id.btnRegistrar);

        bregistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent cargar = new Intent(this, RegistrarActivity.class);
        startActivity(cargar);
    }

    public void CargaLista(View v){
        Intent cargar = new Intent(this, ListarActivity.class);
        startActivity(cargar);
    }
}

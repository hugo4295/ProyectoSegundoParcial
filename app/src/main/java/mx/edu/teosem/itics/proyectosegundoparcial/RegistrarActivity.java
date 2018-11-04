package mx.edu.teosem.itics.proyectosegundoparcial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrarActivity extends AppCompatActivity{

    TextView vNombre, vEdad, vCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        vNombre = (TextView) findViewById(R.id.txtnombre);
        vEdad = (TextView) findViewById(R.id.txtedad);
        vCorreo = (TextView) findViewById(R.id.txtcorreo);

    }

    public void RegistraContenido(View v){
        CDatos datos = new CDatos();
        InformacionArchivo grabar =  new InformacionArchivo();
        datos.setNombre(vNombre.getText().toString());
        datos.setEdad(Integer.parseInt(vEdad.getText().toString()));
        datos.setCorreo(vCorreo.getText().toString());
        if(grabar.escribir(datos.toString())){
            Toast.makeText(this, "Se grabaron los datos correctamente...", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Error al grabar los datos...", Toast.LENGTH_SHORT).show();
        }
    }


}

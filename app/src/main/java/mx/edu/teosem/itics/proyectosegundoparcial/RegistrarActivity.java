package mx.edu.teosem.itics.proyectosegundoparcial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RegistrarActivity extends AppCompatActivity{

    EditText vNombre, vEdad, vCorreo;
    TextView lblinformacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        vNombre = (EditText) findViewById(R.id.txtnombre);
        vEdad = (EditText) findViewById(R.id.txtedad);
        vCorreo = (EditText) findViewById(R.id.txtcorreo);
        lblinformacion = (TextView) findViewById(R.id.lblinformacion);
    }

    public void RegistraContenido(View v){

        InformacionArchivo grabar =  new InformacionArchivo();
        CDatos datos = new CDatos();

        datos.setNombre(vNombre.getText().toString());
        datos.setEdad(Integer.parseInt(vEdad.getText().toString()));
        datos.setCorreo(vCorreo.getText().toString());

        if (grabar.LeerContenido()){
            if (grabar.EscribirContenido(datos)){
                Toast.makeText(this, "Correcto para grabar...", Toast.LENGTH_SHORT).show();
            }
            //String[] elementos = grabar.RegresaArreglo();
            //lblinformacion.setText(elementos[0]);

        }else{
            Toast.makeText(this, "Error al grabar los datos leer...", Toast.LENGTH_SHORT).show();
        }
    }


}

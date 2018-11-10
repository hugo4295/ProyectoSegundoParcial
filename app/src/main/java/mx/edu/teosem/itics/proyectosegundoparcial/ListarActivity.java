package mx.edu.teosem.itics.proyectosegundoparcial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class ListarActivity extends AppCompatActivity {

    GridView gvdatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        gvdatos = (GridView) findViewById(R.id.gvdatos);
        InformacionArchivo conexion = new InformacionArchivo();

        if (conexion.LeerContenido()) {
            conexion.GenerarArreglo();
            String[] arreglo = conexion.RegresaArreglo();

            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arreglo);
            gvdatos.setAdapter(adaptador);
        }
    }
}

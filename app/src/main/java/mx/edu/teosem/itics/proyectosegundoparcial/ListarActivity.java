package mx.edu.teosem.itics.proyectosegundoparcial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class ListarActivity extends AppCompatActivity {

    GridView gvdatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        gvdatos = (GridView) findViewById(R.id.gvdatos);
        InformacionArchivo Leer = new InformacionArchivo();

        if (Leer.leer()){
            String[] contenidoGrid = Leer.contenidoArchivo();

            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contenidoGrid);
            gvdatos.setAdapter(adaptador);
        }
    }
}

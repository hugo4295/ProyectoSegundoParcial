package mx.edu.teosem.itics.proyectosegundoparcial;


import android.os.Environment;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static android.os.Environment.getExternalStorageDirectory;

public class InformacionArchivo {

    boolean sdAccesoEscritura = false;
    String[] infodatos;

    private boolean verificaSD(){

        boolean sdDisponible = false;
        String estado = Environment.getExternalStorageState();

        if (estado.equals(Environment.MEDIA_MOUNTED)) {
            sdDisponible = true;
            }

        return sdDisponible;
    }

    private File verificaCarpeta(){
        File nuevaCarpeta = new File(getExternalStorageDirectory(), "hugo4295");
        if (!nuevaCarpeta.exists()) {
            nuevaCarpeta.mkdirs();
        }
        return nuevaCarpeta;
    }

    public boolean escribir(String Datos) {
        boolean estado = true;
        if (verificaSD()){
            File ubicacion = verificaCarpeta();
            try {
                //se crea archivo
                File f = new File(ubicacion.getAbsolutePath(), "Agenda_sd.txt");
                OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(f));

                //String[] informacion = Datos.split(",");

                fout.write(Datos);
                fout.close();
            }catch (Exception ex)
            {
                estado = false;
            }

        }
        return  estado;
    }

    public boolean leer() {
        boolean estado = true;
        String contenido;

        if (verificaSD()){
            File ubicacion = verificaCarpeta();
            try{
                File f = new File(ubicacion.getAbsolutePath(), "hugo4295_sd.txt");
                BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(f)));

                while ((contenido = fin.readLine()) != null){
                    infodatos = contenido.split(",");
                }

            }catch (Exception ex){
                estado=false;
            }
        }

        return estado;
    }

    public String[] contenidoArchivo(){
        return  infodatos;
    }
}

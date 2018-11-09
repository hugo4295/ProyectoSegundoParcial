package mx.edu.teosem.itics.proyectosegundoparcial;


import android.os.Environment;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import static android.os.Environment.getExternalStorageDirectory;

public class InformacionArchivo {
    List<CDatos> informacion = new ArrayList();
    public String informacionDatos;
    String[] cadenaArreglo = new String[3];

    private Boolean TarjetaExternaEscritura(){
        String estado = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(estado)) {
            return true;
        }
        return false;
    }

    private File directorioAlmacenamiento() {
        // Get the directory for the app's private pictures directory.
        //File file = new File(this.getExternalFilesDir(null).getAbsolutePath(), "MiAgenda");
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "pruebaagenda");
        if (!file.mkdirs()) {
            Log.e("Error: ", "Directory not created");
        }
        return file;
    }

    private void existearchivo(){
        if (TarjetaExternaEscritura()){
            File file = directorioAlmacenamiento();
            File f = new File(file, "Agenda_sd.txt");
            if (!f.exists()){
                OutputStreamWriter fout = null;
                try {
                    fout = new OutputStreamWriter(new FileOutputStream(f));
                    fout.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public Boolean LeerContenido(){
        Boolean estado=true;
        existearchivo();
        File ruta = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "pruebaagenda");
        String contenido;
        try {
            File f = new File(ruta, "Agenda_sd.txt");
            BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(f)));

            while((contenido = fin.readLine()) != null) {
                CDatos datos = new CDatos();
                String[] ArregloDatos = contenido.split(",");
                datos.setNombre(ArregloDatos[0]);
                datos.setEdad(Integer.parseInt(ArregloDatos[1]));
                datos.setCorreo(ArregloDatos[2]);
                informacion.add(datos);
                cadenaArreglo = ArregloDatos;
                informacionDatos = contenido;
            }

        } catch (IOException e) {
            e.printStackTrace();
            estado=false;
        }
        return estado;
    }

    public Boolean EscribirContenido(CDatos datos){
        Boolean estado=true;
        existearchivo();
        informacion.add(datos);
        File ruta = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "pruebaagenda");
        try{
            File f = new File(ruta, "Agenda_sd.txt");
            OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(f));
            for (Object contenido: informacion){
                CDatos elementos = (CDatos) contenido;
                fout.write(elementos.toString());
            }
            fout.close();
        }catch (IOException ex){
            ex.printStackTrace();
            estado = false;
        }
        return estado;
    }

    public String[] RegresaArreglo(){
        return cadenaArreglo;
    }

}

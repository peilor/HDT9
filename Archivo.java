/**
 * @author Pablo Argueta, Carnet: 13028
 * @author Héctor Möller, Carnet: 09002
 * 
 * Descripcion: Clase que lee un archivo y escribe en el mismo. 
 * Código tomado del libro de texto Java Structures
 */
import java.io.*;

public class Archivo{
    
    File archivo;
    FileReader fr;
    BufferedReader br;
    FileWriter fw;
    PrintWriter pw;
    Matriz grafo = new Matriz();

    
    /**
     * obtenerArchivo: Método que obtiene el archivo
     */
    public void obtenerArchivo() throws FileNotFoundException{
       String direccion = new File("datos.txt").getAbsolutePath(); 
       archivo=new File(direccion); 
    }  
    
    /**
     * arregloNombres: Método que obtiene los nombres de los nodos para el grafo
     */
    public Matriz arregloNombres() throws IOException{
        // Lectura del fichero
        fr = new FileReader (archivo);
        br = new BufferedReader(fr);
        String linea;
        while((linea=br.readLine())!=null){
            String[] tmp;
            tmp=linea.split(" ");
            grafo.agregarNodo(tmp[0]);
            grafo.agregarNodo(tmp[1]);
        }
        return grafo;
    }
    
    /**
     * write: Método que escribe en el archivo
     */
    public void write(String cadena) throws IOException{
        fw = new FileWriter(archivo);
        pw = new PrintWriter(fw);
        pw.println(cadena);
    }
    
    /**
     * matrizCostos: Método que obtiene los pesos de los arcos entre nodos del grafo
     */
    public Matriz matrizCostos() throws IOException{
        // Lectura del fichero
        fr = new FileReader (archivo);
        br = new BufferedReader(fr);
        String linea;

        while((linea=br.readLine())!=null){
            String[] tmp;
            tmp=linea.split(" ");
            grafo.agregarConexion(tmp[0], tmp[1], tmp[2]);
        }
        return grafo;
    }
    

}

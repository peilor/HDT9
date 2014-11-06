/**
 * @author Pablo Argueta, Carnet: 13028
 * @author Héctor Möller, Carnet: 09002
 * 
 * Descripcion: Clase que genera una matrizAdyacencia de adyacencia para un grafo y crea nuevos nodos y conexiones.
 * Utiliza despliega una interfaz gráfica. 
 */
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.*;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        Grafo matriz = new Grafo();
        matriz.caminoCorto();
        int op2;
        int tipoMensaje = JOptionPane.QUESTION_MESSAGE;
        String[] tipoImplementacion = {"Ver ruta mas corta entre dos ciudades", "Mostrar ciudad en el centro del grafo","Modificar datos del grafo","Finalizar programa","Ver Matriz de Adyacencia"};
        int op1=JOptionPane.showOptionDialog(null
                    , "Indique la opcion que desee"
                    , "Implementacion"
                    , 0
                    , tipoMensaje
                    , null
                    , tipoImplementacion
                    , "Finalizar programa");
        op1+=1;
        // Realizar ciclo mientras la respuesta del usuario no sea 4
        while(op1!=4){
            // Si la respuesta es 1, preguntar por las ciudades y desplegar resultados
            if(op1==1){
                matriz.caminoCorto(); // Camino mas corto entre todas las ciudades
                String ciudad1=JOptionPane.showInputDialog("Ingrese el nombre de la ciudad de salida");
                String ciudad2=JOptionPane.showInputDialog("Ingrese el nombre de la ciudad de destino");
                // Si las ciudades se encuentran en la matrizAdyacencia, entonces desplegar la distancia minima y la ruta completa
                if(matriz.matrizAdyacencia.verificar(ciudad1)&&matriz.matrizAdyacencia.verificar(ciudad2)){
                    JOptionPane.showMessageDialog(null, "La distancia minima es: "+matriz.matrizAdyacencia.obtenerConexion(ciudad1, ciudad2)+".");
                    if(matriz.matrizAdyacencia.obtenerConexion(ciudad1, ciudad2)!=10000){
                        matriz.mostrarIntermedias(matriz.matrizAdyacencia.obtenerPosicion(ciudad1), matriz.matrizAdyacencia.obtenerPosicion(ciudad2));
                        JOptionPane.showMessageDialog(null, "La ruta es: "+ciudad1+", "+ciudad2);
                    }
                }
            }
            
            // Si la respuesta es 2, desplegar el centro de grafo
            else if(op1==2){
                JOptionPane.showMessageDialog(null, matriz.centroGrafo());
            }
            
            // Si la respuesta es 3, preguntar cual es el cambio archivo realizar y ejecutarlo
            else if(op1==3){
                op2=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su opcion:\n1. Hay interrupcion de trafico entre un par de ciudades\n2. Establecer nueva conexion"));
                // Si la respuesta es 1, preguntar por el nombre de las ciudades y colocar un numero muy grande
                // en la matrizAdyacencia de adyacencia para indicar que no hay conexion
                if(op2==1){
                    String ciudad1=JOptionPane.showInputDialog("Ingrese el nombre de la ciudad de salida");
                String ciudad2=JOptionPane.showInputDialog("Ingrese el nombre de la ciudad de destino");
                    if(matriz.matrizAdyacencia.verificar(ciudad1)&&matriz.matrizAdyacencia.verificar(ciudad2)){
                        matriz.matrizAdyacencia.agregarConexion(ciudad1, ciudad2, 10000);
                        // Guarda los cambios en el archivo
                        try {
                            matriz.archivo.write(ciudad1+" "+ciudad2+" 10000");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                // Si la respuesta es 2, preguntar por el nombre de las ciudades y agregar nueva distancia.
                else if(op2==2){
                    String ciudad1=JOptionPane.showInputDialog("Ingrese el nombre de la ciudad de salida");
                    String ciudad2=JOptionPane.showInputDialog("Ingrese el nombre de la ciudad de destino");
                    int distancia=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la distancia entre las ciudades"));
                
                    // Si las ciudades ya existen, cambiar el valor
                    if(matriz.matrizAdyacencia.verificar(ciudad1)&&matriz.matrizAdyacencia.verificar(ciudad2)){
                        matriz.matrizAdyacencia.agregarConexion(ciudad1, ciudad2, distancia);
                    }
                    // Si las ciudades no existen, agregarlas archivo la matrizAdyacencia
                    else{
                        matriz.matrizAdyacencia.agregarNodo(ciudad1);
                        matriz.matrizAdyacencia.agregarNodo(ciudad2);
                        matriz.matrizAdyacencia.agregarConexion(ciudad1, ciudad2, distancia);
                    }
                    // Guarda los cambios en el archivo
                    try {
                        matriz.archivo.write(ciudad1+" "+ciudad2+" "+distancia);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                // Recalcular las rutas mas cortas
                matriz.caminoCorto();
            }
            
            else if(op1==5){
                // Desplegar la matrizAdyacencia
                JOptionPane.showMessageDialog(null, "Matriz de adyacencia");
                JOptionPane.showMessageDialog(null, matriz.matrizAdyacencia.mostrarMatrizAdy());
                }
       
            op1=JOptionPane.showOptionDialog(null
                    , "Indique la opcion que desee"
                    , "Implementacion"
                    , 0
                    , tipoMensaje
                    , null
                    , tipoImplementacion
                    , "Finalizar programa");
            op1+=1;
        }
        
    }
}

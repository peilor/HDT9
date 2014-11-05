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
        String[] tipoImplementacion = {"Buscar ruta mas corta entre dos ciudades ", "Nombre de la ciudad en el centro del grafo","Modificar grafo","Finalizar programa"};
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
            // Desplegar la matrizAdyacencia
            JOptionPane.showMessageDialog(null, "Matriz de adyacencia");
            matriz.matrizAdyacencia.show();
            
            // Si la respuesta es 1, preguntar por las ciudades y desplegar resultados
            if(op1==1){
                matriz.caminoCorto(); // Camino mas corto entre todas las ciudades
                String ciudad1=JOptionPane.showInputDialog("Ingrese el nombre de la ciudad de salida");
                String ciudad2=JOptionPane.showInputDialog("Ingrese el nombre de la ciudad de destino");
                // Si las ciudades se encuentran en la matrizAdyacencia, entonces desplegar la distancia minima y la ruta completa
                if(matriz.matrizAdyacencia.contains(ciudad1)&&matriz.matrizAdyacencia.contains(ciudad2)){
                    JOptionPane.showMessageDialog(null, "La distancia minima es: "+matriz.matrizAdyacencia.getEdge(ciudad1, ciudad2)+".");
                    if(matriz.matrizAdyacencia.getEdge(ciudad1, ciudad2)!=10000){
                        System.out.print("La ruta es: "+ciudad1);
                        matriz.mostrarIntermedias(matriz.matrizAdyacencia.getIndex(ciudad1), matriz.matrizAdyacencia.getIndex(ciudad2));
                        System.out.println(", "+ciudad2);
                        JOptionPane.showMessageDialog(null, "La ruta es: "+ciudad1+", "+ciudad2);
                    }
                }
            }
            
            // Si la respuesta es 2, desplegar el centro de grafo
            else if(op1==2){
                matriz.centroGrafo();
            }
            
            // Si la respuesta es 3, preguntar cual es el cambio archivo realizar y ejecutarlo
            else if(op1==3){
                op2=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su opcion:\n1. Hay interrupcion de trafico entre un par de ciudades\n2. Establecer nueva conexion"));
                // Si la respuesta es 1, preguntar por el nombre de las ciudades y colocar un numero muy grande
                // en la matrizAdyacencia de adyacencia para indicar que no hay conexion
                if(op2==1){
                    String ciudad1=JOptionPane.showInputDialog("Ingrese el nombre de la ciudad de salida");
                String ciudad2=JOptionPane.showInputDialog("Ingrese el nombre de la ciudad de destino");
                    if(matriz.matrizAdyacencia.contains(ciudad1)&&matriz.matrizAdyacencia.contains(ciudad2)){
                        matriz.matrizAdyacencia.addEdge(ciudad1, ciudad2, 10000);
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
                    if(matriz.matrizAdyacencia.contains(ciudad1)&&matriz.matrizAdyacencia.contains(ciudad2)){
                        matriz.matrizAdyacencia.addEdge(ciudad1, ciudad2, distancia);
                    }
                    // Si las ciudades no existen, agregarlas archivo la matrizAdyacencia
                    else{
                        matriz.matrizAdyacencia.add(ciudad1);
                        matriz.matrizAdyacencia.add(ciudad2);
                        matriz.matrizAdyacencia.addEdge(ciudad1, ciudad2, distancia);
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
       
            op1=JOptionPane.showOptionDialog(null
                    , "Indique la opcion que desee"
                    , "Implementacion"
                    , 0
                    , tipoMensaje
                    , null
                    , tipoImplementacion
                    , "4. Finalizar programa");
            op1+=1;
        }
        
    }
}

/**
 * @author Pablo Argueta, Carnet: 13028
 * @author Héctor Möller, Carnet: 09002
 * 
 * Descripcion: Clase que implementa el algoritmo de Floyd para las conexiones entre nodos 
 * Código tomado del contenido de clase
 */
import java.io.File;
import java.io.IOException;

public class Floyd {
    
    Archivo archivo= new Archivo();
    MatrizGrafo matrizAdyacencia;
    int[][] matrizNodosIntermedios;
    int[] maximo;
    int centro;
    int minimo=10000;
    String centroReturn="";
    
    /**
     * Nombre: Floyd
     * Descripcion: constructor de la clase
     * Pre: no hay
     * Post: nuevo grafo 
     * No hay parametros ni valor de retorno
     */
    public Floyd(){
        
        try {
            
            //Obteniendo la dirección del archivo que contiene los datos. 
                        
            archivo.obtenerArchivo();
            archivo.arregloNombres(); // Nombre de los nodos
            matrizAdyacencia = archivo.matrizCostos(); // Peso de los arcos entre nodos
            matrizNodosIntermedios = new int[25][25]; // MatrizGrafo de nodos intermedios
            maximo = new int[25];
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for(int n=0;n<archivo.grafo.tamanoGrafo();n++){
            for(int m=0;m<archivo.grafo.tamanoGrafo();m++){
                matrizNodosIntermedios[n][m]=10000;
            }
        }
    }
    
    /**
     * Nombre: caminoCorto
     * Descripcion: algoritmo de Floyd para encontrar el camino mas corto entre todos los nodos
     * Basado en la presentacion de clase
     * Pre: existe una matrizAdyacencia de adyacencia con los valores iniciales del grafo
     * Post: matrizAdyacencia de adyacencia con los valores mas pequeños entre cada nodo
     * No hay parametros ni valor de retorno
     */
    public void caminoCorto(){
        for(int k=0;k<matrizAdyacencia.tamanoGrafo();k++){
            for(int i=0;i<matrizAdyacencia.tamanoGrafo();i++){
                for(int j=0;j<matrizAdyacencia.tamanoGrafo();j++){
                    if(matrizAdyacencia.obtenerConexion(matrizAdyacencia.obtenerNodo(i),matrizAdyacencia.obtenerNodo(j))>(matrizAdyacencia.obtenerConexion(matrizAdyacencia.obtenerNodo(i), matrizAdyacencia.obtenerNodo(k))+matrizAdyacencia.obtenerConexion(matrizAdyacencia.obtenerNodo(k), matrizAdyacencia.obtenerNodo(j)))){
                        matrizAdyacencia.agregarConexion(matrizAdyacencia.obtenerNodo(i), matrizAdyacencia.obtenerNodo(j), (matrizAdyacencia.obtenerConexion(matrizAdyacencia.obtenerNodo(i), matrizAdyacencia.obtenerNodo(k))+matrizAdyacencia.obtenerConexion(matrizAdyacencia.obtenerNodo(k), matrizAdyacencia.obtenerNodo(j))));
                        matrizNodosIntermedios[i][j]=k;
                    }
                }
            }
        }
        
    }
    
    /**
     * Nombre: centroGrafo
     * Descripcion: encontrar el centro del grafo
     * Pre: matrizAdyacencia de adyacencia con los menores valores entre cada nodo
     * Post: centro del grafo
     * No hay parametros ni valor de retorno
     */
    public String centroGrafo(){
        caminoCorto();
        int n=0;       
        // Encontrar los maximos de cada columna de la matrizAdyacencia
        for(int i=0;i<matrizAdyacencia.tamanoGrafo();i++){
            for(int j=0;j<matrizAdyacencia.tamanoGrafo()-1;j++){
                int num1=matrizAdyacencia.obtenerConexion(matrizAdyacencia.obtenerNodo(j), matrizAdyacencia.obtenerNodo(i));
                n=j;
                n++;
                int num2=matrizAdyacencia.obtenerConexion(matrizAdyacencia.obtenerNodo(n), matrizAdyacencia.obtenerNodo(i));
                if(num1>num2){
                    maximo[i]=num1;
                }
                else{
                    maximo[i]=num2;
                }
            }
            n++;
        }
        // Encontrar el minimo de los maximos de cada columna
        for(int i=0;i<matrizAdyacencia.tamanoGrafo();i++){
            int num1=maximo[i];
            if(num1<minimo){
                centro=i;
                minimo=num1;
            }
        }
        centroReturn="El centro del grafo es: "+matrizAdyacencia.obtenerNodo(centro);
        return centroReturn;
        
    }
    
    /**
     * Nombres: mostrarIntermedias
     * Descripcion: desplegar los nodos intermedios
     * Basado en el material de clase
     * Pre: no hay
     * Post: nodos intermedios desplegados
     * No hay valor de retorno
     * @param num1
     * @param num2
     */
    public void mostrarIntermedias(int num1, int num2){
        if(matrizNodosIntermedios[num1][num2]!=10000){
            mostrarIntermedias(num1,matrizNodosIntermedios[num1][num2]);
            System.out.print(", "+matrizAdyacencia.obtenerNodo(matrizNodosIntermedios[num1][num2]));
            mostrarIntermedias(matrizNodosIntermedios[num1][num2],num2);
            return;
        }
        else return;
           
    }
}

    
import java.util.Vector;

/**
 * @author Pablo Argueta, Carnet: 13028
 * @author Héctor Möller, Carnet: 09002
 * 
 * MatrizGrafo.java
 * Descripcion: Contiene operaciones para crear la matriz de adyacencia.   
 * 
 */
public class MatrizGrafo<V,E> implements GrafoInterface<V,E>{

    private Vector vertices = new Vector();
    private int[][] arcos= new int [25][25];
    private String matrizRetorno="";
    private String matrizTemporal="";
    
    /**
     * Nombre: MatrizGrafo
     * Descripcion: constructor de la clase
     * Pre: no hay
     * Post: el arreglo de arcos inicializado
     * No hay parametros ni valor de retorno
     */
    public MatrizGrafo(){
        
        for(int i=0;i<25;i++){
            for(int j=0;j<25;j++){
                if(i==j){
                    arcos[i][j]=0;
                }
                else{
                    arcos[i][j]=10000;
                }
            }
        }
    }
    @Override
    public void agregarNodo(V contenido) {
        
        if(!vertices.contains(contenido)){
            vertices.add(contenido);
        }
        
        
    }

    @Override
    public void agregarConexion(V v1, V v2, E contenido) {
        int i = vertices.indexOf(v1);
        int j = vertices.indexOf(v2);        
        String tmp = ""+contenido;
        int peso = Integer.parseInt(tmp);
        arcos[i][j]=peso;
    }

    @Override
    public String mostrarMatrizAdy(){
        
        for(int a=0;a<vertices.size();a++){
            for(int b=0;b<vertices.size();b++){
                matrizTemporal+=""+arcos[a][b]+" ";
            }
            matrizTemporal+="\n";
        }
        matrizRetorno=matrizTemporal;
        matrizTemporal="";
        return matrizRetorno;
    }

    @Override
    public int tamanoGrafo(){
        return vertices.size();
    }

    @Override
    public int obtenerConexion(V contenido1, V contenido2){
        return arcos[vertices.indexOf(contenido1)][vertices.indexOf(contenido2)];
    }

    @Override
    public V obtenerNodo(int contenido){
        
        return (V)vertices.get(contenido);
        
    }

    @Override
    public int obtenerPosicion(V contenido){
        return vertices.indexOf(contenido);
    }
 
 
    @Override
    public boolean verificar(V contenido){
        return vertices.contains(contenido);
    }
}

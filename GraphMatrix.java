import java.util.Vector;
/**
 *Jonathan Aguirre 14349
 * Jose Corona 14417
 */
public class GraphMatrix<V,E> implements InterfazGrafo<V,E>{
    private Vector v = new Vector();
    private int[][] ag = new int [25][25];
    /**
     * Constructor
     */
    public GraphMatrix(){
    for(int i=0;i<25;i++){
       for(int j=0;j<25;j++){
        if(i==j){
        ag[i][j]=0;
        }
        else{
        ag[i][j]=10000;
        }
      }
    }
  }
    /**
     * Método para agregar labels a la matríz
     */
    public void agregar(V label) {
        if(!v.contains(label)){
            v.add(label);
        } 
    }
    /**
     *Método para agregar ezquinas a la matríz
     */
    public void agregare(V vtx1, V vtx2, E label) {
        int i = v.indexOf(vtx1);
        int j = v.indexOf(vtx2);        
        String tmp = ""+label;
        int peso = Integer.parseInt(tmp);
        ag[i][j]=peso;
    }
    /**
     * Método para mostrar resultados
     */
    @Override
    public void mostrar(){
        for(int a=0;a<v.size();a++){
         for(int b=0;b<v.size();b++){
         System.out.print(""+ag[a][b]+" ");
            }
        System.out.println("");
      }
    }
    
    /**
     * retorna el tamaño de la matríz
     */
    public int largo(){
        return v.size();
    }
    
    /**
     *Retorna el borde de la matríz
     */
    public int gete(V label1, V label2){
        return ag[v.indexOf(label1)][v.indexOf(label2)];
    }
    /**
     *Getter de la matríz
     */
    @Override
    public V get(int label){
        return (V)v.get(label); 
    }
    
    /**
     * Getter del indice de un elemento de la matríz
     */
    public int geti(V label){
        return v.indexOf(label);
    }
    /**
     *Método que revisa si un elemento esta o no en la matríz
     */
    public boolean contenido(V label){
        return v.contains(label);
    }
}

/**
 *
 */
public interface InterfazGrafo<V,E> {

    /**
     * Método para agregar labels a la matríz
     */
    public void agregar(V label);

    /**
     * Método para agregar ezquinas a la matríz
     */
    public void agregare(V vtx1, V vtx2, E label);
    
    /**
     *Método para mostrar resultados
     */
    public void mostrar();
    
    /**
     *Getter del indice de un elemento de la matríz
     */
    public int geti(V label);
    
    /**
     * Getter de la matríz
     */
    public V get(int label);
    
    /**
     * Retorna el borde de la matríz
     */
    public int gete(V label1, V label2);
    
    /**
     * Método que revisa si un elemento esta o no en la matríz
     */
    public boolean contenido(V label);
    
    /**
     * retorna el tamaño de la matríz
     */
    public int largo();  
}

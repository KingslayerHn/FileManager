
package filemanager;

import java.util.ArrayList;


public class Nodo {
    public ArrayList<Nodo> keys; 
    public String Data =""; 
    public int inicioRegistro =0;
    public Nodo padre = null; 
    public Nodo der =null; 
    public Nodo izq =null; 
        
    public Nodo(){
        keys= new ArrayList();
        }
    public Nodo(String Llave, int Post){
        keys= new ArrayList();
        Data = Llave;
        inicioRegistro = Post;               
    }
    
    
}

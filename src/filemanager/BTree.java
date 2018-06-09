package filemanager;

import java.util.ArrayList;


public class BTree {
    
    private int mLlaves =0; //minimo de llaves
    private int MLlaves =0; //maximo de llaves
    private Nodo root= null;  
    private int order =0; 
    
    private class Nodo {
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
    //divede un nodo y releva al mas optimo
    public void split(Nodo nuevo, Nodo pointer){
        pointer.keys.add(nuevo);
        Nodo promover =new Nodo();
        promover.keys.add(pointer.keys.get(pointer.keys.size()/2));
        Nodo temp1 = new Nodo();
        Nodo temp2 = new Nodo();
        
        for(int i=0; i< pointer.keys.size()/2;i++){
            temp1.keys.add(pointer.keys.get(i));
        }
        for(int i= (pointer.keys.size()/2)+1; i<pointer.keys.size();i++){
            temp2.keys.add(pointer.keys.get(i));
        }
        promover.der= temp2;
        promover.izq=temp1;
        
        //validar si se puede agregar si hay espacio disponible
        if(promover.padre.keys.size()< MLlaves){
            promover.padre.keys.add(promover.keys.get(0));
            promover.padre.der = promover.izq;
        }
        else{
            split(promover,promover.padre);            
        }
    }
    //inserta un Nodo
    public void insert(Nodo nuevo, Nodo pointer, Nodo pointerPadre){
        
        if(root == null){
            Nodo pagina =  new Nodo();
            pagina.keys.add(nuevo);
            root = pagina;
        }else{
            for (int i = 0; i < pointer.keys.size(); i++) {
                if (nuevo.inicioRegistro>pointer.keys.get(i).inicioRegistro){
                    if(i== (pointer.keys.size()-1)){
                        if (pointer.keys.get(i).der == null){
                            if (pointer.keys.size() < MLlaves){
                                pointer.keys.add(nuevo);
                                ordenar();  
                            }
                            else{
                                pointer.keys.add(nuevo);
                                ordenar();  
                                split(nuevo, pointer);
                            }
                                                        
                        }else{
                            insert(nuevo,pointer.der,pointerPadre);
                        }  
                    }
                    
                }else{
                    if (pointer.keys.get(i).izq == null){
                        if(pointer.keys.size()<MLlaves){
                            pointer.keys.add(nuevo);
                            ordenar();                                                         
                        }else{
                            if (pointer == root){
                                split(nuevo,pointer);                                
                            }else{
                                
                            }
                        }                        
                    }
                    
                }
            }
        }                
    }
    
    public void ordenar(){
        
    }
}

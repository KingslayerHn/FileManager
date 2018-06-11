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
    public void split(Nodo nuevo, Nodo pointer,int indexPropio,int indexPadre){
        
        Nodo temp = pointer;//crea un nodo nuevo el cual sera igual al pointer 
        if (temp.keys.get(indexPropio).inicioRegistro<nuevo.keys.get(0).inicioRegistro) {
             temp.keys.add(nuevo.keys.get(0));           
        }else{
            temp.keys.add(indexPropio,nuevo.keys.get(0));
        }        
        Nodo promover =new Nodo();
        promover.padre = temp.padre;
        promover.keys.add(temp.keys.get(temp.keys.size()/2));
        Nodo temp1 = pointer;
        Nodo temp2 = pointer;
        temp1.keys.clear();
        temp2.keys.clear();
        
        for(int i=0; i< temp.keys.size()/2;i++){
            temp1.keys.add(temp.keys.get(i));
        }
        for(int i= (temp.keys.size()/2)+1; i<temp.keys.size();i++){
            temp2.keys.add(temp.keys.get(i));
        }
        
        //validar si se puede agregar si hay espacio disponible
        if (promover.padre==null) {
            root = promover;
            promover.keys.get(0).izq = temp1; 
            promover.keys.get(0).der = temp2;
            temp1.padre = promover;
            temp2.padre= promover;
            
        }//fin de si el padre de promover es nulo
        else if(promover.padre.keys.size()<MLlaves){
            //si el nodo ha agregar se agrega a la izquierda
            if (indexPadre == 0 && pointer.padre.keys.size() != indexPadre+1){
                pointer.keys.clear();
                promover.padre.keys.get(0).izq = temp1;
                temp1.padre=promover;
                promover.keys.get(0).der = pointer;
                pointer.keys = temp2.keys;
                promover.padre.keys.add(indexPadre,promover.keys.get(0));
                temp.padre = null; 
            } else if (indexPadre == pointer.padre.keys.size()-1) { //si el nodo agregar se agrega a la derecha
                pointer.keys.clear();
                promover.padre.keys.get(0).der = temp2;
                temp2.padre = promover; 
                promover.keys.get(0).izq = pointer;
                promover.padre.keys.add(promover.keys.get(0));
                pointer.keys = temp1.keys;
                temp.padre = null;                
            }else{//si el nodo agregar esta enmedio de dos nodos
                pointer.keys.clear();
                promover.keys.get(0).izq = temp1;
                promover.keys.get(0).der = temp2;
                temp.keys.clear();;
                promover.padre.keys.get(indexPadre+1).izq = temp; 
                temp.keys = temp2.keys;
                pointer.keys = temp1.keys;
                promover.padre.keys.add(indexPadre+1,promover.keys.get(0));
            }                 
        }else{//si el elemento no entra en el padre
            split(promover,promover.padre,indexPropio,indexPadre);
        }
    }
    //inserta un Nodo
    public void insert(Nodo nuevo, Nodo pointer, int indexPadre){
        
        if(root == null){//pregunta si el arbol esta vacio
            Nodo pagina =  new Nodo();
            pagina.keys.add(nuevo.keys.get(0));
            root = pagina;
        }else{// si el arbol no esta vacio
            for (int i = 0; i < pointer.keys.size(); i++) {
                if (nuevo.keys.get(0).inicioRegistro>pointer.keys.get(i).inicioRegistro){
                    if(i== (pointer.keys.size()-1)){
                        if (pointer.keys.get(i).der == null){
                            if (pointer.keys.size() < MLlaves){
                                pointer.keys.add(nuevo.keys.get(0));
                                break;
                            }
                            else{
                                split(nuevo, pointer,i,indexPadre);
                            }                               
                        }else{
                            insert(nuevo,pointer.der,i);
                            break;
                        }  
                    }    
                }else{
                    if (pointer.keys.get(i).izq == null){
                        if(pointer.keys.size()<MLlaves){
                            pointer.keys.add(i,nuevo.keys.get(0));                            
                        }else{
                            split(nuevo,pointer,i,indexPadre);
                        }                        
                    }else{
                        insert(nuevo,pointer.izq,i);
                        break;
                    }      
                }
            }//fin de for
        }                
    }
    
    public void ordenar(Nodo pointer){
        
    }
}

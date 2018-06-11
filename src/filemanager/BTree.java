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
    public void split(Nodo nuevo, Nodo pointer,int index){
        
        Nodo temp = pointer;//crea un nodo nuevo el cual sera igual al pointer 
        if (temp.keys.get(index).inicioRegistro<nuevo.keys.get(0).inicioRegistro) {
             temp.keys.add(nuevo.keys.get(0));           
        }else{
            temp.keys.add(index,nuevo.keys.get(0));
        }        
        Nodo promover =new Nodo();
        promover.padre = temp.padre;
        promover.keys.add(temp.keys.get(temp.keys.size()/2));
        Nodo temp1 = new Nodo();
        Nodo temp2 = new Nodo();
        
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
            //este if ordena el padre respecto al que se promueve
            if (promover.padre.keys.get(index-1).inicioRegistro < 
                    promover.keys.get(0).inicioRegistro) {
                pointer.keys.clear();
                promover.padre.keys.add(promover.keys.get(0));
            }
            
                                    
        }
        /*if (promover.padre==null){
            promover.keys.get(0).der = temp2;
            temp2.padre = promover;
            promover.keys.get(0).izq = temp1;
            temp1.padre = promover;
            root = promover;
            pointer.keys.clear();
            pointer.padre = null;
        }else if(promover.padre.keys.size()<MLlaves){
            if (promover.padre.keys.get(index-1).inicioRegistro < 
                    promover.keys.get(0).inicioRegistro) {
                promover.padre.keys.add(promover.keys.get(0));
                promover.padre.keys.get(index).der =temp2;
                promover.padre.keys.get(index).izq =temp1;
                promover.padre.keys.get(index-1).der = temp1;
                temp1.padre=promover.padre;
                temp2.padre=promover.padre;
                pointer.padre=null;
            }else{
                promover.padre.keys.add(index-1,promover.keys.get(0));
                promover.padre.keys.get(index-1).izq = temp1; 
                promover.padre.keys.get(index-1).der =temp2;
                promover.padre.keys.get(index).izq = temp2;
                temp1.padre = promover.padre;
                temp2.padre = promover.padre;
            }
            temp1.padre = promover.padre;
            temp2.padre = promover.padre;
            promover.keys.clear();
            pointer.keys.clear();
        }else{//split recursivo
            promover.keys.get(0).der = temp2;
            promover.keys.get(0).izq= temp1;
            split(promover,promover.padre,index);
        }
        */
    }
    //inserta un Nodo
    public void insert(Nodo nuevo, Nodo pointer){
        
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
                                split(nuevo, pointer,i);
                            }                               
                        }else{
                            insert(nuevo,pointer.der);
                            break;
                        }  
                    }    
                }else{
                    if (pointer.keys.get(i).izq == null){
                        if(pointer.keys.size()<MLlaves){
                            pointer.keys.add(i,nuevo.keys.get(0));                            
                        }else{
                            split(nuevo,pointer,i);
                        }                        
                    }else{
                        insert(nuevo,pointer.izq);
                        break;
                    }      
                }
            }//fin de for
        }                
    }
    
    public void ordenar(Nodo pointer){
        
    }
}

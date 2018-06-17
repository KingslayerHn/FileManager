package filemanager;

public class BTree {
    
    private int mLlaves =0; //minimo de llaves
    private int MLlaves =0; //maximo de llaves
    private Nodo root= null;  
    private int order =0; 
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
        Nodo temp1 = new Nodo();
        Nodo temp2 = new Nodo();
        temp1.padre = promover.padre; 
        temp2.padre = promover.padre;
        
        for(int i=0; i< temp.keys.size()/2;i++){
            temp1.keys.add(temp.keys.get(i));
        }
        for(int i= (temp.keys.size()/2)+1; i<temp.keys.size();i++){
            temp2.keys.add(temp.keys.get(i));
        }
        
        //validar si el nodo nuevo no tiene hijos
        if (nuevo.keys.get(0).izq != null && nuevo.keys.get(0).der!= null) {
            if (promover.keys.get(0).inicioRegistro == nuevo.keys.get(0).inicioRegistro) {
                temp1.keys.get(temp1.keys.size()-1).der= nuevo.keys.get(0).izq;
                temp2.keys.get(0).izq=nuevo.keys.get(0).der;                
            }
            //agregar padres a nodos del hijo izquierdo
            if (temp1.keys.size() == 1) {
                temp1.keys.get(0).der.padre = temp1; 
                temp1.keys.get(0).izq.padre = temp1;   
            }else{
                for (int i = 0; i < temp1.keys.size(); i++) {
                    if (i==0) {
                        temp1.keys.get(i).izq.padre = temp1; 
                        temp1.keys.get(i).der = temp1.keys.get(i+1).izq;
                        temp1.keys.get(i).der.padre = temp1; 
                    }else if (i == temp1.keys.size()-1) {
                        temp1.keys.get(i).der.padre = temp1; 
                        temp1.keys.get(i).izq.padre = temp1; 
                    }else{
                        temp1.keys.get(i).der = temp1.keys.get(i+1).izq;
                        temp1.keys.get(i).der.padre = temp1; 
                        temp1.keys.get(i).izq.padre = temp1;
                    }   
                }
            }
            
            //agregar nodos hijo derecho
            if (temp2.keys.size() == 1) {
                temp2.keys.get(0).der.padre = temp2; 
                temp2.keys.get(0).izq.padre = temp2;   
            }else{
                for (int i = 0; i < temp2.keys.size(); i++) {
                    if (i==0) {
                        temp2.keys.get(i).izq.padre = temp2; 
                        temp2.keys.get(i).der = temp2.keys.get(i+1).izq;
                        temp2.keys.get(i).der.padre = temp2; 
                    }else if (i == temp2.keys.size()-1) {
                        temp2.keys.get(i).der.padre = temp2; 
                        temp2.keys.get(i).izq.padre = temp2; 
                    }else{
                        temp2.keys.get(i).der = temp2.keys.get(i+1).izq;
                        temp2.keys.get(i).der.padre = temp2; 
                        temp2.keys.get(i).izq.padre = temp2;
                    }   
                }
            } 
            
            // validar si es raiz el nodo a promover
            if (promover.padre==null) {
                root = promover;
            }else if (promover.padre.keys.size()<MLlaves) {
                
                if (indexPadre == 0 && promover.padre.keys.size() != indexPadre+1){
                    promover.padre.keys.add(0,promover.keys.get(0));
                    promover.padre.keys.get(1).izq = temp2; 
                    temp1.padre = promover.padre;
                    temp2.padre = promover.padre;
                    
                }else if (indexPadre == promover.padre.keys.size()-1) {
                    //el nodo agregar se agrega a la deracha
                    promover.padre.keys.add(promover.keys.get(0));
                    promover.padre.keys.get(promover.padre.keys.size()-2).der = temp1;
                    temp1.padre = promover.padre;
                    temp2.padre = promover.padre;                    
                    
                }else{
                    promover.padre.keys.add(indexPadre, promover.keys.get(0));
                    promover.padre.keys.get(indexPadre-1).der = temp1;
                    promover.padre.keys.get(indexPadre+1).izq = temp2; 
                    temp1.padre = promover.padre;
                    temp2.padre = promover.padre; 
                }
                                
            }else{
                split(promover,promover.padre,indexPropio,indexPadre);
            }    
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
    
    public boolean search(Nodo N,Nodo pointer){
        if (root == null) {
            return false;               
        }else{
            for (int i = 0; i < pointer.keys.size(); i++) {
                if (pointer.keys.get(i).Data.equals(N.keys.get(0).Data)) {
                    return true;                     
                }else{
                    if (N.keys.get(0).inicioRegistro<pointer.keys.get(i).inicioRegistro) {
                        if (pointer.keys.get(i).izq != null) {
                            return search(N,pointer.keys.get(i).izq);
                            
                        }else{
                            return false; 
                        }    
                    }  
                }
                if (i== pointer.keys.size()-1) {
                    if (pointer.keys.get(i).der != null) {
                        return search(N,pointer.keys.get(i).der);  
                    }  
                }
                
            }
            return false; 
        } 
    }
    public void print(Nodo pointer){
        for (int i = 0; i < pointer.keys.size(); i++) {
            if (pointer.keys.get(i).izq != null) {
                print(pointer.keys.get(i).izq);
                System.out.println(pointer.keys.get(i).inicioRegistro);
            }
            if ((pointer.keys.size()-1) == i) {
                if (pointer.keys.get(i).der !=null) {
                    print(pointer.keys.get(i).der);
                    
                }  
            }   
        }    
    }
}

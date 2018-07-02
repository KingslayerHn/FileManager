package filemanager;

public class BTree {
    
    private int mLlaves =0; //minimo de llaves
    private int MLlaves =0; //maximo de llaves
    private Nodo root= null;  
    private int order =0; 
    //divede un nodo y releva al mas optimo

    public BTree(int ordenArbol) {
        order = ordenArbol;
        MLlaves = order-1;
        mLlaves = (order-1)/2;
    }

    public Nodo getRoot() {
        return root;
    }

    public void setRoot(Nodo root) {
        this.root = root;
    }
    
    
    public void split(Nodo nuevo, Nodo pointer){
        
        Nodo temp = pointer;//crea un nodo nuevo el cual sera igual al pointer
        temp.keys.add(new Nodo(nuevo.keys.get(0).Data,nuevo.keys.get(0).inicioRegistro));
        temp.keys.get(temp.keys.size()-1).izq = nuevo.keys.get(0).izq;
        temp.keys.get(temp.keys.size()-1).der = nuevo.keys.get(0).der;
        
        Nodo promover =new Nodo();
        promover.keys.add(new Nodo(temp.keys.get(temp.keys.size()/2).Data,
        temp.keys.get(temp.keys.size()/2).inicioRegistro));
        Nodo temp1 = new Nodo();
        Nodo temp2 = new Nodo();
        temp1.padre = promover;
        temp2.padre = promover;
        promover.padre= temp.padre;
        promover.keys.get(0).izq = temp1; 
        promover.keys.get(0).der = temp2;
        

        //asignar valores a cada uno de los temp 
        for(int i=0; i< temp.keys.size()/2;i++){
            temp1.keys.add(temp.keys.get(i));
        }
        for(int i= (temp.keys.size()/2)+1; i<temp.keys.size();i++){
            temp2.keys.add(temp.keys.get(i));
        }
        
        //validar si el nodo nuevo no tiene hijos -------- split recursivo -----------
        if (nuevo.keys.get(0).izq != null && nuevo.keys.get(0).der!= null) {
            //promover.keys.get(0).der = nuevo;
            promover.keys.get(0).der.padre = promover;
            for (int i = 0; i < temp1.keys.size(); i++) {
                temp1.keys.get(i).izq.padre = temp1;
                temp1.keys.get(i).der.padre = temp1;   
            }
            for (int i = 0; i < promover.keys.get(0).der.keys.size(); i++) {
                promover.keys.get(0).der.keys.get(i).izq.padre = promover.keys.get(0).der;
                promover.keys.get(0).der.keys.get(i).der.padre = promover.keys.get(0).der;
            }
           
  
        }// final de recursivo 

        if (promover.padre==null) {
                root = promover;
        }else if (promover.padre.keys.size()<MLlaves) {
            
            promover.padre.keys.add(promover.keys.get(0));
            promover.padre.keys.get(promover.padre.keys.size()-2).der = temp1;
            temp1.padre = promover.padre; 
            temp2.padre = promover.padre;     
        }else{
            split(promover,promover.padre);
        }
    }
    //inserta un Nodo
    public void insert(Nodo nuevo, Nodo pointer){
       
        if(root == null){//pregunta si el arbol esta vacio
            root = nuevo;
        }else{// si el arbol no esta vacio
            for (int i = 0; i < pointer.keys.size(); i++) {
                if (nuevo.keys.get(0).inicioRegistro>pointer.keys.get(i).inicioRegistro){
                    if(i== (pointer.keys.size()-1)){
                        if (pointer.keys.get(i).der == null){
                            if (pointer.keys.size() < MLlaves){ 
                                pointer.keys.add(new Nodo(nuevo.keys.get(0).Data,
                                nuevo.keys.get(0).inicioRegistro));
                                break;
                            }
                            else{
                                
                                split(nuevo,pointer);
                                break;
                            }                               
                        }else{
                            insert(nuevo,pointer.keys.get(i).der);
                            break;
                        }  
                    }    
                }else{
                    if (pointer.keys.get(i).izq == null){
                        if(pointer.keys.size()<MLlaves){
                            pointer.keys.add(i,new Nodo(nuevo.keys.get(0).Data,
                            nuevo.keys.get(0).inicioRegistro));
                            break;                            
                        }else{
                            split(nuevo,pointer);
                            break;
                        }                        
                    }else{
                        insert(nuevo,pointer.keys.get(i).izq);
                        break;
                    }      
                }
            }//fin de for
        }                
    }
    
    public boolean searchKey(String llave,Nodo pointer){
       return true; 
    }
        
}

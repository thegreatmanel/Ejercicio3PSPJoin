package threads3;

import static java.lang.Thread.sleep;

/**
 *
 * @author manel
 */
public class T3S extends Thread{
    
    Thread hijo;
    static int i = 0;
    static int n = 0;
    static int tiempo = 5000;
    
    public T3S(String name) {
        super(name);
    }

    public void run() {
        tiempo-=1000; //Se resta el tiempo del sleep
        System.out.println(getName() + " comenzado");//Comienza el primer hilo
        
        //Si i es menor o igual a 4 se crean hilos 
        while (i <= 4) {
            i++; //lleva la cuenta de los hilos creados
            n++; //y le suma uno por vuelta
            
           
            for (int z = 1; z <= 10; z++) {
                System.out.println(getName()  + " procesando vez n"+z);    
            }
            
        //crea un nuevo hilo hijo 
        hijo = new T3S("Hilo hijo "+i);
        
          /**cada hilo creado duerme hasta que acabe el que procede de el**/
            if(i==n && i<=4){
                try {
                    hijo.start();
                    sleep(tiempo);
                    
                } catch (InterruptedException ex) {}           
            }  
        System.out.println(getName() + " finalizado");
        }    
    }
}


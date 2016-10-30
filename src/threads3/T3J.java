package threads3;

/**
 *
 * @author manel
 */
public class T3J extends Thread {
    
    Thread hijo;
    static int i = 0;
    
    public T3J(String name) {
        super(name);
    }

    public void run() {
        //empieza el hilo
        System.out.println(getName() + " comenzado");
        
        //se crean hilos hasta que i sea mayor que 4
        while (i <= 4) {
            i++;//Cuenta el numero de hilos creados
            
            //El hilo se procesa 10 veces 
            for (int z = 1; z <= 10; z++) {
                System.out.println(getName()  + "en proceso");      
            }
            
        //Crea un nuevo hijo 
        hijo = new T3J("Hijo "+i);
            
          /**crea mientras no sea mayor que 4 y espera a que acabe el hilo que viene de el**/
            if(i<=4){
                try {
                    hijo.start();
                    hijo.join();
                } catch (InterruptedException ex) {}
            }
        System.out.println(getName() + " terminado");  
        }    
    }
}

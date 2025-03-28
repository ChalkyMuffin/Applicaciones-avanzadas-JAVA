import java.util.LinkedList;

public class queue {
    //FIFO: First In First Out
    //add(elemento): Agrega un elemento al final de la cola. Si la cola está llena, arroja una error.
    //offer(elemento): Agrega un elemento al final de la cola. Si la cola está llena, devuelve false.

    //remove(): Elimina el elemento de la parte frontal de la cola. Si la cola está vacía, arroja un error.
    //poll(): Elimina el elemento de la parte frontal de la cola. Si la cola está vacía, devuelve null.

    //element(): Devuelve el elemento de la parte frontal de la cola. Si la cola está vacía, arroja un error.
    //peek(): Devuelve el elemento de la parte frontal de la cola. Si la cola está vacía, devuelve null.


    public static void main(String[] args) {
        LinkedList cola = new LinkedList();
        //add() y offer() agregan un elemento al final de la cola
        //add() y offer() en este caso donde tenemos una LinkedList con espacio dinamico son funcionalmente identicos
        cola.add("Elemento 1");
        cola.offer("Elemento 2");

        System.out.println("Elementos de la cola: " + cola);

        //remove() y poll() eliminan el elemento de la parte frontal de la cola
        //si la cola está vacía, remove() arroja un error y poll() devuelve null
        cola.remove();
        System.out.println("Elementos de la cola: " + cola);

        cola.poll();
        System.out.println("Elementos de la cola: " + cola);

        //No lleva a error
        cola.poll();

        //Lleva a error
        //cola.remove();

        //element() y peek() devuelven el elemento de la parte frontal de la cola
        //si la cola está vacía, element() arroja un error y peek() devuelve null
        cola.offer("Elemento 3");
        cola.offer("Elemento 4");

        System.out.println("Elemento de la parte frontal de la cola: " + cola.peek());





    }
}

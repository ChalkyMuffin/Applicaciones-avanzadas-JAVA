
import java.util.Stack;

public class stack {

    /**
     * LIFO: Last In First Out
     * push: Mete un elemento a la pila
     * pop: Elimina un elemento de la pila
     * peek: Muestra el elemento que esta en la cima de la pila
     * empty: Verifica si la pila esta vacia
     * search: Busca un elemento en la pila
     */
     
    public static void main(String[] args) {
        Stack mochila = new Stack();
        //Agregar elementos a la pila
        mochila.push(1);
        mochila.push(2);
        mochila.push("Laptop");
        mochila.push("Teclado");

        //search()
        //Buscar donde se encuentra un elemento en la pila
        System.out.println("La laptop esta en el espacio: #" + mochila.search(1));

        //empty()
        //Checar si la pila esta vacia
        System.out.println("El stack esta vacio?: " + mochila.empty());
        
        //peek()
        //Mostrar el ultimo elemento de la pila
        System.out.println("El ultimo elemento es: " + mochila.peek());

        //pop()
        //Eliminar el ultimo elemento de la pila
        mochila.pop();
        System.out.println("El ultimo elemento es: " + mochila.peek());


        //while (mochila.empty() == false) {
        //    System.out.println("El ultimo elemento es: " + mochila.peek());
        //    mochila.pop();
        //}
    }
}

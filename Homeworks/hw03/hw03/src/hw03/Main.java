/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw03;

/**
 *
 * @author said
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GITArrayList<String> arraylist = new GITArrayList<>();
        GITLinkedList<String> linkedlist = new GITLinkedList<>();
              
        arraylist.addFirst("Birinci");
        arraylist.addLast("İkinci");
        arraylist.addLast("Üçüncü");
        arraylist.add(1, "araya girdi");        
        arraylist.remove(2);
        
        linkedlist.addFirst("Birinci");
        linkedlist.addLast("İkinci");
        linkedlist.addLast("Üçüncü");
        linkedlist.remove(0);   //İlk eleman silindi!
        
    }
    
}

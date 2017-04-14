import java.util.Scanner;
import java.util.Hashtable;

public class Item {

    static class NoItemException extends Exception {}

    private String primaryName;
    private int weight;
    private Hashtable<String,String> messages;


    Item(Scanner s) throws NoItemException,
        Dungeon.IllegalDungeonFormatException {

        messages = new Hashtable<String,String>();

        // Read item name.
        primaryName = s.nextLine();
        if (primaryName.equals(Dungeon.TOP_LEVEL_DELIM)) {
            throw new NoItemException();
        }

        // Read item weight.
        weight = Integer.valueOf(s.nextLine());

        // Read and parse verbs lines, as long as there are more.
        String verbLine = s.nextLine();
        while (!verbLine.equals(Dungeon.SECOND_LEVEL_DELIM)) {
            if (verbLine.equals(Dungeon.TOP_LEVEL_DELIM)) {
                throw new Dungeon.IllegalDungeonFormatException("No '" +
                    Dungeon.SECOND_LEVEL_DELIM + "' after item.");
            }
            String[] verbParts = verbLine.split(":");
            messages.put(verbParts[0],verbParts[1]);
            
            verbLine = s.nextLine();
        }
    }

    boolean goesBy(String name) {
        // could have other aliases
        return this.primaryName.equals(name);
    }

    String getPrimaryName() { return primaryName; }

    public String getMessageForVerb(String verb) {
        return messages.get(verb);
    }

    public String toString() {
        return primaryName;
    }
    
    /*
    *@param Takes item from Hashtable messages.
    * Method that removes item from the game.
    */
    void disappear(Item item)
    {
        messages.remove(item);
    }
    void transform(String item1Name, String item2Name) throws NoItemException
    {
        //this.disappear(item1);
      
       // GameState gs = GameState()
       //remove item from dungeon hashtable?
       Dungeon d=  GameState.instance().getDungeon();
       for(String s: GameState.instance().getInventoryNames())
       {
           if(s.equals(item1Name))
           {
               GameState.instance().removeFromInventory(d.getItem(item1Name));
               GameState.instance().addToInventory(d.getItem(item2Name));
               
           }
               
           
       }
       for(Item item:GameState.instance().getAdventurersCurrentRoom().getContents())
       {
           if (item.getPrimaryName().equals(item1Name))
           {
               GameState.instance().getAdventurersCurrentRoom().remove(d.getItem(item1Name));
                GameState.instance().getAdventurersCurrentRoom().add(d.getItem(item2Name));
           }
                      

       }
      
       
     
      // Item returnItem = d.getItem(item2Name);
        
        // is the new object in the items input in the dungeon?
        // gets the new object from the hashtable of items in dungeon
        //take the old item out of the dungeon and inev create new object 
    
    }
}

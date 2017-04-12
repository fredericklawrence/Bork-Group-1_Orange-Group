import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Neil
 */
public class NPC {
    int health;
    String name;
    String description;
    String occupiedRoom;
            
    /**
     * 
     * @param s Takes in the Scanner object from the users input
     * @param d takes in the dungeon so we can retrive some of its current state and update it
     */
    public NPC(Scanner s, Dungeon d)
    {
    
    }
     /**
     * Method used to initailize state of the NPC
     * 
     */
    void init()
    {
    
    }
     /**
     * Method used for battle, a game of rock paper scissors, it takes the users input for the game 
     * than puts against the NPC's and determines a winner
     * @param takes in the String command , for the users input during the battle
     * @return
     */
    String battle(String command)
    {
     return "";
    }
     /**
     * Returns the adventurs Current Room
     * @return returns a room object
     * 
     */
    Room currentRoom()
    {
        return new Room(name);
    }
     /**
     * 
     * Method that returns the name of the NPC
     * @return String - returns the name of the NPC
     */
    String getName(){return "";}
    /**
     * 
     * Method that returns the description of the NPC
     * @return String - returns the desc instance varible declared in the contructor
     */
    String getDesc(){return "";}
    /**
     * 
     * Method that stores the state of the NPC
     * @param w takes in a PrintWriter object to print the state of the object to
     */
    void StoreState(PrintWriter w){}
    /**
     * 
     * Method that restores the State of the NPC
     * @param r - takes in a scanner object to read in what state the NPc should restore from a save file
     */
    void restoreState(Scanner r){}
    /**
     * 
     * Method that returns the current health of the NPC
     * @return int - returns the health instance varible
     */
    int getHealth(){return 9;}
}

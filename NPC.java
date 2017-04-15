import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;

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
        s.next();
        d = GameState.instance().getDungeon();
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
        int NPCOutcome = (int) (Math.random()+2);
        
        String rock = "rock";
        String sissers = "sissers";
        String paper = "paper";
        
        String NPCCommand = "";
        if (NPCOutcome == 0)
            NPCCommand = rock;
        if(NPCOutcome == 1)
            NPCCommand = paper;
        if (NPCOutcome == 2)
            NPCCommand = sissers;
        
        
        if (command.equals("rock"))
        {
            if (NPCCommand.equals("rock"))
                return"Draw";
            if (NPCCommand.equals("paper"))
                return"Paper Covers Rock. You Lose.";
            if (NPCCommand.equals("sissers"))
                return"Rock Smashes Sissers. You Win.";
        }
        if (command.equals("paper"))
        {
            if (NPCCommand.equals("rock"))
                return"Paper Covers Rock. You Win.";
            if (NPCCommand.equals("paper"))
                return"Draw";
            if (NPCCommand.equals("sissers"))
                return"Sissers Cuts Paper. You Lose.";
        }
        if (command.equals("sissers"))
        {
            if (NPCCommand.equals("rock"))
                return"Rock Smashes Sissers. You Lose.";
            if (NPCCommand.equals("paper"))
                return"Sissers Cuts Paper. You Win.";
            if (NPCCommand.equals("sissers"))
                return"Draw";
        }
        return null;
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
    String getName(){return name;}
    /**
     * 
     * Method that returns the description of the NPC
     * @return String - returns the desc instance varible declared in the contructor
     */
    String getDesc(){return description;}
    /**
     * 
     * Method that stores the state of the NPC
     * @param w takes in a PrintWriter object to print the state of the object to
     */
    void StoreState(PrintWriter w)
    {
       w.println("Name: " + name);
       w.println(description);
       w.println(occupiedRoom);
    }
    /**
     * 
     * Method that restores the State of the NPC
     * @param r - takes in a scanner object to read in what state the NPc should restore from a save file
     */
    void restoreState(Scanner r)
    {
        String line = r.nextLine();
    }
    /**
     * 
     * Method that returns the current health of the NPC
     * @return int - returns the health instance varible
     */
    int getHealth()
    {
        int health = GameState.instance().getPlayerHealth();
        return health;
    }
}

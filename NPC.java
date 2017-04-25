import java.util.Scanner;
import java.util.Random;
public class NPC {
    private boolean alive = true;
    private String name;
    private String room;
    
    NPC(String n, String r, Dungeon d)
    {
        this.name = n;
        this.room = r;
        d.getRoom(room).add(this);
        //room = s.nextLine();
    }
    String getName()
    {
       return this.name; 
    }
    boolean isNamed(String name){
		return this.name.equalsIgnoreCase(name);
	}
    //String getRoomName(){
	//	returns = RoomName;
	//}
	String battle(String command)
    {
        int NPCOutcome = (int) (3*Math.random());
        
        String returns = "";
        /**
        String NPCCommand = "";
        if (NPCOutcome == 0)
            NPCCommand = "rock";
        if(NPCOutcome == 1)
            NPCCommand = "paper";
        if (NPCOutcome == 2)
            NPCCommand = "scissors";
        **/
        
        if (command.equalsIgnoreCase("rock"))
        {
            if (NPCOutcome == 0)
                returns ="draw";
            if (NPCOutcome == 1)
                returns ="lost";
            if (NPCOutcome == 2)
                returns ="won";
        }else if (command.equalsIgnoreCase("paper"))
        {
            if (NPCOutcome == 0)
                returns ="won";
            if (NPCOutcome == 1)
                returns ="draw";
            if (NPCOutcome == 2)
                returns ="lost";
        }else if (command.equalsIgnoreCase("scissors"))
        {
            if (NPCOutcome == 0)
                returns ="lost";
            if (NPCOutcome == 1)
                returns ="won";
            if (NPCOutcome == 2)
                returns ="draw";
        }
        return returns;
    }
}
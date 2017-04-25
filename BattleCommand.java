import java.util.Scanner;
public class BattleCommand extends Command
{
    private static GameState state;

    
     // Constructor for objects of class BattleCommand
     
    public BattleCommand()
    {
       
    }

    
    public String execute()
    {
        Scanner s = new Scanner(System.in);
        state = GameState.instance();
        boolean game = true;
        boolean secondGame = false;
        boolean draw = false;
        String repeat;
        String returns = "";
        Room room = state.getAdventurersCurrentRoom();
        NPC toBattle = room.getNPCInside();
        
        System.out.println("Enter: 'Rock' or 'Paper' or 'Scissors'");
        String userInput = s.nextLine();
        String outcome = "";
        if(toBattle!=null)
            outcome = toBattle.battle(userInput);
        
         if (outcome.equals("won")){
            state.setPlayerScore(state.getPlayerScore()+2);
            room.remove(toBattle);
            state.setPlayerHealth(state.getPlayerHealth()+1);
            return "\nYou have beaten "+toBattle.getName()+", you receive +2 score.\nYou have also received +1 health.\n";
        }else if(outcome.equals("draw")){
            return "\nDraw. Your health has not been effected\n";
        }else if(outcome.equals("lost")){
           state.setPlayerHealth(state.getPlayerHealth()-2);
           return "\nYou have lost and suffer a minor wound.\n";
         
        }           
        /**        
            
            if(outcome.equals("draw")){
            
            
                
                
                
                if(secondGame == true){
                System.out.println("Enter: 'Rock' or 'Paper' or 'Scissors'");
                userInput = s.nextLine();
                String outcome = toBattle.battle(userInput);
            
            }else{
                if (outcome.equals("won")){
                    state.setPlayerScore(state.getPlayerScore()+2);
                    room.remove(toBattle);
                    state.setPlayerHealth(state.getPlayerHealth()+1);
                    returns = "\nYou have beaten "+toBattle.getName()+", you receive +2 score.\nYou have also received +1 health.\n";
                    game = false;
                }else if
            }
            
            
            
            
                if (outcome.equals("won")){
                    state.setPlayerScore(state.getPlayerScore()+2);
                    room.remove(toBattle);
                    state.setPlayerHealth(state.getPlayerHealth()+1);
                    returns = "\nYou have beaten "+toBattle.getName()+", you receive +2 score.\nYou have also received +1 health.\n";
                    game = false;
                }else if(outcome.equals("draw")){
                    System.out.print("\nDraw. Restarting...\n");
                    System.out.println("Enter: 'Rock' or 'Paper' or 'Scissors'");
                    String userInput = s.nextLine();
                    String outcome = toBattle.battle(userInput);
                }else if(outcome.equals("lost")){
                    state.setPlayerHealth(state.getPlayerHealth()-2);
                    System.out.println("\nYou have lost and suffer a minor wound.");
                    System.out.println("Would you like to battle again? (y/n)");
                    repeat = s.next();
                    if(repeat.equalsIgnoreCase("n")){
                        returns = "\nYou have lost to "+toBattle.getName()+" and have injured yourself\n";
                        game = false;
                    }else if(repeat.equalsIgnoreCase("y")){
                       System.out.println("Enter: 'Rock' or 'Paper' or 'Scissors'");
                       String userInput = s.nextLine();
                       String outcome = toBattle.battle(userInput);
                    }
                        
                    
                      
                 
                
                }else{
                    System.out.print("\nNot sure what happened, restarting...\n");
                }
            
          **/  
                return null;
    }
    
}
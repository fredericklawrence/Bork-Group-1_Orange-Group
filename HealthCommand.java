public class HealthCommand extends Command{
    
    public String Health;
    
    public HealthCommand(String h){
        this.Health = h;
    }
    
    public String execute(){

        if (GameState.instance().getPlayerHealth() > 9){
            return "You are in perfect health.\n";
        }
        if (GameState.instance().getPlayerHealth() <= 9 && GameState.instance().getPlayerHealth() >= 7){
            return "You feel well.\n";
        }
        if (GameState.instance().getPlayerHealth() <= 6 && GameState.instance().getPlayerHealth() >= 4){
            return "Your hands are beginning to feel heavy, rock paper scissors is becoming \n increasingly difficult to play.\n";
        }
        if (GameState.instance().getPlayerHealth() <= 3 && GameState.instance().getPlayerHealth() >= 1){
            return "You are on the brink of death.\n";
        }
        else{
            return "You are dead.\n";
        }
    }
}

public class Event {
    private String eventString;
    private static GameState state;
    private static Dungeon dungeon;
    private Item item;
    
    public Event(Item item, String string){
        this.eventString = string;
        this.item = item;
    }
    String execute(){
       state = GameState.instance();
       dungeon = state.getDungeon();
       String theEvent = eventString.substring(0,eventString.indexOf(']'));
       
       String [] theList = theEvent.split(",");
       
       for(String event : theList){
           System.out.println(event);
           this.getType(event);
        }
        
        return eventString.substring(eventString.indexOf(":")+1) + "\n";
    }
    
    public void getType(String events){
        if(events.contains("Wound"))
            this.woundEvent(eventString); 
        else if(events.contains("Score"))
            this.scoreEvent(eventString);
        else if(events.contains("Die"))
            this.deathEvent();
        else if(events.contains("Teleport"))
            this.teleportEvent();
        else if(events.contains("Disappear"))
            this.disappearEvent();
        else if(events.contains("Transform"))
            this.transformEvent(events);
        else if(events.contains("Win"))
            this.winEvent();
    }
     private void deathEvent(){
         Interpreter.endGame = true;
    }
    private void scoreEvent(String events){  
        int add = Integer.parseInt(events.replaceAll("[\\D]", ""));
        state.setPlayerScore(state.getPlayerScore()+add);
    }
    private void woundEvent(String events){
        int remove = Integer.parseInt(events.replaceAll("[\\D]", ""));
        state.setPlayerHealth(state.getPlayerHealth()-remove);
    }
    

    private void disappearEvent(){
        state.removeFromInventory(item);
        state.getAdventurersCurrentRoom().remove(item);
    }

    private void transformEvent(String events){
        state.removeFromInventory(item);
        state.getAdventurersCurrentRoom().remove(item);
     
        String itemName = events.substring(events.indexOf('(')+1, events.indexOf(')'));
     
        try {
                state.addToInventory(dungeon.getItem(itemName));
        }catch (Item.NoItemException e) {
                System.out.println("Couldn't find the item!");
        }
    }


    private void winEvent(){
        Interpreter.endGame = true;
    }
     private void teleportEvent(){
        state.setAdventurersCurrentRoom(dungeon.getRandomRoom());
    }

}


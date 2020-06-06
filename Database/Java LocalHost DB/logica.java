public class logica{ 
    
    public void begin(){
        gui.showPanel(welkomScherm);
        pin(pas);
    }

    private void pin(String iBan){
        gui.showPanel(pinScherm);
        String pin = "";
        /*
            arduinocode moet pin aanvoegen met 1 char tot 4 cijfers
            While loop is het handigst
        */
        if(db.isBlocked(iBan)){
                gui.showPanel(pasBlok);
                begin();
        } else {
            if(data.equals("*")){
                Boolean pinBool = db.checkPin(iBan, pin);
                if(pinBool){
                    menu(iBan, pinBool);
                } 
                int pogingen = db.checkAttemps(iBan);
                // probeer op nieuw melding;
                gui.showPanel(foutPin);
                // delay
                pin(iBan);
            }
        }
    }


        boolean pinIngevuld = false;
    do{
        uno(1);
        if(data.equals("A")){
            System.out.println("A ingevuld maar niet toegevoegd");
        } else if(data.equals("B")){
            System.out.println("B ingevuld maar niet toegevoegd");
        } else if(data.equals("C")){
            System.out.println("C ingevuld maar niet toegevoegd");
        } else if(data.equals("D")){
            System.out.println("D ingevuld maar niet toegevoegd");
        } else if(data.equals("#")){
            pin = "";
            System.out.println("Pin is geleegd");
        } else if(data.equals("*")){
            System.out.print("* is ingevuld dus : ");
            pinIngevuld = true;
            System.out.println(pinIngevuld);
        }else {
            pin += data;
        }
    }
    while(pinIngevuld);
    System.out.println("pin: " + pin);
} 


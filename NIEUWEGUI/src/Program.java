public class Program{
    static NewJFrame gui;
    static DatabaseConnect db;
    public static main(String args[]){
        gui = new NewJFrame();
        db = new DatabaseConnect();
        db.ConnectToDB();
        while(db.CheckConn()){
            GUI();
        }
    }

    private static void GUI(){
        gui.begin();
        String data = "NK-STNK-42042069";
        while(data.length() >= 11){

        }
        
        if(db.isBlocked(data)){
            blocked();
        }

        String menu = "a";
        switch (menu) {
            case a:
                pin();
        
            default:
                gui.begin();
        }
    }

    private static void blocked(){
        gui.block();
        

        GUI();
    }

    private static void pin(){
        gui.pin();

    }
}
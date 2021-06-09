package apiResultados;

public class Event {
    private String type;
    private String name;
    private String count;

    public Event(){
        this("","","");
    }

    public Event(String type, String name, String count){
        this.type = type;
        this.name = name;
        this.count = count;
    }
}

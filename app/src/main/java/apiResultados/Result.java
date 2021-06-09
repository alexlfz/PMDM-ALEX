package apiResultados;

import java.util.List;

public class Result {
    private String date;
    private String home;
    private String away;
    public String score;
    private List<Event> homeEvents;
    private List<Event> awayEvents;

    public String getScore(){
        return score;
    }
}

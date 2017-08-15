package il.co.electriccollege.triathlon.model;

import il.co.electriccollege.triathlon.animals.*;

import il.co.electriccollege.triathlon.faces.*;

import java.util.ArrayList;

/**
 * Created by Comp8 on 15/08/17.
 */
public class Team {
    private ArrayList<Movable> team;
    public Team(ArrayList<Movable> team) throws SpeedException {
            this.team = team;
    }
    
}

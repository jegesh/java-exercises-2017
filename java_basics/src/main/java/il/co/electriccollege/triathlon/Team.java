package il.co.electriccollege.triathlon;

import il.co.electriccollege.triathlon.faces.Movable;

import java.util.ArrayList;

/**
 * Created by yaakov on 8/16/17.
 */
public class Team {
    private ArrayList<Movable> members;

    public void setTrack(Track track) {
        this.track = track;
    }

    private Track track;

    public int getDistance() {
        return distance;
    }

    private int distance;

    public Team(Movable member1, Movable member2, Movable member3){
        members = new ArrayList<>();
        members.add(member1);
        members.add(member2);
        members.add(member3);
    }

    public void advance() throws Exception {
        if(track == null){
            throw new Exception("No track defined");
        }

        if (distance < track.part1){
            // first part of track
            Movable current = members.get(0);
            current.move();
            distance = current.getDistance();
            return;
        }
        if(distance >= track.part1 && distance < track.part1 + track.part2){
            // second part of track
            Movable current = members.get(1);
            current.move();
            distance = track.part1 + current.getDistance();
            return;
        }
        if(distance >= track.part2){
            // third part of track
            Movable current = members.get(2);
            current.move();
            distance = track.part1 + track.part2 + current.getDistance();
            return;
        }
    }
}

package il.co.electriccollege.triathlon;

import il.co.electriccollege.triathlon.animals.Cheetah;
import il.co.electriccollege.triathlon.animals.Mongoose;
import il.co.electriccollege.triathlon.animals.Squirrel;
import il.co.electriccollege.triathlon.vehicles.Motorcycle;
import il.co.electriccollege.triathlon.vehicles.RaceCar;
import il.co.electriccollege.triathlon.vehicles.Tractor;

/**
 * Created by yaakov on 8/14/17.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Team animals = new Team(new Squirrel(), new Cheetah(), new Mongoose());
        Team vehicles = new Team(new Motorcycle(), new Tractor(), new RaceCar());
        Track track = new Track();
        track.part1 = 300;
        track.part2 = 150;
        track.part3 = 100;

        animals.setTrack(track);
        vehicles.setTrack(track);

        int totalDistance = track.part1 + track.part2 + track.part3;
        while(animals.getDistance() < totalDistance && vehicles.getDistance() < totalDistance){
            animals.advance();
            vehicles.advance();
            System.out.println("Animals: " + animals.getDistance());
            System.out.println("Vehicles: " + String.valueOf(vehicles.getDistance()));
        }
    }

}

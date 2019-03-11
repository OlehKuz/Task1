package model.entity;
import model.service.TrainService;

import java.util.ArrayList;
import java.util.List;

public class Train extends RailwayVehicle{
    private final RailwayVehicle locomotive;
    private List<RailwayVehicle> wagons;

    public Train (TrackSize trackSize, Function function, List <RailwayVehicle> trainParts){
        super(function, trackSize);
        locomotive = trainParts.get(0);
        this.wagons = trainParts.subList(1,trainParts.size());
    }

    public RailwayVehicle getLocomotive() {
        return locomotive;
    }

    public List<RailwayVehicle> getWagons() {
        return wagons;
    }

    public void setWagons(List<RailwayVehicle> wagons) {
        this.wagons = wagons;
    }

    @Override
    public String toString() {
        return "Train{" +
                "\n locomotive = " + locomotive +
                ",\n wagons = " + wagons +
                '}';
    }
}
package model.entity;
import model.service.TrainService;

import java.util.ArrayList;
import java.util.List;

public class Train extends RailwayVehicle{
    private RailwayVehicle[] trainParts;

    public Train (TrackSize trackSize, Function function, RailwayVehicle[] trainParts){
        super(function, trackSize);
        this.trainParts = trainParts;
    }
    public RailwayVehicle[] getTrainParts() {
        return trainParts;
    }

    public void setTrainParts(RailwayVehicle[] trainParts) {
        this.trainParts = trainParts;
    }

    @Override
    public String toString() {
        return "Train{" +
                super.toString() +
                '}';
    }
}

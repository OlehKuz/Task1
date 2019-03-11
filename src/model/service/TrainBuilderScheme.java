package model.service;

import model.entity.RailwayVehicle;

import java.util.List;

import  static model.service.DBVehicleTypes.*;


public enum TrainBuilderScheme {
    PASSENGER_SLEEPING_TRAIN(PASSENGER_LOCOMOTIVE.getRailwayVehicle(),CARRIAGE_SEATING2.getRailwayVehicle(),CARRIAGE_BERTH.getRailwayVehicle(),
            CARRIAGE_LUX.getRailwayVehicle(), CARRIAGE_COMPARTMENT.getRailwayVehicle(),CARRIAGE_SEATING1.getRailwayVehicle()),
    PASSENGER_FAST_TRAIN(PASSENGER_LOCOMOTIVE.getRailwayVehicle(), CARRIAGE_SEATING1.getRailwayVehicle(),CARRIAGE_SEATING2.getRailwayVehicle()),
    FREIGHT_TRAIN(PASSENGER_LOCOMOTIVE.getRailwayVehicle(),FREIGHT_WAGON.getRailwayVehicle());

    private RailwayVehicle[] trainScheme;

    TrainBuilderScheme(RailwayVehicle...vehicles){
        this.trainScheme = vehicles;
    }

    public RailwayVehicle[] getTrainBuilderScheme(){
        return trainScheme;
    }
}

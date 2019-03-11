package controller;

import model.entity.*;
import model.service.DBVehicleTypes;
import model.service.TrainService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static model.service.TrainBuilderScheme.*;

public class Controller {
    public void run(){
        System.out.println("I have this number of railway vehicles in my garage: "+ DBVehicleTypes.values().length );
        System.out.println("Lets construct a PASSENGER_SLEEPING_TRAIN");

        TrainService trainService = new TrainService();
        List<RailwayVehicle> trainBuildingScheme = Arrays.asList(trainService.getTrainBuildingScheme(PASSENGER_SLEEPING_TRAIN));
        Train builtTrain = trainService.constructTrain(trainBuildingScheme);
        System.out.println(builtTrain);
        int numberPassengers = trainService.getNumberPassengers(builtTrain);
        int numberLuggage = trainService.getNumberLuggage(builtTrain);
        System.out.println("Our PASSENGER_SLEEPING_TRAIN has this number of passengers: " + numberPassengers +
                " and this number of luggage compartments " + numberLuggage);
        System.out.println("Lets filter our wagons by passenger capacity 36. Lower bound included");
        trainService.filterByNumberPassengers(builtTrain, 36);
        System.out.println(builtTrain);

    }
}

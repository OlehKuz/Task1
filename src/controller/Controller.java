package controller;

import model.entity.*;
import model.service.DBVehicleTypes;
import model.service.TrainService;
import view.View;

import static view.TextConstant.*;
import static view.View.bundle;


import java.util.Arrays;
import java.util.List;

import static model.service.TrainBuilderScheme.*;

public class Controller{
    public void run(){
        View view = new View();
        view.printMessage(bundle.getString(NUMBER_VEHICLES) + DBVehicleTypes.values().length );
        view.printMessage(bundle.getString(LETS_CONSTRUCT));

        TrainService trainService = new TrainService();
        List<RailwayVehicle> trainBuildingScheme = Arrays.asList(trainService.getTrainBuildingScheme(PASSENGER_SLEEPING_TRAIN));
        Train builtTrain = trainService.constructTrain(trainBuildingScheme);
        System.out.println(builtTrain);
        System.out.println();

        //builtTrain.setWagons(trainService.filterCarriage(builtTrain));
        int numberPassengers = trainService.getNumberPassengers(builtTrain);
        int numberLuggage = trainService.getNumberLuggage(builtTrain);
        view.printMessage(bundle.getString(NUMBER_PASSENGERS) + numberPassengers +
                bundle.getString(NUMBER_LUGGAGE)+ numberLuggage);
        System.out.println();

        view.printMessage(bundle.getString(FILTER_WAGONS_COMFORT));
        trainService.sortWagonsByComfort(builtTrain);
        System.out.println(builtTrain);
        System.out.println();

        view.printMessage(bundle.getString(FILTER_WAGONS_PASSENGERS));
        trainService.filterByNumberPassengers(builtTrain, 54);
        System.out.println(builtTrain);

    }
}

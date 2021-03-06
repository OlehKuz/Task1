package model.service;

import model.entity.*;

import java.util.*;
import java.util.stream.Collectors;


public class TrainService {
    public RailwayVehicle[] getTrainBuildingScheme(TrainBuilderScheme type){
        return type.getTrainBuilderScheme();
    }

    public Train constructTrain(List <RailwayVehicle> trainConstructionScheme) {

        Set<RailwayVehicle> trainParts = new HashSet<>(trainConstructionScheme);
        RailwayVehicle[] trainUnderConstruction = new RailwayVehicle[trainConstructionScheme.size()];

        Arrays.asList(DBVehicleTypes.values()).forEach(vehicleType->{
            if(trainParts.contains(vehicleType.getRailwayVehicle())){
                trainUnderConstruction[trainConstructionScheme.
                        indexOf(vehicleType.getRailwayVehicle())] = vehicleType.getRailwayVehicle();
            }
        });
        return new Train(trainUnderConstruction[0].getTrackSize(),trainUnderConstruction[0].getFunction(),
                Arrays.asList(trainUnderConstruction));

    }

    public int getNumberPassengers(Train train){
        return  train.getWagons()
                .stream()
                .filter(railwayVehicle -> railwayVehicle instanceof  Carriage)
                .mapToInt(railwayVehicle ->((Carriage) railwayVehicle).getPassengerCapacity())
                .sum();

    }

    public int getNumberLuggage(Train train){
        return train.getWagons()
                .stream()
                .filter(railwayVehicle -> railwayVehicle instanceof  Carriage)
                .mapToInt(railwayVehicle ->((Carriage) railwayVehicle).getLuggageCapacity())
                .sum();
    }

    public void filterByNumberPassengers(Train train, int number){
        List<RailwayVehicle> filtered = train.getWagons()
                .stream()
                .filter(railwayVehicle -> railwayVehicle instanceof  Carriage)
                .filter(railwayVehicle -> (((Carriage) railwayVehicle).getPassengerCapacity()>=number))
                .collect(Collectors.toList());
        train.setWagons(filtered);
    }

    public void sortWagonsByComfort(Train train){
        List<RailwayVehicle> comfort = train.getWagons()
                .stream()
                .filter(railwayVehicle -> railwayVehicle instanceof  Carriage)
                .sorted(Comparator.comparing(railwayVehicle -> ((Carriage) railwayVehicle).getCarriageType()))
                .collect(Collectors.toList());
        train.setWagons(comfort);
    }
//
//    public List<Carriage> filterCarriage(Train train){
//        List<Carriage> filtered = train.getWagons()
//                .stream()
//                .filter(railwayVehicle -> railwayVehicle instanceof  Carriage)
//                .map(railwayVehicle -> (Carriage)railwayVehicle)
//                .collect(Collectors.toList());
//        return filtered;
//    }

}

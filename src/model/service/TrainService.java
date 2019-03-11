package model.service;

import model.entity.*;

import java.util.*;

import static model.service.TrainBuilderScheme.*;

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
        int numberPassengers = train.getWagons()
                .stream()
                .filter(railwayVehicle -> railwayVehicle instanceof  Carriage)
                .mapToInt(railwayVehicle ->((Carriage) railwayVehicle).getPassengerCapacity())
                .sum();
        return numberPassengers;
    }

    public int getNumberLuggage(Train train){
        int numberLuggage = train.getWagons()
                .stream()
                .filter(railwayVehicle -> railwayVehicle instanceof  Carriage)
                .mapToInt(railwayVehicle ->((Carriage) railwayVehicle).getLuggageCapacity())
                .sum();
        return numberLuggage;
    }

    public void sortWagonsByComfort(Train train){

    }



    // Functions for user interaction unnecessary for this project
//    private boolean checkCompatibility(Train train,RailwayVehicle vehicle) throws
//            NotSameTrainFunctionException, WrongTrackSizeException{
//        if(!isCompatibleFunction(train,vehicle)){
//            throw new NotSameTrainFunctionException("Train function "+
//                    train.getFunction()+" differ from this vehicle : " +
//                    vehicle.getClass()+ " track dimensions " + vehicle.getFunction());
//        }
//        if(!isCompatibleTrack(train,vehicle)){
//            throw new WrongTrackSizeException("Train track dimensions "+
//                    train.getTrackSize()+" differ from this vehicle : " +
//                    vehicle.getClass()+ " track dimensions "+ vehicle.getTrackSize());
//        }
//        return true;
//    }
//
//    private boolean isCompatibleTrack(Train train,RailwayVehicle vehicle) {
//        return train.getTrackSize() == vehicle.getTrackSize();
//    }
//
//    private boolean isCompatibleFunction(Train train,RailwayVehicle vehicle) {
//        return train.getFunction()== vehicle.getFunction();
//    }
//
//    public void addWagon(Train train, Wagon wagon) throws NotSameTrainFunctionException,
//            WrongTrackSizeException {
//        Objects.requireNonNull(wagon);
//        Objects.requireNonNull(train);
//        if (checkCompatibility(train, (RailwayVehicle) wagon)) {
//            //Exception!!!
//            List<RailwayVehicle> trainParts = train.getTrainParts();
//            trainParts.add(wagon);
//            train.setTrainParts(trainParts);
//        }
//    }
//
//    public void setTrainParts(Train train , List<RailwayVehicle> trainParts) throws
//        NotSameTrainFunctionException, WrongTrackSizeException{
//        for(RailwayVehicle v:trainParts) {
//            checkCompatibility(train, v);
//        }
//        train.setTrainParts(trainParts);
//    }
}

package model.service;
import model.entity.*;

public enum DBVehicleTypes {
    PASSENGER_LOCOMOTIVE(new Locomotive(RailwayVehicle.Function.Passenger,TrackSize.EURO_TRACK,
            Locomotive.Engine.Diesel,20000, 150)),
    FREIGHT_LOCOMOTIVE(new Locomotive(RailwayVehicle.Function.Freight,TrackSize.EURO_TRACK,
            Locomotive.Engine.Electric,20000, 120)),
    FREIGHT_WAGON(new FreightWagon(TrackSize.EURO_TRACK, FreightWagon.FreightType.Coal,80)),
    CARRIAGE_SEATING2(new Carriage(TrackSize.EURO_TRACK, Carriage.CarriageType.Seating2Class)),
    CARRIAGE_SEATING1(new Carriage(TrackSize.EURO_TRACK, Carriage.CarriageType.Seating1Class)),
    CARRIAGE_BERTH(new Carriage(TrackSize.EURO_TRACK, Carriage.CarriageType.Berth)),
    CARRIAGE_COMPARTMENT(new Carriage(TrackSize.EURO_TRACK, Carriage.CarriageType.Compartment)),
    CARRIAGE_LUX(new Carriage(TrackSize.EURO_TRACK, Carriage.CarriageType.DeLuxe));

    private RailwayVehicle railwayVehicle;
    DBVehicleTypes(RailwayVehicle railwayVehicle){
        this.railwayVehicle = railwayVehicle;
    }

    public RailwayVehicle getRailwayVehicle() {
        return railwayVehicle;
    }
}

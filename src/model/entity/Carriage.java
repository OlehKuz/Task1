package model.entity;

public class Carriage extends Wagon {
    public enum CarriageType {DeLuxe, Compartment, Berth, Seating1Class, Seating2Class}
    private final CarriageType carriageType;
    private int passengerCapacity;
    private int luggageCapacity;

    public Carriage(TrackSize trackSize, CarriageType carriageType) {
        super(Function.Passenger, trackSize);
        this.carriageType = carriageType;
        this.passengerCapacity = numberPassengers(carriageType);
        this.luggageCapacity = numberLuggage(carriageType);
    }

    public Carriage(TrackSize trackSize, CarriageType carriageType,
                    int passengerCapacity, int luggageCapacity) {
        super(Function.Passenger, trackSize);
        this.carriageType = carriageType;
        this.luggageCapacity = luggageCapacity;
        this.passengerCapacity = passengerCapacity;
    }

    private static int numberPassengers(Carriage.CarriageType carriageType){
        switch (carriageType){
            case DeLuxe: return 18;
            case Compartment: return 36;
            case Berth: return 54;
            case Seating1Class:
            case Seating2Class: return 56;
            default: return 56;
        }
    }

    private int numberLuggage(Carriage.CarriageType carriageType){
        switch (carriageType){
            case DeLuxe:
            case Compartment: return 36;
            case Berth: return 27;
            case Seating1Class: return 50;
            case Seating2Class: return 42;
            default: return 42;
        }
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getLuggageCapacity() {
        return luggageCapacity;
    }

    public void setLuggageCapacity(int luggageCapacity) {
        this.luggageCapacity = luggageCapacity;
    }

    public CarriageType getCarriageType() {
        return carriageType;
    }


    @Override
    public String toString() {
        return "Carriage{" +
                "carriage type = '" + carriageType +
                "', passengerCapacity = '" + passengerCapacity+
                "', number of luggage compartments = '" + luggageCapacity +
                "', "+ super.toString() + "}";
    }
}

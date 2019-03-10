package model.entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Train extends RailwayVehicle{
    private List<Wagon> wagons = new ArrayList<>();
    private Locomotive locomotive;

    public Train (TrackSize trackSize, Function function){
        super(function, trackSize);
    }

    public Train (TrackSize trackSize, Function function,
    Locomotive locomotive, List<Wagon> wagons)throws NotSameTrainFunctionException,
            WrongTrackSizeException{
        super(function, trackSize);
        this.setLocomotive(locomotive);
        this.setWagons(wagons);
    }

    public Train (TrackSize trackSize, Function function,
                  Locomotive locomotive, Wagon wagon)throws NotSameTrainFunctionException,
            WrongTrackSizeException{
        super(function, trackSize);
        this.setLocomotive(locomotive);
        this.addWagon(wagon);
    }

    public void addWagon(Wagon wagon) throws NotSameTrainFunctionException,
            WrongTrackSizeException {
        Objects.requireNonNull(wagon);
        if(checkCompatibility((RailwayVehicle) wagon)){
            wagons.add(wagon);
        }
    }


    public Wagon getWagon(int index) throws IndexOutOfBoundsException{
        if(index >= this.getTrainSize()){
            throw new IndexOutOfBoundsException(index);
        }
        return wagons.get(index);
    }

    public void setWagons(List<Wagon> wagons) throws
            NotSameTrainFunctionException, WrongTrackSizeException{
            for (Wagon w: wagons) {
               checkCompatibility((RailwayVehicle)w);
            }
            this.wagons = wagons;
    }

    public Locomotive getLocomotive() {
        Objects.requireNonNull(locomotive);
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) throws
            NotSameTrainFunctionException, WrongTrackSizeException{
            if(checkCompatibility(locomotive)){
                this.locomotive = locomotive;
            }
    }

    private boolean checkCompatibility(RailwayVehicle vehicle) throws
            NotSameTrainFunctionException, WrongTrackSizeException{
        if(!this.isCompatibleFunction(vehicle.getFunction())){
        throw new NotSameTrainFunctionException("Train function "+
                this.getFunction()+" differ from this vehicle : " +
                vehicle.getClass()+ " track dimensions " + vehicle.getFunction());
        }
        if(!this.isCompatibleTrack(vehicle.getTrackSize())){
        throw new WrongTrackSizeException("Train track dimensions "+
                this.getTrackSize()+" differ from this vehicle : " +
                vehicle.getClass()+ " track dimensions "+ vehicle.getTrackSize());
        }
        return true;
    }

    private boolean isCompatibleTrack(TrackSize trackSize) {
        return this.getTrackSize() == trackSize;
    }

    private boolean isCompatibleFunction(Function function) {
        return this.getFunction()== function;
    }

    private int getTrainSize(){
        Objects.requireNonNull(wagons);
        return wagons.size();
    }
}

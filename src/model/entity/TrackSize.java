package model.entity;

public enum TrackSize {
    EURO_TRACK(143),
    EASTERN_TRACK(152);

    private final int size;
    TrackSize(int size) {
        this.size = size;
    }

    public int getSize(){
        return size;
    }
}


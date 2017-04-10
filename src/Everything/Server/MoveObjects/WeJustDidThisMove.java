package Everything.Server.MoveObjects;


import Everything.models.MapSpot;
import Everything.models.Terrain;

public class WeJustDidThisMove implements Move {

    //-----------
    // Attributes

    private MapSpot tileSpot;
    private MapSpot buildSpot;
    private int orientation;
    private Terrain terrain;
    private int buildType;

    //-----------
    // Constructors

    public WeJustDidThisMove(MapSpot tileSpot, MapSpot buildSpot, int orientation, Terrain terrain, int buildType){
        this.tileSpot = tileSpot;
        this.buildSpot = buildSpot;
        this.orientation = orientation;
        this.terrain = terrain;
        this.buildType = buildType;
    }

    //-----------
    // Getters

    public MapSpot getTileSpot(){return this.tileSpot;}
    public MapSpot getBuildSpot(){return this.buildSpot;}
    public int getOrientation(){return this.orientation;}
    public Terrain getTerrain(){return this.terrain;}
    public int getBuildType(){return this.buildType;}
}
package game.action.utils.settlemenet.expanding;

import game.action.utils.NoValidActionException;
import models.Map;
import models.MapSpot;
import models.Settlement;
import models.Terrain;

import java.util.ArrayList;

/**
 * Takes in a Settlement, map, and terrain type
 * returns an arraylist of mapspots that can be expanded to from a the given settlement for the givern terrain type
 */
public class ExpansionScannerTerrain {

    //---------------
    // Public Methods

    public ArrayList<MapSpot> scan(final Settlement settlement, final Map map, Terrain terraintype) throws NoValidActionException {

        final ArrayList<MapSpot> expandableMapSpots = new ArrayList<>();

        final boolean visited[][][] = new boolean[Map.size()][Map.size()][Map.size()];

        visit(settlement.getMapSpots().get(0), expandableMapSpots, visited, map, settlement, terraintype);

        if(expandableMapSpots.size() < 1)
            throw new NoValidActionException("No available expansion spots");

        return expandableMapSpots;
    }

    //----------------
    // Private Methods

    private void visit(final MapSpot currentMapSpot, final ArrayList<MapSpot> expandableMapSpots, boolean visited[][][], final Map map, final Settlement settlement, final Terrain terraintype) {

        if(visited[currentMapSpot.getX()][currentMapSpot.getY()][currentMapSpot.getZ()])
            return;
        else
            visited[currentMapSpot.getX()][currentMapSpot.getY()][currentMapSpot.getZ()] = true;


        if (satisfiesExpansionRequirements(currentMapSpot, map, settlement, terraintype)) {
            expandableMapSpots.add(currentMapSpot);
        }

        for (final MapSpot adjMapSpot : currentMapSpot.getAdjacentMapSpots()) {
            if(satisfiesVisitingRequirements(adjMapSpot, map, settlement, terraintype))
                visit(adjMapSpot, expandableMapSpots, visited, map, settlement, terraintype);
        }
    }

    private boolean satisfiesExpansionRequirements(final MapSpot mapSpot, final Map map, final Settlement settlement, Terrain terraintype) {
        return satisfiesVisitingRequirements(mapSpot, map, settlement, terraintype) &&
                map.getHexagon(mapSpot).isEmpty();
    }

    private boolean satisfiesVisitingRequirements(final MapSpot mapSpot, final Map map, final Settlement settlement, final Terrain terraintype) {
        return map.getHexagon(mapSpot) != null &&
                map.getHexagon(mapSpot).getTerrainType() == terraintype;

    }
}
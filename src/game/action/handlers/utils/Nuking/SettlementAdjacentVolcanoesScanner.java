package game.action.handlers.utils.Nuking;

import models.Map;
import models.MapSpot;
import models.Settlement;
import models.Terrain;

import java.util.ArrayList;

/**
 * Scans for all volcanoes that are touching the settlement (volcanoes surrounded by the settlement are included)
 */
public class SettlementAdjacentVolcanoesScanner {

    //-----------
    // Attributes

    private SettlementAdjacentMapSpotsScanner settlementAdjacentMapSpotsScanner;

    //--------
    // Methods

    public ArrayList<MapSpot> scan(final Settlement settlement, final Map map) {
        final ArrayList<MapSpot> boarderLineVolcanoes = new ArrayList<>();
        final ArrayList<MapSpot> boarderLine = settlementAdjacentMapSpotsScanner.generate(settlement, map);

        for (MapSpot boarderLineMapSpot : boarderLine) {
            if (map.getHexagon(boarderLineMapSpot) != null &&
                    map.getHexagon(boarderLineMapSpot).getTerrainType() == Terrain.VOLCANO) {

                boarderLineVolcanoes.add(boarderLineMapSpot);
            }
        }

        return boarderLineVolcanoes;
    }

    //-------------
    // Constructors

    public SettlementAdjacentVolcanoesScanner(final SettlementAdjacentMapSpotsScanner settlementAdjacentMapSpotsScanner) {
        this.settlementAdjacentMapSpotsScanner = settlementAdjacentMapSpotsScanner;
    }


}

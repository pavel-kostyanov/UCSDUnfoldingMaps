package module5;

import java.util.List;

import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.utils.ScreenPosition;
import processing.core.PGraphics;

/** Implements a visual marker for ocean earthquakes on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 * @author Your name here
 *
 */
public class OceanQuakeMarker extends EarthquakeMarker {
	
	public OceanQuakeMarker(PointFeature quake, Integer markerId) {
		super(quake);
		
		// setting field in earthquake marker
		isOnLand = false;
		this.id = Integer.toString(markerId);
	}
	

	/** Draw the earthquake as a square */
	@Override
	public void drawEarthquake(PGraphics pg, float x, float y) {
		pg.rect(x-radius, y-radius, 2*radius, 2*radius);
		if(getClicked()) {
			
			for(Marker city : EarthquakeCityMap.getCityMarkers()) {
				if(quake.getDistanceTo(city.getLocation()) <= ((EarthquakeMarker) quake).threatCircle()) {
			drawLines(pg, x, y);
				}
		}
		}
	}

	public void drawLines(PGraphics pg, float x, float y) {
		pg.line(x, y, x+100, y+100);
	}

}

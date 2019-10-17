package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {
		//Opprette ny tabell 
		gpspoints = new GPSPoint[n];

	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}

	protected boolean insertGPS(GPSPoint gpspoint) {
			// Sette inn gps punkt i tabell om det er plass i tabell(antall < gpspoints.length)
		boolean inserted = false;

		if (antall < gpspoints.length) {
			gpspoints[antall] = gpspoint;
			antall++;
			inserted = true;
		}
		return inserted;
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {
		// Konverterer data i ein streng til tall og oppretter et nytt gps punkt
		GPSPoint gpspoint;
		gpspoint = GPSDataConverter.convert(time, latitude, longitude, elevation);
		boolean a = insertGPS(gpspoint);

		return a;

	}

	public void print() {
		// Skriver ut gps data fra gpspoints tabellen. 
		System.out.println("====== Konvertert GPS Data - START ======");

		for (int i = 0; i < antall; i++) {
			System.out.println(gpspoints.toString());
		}

		System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}

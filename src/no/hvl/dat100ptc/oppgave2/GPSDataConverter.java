package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
	// skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26

	private static int TIME_STARTINDEX = 11; // startindex for tidspunkt i timestr

	public static int toSeconds(String timestr) {

		int secs;
		int hr, min, sec;

		// TODO
		// Leser tekststreng og gjer om tidsdata til sekunder

		hr = Integer.parseInt(timestr.substring(TIME_STARTINDEX, (TIME_STARTINDEX + 2)));
		min = Integer.parseInt(timestr.substring(TIME_STARTINDEX + 3, (TIME_STARTINDEX + 5)));
		sec = Integer.parseInt(timestr.substring(TIME_STARTINDEX + 6, (TIME_STARTINDEX + 8)));

		secs = hr * 60 * 60 + min * 60 + sec;

		return secs;

	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint;

		// Gjer om ein streng med tid, breddegrad, lengdegrad og høyde og konverterer
		// dette til et gps punkt

		int time = toSeconds(timeStr);
		double latitude = Double.parseDouble(latitudeStr);
		double longitude = Double.parseDouble(longitudeStr);
		double elevation = Double.parseDouble(elevationStr);

		gpspoint = new GPSPoint(time, latitude, longitude, elevation);
		return gpspoint;

	}

}

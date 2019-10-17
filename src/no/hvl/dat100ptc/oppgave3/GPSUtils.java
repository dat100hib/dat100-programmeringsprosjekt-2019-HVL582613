package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {
		// finne største tall i ein tabell
		double max;

		max = da[0];

		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}

		return max;
	}

	public static double findMin(double[] da) {
		// Finner miste tall i ein tabell
		double min;

		min = da[0];

		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		return min;

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {
		// Leser tabell med gps punkter og returnerer ein ny tabell med desimaltall for
		// breddegrad
		double[] lattab = new double[gpspoints.length];

		for (int i = 0; i < gpspoints.length; i++) {
			lattab[i] = gpspoints[i].getLatitude();
		}
		return lattab;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {
		// Leser tabell med gps punkter og returnerer ein ny tabell med desimaltall for
		// lengdegrad
		double[] longtab = new double[gpspoints.length];

		for (int i = 0; i < gpspoints.length; i++) {
			longtab[i] = gpspoints[i].getLongitude();
		}
		return longtab;

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		// Beregner avstanden mellom to punkter på jordkloden
		double d;
		double latitude1, longitude1, latitude2, longitude2;

		latitude1 = gpspoint1.getLatitude();
		latitude2 = gpspoint2.getLatitude();
		longitude1 = gpspoint1.getLongitude();
		longitude2 = gpspoint2.getLongitude();

		double deltalat = Math.toRadians(latitude2 - latitude1);
		double deltalong = Math.toRadians(longitude2 - longitude1);
		double a = Math.pow(Math.sin(deltalat / 2), 2) + Math.cos(Math.toRadians(latitude1))
				* Math.cos(Math.toRadians(latitude2)) * Math.pow(Math.sin(deltalong / 2), 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		d = R * c;

		return d;
	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		// Beregner gj.fart mellom to punkter i km/t
		int secs;
		double speed;

		int time1 = gpspoint1.getTime();
		int time2 = gpspoint2.getTime();

		secs = time2 - time1;

		double distance = distance(gpspoint1, gpspoint2);
		speed = (distance / secs) * 3.6;

		return speed;

	}

	public static String formatTime(int secs) {
		// Returnerer tid etter midnatt på gitt form. Gjer om tid i sekund til timer,
		// minutt og rest sekund. Streng skal vere 10 tegn lang.
		String timestr;
		String TIMESEP = ":";

		int hh = secs / 3600;
		int rest = secs % 3600;
		int mm = rest / 60;
		int rest2 = rest % 60;

		String hr = String.format("%02d", hh);
		String min = String.format("%02d", mm);
		String sec = String.format("%02d", rest2);

		timestr = String.format("%1$10s", "  " + hr + TIMESEP + min + TIMESEP + sec);

		return timestr;

	}

	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {
		// Runder av flyttal til to desimaler. Lengde på streng = 10.
		String str;
		double svar = (double) Math.round(d * 100) / 100;

		str = String.format("%1$" + TEXTWIDTH + "s", svar);
		return str;

	}
}

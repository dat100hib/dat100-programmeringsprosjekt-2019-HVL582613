package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);

		playRoute(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon)); 

		return xstep;
	}

	// antall y-pixels per breddegrad
	public double ystep() {
	
		double ystep;
		
		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));

		ystep = MAPXSIZE / (Math.abs(maxlat - minlat)); 

		return ystep;
		
	}

	public void showRouteMap(int ybase) {

		// TODO - START
		
		
		int j = 0;
		for(int i = 0; i < gpspoints.length; i++);
			j += 2;
			setColor(0,255,0);
			fillCircle((int) GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints)) + j, (int) GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints)) + j, 5);
			setColor(0,0,255);
			drawLine((int) GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints)), (int) GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints)), (int) GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints)), (int) GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints)));
		// TODO - SLUTT
	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		
		// TODO - START
		
		
		
		// TODO - SLUTT;
	}

	public void playRoute(int ybase) {

		// TODO - START
		
		
		
		// TODO - SLUTT
	}

}

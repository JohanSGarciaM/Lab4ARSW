package edu.eci.arsw.blueprints.test.persistence.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.filters.FilterRedundancies;

public class FilterRedundanciesTest {

	@Test
	public void filterRedundanciesConsecutive() {
		FilterRedundancies flr = new FilterRedundancies();
		Point[] pts = new Point[] {new Point(40,40),new Point(40,40), new Point(40,40), new Point(50,40)};
		Blueprint bp = new Blueprint("johan","design",pts);
		Blueprint bpf = flr.filter(bp);
		assertEquals(2,bpf.getPoints().size());
	}
	
	
	@Test
	public void filterRedundanciesDiferents() {
		FilterRedundancies flr = new FilterRedundancies();
		Point[] pts = new Point[] {new Point(40,40),new Point(50,50), new Point(60,50)};
		Blueprint bp = new Blueprint("johan","design",pts);
		Blueprint bpf = flr.filter(bp);
		assertEquals(3,bpf.getPoints().size());
	}

	@Test
	public void filterRedundanciesDiferents2() {
		FilterRedundancies flr = new FilterRedundancies();
		Point[] pts = new Point[] {new Point(40,40),new Point(40,40), new Point(60,60), new Point(60,60)};
		Blueprint bp = new Blueprint("johan","design",pts);
		Blueprint bpf = flr.filter(bp);
		assertEquals(2,bpf.getPoints().size());
	}
}
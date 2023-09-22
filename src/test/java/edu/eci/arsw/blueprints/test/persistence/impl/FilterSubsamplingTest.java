package edu.eci.arsw.blueprints.test.persistence.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.filters.FilterSubsampling;

public class FilterSubsamplingTest {

	@Test
	public void filterSubsamplingTwoPoints() {
		FilterSubsampling fls = new FilterSubsampling();
		Point[] pts = new Point[] {new Point(20,20),new Point(30,20)};
		Blueprint bp = new Blueprint("johan", "design",pts);		
		Blueprint bpf = fls.filter(bp);
		assertEquals(1,bpf.getPoints().size());
	}
	


	@Test
	public void filterSubsampling4Points() {
		FilterSubsampling fls = new FilterSubsampling();
		Point[] pts = new Point[] {new Point(20,20),new Point(30,30), new Point(40,40), new Point(50,50)};
		Blueprint bp = new Blueprint("johan", "design",pts);		
		Blueprint bpf = fls.filter(bp);
		assertEquals(2,bpf.getPoints().size());
	}

	@Test
	public void filterSubsamplingOnePoint() {
		FilterSubsampling fls = new FilterSubsampling();
		Point[] pts = new Point[] {new Point(20,20)};
		Blueprint bp = new Blueprint("johan", "design",pts);		
		Blueprint bpf = fls.filter(bp);
		assertEquals(0,bpf.getPoints().size());
	}
	
}
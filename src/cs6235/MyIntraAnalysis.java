package cs6235;

import java.util.Map;

import soot.Body;
import soot.BodyTransformer;

public class MyIntraAnalysis extends BodyTransformer {
	
	@Override
	protected void internalTransform(Body b, String phaseName, Map<String, String> options) {
		
		System.out.println(b.getMethod());
		
		
	}
};
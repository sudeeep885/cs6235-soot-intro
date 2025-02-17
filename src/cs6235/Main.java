package cs6235;

import java.util.Arrays;

import soot.PackManager;
import soot.Transform;

public class Main {
	public static void main(String[] args) {
		System.out.println("Inside Main");
		
		String classPath = "tests";		// path from which soot will take input to analyze
		String mainClass = "Main";		// entry point
		
		String[] sootArgs = {
				"-cp", classPath,
				"-pp",
				"-w",
				"-app",
				"-src-prec","java",
				"-p", "jb", "use-original-names:true",
//				"-p", "cg.cha", "enabled:true",
//				"-p", "cg.spark", "enabled:false",
//				"-f", "J",
//				"-d", "output",
				mainClass
		};
		
		System.out.println("Soot arguments are: " + Arrays.toString(sootArgs));
		
		MyInterAnalysis ma1 = new MyInterAnalysis();
		PackManager.v().getPack("wjtp").add(new Transform("wjtp.MyInterAnalysis", ma1));
		
//		MyIntraAnalysis ma2 = new MyIntraAnalysis();
//		PackManager.v().getPack("jtp").add(new Transform("jtp.MyIntraAnalysis", ma2));
		

		soot.Main.main(sootArgs);
	}
}
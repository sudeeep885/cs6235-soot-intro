package cs6235;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import soot.RefLikeType;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.jimple.ArrayRef;
import soot.jimple.DefinitionStmt;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InvokeStmt;
import soot.jimple.ReturnStmt;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.toolkits.graph.BriefUnitGraph;
import soot.toolkits.graph.UnitGraph;

public class MyInterAnalysis extends SceneTransformer {
	
	@Override
	protected void internalTransform(String phaseName, Map<String, String> options) {
		System.out.println("hello from " + phaseName);
		
		SootClass mainClass = Scene.v().getMainClass();
		SootMethod mainMethod = mainClass.getMethodByName("main");
		
		System.out.println("Printing statements of main method only");
		System.out.println(mainMethod.getActiveBody());
		System.out.println("**********************");
		
		
		// iterating over the units of the main method:
		for(Unit u: mainMethod.getActiveBody().getUnits()) {
			System.out.println("processing unit : " + u);
			
			Stmt stmt = (Stmt) u;
			
			if(stmt instanceof DefinitionStmt) {
				DefinitionStmt ds = (DefinitionStmt) stmt;
				Value lhs = ds.getLeftOp();
				Value rhs = ds.getRightOp();
				
				System.out.println("lhs: " + lhs + ", rhs: " + rhs);
				
				if(lhs.getType() instanceof RefLikeType) {
					
					if(lhs instanceof InstanceFieldRef || lhs instanceof ArrayRef) {
						
					}
				}
				
				else {
					// lhs is scalar, do something
				}
			}
			
			else if(stmt instanceof InvokeStmt) {
				
			}
			
			else if(stmt instanceof ReturnStmt) {
				
			}
			
			else {
				// handle other type of statements here like above
			}
		}
		
		System.out.println("**********************");
		System.out.println("flowing through the program");
		
		//obtain the Call graph
		CallGraph cg = Scene.v().getCallGraph();		// generated before wjtp phase
		
		//obtain the CFG
		UnitGraph cfg = new BriefUnitGraph(mainMethod.getActiveBody());
		
		List<Unit> heads = cfg.getHeads();
		Unit head = heads.get(0);
		
//		dfs(cfg, cg, head);
	}
	
	// EXCERCISE
	
	// may need to have a visited set to avoid infinite recursion.
	
	public void dfs(UnitGraph cfg, CallGraph cg, Unit u) {
		Stmt stmt = (Stmt) u;
		System.out.println(stmt);
		
		if(stmt instanceof InvokeStmt) {
			//in the call graph, if you have an edge of the form src -> tgt1, tg2, tgt3
			Iterator<Edge> targetEdges = cg.edgesOutOf(u);
			while(targetEdges.hasNext()) {
				Edge e = targetEdges.next();
				// for each Edge e in targetEdges, find out the target method m, generate m's cfg say cfg_m 
				// and get cfg_m's head say m_h. Call dfs(cfg_m, cg, m_h);
			}
		}
		
		// iterate through the successors of unit u in cfg and call dfs on them
	}
};
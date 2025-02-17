# Soot introduction
- **How to setup repo on your machine ?**

	1. git clone https://github.com/sudeeep885/cs6235-soot-intro.git
	2. Open project in Eclipse.
	3. Right click on project name and click on build path -> configure build path
	4. In the left panel, click on “java compiler”. Set the compiler compliance level to 1.8
	5. In the left panel, click on “java build path”. Click on Libraries option. There should be 2 entries -Soot jar and JRE system library.

	      a) If the Soot jar entry is “missing”, download the jar separately. Click on “Add external jar” and give the path to the downloaded Soot Jar.

	      b) If the JRE library’s version is not 1.8 , then double click on JRE and click on alternate JRE. Check if JRE 1.8 is present in the drop down list.

		* If present, simply select JRE 1.8.
		* If absent, download JRE 1.8 separately and select “installed JRE”. Click on add libraries and then standard VM. Here give the path to your installed JRE 1.8 . Now again besides alternate JRE, Your new JRE should be visible in the drop down list. 



## Cheat sheet
- **How to get the Control Flow graph of a method ?**

	Your first argument to the internalTransform method in BodyTransformer class is the body of the method under analysis. Let’s call it arg0.

	```
	UnitGraph g = new BriefUnitGraph(arg0);
	```
  **Note** : observe that LHS is a UnitGraph, and we're instantiating a BriefUnitGraph. Why? What other forms of graphs might be available for use?

- **You can get Head of Control Flow Graph as follows**

	```
	List<Unit> heads = g.getHeads();
	```

- **You can get successor of a Unit u as follows** 

	```
	List<Unit> successors = g.getSuccsOf(u); 
	```

- **How to get Stmt from Unit u?**

	Simply cast the Unit to Stmt. 
	Eg: 
		```
		Stmt s = (Stmt) u;
		```

- **How to get Definition statements ?**
	```
	if(s instanceof DefinitionStmt){

	}
	```

	Once you get the definition statement, you can fetch it's left and right operand as follows :

	```
	DefinitionStmt ds = (DefinitionStmt)s;
	Value leftOp = ds.getLeftOp();
	Value rightOp = ds.getRightOp();
	```

- **How to check if operands are RefLike type ?**
	
	```
	if(leftOp.getType() instanceof RefLikeType){

	}
	```

- **Given a Scene, how to get the call graph?**
  ```
  CallGraph cg = Scene.v().getCallGraph(); 
  ```
  **Note** : write some test cases and try to identify by observation what kind of Call Graph is being delivered in this code, CHA or something else. What other Call Graph is offered by Soot?

## A simple task to start with
	
Traverse Control flow graph graph in a control flow order and print the units. (Hint - DFS)

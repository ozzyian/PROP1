package prop.assignment0;

public class AssignmentNode implements INode  {
	private Object[] nodeObjects = new Object[4];
	
	@Override
	public Object evaluate(Object[] args) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		// TODO Auto-generated method stub
		
	}
	
	public void setObjects(Object o, int i) {
		nodeObjects[i] = o;
	}

}
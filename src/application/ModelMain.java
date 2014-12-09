package application;

public class ModelMain extends CVEModel {

	public static void main(String[] args) {
		CVEModel model = new CVEModel();
		String[] arr = model.getSearchTerms(model.getCVEDocument());
		for(String s : arr)
			System.out.println(s);
	}

}

package application;

public class CVEApplication
{
	public static void main(String[] args)
	{
		new CVEApplication();
	}

	private CVEController myController;

	public CVEApplication()
	{
		this.setController(new CVEController());
	}

	public void setController(CVEController myController)
	{
		this.myController = myController;
	}

	public CVEController getController()
	{
		return myController;
	}
}


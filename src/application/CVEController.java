package application;

import java.lang.reflect.Method;

public class CVEController
{
		private CVEView myView;
		private CVEModel myModel;
		/**
		 * Makes it so that buttons actually communicate with the model and back
		 */
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public CVEController()
		{
			myModel = new CVEModel();
			myView = new CVEView(this);
			
			Class cls = this.getClass();
			Method mySearchButton = null;
			try
			{
				mySearchButton = cls.getMethod("search", new Class[]{});
			} catch (NoSuchMethodException | SecurityException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			myView.setSearchButton(this, mySearchButton);
		}
		
		public void search()
		{
			
		}
		
		public String getXMLInfo()
		{
			return null;
		}
}

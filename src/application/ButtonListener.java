package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ButtonListener implements ActionListener
{
	private Object myInvoker;
	private Method myMethod;
	
	ButtonListener(Object invoker, Method method)
	{
		myInvoker = invoker;
		myMethod = method;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		try
		{
			myMethod.invoke(myInvoker, new Object[] {});
		}
		catch(InvocationTargetException | IllegalAccessException | IllegalArgumentException x)
		{
		}
	}
}

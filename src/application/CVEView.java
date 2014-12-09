package application;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

@SuppressWarnings("serial")
public class CVEView extends JFrame
{

	private JButton mySearchButton;
	private JTextField mySearchField;
	private JTextPane myXML;
	private JList<Object> myList;
	
	public CVEView(CVEController controller)
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1080, 720);
		
		JPanel mySearchPanel = new JPanel();
		JPanel myCVEPanel = new JPanel();
		JPanel myApplication = new JPanel();
		JPanel mySearchBar = new JPanel();
		JPanel myListPanel = new JPanel();
		
		mySearchField = new JTextField();
		mySearchButton = new JButton("Search");
	
		myList = new JList<Object>();
		myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		myList.setLayoutOrientation(JList.VERTICAL);
		myList.setVisibleRowCount(-1);
		myList.addMouseListener(new MouseListener() 
		{
			@Override
			public void mouseClicked(MouseEvent event)
			{
			}

			@Override
			public void mouseEntered(MouseEvent event)
			{
			}

			@Override
			public void mouseExited(MouseEvent event)
			{
			}

			@Override
			public void mousePressed(MouseEvent event)
			{
				
			}

			@Override
			public void mouseReleased(MouseEvent event)
			{	
			}
		});
		
		JScrollPane listScroller = new JScrollPane(myList);
	    listScroller.setPreferredSize(new Dimension(275, 635));
	    listScroller.setMinimumSize(new Dimension(10, 10));
	    listScroller.setAlignmentX(LEFT_ALIGNMENT);
	    listScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		mySearchField.setColumns(14);
		
		mySearchBar.add(mySearchField);
		mySearchBar.add(mySearchButton);
		myListPanel.add(listScroller);
		mySearchPanel.setLayout(new BorderLayout());
		mySearchPanel.add(mySearchBar, BorderLayout.NORTH);
		mySearchPanel.add(myListPanel);
		
		myXML = new JTextPane();
		myXML.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(myXML);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(750, 675));
        scrollPane.setMinimumSize(new Dimension(10, 10));
        
		myCVEPanel.add(scrollPane);
		
		myApplication.setLayout(new BorderLayout());
		myApplication.add(mySearchPanel, BorderLayout.WEST);
		myApplication.add(myCVEPanel, BorderLayout.CENTER);
		
		
		this.add(myApplication);

		this.setVisible(true);
	}

	public void setSearchButton(Object invoker, Method method)
	{
		ButtonListener search = new ButtonListener(invoker, method);
		mySearchButton.addActionListener(search);
	}
	
	public void clearTextPane()
	{
		myXML.setText("");
	}
	
	public void loadXML(String xml)
	{
		myXML.setText(xml);
	}
}

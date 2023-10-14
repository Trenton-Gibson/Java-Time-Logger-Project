package Time_Logger_Classes;

import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Time_Logger_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField newTaskTypeField;
	private JTextField startDateField;
	private JTextField endDateField;
	private JTextField startTimeField;
	private JTextField endTimeField;
	private JTextField taskDescriptionField;
	private JTextField createTaskCategoryField;
	private JTextField categoryDescriptionField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Time_Logger_GUI frame = new Time_Logger_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Time_Logger_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1899, 895);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel createTaskTypeLabel = new JLabel("Create Task Type");
		GridBagConstraints gbc_createTaskTypeLabel = new GridBagConstraints();
		gbc_createTaskTypeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_createTaskTypeLabel.gridx = 2;
		gbc_createTaskTypeLabel.gridy = 0;
		getContentPane().add(createTaskTypeLabel, gbc_createTaskTypeLabel);
		
		newTaskTypeField = new JTextField();
		GridBagConstraints gbc_newTaskTypeField = new GridBagConstraints();
		gbc_newTaskTypeField.insets = new Insets(0, 0, 5, 5);
		gbc_newTaskTypeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_newTaskTypeField.gridx = 3;
		gbc_newTaskTypeField.gridy = 0;
		getContentPane().add(newTaskTypeField, gbc_newTaskTypeField);
		newTaskTypeField.setColumns(10);
		
		JLabel dataEntryHeaderLabel = new JLabel("Data Entry");
		GridBagConstraints gbc_dataEntryHeaderLabel = new GridBagConstraints();
		gbc_dataEntryHeaderLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dataEntryHeaderLabel.gridx = 6;
		gbc_dataEntryHeaderLabel.gridy = 0;
		getContentPane().add(dataEntryHeaderLabel, gbc_dataEntryHeaderLabel);
		
		JLabel projDisplayHeaderLabel = new JLabel("Projections Display");
		GridBagConstraints gbc_projDisplayHeaderLabel = new GridBagConstraints();
		gbc_projDisplayHeaderLabel.insets = new Insets(0, 0, 5, 5);
		gbc_projDisplayHeaderLabel.anchor = GridBagConstraints.EAST;
		gbc_projDisplayHeaderLabel.gridx = 26;
		gbc_projDisplayHeaderLabel.gridy = 0;
		getContentPane().add(projDisplayHeaderLabel, gbc_projDisplayHeaderLabel);
		
		JLabel taskDescriptionLabel = new JLabel("Task Description");
		GridBagConstraints gbc_taskDescriptionLabel = new GridBagConstraints();
		gbc_taskDescriptionLabel.anchor = GridBagConstraints.EAST;
		gbc_taskDescriptionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_taskDescriptionLabel.gridx = 2;
		gbc_taskDescriptionLabel.gridy = 1;
		getContentPane().add(taskDescriptionLabel, gbc_taskDescriptionLabel);
		
		taskDescriptionField = new JTextField();
		GridBagConstraints gbc_taskDescriptionField = new GridBagConstraints();
		gbc_taskDescriptionField.insets = new Insets(0, 0, 5, 5);
		gbc_taskDescriptionField.fill = GridBagConstraints.HORIZONTAL;
		gbc_taskDescriptionField.gridx = 3;
		gbc_taskDescriptionField.gridy = 1;
		getContentPane().add(taskDescriptionField, gbc_taskDescriptionField);
		taskDescriptionField.setColumns(10);
		
		JLabel selectTaskType = new JLabel("Select Task Type");
		GridBagConstraints gbc_selectTaskType = new GridBagConstraints();
		gbc_selectTaskType.anchor = GridBagConstraints.EAST;
		gbc_selectTaskType.insets = new Insets(0, 0, 5, 5);
		gbc_selectTaskType.gridx = 2;
		gbc_selectTaskType.gridy = 2;
		getContentPane().add(selectTaskType, gbc_selectTaskType);
		
		JComboBox taskTypeDropDown = new JComboBox();
		GridBagConstraints gbc_taskTypeDropDown = new GridBagConstraints();
		gbc_taskTypeDropDown.insets = new Insets(0, 0, 5, 5);
		gbc_taskTypeDropDown.fill = GridBagConstraints.HORIZONTAL;
		gbc_taskTypeDropDown.gridx = 3;
		gbc_taskTypeDropDown.gridy = 2;
		getContentPane().add(taskTypeDropDown, gbc_taskTypeDropDown);
		
		JLabel createTaskCategoryLabel = new JLabel("Create Task Category");
		GridBagConstraints gbc_createTaskCategoryLabel = new GridBagConstraints();
		gbc_createTaskCategoryLabel.anchor = GridBagConstraints.EAST;
		gbc_createTaskCategoryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_createTaskCategoryLabel.gridx = 2;
		gbc_createTaskCategoryLabel.gridy = 3;
		getContentPane().add(createTaskCategoryLabel, gbc_createTaskCategoryLabel);
		
		createTaskCategoryField = new JTextField();
		GridBagConstraints gbc_createTaskCategoryField = new GridBagConstraints();
		gbc_createTaskCategoryField.insets = new Insets(0, 0, 5, 5);
		gbc_createTaskCategoryField.fill = GridBagConstraints.HORIZONTAL;
		gbc_createTaskCategoryField.gridx = 3;
		gbc_createTaskCategoryField.gridy = 3;
		getContentPane().add(createTaskCategoryField, gbc_createTaskCategoryField);
		createTaskCategoryField.setColumns(10);
		
		JLabel categoryDescriptionLabel = new JLabel("Category Description");
		GridBagConstraints gbc_categoryDescriptionLabel = new GridBagConstraints();
		gbc_categoryDescriptionLabel.anchor = GridBagConstraints.EAST;
		gbc_categoryDescriptionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_categoryDescriptionLabel.gridx = 2;
		gbc_categoryDescriptionLabel.gridy = 4;
		getContentPane().add(categoryDescriptionLabel, gbc_categoryDescriptionLabel);
		
		categoryDescriptionField = new JTextField();
		GridBagConstraints gbc_categoryDescriptionField = new GridBagConstraints();
		gbc_categoryDescriptionField.insets = new Insets(0, 0, 5, 5);
		gbc_categoryDescriptionField.fill = GridBagConstraints.HORIZONTAL;
		gbc_categoryDescriptionField.gridx = 3;
		gbc_categoryDescriptionField.gridy = 4;
		getContentPane().add(categoryDescriptionField, gbc_categoryDescriptionField);
		categoryDescriptionField.setColumns(10);
		
		JLabel selectTaskCategoryLabel = new JLabel("Select Task Category");
		GridBagConstraints gbc_selectTaskCategoryLabel = new GridBagConstraints();
		gbc_selectTaskCategoryLabel.anchor = GridBagConstraints.EAST;
		gbc_selectTaskCategoryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_selectTaskCategoryLabel.gridx = 2;
		gbc_selectTaskCategoryLabel.gridy = 5;
		getContentPane().add(selectTaskCategoryLabel, gbc_selectTaskCategoryLabel);
		
		JComboBox selectTaskCategoryDropDown = new JComboBox();
		GridBagConstraints gbc_selectTaskCategoryDropDown = new GridBagConstraints();
		gbc_selectTaskCategoryDropDown.insets = new Insets(0, 0, 5, 5);
		gbc_selectTaskCategoryDropDown.fill = GridBagConstraints.HORIZONTAL;
		String[] CatInfo=Task_Category.CategoryInfo();
		for(int r=0;r<CatInfo.length;r++) {
		System.out.println(CatInfo[r]);	
		selectTaskCategoryDropDown.addItem(CatInfo[r]);
		}
		gbc_selectTaskCategoryDropDown.gridx = 3;
		gbc_selectTaskCategoryDropDown.gridy = 5;
		getContentPane().add(selectTaskCategoryDropDown, gbc_selectTaskCategoryDropDown);
		
		JLabel startDateLabel = new JLabel("Start Date");
		GridBagConstraints gbc_startDateLabel = new GridBagConstraints();
		gbc_startDateLabel.anchor = GridBagConstraints.NORTH;
		gbc_startDateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_startDateLabel.gridx = 2;
		gbc_startDateLabel.gridy = 6;
		getContentPane().add(startDateLabel, gbc_startDateLabel);
		
		startDateField = new JTextField();
		GridBagConstraints gbc_startDateField = new GridBagConstraints();
		gbc_startDateField.insets = new Insets(0, 0, 5, 5);
		gbc_startDateField.fill = GridBagConstraints.HORIZONTAL;
		gbc_startDateField.gridx = 3;
		gbc_startDateField.gridy = 6;
		getContentPane().add(startDateField, gbc_startDateField);
		startDateField.setColumns(10);
		
		JLabel endDateLabel = new JLabel("End Date");
		GridBagConstraints gbc_endDateLabel = new GridBagConstraints();
		gbc_endDateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_endDateLabel.gridx = 2;
		gbc_endDateLabel.gridy = 7;
		getContentPane().add(endDateLabel, gbc_endDateLabel);
		
		endDateField = new JTextField();
		GridBagConstraints gbc_endDateField = new GridBagConstraints();
		gbc_endDateField.insets = new Insets(0, 0, 5, 5);
		gbc_endDateField.fill = GridBagConstraints.HORIZONTAL;
		gbc_endDateField.gridx = 3;
		gbc_endDateField.gridy = 7;
		getContentPane().add(endDateField, gbc_endDateField);
		endDateField.setColumns(10);
		
		JLabel startTimeLabel = new JLabel("Start Time");
		GridBagConstraints gbc_startTimeLabel = new GridBagConstraints();
		gbc_startTimeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_startTimeLabel.gridx = 2;
		gbc_startTimeLabel.gridy = 8;
		getContentPane().add(startTimeLabel, gbc_startTimeLabel);
		
		startTimeField = new JTextField();
		GridBagConstraints gbc_startTimeField = new GridBagConstraints();
		gbc_startTimeField.insets = new Insets(0, 0, 5, 5);
		gbc_startTimeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_startTimeField.gridx = 3;
		gbc_startTimeField.gridy = 8;
		getContentPane().add(startTimeField, gbc_startTimeField);
		startTimeField.setColumns(10);
		
		JLabel endTimeLabel = new JLabel("End Time");
		GridBagConstraints gbc_endTimeLabel = new GridBagConstraints();
		gbc_endTimeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_endTimeLabel.gridx = 2;
		gbc_endTimeLabel.gridy = 9;
		getContentPane().add(endTimeLabel, gbc_endTimeLabel);
		
		endTimeField = new JTextField();
		GridBagConstraints gbc_endTimeField = new GridBagConstraints();
		gbc_endTimeField.insets = new Insets(0, 0, 5, 5);
		gbc_endTimeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_endTimeField.gridx = 3;
		gbc_endTimeField.gridy = 9;
		getContentPane().add(endTimeField, gbc_endTimeField);
		endTimeField.setColumns(10);
		
		JToolBar timeLoggingToolBar = new JToolBar();
		GridBagConstraints gbc_timeLoggingToolBar = new GridBagConstraints();
		gbc_timeLoggingToolBar.insets = new Insets(0, 0, 5, 5);
		gbc_timeLoggingToolBar.gridx = 3;
		gbc_timeLoggingToolBar.gridy = 10;
		getContentPane().add(timeLoggingToolBar, gbc_timeLoggingToolBar);
		
		JButton insertDataBtn = new JButton("Insert Data");
		insertDataBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			String startDate=startDateField.getText();
			String	endDate=endDateField.getText();
			String startTime=startTimeField.getText();
			String endTime=endTimeField.getText();
			String taskType=(String)(taskTypeDropDown.getSelectedItem());
			}
		});
		timeLoggingToolBar.add(insertDataBtn);
		insertDataBtn.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton deleteDataBtn = new JButton("Delete Data");
		timeLoggingToolBar.add(deleteDataBtn);
		
		JButton editDataBtn = new JButton("Edit Data");
		timeLoggingToolBar.add(editDataBtn);
		
		JButton newTaskTypeBtn = new JButton("New Task Type");
		timeLoggingToolBar.add(newTaskTypeBtn);
		
		JButton newCategoryBtn = new JButton("New Category");
		timeLoggingToolBar.add(newCategoryBtn);
		deleteDataBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		insertDataBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JSeparator midSeparator = new JSeparator();
		GridBagConstraints gbc_midSeparator = new GridBagConstraints();
		gbc_midSeparator.insets = new Insets(0, 0, 5, 5);
		gbc_midSeparator.gridx = 22;
		gbc_midSeparator.gridy = 11;
		getContentPane().add(midSeparator, gbc_midSeparator);
		
		JTree timeTransTree = new JTree();
		timeTransTree.setToolTipText("");
		GridBagConstraints gbc_timeTransTree = new GridBagConstraints();
		gbc_timeTransTree.insets = new Insets(0, 0, 5, 5);
		gbc_timeTransTree.fill = GridBagConstraints.BOTH;
		gbc_timeTransTree.gridx = 3;
		gbc_timeTransTree.gridy = 13;
		getContentPane().add(timeTransTree, gbc_timeTransTree);
	}

}

package ObjectOrientedDesign;
import java.util.*;

/**
 * @author sjia
 *Design a printserver. (there were some criteria) 
 */
public class PrintServer {
	private DriverInfo _driverInfo;
	private Queue<PrintingTask> tasks;

	public PrintServer() {
		 _driverInfo = new DriverInfo();
		 tasks = new LinkedList<PrintingTask>();
	}

	public boolean addTask(PrintingTask task) {
		if(task != null) {
			tasks.add(task);
			return true;
		}
		//log message here
		return false;
	}

	public boolean processTask() {
		if(!tasks.isEmpty()) {
			PrintingTask processingTask = tasks.poll();
			// TODO: code here to print the task 
			return true;
		}
		return false;
	}
}

class PrintingTask {
	private String _creationTime;
	private String _source;
	//more properties and their get and set methods here	
}

class DriverInfo {
	private String _driverVersion;
	private String _provider;
	private String _environment;
	//more properties here

	//default constructor
	public DriverInfo() {
		setDriverVersion("1.0");
		setProvider("Microsoft");
		//setEnvironment("Windows X64");
	}

	public void setDriverVersion(String newVersion) {
		_driverVersion = newVersion;
	}

	public String getDriverVersion() {
		if(_driverVersion != null){
			return _driverVersion;
		}
		return "1.0";
	}

	public void setProvider(String newProvider) {
		_provider = newProvider;
	}

	//more set and get methods here
}
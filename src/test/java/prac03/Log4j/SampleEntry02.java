package prac03.Log4j;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class SampleEntry02 {

		 
		public static void main(String[] args) {
	 
			 BasicConfigurator.configure();
		     Logger Mylogger = LogManager.getLogger("DebugLogger");
		 
		     //Setting up the log level of both loggers
		      Mylogger.setLevel(Level.DEBUG);
		 
		      Mylogger.trace("This is the trace log - DEBUG");
		      Mylogger.debug("This is debug log - DEBUG");
		      Mylogger.info("This is info log - DEBUG");
		      Mylogger.warn("This is Warn log - DEBUG");
		      Mylogger.error("This is error log - DEBUG");
		      Mylogger.fatal("This is Fatal log - DEBUG");
		 
		      Mylogger.setLevel(Level.WARN);
		      Mylogger.trace("This is the trace log - WARN");
		      Mylogger.debug("This is debug log - WARN");
		      Mylogger.info("This is info log - WARN");
		      Mylogger.warn("This is Warn log - WARN");
		      Mylogger.error("This is error log - WARN");
		      Mylogger.fatal("This is Fatal log - WARN");  
			
			
		}
	
	
	
	
}

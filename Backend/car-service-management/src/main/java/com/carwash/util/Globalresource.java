package com.carwash.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Globalresource {
	
	public static Logger getLogger(Class classname)
    {
        return LoggerFactory.getLogger(classname);
    }

}

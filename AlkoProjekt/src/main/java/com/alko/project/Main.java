package com.alko.project;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.alko.events.Desk;
import com.alko.events.Desk.ChangeBoxProduct;
import com.alko.events.Desk.CleanProduct;
import com.alko.events.Desk.PromoteProduct;
import com.alko.events.Desk.RollbackProduct;
import com.alko.events.IProductProcesses;
import com.alko.services.ClientDBManager;
import com.alko.services.ClientProductDBManager;
import com.alko.services.Condition;
import com.alko.services.ProductDBManager;

public class Main {

	private static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) throws PriceException, SQLException {

		
		PropertyConfigurator.configure("Log4J.properties");

		


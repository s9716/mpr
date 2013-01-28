package com.alko.tests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.alko.project.Client;
import com.alko.project.Product;
import com.alko.project.ProductMarks;
import com.alko.services.ClientDBManager;
import com.alko.services.ClientProductDBManager;
import com.alko.services.ProductDBManager;

public class ClientProductDBManagerTest {

	ProductDBManager pdb = new ProductDBManager();
	ClientDBManager cdb = new ClientDBManager();
	ClientProductDBManager cpdb = new ClientProductDBManager();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@After
	public void tearDown() throws Exception {
	cpdb.deleteAllProductFromClient();
	cdb.deleteAllClients();
	pdb.deleteAllProducts();
	}
	
	@Test
	public void testAddProductToClient() throws SQLException {
		cdb.addClient(new Client("MM"));
		pdb.addProduct(new Product(ProductMarks.Johniee_Walker_Red,65,12112245));
		cpdb.addProductToClient(cdb.FindClientByName("MM"), pdb.findProductByCode(12112245));
		assertEquals(1, cpdb.getClientProduct(cdb.FindClientByName("MM")).size());
	}

	@Test
	public void testDeleteAllClientProduct() throws SQLException {
		cdb.addClient(new Client("MM"));
		cdb.addClient(new Client("MML"));
		pdb.addProduct(new Product(ProductMarks.Johniee_Walker_Red,65,12112245));
		cpdb.addProductToClient(cdb.FindClientByName("MM"), pdb.findProductByCode(12112245));
		cpdb.addProductToClient(cdb.FindClientByName("MML"), pdb.findProductByCode(12112245));
		cpdb.addProductToClient(cdb.FindClientByName("MM"), pdb.findProductByCode(12112245));
		cpdb.deleteAllClientProduct(cdb.FindClientByName("MM"));
		cpdb.deleteAllClientProduct(cdb.FindClientByName("MML"));
		assertTrue(cpdb.getClientProduct(cdb.FindClientByName("MM")).size() == 0);
		assertTrue(cpdb.getClientProduct(cdb.FindClientByName("MML")).size() == 0);
	}

	@Test
	public void testDeleteAllProductFromClient() throws SQLException {
		cdb.addClient(new Client("MM"));
		pdb.addProduct(new Product(ProductMarks.Johniee_Walker_Red,65,12112245));
		cpdb.addProductToClient(cdb.FindClientByName("MM"), pdb.findProductByCode(12112245));
		cpdb.deleteAllProductFromClient();
		assertTrue(cpdb.getClientProduct(cdb.FindClientByName("MM")).size() == 0);
	}

	@Test
	public void testGetClientProduct() throws SQLException {
		cdb.addClient(new Client("MM"));
		pdb.addProduct(new Product(ProductMarks.Johniee_Walker_Red,65,12112245));
		cpdb.addProductToClient(cdb.FindClientByName("MM"), pdb.findProductByCode(12112245));
		assertEquals(1, cpdb.getClientProduct(cdb.FindClientByName("MM")).size());
	}

}

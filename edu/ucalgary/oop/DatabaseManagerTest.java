package edu.ucalgary.oop;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DatabaseManagerTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    private DatabaseManager databaseManager;

    @Before
    public void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        databaseManager = new DatabaseManager();
        databaseManager.setConnection(mockConnection);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
    }

    @After
    public void tearDown() throws SQLException {
        databaseManager = null;
        reset(mockConnection, mockPreparedStatement, mockResultSet);
    }

    @Test
    public void testConnect_Success() throws SQLException {
        assertNotNull(databaseManager.connect());
    }

    @Test(expected = SQLException.class)
    public void testConnect_Failure() throws SQLException {
        when(mockConnection.prepareStatement(anyString())).thenThrow(new SQLException());
        databaseManager.connect();
    }

    @Test
    public void testStoreData_Success() throws SQLException {
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);
        assertTrue(databaseManager.storeData(new Object()));
    }

    @Test
    public void testStoreData_Failure() throws SQLException {
        when(mockPreparedStatement.executeUpdate()).thenReturn(0);
        assertFalse(databaseManager.storeData(new Object()));
    }

    @Test(expected = SQLException.class)
    public void testStoreData_SQLException() throws SQLException {
        when(mockPreparedStatement.executeUpdate()).thenThrow(new SQLException());
        databaseManager.storeData(new Object());
    }

    @Test
    public void testRetrieveData_Success() throws SQLException {
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        assertNotNull(databaseManager.retrieveData());
    }

    @Test(expected = SQLException.class)
    public void testRetrieveData_SQLException() throws SQLException {
        when(mockPreparedStatement.executeQuery()).thenThrow(new SQLException());
        databaseManager.retrieveData();
    }
}

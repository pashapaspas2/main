package by.bsu.example.dao;

import by.bsu.example.dao.DBConnectionPool;

public abstract class DAO {
	protected static DBConnectionPool poolInstance;    
    protected DAO() {
        poolInstance = DBConnectionPool.getInstance();
        
    }
}

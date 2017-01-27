package by.htp6.comicsworld.dao.jdbc;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import by.htp6.comicsworld.dao.exception.DAOException;

public class DBConnectionPool implements Closeable {
	public static final DBConnectionPool instance = new DBConnectionPool();
	private BlockingQueue<Connection> freeConnection;
	private BlockingQueue<Connection> busyConnection;
	private int poolsize = 6;

	private DBConnectionPool() {
	}

	public void init() throws SQLException {
		freeConnection = new ArrayBlockingQueue<>(poolsize);
		busyConnection = new ArrayBlockingQueue<>(poolsize);

		try {
			Class.forName(DAOConfig.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < poolsize; i++) {
			freeConnection
					.add(DriverManager.getConnection(DAOConfig.URL, DAOConfig.USER_NAME, DAOConfig.USER_PASSWORD));
		}
	}

	public Connection take() throws InterruptedException {
		Connection connection = freeConnection.take();
		busyConnection.put(connection);
		return connection;
	}

	public void free(Connection connection) throws InterruptedException, DAOException {
		if (connection == null) {
			throw new DAOException();
		}

		Connection tempConnection = connection;
		connection = null;
		busyConnection.remove(tempConnection);
		freeConnection.put(tempConnection);
	}

	public static DBConnectionPool getInstance() {
		return instance;
	}

	@Override
	public void close() throws IOException{
		ArrayList<Connection> listConnection = new ArrayList<>();
		
		for(int i = 0; i < poolsize; i++){
			listConnection.add(busyConnection.poll());
			listConnection.add(freeConnection.poll());
		}
		
		for(Connection connection : listConnection){
			try{
				if(connection != null){
					connection.close();
				}
			}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}


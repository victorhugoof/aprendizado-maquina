package br.com.victor.sql;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Connection implements java.sql.Connection {

	private Connection inner;

	public Connection(Connection connection) {
		this.inner = connection;
	}

	@Override
	public Statement createStatement() throws SQLException {
		return this.inner.createStatement();
	}

	@Override
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return new PreparedStatement(this.inner.prepareStatement(sql), this);
	}

	@Override
	public CallableStatement prepareCall(String sql) throws SQLException {
		return this.inner.prepareCall(sql);
	}

	@Override
	public String nativeSQL(String sql) throws SQLException {
		return this.inner.nativeSQL(sql);
	}

	@Override
	public void setAutoCommit(boolean autoCommit) throws SQLException {
		this.inner.setAutoCommit(autoCommit);
	}

	@Override
	public boolean getAutoCommit() throws SQLException {
		return this.inner.getAutoCommit();
	}

	@Override
	public void commit() throws SQLException {
		this.inner.commit();
	}

	@Override
	public void rollback() throws SQLException {
		this.inner.rollback();
	}

	@Override
	public void close() throws SQLException {
		this.inner.close();
	}

	@Override
	public boolean isClosed() throws SQLException {
		return this.inner.isClosed();
	}

	@Override
	public DatabaseMetaData getMetaData() throws SQLException {
		return this.inner.getMetaData();
	}

	@Override
	public void setReadOnly(boolean readOnly) throws SQLException {
		this.inner.setReadOnly(readOnly);
	}

	@Override
	public boolean isReadOnly() throws SQLException {
		return this.inner.isReadOnly();
	}

	@Override
	public void setCatalog(String catalog) throws SQLException {
		this.inner.setCatalog(catalog);
	}

	@Override
	public String getCatalog() throws SQLException {
		return this.inner.getCatalog();
	}

	@Override
	public void setTransactionIsolation(int level) throws SQLException {
		this.inner.setTransactionIsolation(level);
	}

	@Override
	public int getTransactionIsolation() throws SQLException {
		return this.inner.getTransactionIsolation();
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		return this.inner.getWarnings();
	}

	@Override
	public void clearWarnings() throws SQLException {
		this.inner.clearWarnings();
	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
		return this.inner.createStatement(resultSetType, resultSetConcurrency);
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
		return new PreparedStatement(this.inner.prepareStatement(sql, resultSetType, resultSetConcurrency), this);
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
		return this.inner.prepareCall(sql, resultSetType, resultSetConcurrency);
	}

	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		return this.inner.getTypeMap();
	}

	@Override
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		this.inner.setTypeMap(map);
	}

	@Override
	public void setHoldability(int holdability) throws SQLException {
		this.inner.setHoldability(holdability);
	}

	@Override
	public int getHoldability() throws SQLException {
		return this.inner.getHoldability();
	}

	@Override
	public Savepoint setSavepoint() throws SQLException {
		return this.inner.setSavepoint();
	}

	@Override
	public Savepoint setSavepoint(String name) throws SQLException {
		return this.inner.setSavepoint(name);
	}

	@Override
	public void rollback(Savepoint savepoint) throws SQLException {
		this.inner.rollback(savepoint);
	}

	@Override
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		this.inner.releaseSavepoint(savepoint);
	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
		return this.inner.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
		return new PreparedStatement(this.inner.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability), this);
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
		return this.inner.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
		return new PreparedStatement(this.inner.prepareStatement(sql, autoGeneratedKeys), this);
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
		return new PreparedStatement(this.inner.prepareStatement(sql, columnIndexes), this);
	}

	@Override
	public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
		return new PreparedStatement(this.inner.prepareStatement(sql, columnNames), this);
	}

	@Override
	public Clob createClob() throws SQLException {
		return this.inner.createClob();
	}

	@Override
	public Blob createBlob() throws SQLException {
		return this.inner.createBlob();
	}

	@Override
	public NClob createNClob() throws SQLException {
		return this.inner.createNClob();
	}

	@Override
	public SQLXML createSQLXML() throws SQLException {
		return this.inner.createSQLXML();
	}

	@Override
	public boolean isValid(int timeout) throws SQLException {
		return this.inner.isValid(timeout);
	}

	@Override
	public void setClientInfo(String name, String value) throws SQLClientInfoException {
		this.inner.setClientInfo(name, value);
	}

	@Override
	public void setClientInfo(Properties properties) throws SQLClientInfoException {
		this.inner.setClientInfo(properties);
	}

	@Override
	public String getClientInfo(String name) throws SQLException {
		return this.inner.getClientInfo(name);
	}

	@Override
	public Properties getClientInfo() throws SQLException {
		return this.inner.getClientInfo();
	}

	@Override
	public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
		return this.inner.createArrayOf(typeName, elements);
	}

	@Override
	public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
		return this.inner.createStruct(typeName, attributes);
	}

	@Override
	public void setSchema(String schema) throws SQLException {
		this.inner.setSchema(schema);
	}

	@Override
	public String getSchema() throws SQLException {
		return this.inner.getSchema();
	}

	@Override
	public void abort(Executor executor) throws SQLException {
		this.inner.abort(executor);
	}

	@Override
	public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
		this.inner.setNetworkTimeout(executor, milliseconds);
	}

	@Override
	public int getNetworkTimeout() throws SQLException {
		return this.inner.getNetworkTimeout();
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return this.inner.unwrap(iface);
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return this.inner.isWrapperFor(iface);
	}

}

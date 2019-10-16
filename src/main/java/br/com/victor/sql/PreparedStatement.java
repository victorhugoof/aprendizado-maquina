package br.com.victor.sql;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;

public class PreparedStatement implements java.sql.PreparedStatement {

	private java.sql.PreparedStatement inner;
	private br.com.victor.sql.Connection connection;

	public PreparedStatement(java.sql.PreparedStatement preparedStatement, br.com.victor.sql.Connection connection) {
		this.inner = preparedStatement;
		this.connection = connection;
	}

	@Override
	public ResultSet executeQuery() throws SQLException {
		this.logSql();
		return this.inner.executeQuery();
	}

	@Override
	public int executeUpdate() throws SQLException {
		this.logSql();
		return this.inner.executeUpdate();
	}

	@Override
	public void setNull(int parameterIndex, int sqlType) throws SQLException {
		this.inner.setNull(parameterIndex, sqlType);
	}

	@Override
	public void setBoolean(int parameterIndex, boolean x) throws SQLException {
		this.inner.setBoolean(parameterIndex, x);
	}
	
	@Override
	public void setByte(int parameterIndex, byte x) throws SQLException {
		this.inner.setByte(parameterIndex, x);
	}
	
	@Override
	public void setShort(int parameterIndex, short x) throws SQLException {
		this.inner.setShort(parameterIndex, x);
	}
	
	@Override
	public void setInt(int parameterIndex, int x) throws SQLException {
		this.inner.setInt(parameterIndex, x);
	}
	
	@Override
	public void setLong(int parameterIndex, long x) throws SQLException {
		this.inner.setLong(parameterIndex, x);
	}
	
	@Override
	public void setFloat(int parameterIndex, float x) throws SQLException {
		this.inner.setFloat(parameterIndex, x);
	}
	
	@Override
	public void setDouble(int parameterIndex, double x) throws SQLException {
		this.inner.setDouble(parameterIndex, x);
	}
	
	@Override
	public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
		this.inner.setBigDecimal(parameterIndex, x);
	}
	
	@Override
	public void setString(int parameterIndex, String x) throws SQLException {
		this.inner.setString(parameterIndex, x);
	}
	
	@Override
	public void setBytes(int parameterIndex, byte[] x) throws SQLException {
		this.inner.setBytes(parameterIndex, x);
	}
	
	@Override
	public void setDate(int parameterIndex, Date x) throws SQLException {
		this.inner.setDate(parameterIndex, x);
	}
	
	@Override
	public void setTime(int parameterIndex, Time x) throws SQLException {
		this.inner.setTime(parameterIndex, x);
	}
	
	@Override
	public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
		this.inner.setTimestamp(parameterIndex, x);
	}
	
	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
		this.inner.setAsciiStream(parameterIndex, x, length);
	}
	
	@Override
	public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
		this.inner.setUnicodeStream(parameterIndex, x, length);
	}
	
	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
		this.inner.setBinaryStream(parameterIndex, x, length);
	}
	
	@Override
	public void clearParameters() throws SQLException {
		this.inner.clearParameters();
	}
	
	@Override
	public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
		this.inner.setObject(parameterIndex, x, targetSqlType);
	}
	
	@Override
	public void setObject(int parameterIndex, Object x) throws SQLException {
		this.inner.setObject(parameterIndex, x);
	}
	
	@Override
	public boolean execute() throws SQLException {
		this.logSql();
		return this.inner.execute();
	}
	
	@Override
	public void addBatch() throws SQLException {
		this.inner.addBatch();
	}
	
	@Override
	public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
		this.inner.setCharacterStream(parameterIndex, reader, length);
	}
	
	@Override
	public void setRef(int parameterIndex, Ref x) throws SQLException {
		this.inner.setRef(parameterIndex, x);
	}
	
	@Override
	public void setBlob(int parameterIndex, Blob x) throws SQLException {
		this.inner.setBlob(parameterIndex, x);
	}
	
	@Override
	public void setClob(int parameterIndex, Clob x) throws SQLException {
		this.inner.setClob(parameterIndex, x);
	}
	
	@Override
	public void setArray(int parameterIndex, Array x) throws SQLException {
		this.inner.setArray(parameterIndex, x);
	}
	
	@Override
	public ResultSetMetaData getMetaData() throws SQLException {
		return this.inner.getMetaData();
	}
	
	@Override
	public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
		this.inner.setDate(parameterIndex, x, cal);
	}
	
	@Override
	public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
		this.inner.setTime(parameterIndex, x, cal);
	}
	
	@Override
	public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
		this.inner.setTimestamp(parameterIndex, x, cal);
	}
	
	@Override
	public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
		this.inner.setNull(parameterIndex, sqlType, typeName);
	}
	
	@Override
	public void setURL(int parameterIndex, URL x) throws SQLException {
		this.inner.setURL(parameterIndex, x);
	}
	
	@Override
	public ParameterMetaData getParameterMetaData() throws SQLException {
		return this.inner.getParameterMetaData();
	}
	
	@Override
	public void setRowId(int parameterIndex, RowId x) throws SQLException {
		this.inner.setRowId(parameterIndex, x);
	}
	
	@Override
	public void setNString(int parameterIndex, String value) throws SQLException {
		this.inner.setNString(parameterIndex, value);
	}
	
	@Override
	public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
		this.inner.setNCharacterStream(parameterIndex, value, length);
	}
	
	@Override
	public void setNClob(int parameterIndex, NClob value) throws SQLException {
		this.inner.setNClob(parameterIndex, value);
	}
	
	@Override
	public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
		this.inner.setClob(parameterIndex, reader, length);
	}
	
	@Override
	public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
		this.inner.setBlob(parameterIndex, inputStream, length);
	}
	
	@Override
	public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
		this.inner.setNClob(parameterIndex, reader, length);
	}
	
	@Override
	public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
		this.inner.setSQLXML(parameterIndex, xmlObject);
	}
	
	@Override
	public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException {
		this.inner.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
	}
	
	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
		this.inner.setAsciiStream(parameterIndex, x, length);
	}
	
	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
		this.inner.setBinaryStream(parameterIndex, x, length);
	}
	
	@Override
	public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
		this.inner.setCharacterStream(parameterIndex, reader, length);
	}
	
	@Override
	public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
		this.inner.setAsciiStream(parameterIndex, x);
	}
	
	@Override
	public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
		this.inner.setBinaryStream(parameterIndex, x);
	}
	
	@Override
	public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
		this.inner.setCharacterStream(parameterIndex, reader);
	}
	
	@Override
	public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
		this.inner.setNCharacterStream(parameterIndex, value);
	}
	
	@Override
	public void setClob(int parameterIndex, Reader reader) throws SQLException {
		this.inner.setClob(parameterIndex, reader);
	}
	
	@Override
	public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
		this.inner.setBlob(parameterIndex, inputStream);
	}
	
	@Override
	public void setNClob(int parameterIndex, Reader reader) throws SQLException {
		this.inner.setNClob(parameterIndex, reader);
	}
	
	@Override
	public ResultSet executeQuery(String sql) throws SQLException {
		this.logSql();
		return this.inner.executeQuery(sql);
	}
	
	@Override
	public int executeUpdate(String sql) throws SQLException {
		this.logSql();
		return this.inner.executeUpdate(sql);
	}
	
	@Override
	public void close() throws SQLException {
		this.inner.close();
	}
	
	@Override
	public int getMaxFieldSize() throws SQLException {
		return this.inner.getMaxFieldSize();
	}
	
	@Override
	public void setMaxFieldSize(int max) throws SQLException {
		this.inner.setMaxFieldSize(max);
	}
	
	@Override
	public int getMaxRows() throws SQLException {
		return this.inner.getMaxRows();
	}
	
	@Override
	public void setMaxRows(int max) throws SQLException {
		this.inner.setMaxRows(max);
	}
	
	@Override
	public void setEscapeProcessing(boolean enable) throws SQLException {
		this.inner.setEscapeProcessing(enable);
	}
	
	@Override
	public int getQueryTimeout() throws SQLException {
		return this.inner.getQueryTimeout();
	}
	
	@Override
	public void setQueryTimeout(int seconds) throws SQLException {
		this.inner.setQueryTimeout(seconds);
	}
	
	@Override
	public void cancel() throws SQLException {
		this.inner.cancel();
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
	public void setCursorName(String name) throws SQLException {
		this.inner.setCursorName(name);
	}
	
	@Override
	public boolean execute(String sql) throws SQLException {
		this.logSql();
		return this.inner.execute(sql);
	}
	
	@Override
	public ResultSet getResultSet() throws SQLException {
		return this.inner.getResultSet();
	}
	
	@Override
	public int getUpdateCount() throws SQLException {
		return this.inner.getUpdateCount();
	}
	
	@Override
	public boolean getMoreResults() throws SQLException {
		return this.inner.getMoreResults();
	}
	
	@Override
	public void setFetchDirection(int direction) throws SQLException {
		this.inner.setFetchDirection(direction);
	}
	
	@Override
	public int getFetchDirection() throws SQLException {
		return this.inner.getFetchDirection();
	}
	
	@Override
	public void setFetchSize(int rows) throws SQLException {
		this.inner.setFetchSize(rows);
	}
	
	@Override
	public int getFetchSize() throws SQLException {
		return this.inner.getFetchSize();
	}
	
	@Override
	public int getResultSetConcurrency() throws SQLException {
		return this.inner.getResultSetConcurrency();
	}
	
	@Override
	public int getResultSetType() throws SQLException {
		return this.inner.getResultSetType();
	}
	
	@Override
	public void addBatch(String sql) throws SQLException {
		this.inner.addBatch(sql);
	}
	
	@Override
	public void clearBatch() throws SQLException {
		this.inner.clearBatch();
	}
	
	@Override
	public int[] executeBatch() throws SQLException {
		this.logSql();
		return this.inner.executeBatch();
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		return this.connection;
	}
	
	@Override
	public boolean getMoreResults(int current) throws SQLException {
		return this.inner.getMoreResults();
	}
	
	@Override
	public ResultSet getGeneratedKeys() throws SQLException {
		return this.inner.getGeneratedKeys();
	}
	
	@Override
	public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
		this.logSql();
		return this.inner.executeUpdate(sql, autoGeneratedKeys);
	}
	
	@Override
	public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
		this.logSql();
		return this.inner.executeUpdate(sql, columnIndexes);
	}
	
	@Override
	public int executeUpdate(String sql, String[] columnNames) throws SQLException {
		this.logSql();
		return this.inner.executeUpdate(sql, columnNames);
	}
	
	@Override
	public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
		this.logSql();
		return this.inner.execute(sql, autoGeneratedKeys);
	}
	
	@Override
	public boolean execute(String sql, int[] columnIndexes) throws SQLException {
		this.logSql();
		return this.inner.execute(sql, columnIndexes);
	}
	
	@Override
	public boolean execute(String sql, String[] columnNames) throws SQLException {
		this.logSql();
		return this.inner.execute(sql, columnNames);
	}
	
	@Override
	public int getResultSetHoldability() throws SQLException {
		return this.inner.getResultSetHoldability();
	}
	
	@Override
	public boolean isClosed() throws SQLException {
		return this.inner.isClosed();
	}
	
	@Override
	public void setPoolable(boolean poolable) throws SQLException {
		this.inner.setPoolable(poolable);
	}
	
	@Override
	public boolean isPoolable() throws SQLException {
		return this.inner.isPoolable();
	}
	
	@Override
	public void closeOnCompletion() throws SQLException {
		this.inner.closeOnCompletion();
	}
	
	@Override
	public boolean isCloseOnCompletion() throws SQLException {
		return this.inner.isCloseOnCompletion();
	}
	
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return this.inner.unwrap(iface);
	}
	
	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return this.inner.isWrapperFor(iface);
	}

	private void logSql() {
		String env = System.getProperty("env");
		if ("debug".equals(env)) {
			try {
				C3P0ProxyStatement c3p0Stmt = (C3P0ProxyStatement) this.inner;
				Method toStringMethod = Object.class.getMethod("toString", new Class[]{});
				Object toStr = c3p0Stmt.rawStatementOperation(toStringMethod, C3P0ProxyStatement.RAW_STATEMENT, new Object[]{});

				if (toStr instanceof String) {
					System.out.println(String.format("| %s | %s", this.connection.getCatalog(), (String) toStr));
				}
			} catch (Exception e) {
				System.out.println("Exception extracting SQL: " + e.getMessage());
			}
		}
	}
}
	

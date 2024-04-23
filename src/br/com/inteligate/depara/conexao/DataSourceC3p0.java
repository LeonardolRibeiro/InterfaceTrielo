package br.com.inteligate.depara.conexao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.DataSources;
import com.mchange.v2.c3p0.PooledDataSource;

public class DataSourceC3p0 {

	private static javax.sql.DataSource unpooled = null;
	private static javax.sql.DataSource pooled  = null;
	public static PooledDataSource pds = null;
	
	static {
		System.out.println("Iniciando DataSourceC3p0");
		/* 	config.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	local     

	        config.setJdbcUrl( "jdbc:sqlserver://localhost:1433;databaseName=Proper_d" );
	        config.setUsername( "sa" );
	        config.setPassword( "Trielo" ); */

		/* server
	        config.setJdbcUrl( "jdbc:sqlserver://properstock.cxplzsv9gfx3.us-east-2.rds.amazonaws.com:1433;databaseName=properstock:1433;databaseName=Proper_d" );
	        config.setUsername( "proper" );
	        config.setPassword( "Proper1!" ); 


	        config.addDataSourceProperty( "cachePrepStmts" , "true" );
	        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
	        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
	        config.setMaximumPoolSize(250);

	        ds = new HikariDataSource( config ); */

/*	}

	static String dataBase;
	static boolean printDebug = false;
	public static void reconfigurar(String _dataBase){

		dataBase = _dataBase;*/

	} 
	public static void configurar(String configFile){

		Properties props = new Properties();
		FileInputStream file = null;
		String JdbcUrl = null;
		String JdbcUsuario = null;
		String JdbcSenha = null;
		String JdbcClass = null;
		// JdbcUrl=jdbc:postgresql://localhost:5432/postgres
		// JdbcClass=org.postgresql.Driver
		try {
			
			System.out.println("Lendo config.props");
			
			//file = new FileInputStream(
			//		"config.props");
			file = new FileInputStream(
					configFile);
			props.load(file);
			
			JdbcUrl = props.getProperty("JdbcUrl");
			System.out.println("JdbcUrl:"+JdbcUrl);
			JdbcClass = props.getProperty("JdbcClass");
			System.out.println("JdbcClass:"+JdbcClass);
			JdbcUsuario = props.getProperty("JdbcUsuario");
			JdbcSenha = props.getProperty("JdbcSenha");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("config.props nao encontrado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Class.forName(JdbcClass);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		try {
			unpooled = DataSources.unpooledDataSource(JdbcUrl,
					JdbcUsuario,
					JdbcSenha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//				pooled = DataSources.pooledDataSource( unpooled );



			Map overrides = new HashMap();
			overrides.put("maxStatements", "400");         //Stringified property values work
			overrides.put("maxPoolSize", new Integer(200)); //"boxed primitives" also work
			//				overrides.put("maxConnectionAge", new Integer(240));
			//				overrides.put("c3p0.statementCacheNumDeferredCloseThreads", new Integer(1));
			overrides.put( "hibernate.c3p0.statementCacheNumDeferredCloseThreads", "1" );
			//create the PooledDataSource using the default configuration and our overrides
			pooled = DataSources.pooledDataSource( unpooled, overrides );

			pds = (PooledDataSource) pooled;



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private DataSourceC3p0() {}

	public static Connection getConnection() throws SQLException {
//		if(printDebug){
			System.out.print("num_connections: "      + pds.getNumConnectionsDefaultUser());
			System.out.print(" - num_busy_connections: " + pds.getNumBusyConnectionsDefaultUser());
			System.out.println( " - num_idle_connections: " + pds.getNumIdleConnectionsDefaultUser());
	//	}

		return pooled.getConnection();
	}
	public static boolean inicializado(){
		return (unpooled!=null);
	}

//	public static String getDataBase() {
//		return dataBase;
//	}
}

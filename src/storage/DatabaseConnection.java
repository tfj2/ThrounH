package storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.*;

public class DatabaseConnection /*implements Database*/ {

    private static void createNewDatabase(String url) {
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //https://docs.oracle.com/cd/E35521_01/doc.111230/e24475/amxdatabase.htm#ADFMF1263
    private static void initializeDatabase() throws Exception {
        InputStream scriptStream = null;
        Connection conn = null;
        //Class.forName("org.sqlite.JDBC");
        try {
            String currDir = System.getProperty("user.dir");
            // til að þetta sé óhátt stýrikerfi
            String fileName = "dev.db"; // viljum kannski breyta seinna
            String dbDir = currDir + File.separator + "src" + File.separator + "storage" + File.separator;
            String dbDir2 = dbDir.replace(File.separator, "/");
            String dbName = dbDir2 + fileName;
            System.out.println(currDir);
            System.out.println(dbName);

            String url = "jdbc:sqlite:" + dbName;

            File dbFile = new File(dbName);
            if (dbFile.exists()) {
                System.out.println("File exists");
                Files.deleteIfExists(dbFile.toPath());
                //    return;
            } else {
                System.out.println("not exists");
                createNewDatabase(url);
            }

            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);

            String hailmary = (dbDir + "schema.sql").replace(File.separator, "/");
            // getContextClassLoader vill dukka upp i out...
            //scriptStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("schema.sql");
            //System.out.println(DatabaseConnection.class.getResource("/").getPath());
            // File reader to read from disc
            //BufferedReader scriptReader = new BufferedReader(new InputStreamReader(scriptStream));

            BufferedReader scriptReader = new BufferedReader(new FileReader(hailmary));

            String nextLine;
            StringBuffer nextStatement = new StringBuffer();
            Statement stmt = conn.createStatement();
            while ((nextLine = scriptReader.readLine()) != null) {
                if (nextLine.startsWith("REM") ||
                        nextLine.startsWith("COMMIT") ||
                        nextLine.length() < 1)
                    continue;
                nextStatement.append(nextLine + "\n");
                if (nextLine.endsWith(";")) {
                    System.out.println(nextStatement.toString());
                    stmt.execute(nextStatement.toString());
                    nextStatement = new StringBuffer();
                }
            }
            conn.commit();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    public static void populateDatabase() throws Exception {
        InputStream scriptStream = null;
        Connection conn = null;
        try {
            String currDir = System.getProperty("user.dir");
            // til að þetta sé óhátt stýrikerfi
            String fileName = "dev.db"; // viljum kannski breyta seinna
            String dbDir = currDir + File.separator + "src" + File.separator + "storage" + File.separator;
            String dbDir2 = dbDir.replace(File.separator, "/");
            String dbName = dbDir2 + fileName;

            String url = "jdbc:sqlite:" + dbName;

            File dbFile = new File(dbName);
            if (!dbFile.exists()) {
                return;
            }
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);

            String hailmary = (dbDir + "values.sql").replace(File.separator, "/");

            BufferedReader scriptReader = new BufferedReader(new FileReader(hailmary));

            String nextLine;
            StringBuffer nextStatement = new StringBuffer();
            Statement stmt = conn.createStatement();
            while ((nextLine = scriptReader.readLine()) != null) {
                if (nextLine.startsWith("REM") ||
                        nextLine.startsWith("COMMIT") ||
                        nextLine.length() < 1)
                    continue;
                nextStatement.append(nextLine + "\n");
                if (nextLine.endsWith(";")) {
                    System.out.println(nextStatement.toString());
                    stmt.execute(nextStatement.toString());
                    nextStatement = new StringBuffer();
                }
            }
            conn.commit();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        initializeDatabase();
    }

}

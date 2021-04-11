package storage;

import entities.Accommodation;
import entities.Room;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.*;
import java.time.format.DateTimeFormatter;

public class DatabaseConnection /*implements Database*/ {

    private Connection conn = null;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public DatabaseConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:hotel.db");
            initializeDatabase();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            closeConnection();
        }
    }

    private void closeConnection() {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private void getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:hotel.db");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

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
    private void initializeDatabase() throws Exception {
        InputStream scriptStream = null;
        Connection conn = null;
        //Class.forName("org.sqlite.JDBC");
        try {
            String currDir = System.getProperty("user.dir");
            // til að þetta sé óhátt stýrikerfi
            String fileName = "hotel.db"; // viljum kannski breyta seinna
            String dbDir = currDir + File.separator + "src" + File.separator + "storage" + File.separator;
            String dbDir2 = dbDir.replace(File.separator, "/");
            String dbName = dbDir2 + fileName;

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

    public void createAcc(Accommodation acc) throws Exception {
        getConnection();
        String q = "INSERT INTO Accommodation "
                + "(name, location, rating, description)"
                + "VALUES (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(q);
        ps.setString(1, acc.getName());
        ps.setString(2, acc.getLocation());
        ps.setDouble(3, acc.getRating());
        ps.setString(4, acc.getDescription());
        ps.executeUpdate();
        ps.close();
        closeConnection();
    }

 /*   public ArrayList<Accommodation> getAllAcc() throws Exception {
        getConnection();
        Statement stmt = conn.createStatement();
        //ResultSet rs = stmt.executeQuery();
        closeConnection();
    }
*/
    public void createRoom(Room room) throws Exception {
        getConnection();
        String q = "INSERT INTO Room "
                + "(roomType, price, cap)"
                + "VALUES (?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(q);
        pstmt.setString(1, room.getRoomType().name()); // þvi þetta er enum
        pstmt.setDouble(2, room.getPrice());
        pstmt.setInt(3, room.getCap());
        pstmt.executeUpdate();
        pstmt.close();
        closeConnection();
    }


    public static void main(String[] args) throws Exception {
        DatabaseConnection test = new DatabaseConnection();

    }

}

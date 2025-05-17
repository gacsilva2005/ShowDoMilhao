package CodigoPoligenio;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {
    private static String host = "localhost";
    private static String porta = "3306";
    private static String db = "nosso bd";
    private static String usuario = "root";
    private static String senha = "nossa senha";
    
    public static Connection obterConexao() throws Exception{

        String url = "jdbc:mysql://" + host + ":" + porta + "/" + db 
                + "?useTimezone=true&serverTimezone=UTC";
        return DriverManager.getConnection(url, usuario, senha);
    }  
}

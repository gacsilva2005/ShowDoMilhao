package CodigoPoligenio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
    
    public boolean existe(Aluno usuario) throws Exception{
        String sql = 
          "SELECT * FROM tb_usuario" 
               + " WHERE nome = ? AND senha = ?"; 
        try(Connection conn = ConexaoBD.obterConexao();
            PreparedStatement ps = conn.prepareStatement(sql)
         ){
            // somente se as funções em try forem executadas
            // método para substituir os placeholders
            //ps.setString(1, Aluno.getNome());
            //ps.setString(2, Aluno.getSenha());
            
            //executar o comando sql, que seria o ps
            // receber a grid de resultado do comando
            // dentro do objeto rs e vamos verificar
            // se a grid esta vazia ou nao utilizando
            // o comando rs.next();
            try(ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        }
    }
}


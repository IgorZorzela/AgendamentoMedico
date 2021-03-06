package br.com.model.persistencia;

import br.com.model.funcionario.Funcionario;
import br.com.model.persistencia.dao.FuncionarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionarioDAOImplements implements FuncionarioDAO {

    private static final String INSERT = "insert into funcionario(nome, login, senha, telefone, celular, cargo, data_nascimento, "
            + "rg, endereco, cidade, estado) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String LIST = "select * from funcionario where codigo <> 1;";
    private static final String REMOVE = "delete from funcionario where codigo = ?;";
    private static final String UPDATE = "update funcionario set nome = ?, login = ?, senha = ?, telefone = ?, celular = ?, "
            + "cargo = ?,data_nascimento = ?, rg = ?, endereco = ?, cidade = ?, estado = ? where codigo = ?;";
    private static final String LISTBYID = "select * from funcionario where codigo = ? and codigo <> 1;";
    private static final String LISTBYNOME = "select * from funcionario where nome like ? AND codigo <> 1;";
//    private static final String VALIDALOGIN = "select login,senha from funcionario where login = ? and senha = ?;";
    private static final String VALIDALOGIN = "select * from funcionario;";

    @Override
    public int salvar(Funcionario f) {
        if (f.getCodigo() == 0) {
            return insert(f);
        } else {
            return update(f);
        }
    }

    private int insert(Funcionario f) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {

            //con = guarda a conexão aberta no connectionFactory
            con = ConnectionFactory.getConnection();
            //pstm = manda um sql para o banco
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            //(nome, login, senha, telefone, celular, cargo, data_nascimento, rg, endereco, cidade, estado)
            pstm.setString(1, f.getNome());
            pstm.setString(2, f.getLogin());
            pstm.setString(3, f.getSenha());
            pstm.setString(4, f.getTelefone());
            pstm.setString(5, f.getCelular());
            pstm.setString(6, f.getCargo());
            pstm.setDate(7, new java.sql.Date(f.getDataNascimento().getTime()));
            pstm.setString(8, f.getRg());
            pstm.setString(9, f.getEndereco());
            pstm.setString(10, f.getCidade());
            pstm.setString(11, f.getEstado());

            pstm.execute();
            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = rs.getInt(1);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir: " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao finalizar conexão em inserir: " + ex.getMessage());
            }
        }
        return retorno;
    }

    private int update(Funcionario f) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            //pdate funcionario set nome = ?, login = ?, senha = ?, telefone = ?, celular = ?, 
            //cargo = ?,data_nascimento = ?, rg = ?, endereco = ?, cidade = ?, estado = ? where codigo = ?
            pstm.setString(1, f.getNome());
            pstm.setString(2, f.getLogin());
            pstm.setString(3, f.getSenha());
            pstm.setString(4, f.getTelefone());
            pstm.setString(5, f.getCelular());
            pstm.setString(6, f.getCargo());
            pstm.setDate(7, new java.sql.Date(f.getDataNascimento().getTime()));
            pstm.setString(8, f.getRg());
            pstm.setString(9, f.getEndereco());
            pstm.setString(10, f.getCidade());
            pstm.setString(11, f.getEstado());
            pstm.setInt(12, f.getCodigo());

            pstm.execute();
            retorno = f.getCodigo();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar dados do funcionário: " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao finalizar conexão em inserir: " + ex.getMessage());
            }
        }
        return retorno;
    }

    @Override
    public boolean remove(int codigo) {
        boolean status = false;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(REMOVE);
            pstm.setInt(1, codigo);
            pstm.execute();
            status = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir funcionario: " + e.getMessage());
            System.out.println("Erro ao remover:" + e + ":");
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão do remove:" + ex.getMessage());
            }
        }
        return status;
    }

    @Override
    public List<Funcionario> listAll() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //nome = ?, login = ?, senha = ?, telefone = ?, celular = ?, cargo = ?,data_nascimento = ?, rg = ? 

                Funcionario f = new Funcionario();
                f.setNome(rs.getString("nome"));
                f.setCodigo(rs.getInt("codigo"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
                f.setTelefone(rs.getString("telefone"));
                f.setCelular(rs.getString("celular"));
                f.setCargo(rs.getString("cargo"));
                f.setDataNascimento(rs.getDate("data_nascimento"));
                f.setRg(rs.getString("rg"));
                f.setEndereco(rs.getString("endereco"));
                f.setCidade(rs.getString("cidade"));
                f.setEstado(rs.getString("estado"));
                funcionarios.add(f);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar funcionarios: " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão de listar funcionarios: " + e.getMessage());
            }
        }
        return funcionarios;
    }

    @Override
    public Funcionario listById(int codigo) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Funcionario f = new Funcionario();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, codigo);
            rs = pstm.executeQuery();
            while (rs.next()) {

                f.setCodigo(rs.getInt("codigo"));
                f.setNome(rs.getString("nome"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
                f.setTelefone(rs.getString("telefone"));
                f.setCelular(rs.getString("celular"));
                f.setCargo(rs.getString("cargo"));
                f.setDataNascimento(rs.getDate("data_nascimento"));
                f.setRg(rs.getString("rg"));
                f.setEndereco(rs.getString("endereco"));
                f.setCidade(rs.getString("cidade"));
                f.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar funcionário: " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão do listar: " + ex.getMessage());
            }
        }
        return f;
    }

    @Override
    public List<Funcionario> listByNome(String nome) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYNOME);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                //(nome, login, senha, telefone, celular, endereco, cidade, estado)

                Funcionario f = new Funcionario();
                f.setCodigo(rs.getInt("codigo"));
                f.setNome(rs.getString("nome"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
                f.setTelefone(rs.getString("telefone"));
                f.setCelular(rs.getString("celular"));
                f.setCargo(rs.getString("cargo"));
                f.setDataNascimento(rs.getDate("data_nascimento"));
                f.setRg(rs.getString("rg"));
                f.setEndereco(rs.getString("endereco"));
                f.setCidade(rs.getString("cidade"));
                f.setEstado(rs.getString("estado"));
                funcionarios.add(f);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar funcionarios: " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão de pesquisar funcionarios: " + e.getMessage());
            }
        }
        return funcionarios;
    }

    @Override
    public boolean autentica(String login, String senha) {
        boolean valida = false;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(VALIDALOGIN);
            rs = pstm.executeQuery();
            
//            pstm.setString(1, login);
//            pstm.setString(2, senha);
//            rs = pstm.executeQuery();
//            while (rs.next()) {
//                return true;
//            }
            while (rs.next()) {
                System.out.println("autentica");
                Funcionario f = new Funcionario();
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));

                System.out.println("login digitado: " + login + "    Senha digitada." + senha);
                System.out.println("Login do banco: " + f.getLogin() + "    Senha do banco: " + f.getSenha());
                if (f.getLogin().equalsIgnoreCase(login) && f.getSenha().equals(senha)) {
                    return true;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar login..." + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão do login..." + e.getMessage());
            }
        }
        return valida;
    }
}

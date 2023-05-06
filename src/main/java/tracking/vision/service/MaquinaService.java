/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tracking.vision.service;

import com.mycompany.tracking.vision.paulo.Conexao;
import com.mycompany.tracking.vision.paulo.ConexaoMysql;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author PAULOROBERTODEALMEID
 */
public class MaquinaService {
    public void salvarMaquina (Maquina maquina) {
        Conexao conexao =  new Conexao();
        ConexaoMysql conexaoMysql = new ConexaoMysql();
        
        JdbcTemplate con = conexao.getConnection();
        JdbcTemplate conMysql =  conexaoMysql.getConnection();

        con.update("insert into maquina(status,hostnameMaquina,nomeModeloCpu,clockCpu,nomeModeloRam,capacidadeTotalRam,nomeModeloDisco,capacidadeTotalDisco,leituraDisco,escritaDisco,fkEmpresa,fkJanelasBloqueadas) values (?,?,?,?,?,?,?,?,?,?,?,?)", 1,maquina.getHostnameMaquina(), maquina.getNomeModeloCpu(), maquina.getClockCpu(), maquina.getNomeModeloRam(), maquina.getCapacidadeTotalRam(), maquina.getNomeModeloDisco(), maquina.getCapacidadeTotalDisco(), maquina.getLeituraDisco(), maquina.getEscritaDisco(),null,null);
        conMysql.update("insert into maquina(status,hostnameMaquina,nomeModeloCpu,clockCpu,nomeModeloRam,capacidadeTotalRam,nomeModeloDisco,capacidadeTotalDisco,leituraDisco,escritaDisco,fkEmpresa,fkJanelasBloqueadas) values (?,?,?,?,?,?,?,?,?,?,?,?)", 1,maquina.getHostnameMaquina(), maquina.getNomeModeloCpu(), maquina.getClockCpu(), maquina.getNomeModeloRam(), maquina.getCapacidadeTotalRam(), maquina.getNomeModeloDisco(), maquina.getCapacidadeTotalDisco(), maquina.getLeituraDisco(), maquina.getEscritaDisco(),null,null);
    }

    public List<Maquina> buscarPeloHostname(String hostname) {
        Conexao conexao = new Conexao();

        JdbcTemplate con = conexao.getConnection();

        return con.query("select * from maquina where hostnameMaquina = ?", new BeanPropertyRowMapper(Maquina.class), hostname);
    }
}

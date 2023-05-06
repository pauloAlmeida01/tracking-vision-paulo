package tracking.vision.service;

import com.mycompany.tracking.vision.paulo.Conexao;
import com.mycompany.tracking.vision.paulo.ConexaoMysql;
import org.springframework.jdbc.core.JdbcTemplate;

public class LogService {
    public void salvarLog(Log log) {
        Conexao conexao = new Conexao();
        ConexaoMysql conexaoMysql = new ConexaoMysql();

        JdbcTemplate con = conexao.getConnection();
        JdbcTemplate conMysql = conexaoMysql.getConnection();
        //conexao
        con.update("insert into log(horarioCapturado,janelaPid,tituloJanela,usoCpu,usoDisco,usoRam,bytesRecebidos,bytesEnviados,fkMaquina) values (?, ?, ?, ?, ?,?,?,?,?)", log.getHorarioCapturado(), log.getJanelaPid(), log.getTituloJanela(), log.getUsoCpu(), log.getUsoDisco(), log.getUsoRam(),log.getBytesRecebidos(),log.getBytesEnviados(), log.getFkMaquina());
        conMysql.update("insert into log(horarioCapturado,janelaPid,tituloJanela,usoCpu,usoDisco,usoRam,bytesRecebidos,bytesEnviados,fkMaquina) values (?, ?, ?, ?, ?,?,?,?,?)", log.getHorarioCapturado(), log.getJanelaPid(), log.getTituloJanela(), log.getUsoCpu(), log.getUsoDisco(), log.getUsoRam(),log.getBytesRecebidos(),log.getBytesEnviados(), log.getFkMaquina());
    }
}

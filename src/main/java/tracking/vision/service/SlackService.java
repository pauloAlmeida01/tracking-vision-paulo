/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tracking.vision.service;

/**
 *
 * @author PAULOROBERTODEALMEID
 */
import com.mycompany.tracking.vision.paulo.Conexao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class SlackService {
    public static Slack retornarLink() {
        Conexao conexao = new Conexao();

        return (Slack) conexao.getConnection().queryForObject("select * from slack", new BeanPropertyRowMapper(Slack.class));
    }
}

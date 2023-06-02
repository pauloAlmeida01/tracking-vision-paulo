/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tracking.vision.service;

/**
 *
 * @author PAULOROBERTODEALMEID
 */
import com.github.britooo.looca.api.core.Looca;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class AlertaSlack {
    public static void mandarAlerta(Log log, List<Limites> limites, Integer fkEmpresa) throws IOException, InterruptedException {
        Looca looca = new Looca();
        String mensagem = "[ "+ log.getHorarioCapturado() + " ] A maquina " + log.getFkMaquina() + ", com o Hostname: " + MaquinaService.buscarPeloHostname(looca.getRede().getParametros().getHostName()).get(0).getHostnameMaquina() + " da empresa " + EmpresaService.retornarEmpresa(fkEmpresa).getNomeEmpresa();

        if (log.getUsoCpu() <= limites.get(0).getOk()) {
            mensagem += String.format(" esta com o uso de CPU em %.2f%%, e está com uso OK", log.getUsoCpu());
        }else if(log.getUsoCpu() <= limites.get(0).getAviso()){
            mensagem += String.format(" esta com o uso de CPU em %.2f%%, e está com uso em ALERTA", log.getUsoCpu());
        }else {
            mensagem += String.format(" esta com o uso de CPU em %.2f%%, e está com uso em CRÍTICO", log.getUsoCpu());
        }

        SlackBot.sendMessage(new JSONObject().put("text", mensagem));

        mensagem = "[ "+ log.getHorarioCapturado() + " ] A maquina " + log.getFkMaquina() + ", com o Hostname: " + MaquinaService.buscarPeloHostname(looca.getRede().getParametros().getHostName()).get(0).getHostnameMaquina() + " da empresa " + EmpresaService.retornarEmpresa(fkEmpresa).getNomeEmpresa();

        if (log.getUsoRam() <= limites.get(0).getOk()) {
            mensagem += String.format(" esta com o uso de RAM em %.2f%%, e está com uso OK", log.getUsoRam());
        } else if(log.getUsoRam() <= limites.get(0).getAviso()){
            mensagem += String.format(" esta com o uso de RAM em %.2f%%, e está com uso em ALERTA", log.getUsoRam());
        } else {
            mensagem += String.format(" esta com o uso de RAM em %.2f%%, e está com uso em CRITICO", log.getUsoRam());
        }

        SlackBot.sendMessage(new JSONObject().put("text", mensagem));

        mensagem = "[ "+ log.getHorarioCapturado() + " ] A maquina " + log.getFkMaquina() + ", com o Hostname: " + MaquinaService.buscarPeloHostname(looca.getRede().getParametros().getHostName()).get(0).getHostnameMaquina() + " da empresa " + EmpresaService.retornarEmpresa(fkEmpresa).getNomeEmpresa();

        if (log.getUsoDisco() <= limites.get(0).getOk()) {
            mensagem += String.format(" esta com o uso de Disco em %.2f%%, e está com uso OK", log.getUsoDisco());
        }else if(log.getUsoDisco() <= limites.get(0).getAviso()){
            mensagem += String.format(" esta com o uso de Disco em %.2f%%, e está com uso em ALERTA", log.getUsoDisco());
        }else {
            mensagem += String.format(" esta com o uso de Disco em %.2f%%, e está com uso em CRITICO", log.getUsoDisco());
        }

        SlackBot.sendMessage(new JSONObject().put("text", mensagem));
    }
}

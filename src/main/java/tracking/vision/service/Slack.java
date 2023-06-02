package tracking.vision.service;

public class Slack {
    private Integer idSlack;
    private String linkSlack;

    public Slack(Integer idSlack, String linkSlack) {
        this.idSlack = idSlack;
        this.linkSlack = linkSlack;
    }

    public Slack() {
    }

    public Integer getIdSlack() {
        return idSlack;
    }

    public void setIdSlack(Integer idSlack) {
        this.idSlack = idSlack;
    }

    public String getLinkSlack() {
        return linkSlack;
    }

    public void setLinkSlack(String linkSlack) {
        this.linkSlack = linkSlack;
    }

    @Override
    public String toString() {
        return "Slack{" +
                "idSlack=" + idSlack +
                ", linkSlack='" + linkSlack + '\'' +
                '}';
    }
}

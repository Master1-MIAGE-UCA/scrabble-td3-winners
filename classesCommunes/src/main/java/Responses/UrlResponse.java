package Responses;

public class UrlResponse {

    private String UrlPartie;
    private String appariement;
    private String UrlAnnagrameur;
    private boolean ready = false;
    public UrlResponse() {
        UrlPartie = "";
    }

    public String getUrlPartie() {
        return this.UrlPartie;
    }

    public void setUrlPartie(String urlPartie) {
        this.UrlPartie = urlPartie;
    }

    public String getUrlAnnagrameur() {
        return UrlAnnagrameur;
    }

    public void setUrlAnnagrameur(String urlAnnagrameur) {
        UrlAnnagrameur = urlAnnagrameur;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public String getAppariement() {
        return appariement;
    }

    public void setAppariement(String appariement) {
        this.appariement = appariement;
    }
}

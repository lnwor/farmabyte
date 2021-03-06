package it.farmabyte.app.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class Farmacia {
    private String id;
    private String nome;
    private String provincia;
    private String comune;
    private String via;
    private int numeroCivico;

    private HashMap<Farmaco, Lotto> magazzino;
    private ArrayList<Prenotazione> prenotazioni;

    public Farmacia(String id, String nome, String provincia, String comune, String via, int numeroCivico) {
        this.id = id;
        this.nome = nome;
        this.provincia = provincia;
        this.comune = comune;
        this.via = via;
        this.numeroCivico = numeroCivico;
        this.prenotazioni = new ArrayList<Prenotazione>();
        this.magazzino = new HashMap<>();
    }

    public Farmacia() {
        this.magazzino = new HashMap<>();
        this.prenotazioni = new ArrayList<Prenotazione>();
    }

    public void addFarmaco(Farmaco toAdd, Lotto lotto) {
        magazzino.put(toAdd, lotto);
    }

    public void addPrenotazione(Prenotazione toAdd) {
        prenotazioni.add(toAdd);
    }

    public Collection<Prenotazione> elencaPrenotazioni(Date inizio, Date fine) {
        ArrayList<Prenotazione> prenotazioniFiltrate = new ArrayList<>();
        Calendar calInizio = Calendar.getInstance();
        Calendar calFine = Calendar.getInstance();
        Calendar calPrenotazione = Calendar.getInstance();
        boolean giornoInizio = false;
        boolean giornoFine = false;
        calInizio.setTime(inizio);
        calFine.setTime(fine);

        for (Prenotazione prenotazione : prenotazioni) {
            calPrenotazione.setTime(prenotazione.getData());
            giornoInizio = calInizio.get(Calendar.DAY_OF_YEAR) == calPrenotazione.get(Calendar.DAY_OF_YEAR)
                    && calInizio.get(Calendar.YEAR) == calPrenotazione.get(Calendar.YEAR);
            giornoFine = calFine.get(Calendar.DAY_OF_YEAR) == calPrenotazione.get(Calendar.DAY_OF_YEAR)
                    && calFine.get(Calendar.YEAR) == calPrenotazione.get(Calendar.YEAR);
            if (( giornoInizio || !inizio.after(prenotazione.getData())) && ( giornoFine || !fine.before(prenotazione.getData()))) {
                prenotazioniFiltrate.add(prenotazione);
            }
        }

        return prenotazioniFiltrate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public int getNumeroCivico() {
        return numeroCivico;
    }

    public void setNumeroCivico(int numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    public HashMap<Farmaco, Lotto> getMagazzino() {
        return magazzino;
    }

    public void setMagazzino(HashMap<Farmaco, Lotto> magazzino) {
        this.magazzino = magazzino;
    }

    public ArrayList<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(ArrayList<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

}

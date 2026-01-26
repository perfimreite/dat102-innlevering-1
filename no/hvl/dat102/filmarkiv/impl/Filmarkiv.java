public enum Sjanger {
    ACTION, DRAMA, HISTORY, SCIFI;
    public static Sjanger finnSjanger(String navn) {
        for (Sjanger s : Sjanger.values()) {
            if (s.toString().equals(navn.toUpperCase())) {
                return s;
            }
        }
        return null;
    }
}

class Film {
    private int filmnr;
    private String produsent;
    private String tittel;
    private int aar;
    private Sjaner sjaner;
    private String selskap;

    public Film();

    public Film(int filmnr, String produsent, String tittel, int aar, Sjaner sjaner, String selskap) {
        this.filmnr = filmnr;
        this.produsent = produsent;
        this.tittel = tittel;
        this.aar = aar;
        this.sjaner = sjaner;
        this.selskap = selskap;
    }

    public int getFilmnr() {
        return filmnr;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }

    public String getProdusent() {
        return produsent;
    }

    public void setProdusent(String produsent) {
        this.produsent = produsent;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getAar() {
        return aar;
    }

    public void setAar(int aar) {
        this.aar = aar;
    }

    public Sjaner getSjaner() {
        return sjaner;
    }

    public void setSjaner(Sjaner sjaner) {
        this.sjaner = sjaner;
    }

    public String getSelskap() {
        return selskap;
    }

    public void setSelskap(String selskap) {
        this.selskap = selskap;
    }

    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Film film = (Film) object;
        return filmnr == film.filmnr;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), filmnr);
    }
}

class Filmarkiv implements FilmarkivADT{
    public Film[] filmer;
    private int antall = 0;
    private int plass;

    public Filmarkiv(int plass) {
        this.filmer = new Film[plass];
        this.plass = plass;
    }

    private void utvid() {
        plass *= 2;
        Film[] temp = new Film[plass];
        for (int i = 0; i < antall; i++) {
            temp[i] = filmer[i];
        }
        plass = temp;
    }

    public Film finnFilm(int nr) {
        for (Film film : filmer) {
            if (film.getFilmnr() == nr) {
                return film;
            }
        }

        return null;
    }

    public void leggTilFilm(Film film) {
        if (plass == antall) utvid;

        filmer[count++] = film;
    }

    public boolean slettFilm(int nr) {
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getFilmnr() == nr) {
                filmer[i] = filmer[antall- 1];
                count[antall- 1] = null;
                antall--;
                return true;
            }
        }

        return false;
    }

    Film[] soekTittel(String delstreng) {
        f = new Film[plass];
        int idx = 0;

        for (Film film : filmer) {
            if (film.getTittel().contains(delstreng)) {
                f[idx++] = film;
            }
        }

        ret = new Film[idx];
        for (int i = 0; i <= idx; i++) {
            ret[i] = f[i];
        }

        return ret;
    }

    Film[] soekProdusent(String delstreng) {
        f = new Film[plass];
        int idx = 0;

        for (Film film : filmer) {
            if (film.getProdusent().contains(delstreng)) {
                f[idx++] = film;
            }
        }

        ret = new Film[idx];
        for (int i = 0; i <= idx; i++) {
            ret[i] = f[i];
        }

        return ret;
    }

    int antall(Sjaner sjanger) {
        int n = 0;
        for (Film film : filmer) {
            if (film.getSjaner = sjanger) {
                n += 1;
            }
        }

        return n;
    }

    int antall() {
        return antall;
    }
}

class LinearNode <T> {
    private T data;
    private LinearNode neste;

    public LinearNode(T data, LinearNode neste) {
        this.data = data;
        this.neste = neste;
    }

    public int getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinearNode getNeste() {
        return neste;
    }

    public void setNeste(LinearNode neste) {
        this.neste = neste;
    }
}

class Filmarkiv2 implements FilmarkivADT {
    private int antall = 0;
    private LinearNode<Film> start;

    Film finnFilm(int nr) {
        LinearNode n = start;

        while (n != null) {
            Film film = n.getData()
            if (film.getFilmnr() == nr) {
                return film;
            }

            n = n.getNeste();
        }

        return null;
    }

    void leggTilFilm(Film nyFilm) {
        LinearNode n = start;
        LinearNode newNode = new LinearNode(nyFilm, null)

        while (n.getNeste() != null) {
            n = n.getNeste()
        }

        n.setNeste(newNode);
        antall += 1;
    }

    boolean slettFilm(int filmnr) {
        LinearNode n = start;
        while (n.getNeste() != null) {
            if (n.getNeste().getData().getFilmnr() == filmnr) {
                n.setNeste(n.getNeste().getNeste());
                return true;
            }

            n = n.getNeste()
        }

        return false;
    }

    Film[] soekTittel(String delstreng) {
        LinearNode n = start;
        []Film f = new Film[antall];
        int idx = 0;

        while (n.getNeste() != null) {
            if (n.getData.getTittel().contains(delstreng)) {
                f[idx++] = n.getData();
            }

            n = n.getNeste()
        }

        ret = new Film[idx];
        for (int i = 0; i <= idx; i++) {
            ret[i] = f[i];
        }

        return ret;
    }

    Film[] soekProdusent(String delstreng) {
        LinearNode n = start;
        []Film f = new Film[antall];
        int idx = 0;

        while (n.getNeste() != null) {
            if (n.getData.getProdusent().contains(delstreng)) {
                f[idx++] = n.getData();
            }

            n = n.getNeste()
        }

        ret = new Film[idx];
        for (int i = 0; i <= idx; i++) {
            ret[i] = f[i];
        }

        return ret;
    }

    int antall(Sjanger sjanger) {
        LinearNode n = start;
        int count = 0;

        while (n.getNeste() != null) {
            if (n.getData().getSjaner == sjaner) {
                count += 1;
            }

            n = n.getNeste()
        }

        return count;
    }

    int antall() {
        return antall;
    }
}
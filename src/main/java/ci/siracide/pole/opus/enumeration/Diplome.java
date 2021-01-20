package ci.siracide.pole.opus.enumeration;

public enum Diplome {
    BAC("BAC", "Baccalaureat"),
    BTS("BTS", "Brevet de Technicien Supérieur"),
    LICENCE_PROFESSIONNELLE("LICENCE PROFESSIONNELLE", "Brevet de Technicien Supérieur"),
    MAITRISE("MAITRISE", "Master"),
    MASTETR("MASTER", "Master"),
    DOCTORAT("DOCTORAT", "Doctorat");

    public String sigle;
    public String libelle;

    Diplome(String sigle, String libelle) {
        this.sigle = sigle;
        this.libelle = libelle;
    }
}

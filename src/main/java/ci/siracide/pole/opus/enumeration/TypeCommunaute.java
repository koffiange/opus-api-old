package ci.siracide.pole.opus.enumeration;

public enum TypeCommunaute {
    RELIGIEUSE("Communauté Réligieuse"),
    ASSOCIATION("Association");

    public String libelle;

    TypeCommunaute(String libelle) {
        this.libelle = libelle;
    }
}

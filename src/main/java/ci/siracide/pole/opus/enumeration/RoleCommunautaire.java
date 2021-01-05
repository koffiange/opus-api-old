package ci.siracide.pole.opus.enumeration;

public enum RoleCommunautaire {
    CHEF("Chef de communauté"),
    PARTICIPANT("Membre participant de la communauté");

    public String libelle;

    RoleCommunautaire(String libelle) {
        this.libelle = libelle;
    }
}

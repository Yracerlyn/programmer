package lsi.fonctionalite.data;

import lsi.fonctionalite.utils.Programmeur;

public interface ActionsBDD {

    public abstract void dataBaseConnection();

    public abstract void dataBaseConnectionEnd();

    public abstract void deleteProgrammeur(int id);

    public abstract void addProgrammeur(Programmeur p);

    public abstract void modifySalaire(int id, float newSalaire);

    public abstract void printAllProgrammeur();

    public abstract void printProgrammeur(int id);

    public abstract void printBestSalaryProgrammeur();

    public abstract void printSameResponsableProgrammeur(String responsable);

    public abstract void printPorgrammerWithSameHobby();

    public abstract void diagramAgeOfProgrammeur();

    public abstract int nombreTotalProgrammeur();

    public abstract float totalSalaire();

    public abstract int ageMoyenneProgrammeur();

}

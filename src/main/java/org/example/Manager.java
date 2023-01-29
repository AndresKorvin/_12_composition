package org.example;
public class Manager {
    private int outputLimit = 10;
    private String [] films = new String[0];
    public Manager() {
    }
    public Manager (int outputLimit) {
        if (outputLimit > 0)
            this.outputLimit = outputLimit;
    }

    public void addFilm(String newFilm){
         String [] tmp = new String[films.length + 1];

        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = newFilm;
        films = tmp;
    }

    public String[] findAll() {
        return this.films;
    }

    public String[] findLast() {
        int resultLength = this.outputLimit;

        if (films.length < resultLength) resultLength = films.length;

            String[] tmp = new String[resultLength];
            for (int i = 0; i < resultLength; i++) {
                tmp[i] = films[resultLength - 1 - i];
            }
            return tmp;
        }
    public int getOutputLimit() {
        return outputLimit;
    }
}

package model;

import java.io.Serializable;

public class ClientProvider implements Serializable {
    private int clNumber;
    private String internetType;
    private int nbMonths;

    public int getClNumber() {
        return clNumber;
    }

    public void setClNumber(int clNumber) {
        this.clNumber = clNumber;
    }

    public String getInternetType() {
        return internetType;
    }

    public void setInternetType(String internetType) {
        this.internetType = internetType;
    }

    public int getNbMonths() {
        return nbMonths;
    }

    public void setNbMonths(int nbMonths) {
        this.nbMonths = nbMonths;
    }

    public ClientProvider(int clNumber, String internetType, int nbMonths) {
        this.clNumber = clNumber;
        this.internetType = internetType;
        this.nbMonths = nbMonths;

    }

    @Override
    public String toString() {

        return
                "Client Number: " + clNumber + " Internet Provider: " + internetType + " Number of Months: " + nbMonths + " Amount: " + getTotal() + "\n";
    }

    public float getTotal() {
        float amount = 0;

        if (internetType.equals("Bell"))
            if (getNbMonths() <= 11) {
                amount = 60;
            }
        if (getNbMonths() == 12) {
            amount = 600;
        } else if (internetType.equals("Videotron")) {
            if (getNbMonths() < 6) {
                amount = 70;
            } else if (getNbMonths() > 6 && getNbMonths() < 12) {
                amount = 70;

            } else if (getNbMonths() == 6) {
                amount = 350;
            } else if (getNbMonths() == 12) {
                amount = 588;
            }
        }else if (internetType.equals("Acanac")) {
                if (getNbMonths() <= 11) {
                    amount = 45;
                } else if (getNbMonths() == 12) {
                    amount = 495;
                }


            }

        return amount;
    }
}

